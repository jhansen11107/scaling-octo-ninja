/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW5
 * 
 * Pattern/Participant: Prototype: ConcretePrototype
 * Pattern/Participant: Command: ConcreteCommand
 * Command for redoing the last undone Command.
 */

public class RedoCommand implements Command {

	/**
	 * @see Command#execute()
	 */
	public void execute() {
		CommandHistory.instance().redo();
	}

	/**
	 * @see Command#unexecute()
	 */
	public void unexecute() {
		CommandHistory.instance().undo();
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
		return new RedoCommand();
	}

}
