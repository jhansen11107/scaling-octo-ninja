/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW1
 *
 * Pattern/Participant: Composite(163): Composite
 * An implementation of the Row Glyph.
 */

import java.awt.Point;

public class Row extends CompositeGlyph {

	/**
	 * Instantiates a Row GlYP-Q and initializes the Row's parent pointer
	 * window the window the row's children will appear on
	 * parent the Row's parent CompositeGlyph
	 */
	public Row(CompositeGlyph parent, Window w) {
		super(w);
		if (parent != null) {
			setParent(parent);
			parent.append(this);
		}
	}

	/**
	 * Instantiates a Row §lyQh with a sequence of characters
	 * window the window the row's children will appear on
	 * s the character sequence to insert into the row
	 */
	public Row(Window w, String s) {
		super(w);
		for (int i=0; i < s.length(); i++) {
			append(new Character(s.charAt(i)));
		}
	}

	/**
	 * Instantiates a Row §lyQh with a sequence of characters
	 * parent the Row's parent CompositeGlyph
	 * window the window the row's children will appear on
	 * s the character sequence to insert into the row
	 */
	public Row(CompositeGlyph parent, String s, Window w) {
		super(w);
		for (int i=0; i < s.length(); i++) {
			append(new Character(s.charAt(i)));
		}

		if (parent != null) {
			setParent(parent);
			parent.append(this);
		}
	}

	/**
	 * Sets the position of the Row §lyQh~ and the position of the Glyph's
	 * children
	 */
	public void setPosition(Point p) {
		int offset = p.x-position.x;
		for (Glyph g : children) {
			g.setPosition(new Point(g.getPosition().x+offset,p.y));
		}
		this.position = p;
	}

	/**
	 * Composition#xCoefficient()
	 */
	public int xCoefficient() {
		return 1;
	}
	/**
	 * Composition#yCoefficient()
	 */
	public int yCoefficient() {
		return 0;
	}
}
