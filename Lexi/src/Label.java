/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW3
 *
 * Pattern/Participant: AbstractFactory(87): AbstractProduct
 * Pattern/Participant: FactoryMethod(107): Product
 * Provides interface for other, concrete labels.
 */

import java.awt.Point;

public abstract class Label extends Embellishment {
	private String color ;

	/**
	 * Instantiates a Label Embellishment and initializes
	 * the Window pointer and the embellished CompositeGlyph
	 * @param w the Window to draw on
	 * @param c the CompositeGlyph to embellish with a label
	 * @return color the color of the button
	 */
	public Label(Window w, CompositeGlyph c, String color) {
		super(w,c);
		this.color = color;
	}

	/**
	 * Instantiates a Label Embellishment, initializes
	 * the Window pointer, the embellished CompositeGlyph,
	 * and the parent pointer
	 * @param parent the parent CompositeGlyph to set
	 * @param w the Window to draw on
	 * @param c the CompositeGlyph to embellish with a label
	 * @param color the color of the button
	 */
	public Label(CompositeGlyph parent, CompositeGlyph c, Window w, String color) {
		this(w,c,color);
		if (parent != null) {
			setParent(parent);
			parent.append(this);
		}
	}

	/**
	 * Draws the embellished CompositeGlyph and a label surrounding it.
	 * @param w the Window to draw on
	 */
	public void draw(Window w) {
		c.draw(w);
		w.drawLabel(position.x, position.y, bounds(w).width, bounds(w).height, color);
	}

	/**
	 * Sets the bounds of the Label and of the
	 * CompositeGlyph it embellishes
	 * @param bounds the bounds of the Label Embellishment
	 */
	public void setBounds(Rect bounds) {
		this.widthAndHeight = bounds;
		c.setBounds(bounds);
	}

	/**
	 * Returns the bounds of the Label
	 * @param w Window to use for size computations
	 * @return the bounds of the Label
	 */

	public Rect bounds(Window w) {
		return new Rect(c.bounds(w).width,c.bounds(w).height);
	}

	/**
	 * Sets the position of the Label and the embellished
	 * CompositeGlyph
	 * @param p the position of the Label
	 */
	public void setPosition(Point p) {
		this.position = p;
		c.setPosition(p);
	}
}
