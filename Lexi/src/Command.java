/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW5
 * 
 * Pattern/Participant: Command(233): Command
 * Pattern/Participant: Prototype(117): Prototype
 */

public interface Command {
	/**
	 * Executes the Command.
	 */
	void execute();
	
	/**
	 * Reverses the effects of the Command, if possible. Not all Commands
	 * are able to be unexecuted.
	 */
	void unexecute();
	
	/**
	 * Returns whether or not the Command can be undone
	 * @return whether or not he Command can be undone
	 */
	boolean reversible();
	
	/**
	 * Method for asking a Command object to clone itself.
	 * @return a clone of the Command object, with any state variables of the
	 * original copied to the clone
	 */
	Command clone();
}
