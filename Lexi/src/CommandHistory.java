/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW5
 * 
 * Pattern/Participant: Prototype: Client
 * Pattern/Participant: Singleton: Singleton
 * Data structure for maintaining a history of Commands executed for the purposes
 * of allowing multiple levels of undoing and redoing
 */

import java.util.Vector;

public class CommandHistory {
	private static CommandHistory instance;
	private Vector<Command> history;
	private int present;
	
	private CommandHistory() {
		history = new Vector<Command>();
		present = 0;
	}
	
	/**
	 * Single point of access for creating a CommandHistory instance.
	 * @return the CommandHistory singleton object
	 */
	public static CommandHistory instance() {
		if (instance==null) {
			instance = new CommandHistory();
		}
		return instance;
	}
	
	/**
	 * Adds a clone of the Command to the command history stack. If any commands have
	 * been undone since the last call to push, those commands will be
	 * popped off the stack before the new command is pushed.
	 * @param command the Command to push onto the CommandHistory object
	 */
	public void push(Command command) {
		if (present < history.size()) {
			history.subList(present, history.size()).clear();
		}
		history.add(command.clone());
		present++;
	}
	
	/**
	 * Un-executes the most recently executed Command in the CommandHistory
	 * structure. Does nothing if the history is empty or if all Commands
	 * in the history have already been undone.
	 */
	public void undo() {
		if (present==0) {
			return;
		}
		if (history.get(present-1).reversible())	{
			history.get(--present).unexecute();
		} else {
			present--;
			undo();
		}
	}
	
	/**
	 * Re-executes the most recently unexecuted Command in the CommandHistory
	 * structure. Does nothing if the history is empty of if no Commands in the
	 * history have been undone.
	 */
	public void redo() {
		if (present==history.size()) {
			return;
		}
		
		if (history.get(present).reversible()) {
			history.get(present++).execute();
		} else {
			present++;
			redo();
		}
	}
}
