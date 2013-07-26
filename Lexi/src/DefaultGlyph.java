/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW1
 * 
 * Pattern/Participant: Composite(163): Component
 * Pattern/Participant: Command(233): Receiver
 * Default implementation of the Glyph interface.
 */

import java.awt.Point;
public class DefaultGlyph implements Glyph {
	protected Point position = new Point(0,0);
	protected CompositeGlyph parent;
	protected Rect widthAndHeight = new Rect(0,0);

	public DefaultGlyph() {

	}

	/**
	 * @see Glyph#draw(Window)
	 */
	public void draw(Window w) {
		throw new UnsupportedOperationException (getClass (). getSimpleName() + " does not support draw operation");
	}

	/**
	 * @see Glyph#intersects(Point)
	 */
	public boolean intersects(Point p) {
		throw new UnsupportedOperationException(getClass().getSimpleName() +"does not support intersects operation");
	}

	/**
	 * @see Glyph#bounds()
	 */
	public Rect bounds() {
		throw new UnsupportedOperationException(getClass().getSimpleName() + "support bounds operation");
	}

	/**
	 * @see Glyph#bounds(Window)
	 */
	public Rect bounds(Window w) {
		return bounds();
	}

	/**
	 * @see Glyph#insert(Glyph, int)
	 */
	public void insert(Glyph g, int i) {
		throw new UnsupportedOperationException(getClass() .getSimpleName() + " does not support insert operation");
	}

	/**
	 * @see Glyph#remove(Glyph)
	 */
	public void remove(Glyph g) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + " does not support remove operation");
	}

	/**
	 * @see Glyph#append(Glyph)
	 */
	public void append(Glyph g) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + "does not support append operation");
	}

	/**
	 * @see Glyph#getParent()
	 */
	public CompositeGlyph getParent() {
		return parent;
	}

	/**
	 * @see Glyph#setPosition(Point)
	 */
	public void setPosition(Point p) {
		this.position = p;
	}

	/**
	 * @see Glyph#setParent(CompositeGlyph)
	 */
	public void setParent(CompositeGlyph g) {
		parent = g;
	}
	/**
	 * @see Glyph#getPosition()
	 */
	public Point getPosition() {
		return position;
	}
	
	/**
	 * @see Glyph#setBounds(Rect)
	 */
	public void setBounds(Rect bounds) {
		this.widthAndHeight = bounds;
	}
	
	/**
	 * @see Glyph#click()
	 */
	public Command click() {
		return null;
	}
	
	/**
	 * @see Glyph#find(int, int)
	 */
	public Glyph find(int x, int y) {
		return null;
	}
	
	/**
	 * @see Glyph#createIterator()
	 */
	public Iterator<Glyph> createIterator() {
		return new NullIterator<Glyph>();
	}
	
	/**
	 * @see Glyph#accept(GlyphVisitor)
	 */
	public void accept(GlyphVisitor v) { }
}