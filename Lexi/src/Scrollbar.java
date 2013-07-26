/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW2
 *
 * Pattern/Participant: Decorator(175): ConcreteDecorator
 * Decorates a CompositeGlyph by adding a "scroll bar".
 */

import java. awt. Point;

public class Scrollbar extends Embellishment {
	private static int SCROLLBAR_WIDTH = 15;

	/**
	 * Instantiates a Scrollbar Embellishment and initializes
	 * the Window pointer and the embellished CompositeGlyph
	 * w the Window to draw on
	 * c the CompositeGlyph to embellish with a scroll bar
	 */
	public Scrollbar(Window w, CompositeGlyph c) {
		super(w,c);
	}

	/**
	 * Instantiates a Scrollbar Embellishment, initializes
	 * the Window pointer, the embellished CompositeGlyph,
	 * and the parent pointer
	 * parent the parent CompositeGlyph to set
	 * w the Window to draw on
	 * c the CompositeGlyph to embellish with a scroll bar
	 */
	public Scrollbar(CompositeGlyph parent, CompositeGlyph c, Window w) {
		this(w,c);
		if (parent != null) {
			setParent(parent);
			parent.append(this);
		}
	}

	/**
	 * Draws the CompositeGlyph and a scroll bar
	 * w the Window to draw on
	 */
	public void draw(Window w) {
		c.draw(w);
		w.addScrollBar(position.x+bounds(w).width-SCROLLBAR_WIDTH,
				position.y,
				SCROLLBAR_WIDTH,
				position.y+bounds(w).height-2);
	}

	/**
	 * Sets the bounds of the Scrollbar and of the
	 * CompositeGlyph it embellishes
	 * bounds the bounds of the ~crollbaL Embellishment
	 */
	public void setBounds(Rect bounds) {
		this.widthAndHeight = new Rect(bounds.width+SCROLLBAR_WIDTH,bounds.height);
		c.setBounds(bounds);
	}
	/**
	 * Returns the bounds of the Scrollbar
	 *
	 *
	 */

	public Rect bounds(Window w) {
		return new Rect(c.bounds(w).width+SCROLLBAR_WIDTH,c.bounds(w).height);
	}
	/**
	 * Sets the position of the Scrollbar and the embellished
	 * CompositeGlyph
	 * p the position of the Scrol_lbar
	 */
	public void setPosition(Point p) {
		this.position = p;
		c.setPosition(p);
	}

}
