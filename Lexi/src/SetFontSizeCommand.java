/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW5
 * 
 * Pattern/Participant: Command(233): ConcreteCommand
 * Pattern/Participant: Prototype(117): ConcretePrototype
 * Command for setting the font size of a Window object.
 */
public class SetFontSizeCommand implements Command {
	private int oldFontSize;
	private int newFontSize;
	private Window receiver;
	
	/**
	 * Instantiates a SetFontSizeCommand object
	 * @param receiver the Window that will be affected by execution 
	 */
	public SetFontSizeCommand(Window receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * @see Command#execute()
	 */
	public void execute() {
		oldFontSize = receiver.getFontSize();
		receiver.setFontSize(newFontSize);
	}
	
	/**
	 * @see Command#unexecute()
	 */
	public void unexecute() {
		receiver.setFontSize(oldFontSize);
	}
	
	/**
	 * Sets the size that font size that will be set when the object's
	 * execute() method is called.
	 * @param size the font size to set when execute() is called
	 */
	public void setNewFontSize(int size) {
		oldFontSize = newFontSize;
		newFontSize = size;
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
		SetFontSizeCommand clone = new SetFontSizeCommand(receiver);
		clone.oldFontSize = this.oldFontSize;
		clone.newFontSize = this.newFontSize;
		return clone;
	}
}
