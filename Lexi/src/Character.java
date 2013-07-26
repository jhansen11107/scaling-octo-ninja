/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW1
 *
 * Pattern/Participant: Composite(163): Leaf
 * Pattern/Participant: Visitor(331): ConcreteElementA
 * An implementation of the Character Glyph.
 */

import java.awt.Point;


public class Character extends DefaultGlyph {
	private char c;

	/**
	 * Instantiates a Character §ly~ and sets its width and height.
	 * c the char to wrap the Character GlYQh around.
	 * w the window to use to set the width and height of the GlyQh
	 */
	public Character(char c) {
		super();
		this.c = c;
	}

	/**
	 * Draws the character on the passed-in window.
	 * w the Window to draw on
	 */
	public void draw(Window w) {
		w.drawCharacter(c, position.x, position.y);
	}

	/**
	 * Returns whether or not the Character intersects
	 * the point passed in.
	 * @param p the point to compare the Character's position to
	 */
	public boolean intersects(Point p) {
		return new Rectangle(bounds().width,bounds().height,position.x,position.y).intersects(p);
	}

	/**
	 * Getter method for the Character's width and height 
	 * on a given Window
	 * @return a struct containing the Character's width and height information
	 */
	public Rect bounds() {
		return widthAndHeight;
	}

	/**
	 *Getter method for the Character's width and height
	 * on a given Window
	 * @param w the window to query about the Character's width and height
	 * @return a struct containing the Character's width and height information
	 */
	public Rect bounds(Window w) {
		return new Rect(w.charWidth(c),w.charHeight(c));
	}

	/**
	 * Setter method for the Character's parent attribute.
	 * g the CompositeGlyph to set as the parent
	 */
	public void setParent(CompositeGlyph g) {
		parent = g;
	}
	
	/**
	 * Gets the Character object's internal char primitive.
	 * @return the char wrapped by the Character object
	 */
	public char getChar() {
		return c;
	}
	
	/**
	 * @see Glyph#accept(GlyphVisitor)
	 */
	public void accept(GlyphVisitor v) {
		v.visit(this);
	}
}
