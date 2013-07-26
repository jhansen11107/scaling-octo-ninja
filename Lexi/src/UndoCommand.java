/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW5
 * 
 * Pattern/Participant: Prototype: ConcretePrototype
 * Pattern/Participant: Command: ConcreteCommand
 * Command for undoing the last executed Command.
 */

public class UndoCommand implements Command {

	/**
	 * @see Command#execute()
	 */
	public void execute() {
		CommandHistory.instance().undo();
	}

	/**
	 * @see Command#unexecute()
	 */
	public void unexecute() {
		CommandHistory.instance().redo();
	}

	/**
	 * @see Command#reversible()
	 */
	public boolean reversible() {
		return false;
	}
	
	/**
	 * @see Command#clone()
	 */
	public Command clone() {
		return new UndoCommand();
	}

}
