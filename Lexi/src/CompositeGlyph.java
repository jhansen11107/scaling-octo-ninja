/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW1
 * 
 * Pattern/Participant: Composite(163): Composite
 * Pattern/Participant: Strategy(315): Context
 * Pattern/Participant: Chain of Responsibility(233): Handler
 * Pattern/Participant: Iterator(257): ConcreteAggregate
 * Pattern/Participant: Visitor(331): ConcreteElement
 */

import java.awt.Point;
import java.util.Vector;

public abstract class CompositeGlyph extends DefaultGlyph implements Composition {
	protected Vector<Glyph> children = new Vector<Glyph>();
	protected Compositor compositor = new SimpleCompositor();
	protected Window window;

	/**
	 * Default constructor for CompositeGlyph objects. Instantiates and
	 * sets a SimpleCompositor as the instance's Compositor.
	 */
	public CompositeGlyph() {
		super();
		compositor.setComposition(this);
	}
	
	/**
	 * Instantiates and sets a SimpleCompositor as the instance's Compositor.
	 * @param window the Window the CompositeGlyph is to be drawn on
	 */
	public CompositeGlyph(Window window) {
		this.window = window;
		compositor.setComposition(this);
	}

	/**
	 * Inserts a Glyph into the CompositeGlyph's list of child objects
	 * at an arbitrary position.
	 * @param g the Glyph to insert
	 * @param i the position to insert the Glyph at
	 */
	public void insert(Glyph g, int i) {
		insert(g,i,this);
	}

	/**
	 * Appends a Glyph object to the end of the list of child objects.
	 * @param g the Glyph to append
	 */
	public void append(Glyph g) {
		insert(g,children.size());
	}
	
	/**
	 * Appends a Glyph object to the end of the list of child objects.
	 * @param g the Glyph to append
	 */
	public void append(Glyph g, CompositeGlyph parent) {
		insert(g,children.size(),parent);
	}

	/**
	 * Inserts a Glyph into the CompositeGlyph's list of child objects
	 * at an arbitrary position and sets the Glyph's parent reference.
	 * After the removal, the remaining children are recomposed.
	 * @param g the Glyph to insert
	 * @param i the position to insert the Glyph at
	 * @param parent the object to set the Glyph's parent reference to
	 */
	public void insert(Glyph g, int i, CompositeGlyph parent) {
		g.setParent(parent);
		children.add(i,g);
		compositor.compose();
	}

	/**
	 * Removes a Glyph from the list of child objects
	 * @param g the Glyph to remove
	 */
	public void remove(Glyph g) {
		children.remove(g);
		compositor.compose();
	}

	/**
	 * Sets the CompositeGlyph's Compositor object
	 * @param compositor the compositor object to use
	 */
	public void setCompositor(Compositor compositor) {
		this.compositor = compositor;
	}

	/**
	 * Returns a Rect containing width and height information of the CompositeGlyph
	 * @return a Rect struct containing the CompositeGlyph's width and height
	 */
	public Rect bounds() {
		return widthAndHeight;
	}
	
	/**
	 * Returns a Rect containing width and height information of the CompositeGlyph
	 * @param w unused, required by the Glyph interface
	 * @return a Rect struct containing the CompositeGlyph's width and height
	 */
	public Rect bounds(Window w) {
		return bounds();
	}

	/**
	 * Draws all of the CompositeGlyph's children in the Window passed in.
	 * @param w the Window to draw the children on
	 */
	public void draw(Window window) {
		compositor.compose();
		for (Glyph child : children) {
			child.draw(window);
		}
	}
	
	/**
	 * Draws all of the CompositeGlyph's children in the Window passed in.
	 */
	public void draw() {
		draw(window);
	}
	
	/**
	 * @see Glyph#intersects(Point)
	 */

	public boolean intersects(Point p) {
		return new Rectangle(widthAndHeight.width,widthAndHeight.height,position.x,position.y).intersects(p);
	}

	/**
	 * Grows the height and the width of the passed-in cursor using the
	 * height and width of the passed in child using methods of
	 * the concrete subclasses of CompositeGlyph.
	 */
	public void moveCursor(Rect cursor, Glyph child) {
		int xc = xCoefficient();
		int yc = yCoefficient();
		Rect childBounds = child.bounds(window);
		cursor.width += childBounds.width*xc;
		cursor.height += childBounds.height*yc;

		if ((childBounds.width*yc) > cursor.width) {
			cursor.width = childBounds.width*yc;
		}

		if ((childBounds.height*xc) > cursor.height) {
			cursor.height = childBounds.height*xc;
		}
	}
	
	/**
	 * Determines if any of the Glyph's children intersect the x,y pair passed in. 
	 * @param x the x-coordinate of the Glyph being requested
	 * @param y the y-coordinate of the Glyph being requested
	 * @return the Glyph intersecting the coordinates, if found
	 */
	public Glyph find(int x, int y) {
		for (int i=0; i < children.size(); i++) {
			Glyph child = children.get(i);
			if (child.intersects(new Point(x,y))) {
				return child.find(x, y);
			}
		}
		return null;
	}
	
	/**
	 * @see Aggregate#createIterator()
	 */
	public Iterator<Glyph> createIterator() {
		return new VectorIterator<Glyph>(children);
	}
	
	/**
	 * @see Glyph#accept(GlyphVisitor)
	 */
	public void accept(GlyphVisitor v) {
		v.visit(this);
	}
}