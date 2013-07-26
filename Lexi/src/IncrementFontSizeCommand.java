/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW5
 * 
 * Pattern/Participant: Prototype: ConcretePrototype
 * Pattern/Participant: Command: ConcreteCommand
 * Command for incrementing a Window object's font size by 1.
 */

public class IncrementFontSizeCommand implements Command {
	private Window receiver;
	
	/**
	 * Instantiates an IncrementFontSizeCommand object
	 * @param receiver the Window that will be affected by execution 
	 */
	public IncrementFontSizeCommand(Window receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * @see Command#execute()
	 */
	public void execute() {
		receiver.setFontSize(receiver.getFontSize()+1);
	}

	/**
	 * @see Command#unexecute()
	 */
	public void unexecute() {
		receiver.setFontSize(receiver.getFontSize()-1);
	}

	/**
	 * @see Command#reversible()
	 */
	public boolean reversible() {
		return true;
	}
	
	/**
	 * @see Command#clone()
	 */
	public Command clone() {
		return new IncrementFontSizeCommand(receiver);
	}

}
