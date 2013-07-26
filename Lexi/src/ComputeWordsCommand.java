/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW6
 * 
 * Pattern/Participant: Prototype: ConcretePrototype
 * Pattern/Participant: Command: ConcreteCommand
 * Command for collecting a list of words in a Lexi document and printing
 * them to System.out.
 */

public class ComputeWordsCommand implements Command {
	private Iterator<Glyph> i;
	private WordsVisitor wv = new WordsVisitor();
	
	/**
	 * Creates a new ComputeWordsCommand object that will use
	 * the passed-in iterator for document analysis purposes.
	 * @param i the Iterator to iterator over the Glyphs in the document
	 */
	public ComputeWordsCommand(Iterator<Glyph> i) {
		this.i = i;
	}
	
	/**
	 * @see Command#execute()
	 */
	public void execute() {
		for (i.first(); !i.isDone(); i.next()) {
			i.currentItem().accept(wv);
		}		
		wv.printWords();
		wv.clear();
	}

	/**
	 * @see Command#unexecute()
	 */
	public void unexecute() { }

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
		return this;
	}
}
