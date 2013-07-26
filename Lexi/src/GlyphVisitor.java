/**
 * @author Josh Hansen 
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW6
 *
 * Pattern/Participant: Visitor(331): Visitor
 * Interface for Visitor objects.
 */
public interface GlyphVisitor {
	/**
	 * Visits a Character Glyph and performs analysis on it.
	 * @param c the Character Glyph to visit.
	 */
	void visit(Character c);
	
	/**
	 * Visits a Rectangle Glyph and performs analysis on it.
	 * @param r the Rectangle to visit.
	 */
	void visit(Rectangle r);
	
	/**
	 * Visits a CompositeGlyph and performs analysis on it.
	 * @param cg the CompositeGlyph to visit.
	 */
	void visit(CompositeGlyph cg);
}
