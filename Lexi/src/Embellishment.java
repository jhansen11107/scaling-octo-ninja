/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW2
 *
 * Pattern/Participant: Decorator(175): Decorator
 * An abstract class for other Embellishments to inherit from.
 */
import java.awt.Point;

public abstract class Embellishment extends CompositeGlyph {
	//The CompositeGlyph to embellish.
	protected CompositeGlyph c;

	public Embellishment(Window w, CompositeGlyph c) {
		super(w);
		this.c = c;
		c.setCompositor(compositor);
	}

	/**
	 * @see Composition#xCoefficient()
	 */
	public int xCoefficient() {
		return c.xCoefficient();
	}
	/**
	 * @see Composition#yCoefficient()
	 */
	public int yCoefficient() {
		return c.yCoefficient();
	}

	/**
	 * @see CompositeGlyph#insert(Glyph, int)
	 */
	public void insert(Glyph g, int i) {
		c.insert(g,i,this);
	}

	/**
	 * @see CompositeGlyph#append(Glyph)
	 */
	public void append(Glyph g) {
		c.append(g,this);
	}
	
	public void append(Glyph g, CompositeGlyph parent) {
		c.append(g,parent);
	}

	/**
	 * @see CompositeGlyph#insert(Glyph, int, CompositeGlyph)
	 */
	public void insert(Glyph g, int i, CompositeGlyph parent) {
		c.insert(g, i, parent);
	}

	/**
	 * @see CompositeGlyph#remove(Glyph)
	 */
	public void remove(Glyph g) {
		c.remove(g);
	}

	/**
	 * @see Composition#movecursor(Rect, Glyph)
	 */
	public void moveCursor(Rect cursor, Glyph child) {
		c.moveCursor(cursor, child);
	}

	/**
	 * @see Composition#setCompositor(Compositor)
	 */
	public void setCompositor(Compositor compositor) {
		c.setCompositor(compositor);
	}

	/**
	 * @see Glyph#setParent(CompositeGlyph)
	 */
	public void setParent(CompositeGlyph parent) {
		c.setParent(parent);
	}

	/**
	 * @see Glyph#getParent()
	 */

	public CompositeGlyph getParent() {
		return c.getParent();
	}
	
	/**
	 * @see Glyph#intersects(Point)
	 */
	public boolean intersects(Point p) {
		return c.intersects(p);
	}
	
	/**
	 * @see Glyph#createIterator()
	 */
	public Iterator<Glyph> createIterator() {
		return c.createIterator();
	}
	
	/**
	 * @see CompositeGlyph#find(int,int)
	 */
	public Glyph find(int x, int y) {
		return c.find(x, y);
	}

	/**
	 * Draws the CompositeGlyph and its embellishment
	 * @param w the Window to draw on
	 */
	public abstract void draw(Window w);
}