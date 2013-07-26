/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW6
 *
 * Pattern/Participant: Visitor(331): ConcreteVisitor1
 * Visits Glyph objects and builds up words based 
 * on the contents of character Glyphs. Words are delimited by
 * any non-Character Glyph. 
 */

import java.util.*;
import java.util.regex.*;

public class WordsVisitor implements GlyphVisitor {
	private Set<String> words = new HashSet<String>();
	private String word ="";
	private Pattern p = Pattern.compile("\\s");
	
	/**
	 * @see GlyphVisitor#visit(Character)
	 */
	public void visit(Character c) {
		if (p.matcher(c.getChar()+"").matches()) {
			newWord();
		} else {
			word += c.getChar();
		}
	}
	
	/**
	 * @see GlyphVisitor#visit(Rectangle)
	 */
	public void visit(Rectangle r) {
		newWord();
	}
	
	/**
	 * @see GlyphVisitor#visit(CompositeGlyph)
	 */
	public void visit(CompositeGlyph cg) {
		newWord();
	}
	
	/**
	 * Prints out the set of words accumulated thus far from the document.
	 * then clears the set.
	 */
	public void printWords() {
		if (!word.isEmpty()) {
			words.add(word);
		}
		
		for (String s : words) {
			System.out.println(s);
		}
	}
	
	/**
	 * Clears the set of accumulated words from the document.
	 */
	public void clear() {
		words.clear();
		word = "";
	}
	
	/**
	 * Adds the current word being built to the set of words,
	 * then begins building a new word.
	 */
	private void newWord() {
		if (!word.isEmpty()) {
			words.add(word);
			word = "";
		}
	}

}
