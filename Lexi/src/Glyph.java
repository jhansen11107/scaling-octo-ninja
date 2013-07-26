/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW1
 * 
 * Pattern/Participant: Composite(163): Component
 * Pattern/Participant: Command(233): Receiver
 * Pattern/Participant: Visitor(331): Element
 * Pattern/Participant: Chain of Responsibility(223): Handler
 */
import java.awt.Point;

interface Glyph extends Aggregate<Glyph> {

	/**
	 * Draws the Glyph on the Window.
	 * @param w the Window to draw the Glyph on.
	 * @throws UnsupportedOperationsException if the draw operation is not supported by
	 */
	void draw(Window w);

	/**
	 * Determines whether or not the Glyph intersects the Point.
	 * @param p the Point to check
	 * @return true if the Glyph intersects the Point, false otherwise
	 * @throws UnsupportedOperationsException if the intersects operation is not
	 */
	boolean intersects(Point p);

	/**
	 * Returns the bounds of the Glyph.
	 * @return a struct containing the width and the height of the Glyph.
	 * @throws UnsupportedOperationsException if the bounds operation is not supported
	 */
	Rect bounds();

	/**
	 * Returns the bounds of the Glyph.
	 * @param w the Window the Glyph is drawn on
	 * @return a struct containing the width and the height of the Glyph.
	 * @throws UnsupportedOperationsException if the bounds operation is not supported
	 */
	Rect bounds(Window w);

	/**
	 * Setter method for setting the bounds of a Glyph.
	 * @param bounds a Rect containing the width and height of the Glyph
	 */
	void setBounds(Rect bounds);

	/**
	 * Inserts the child Glyph g into the list of children at position i.
	 * @param g the child Glyph to insert.
	 * @param i the position to insert the child Glyph at.
	 */
	void insert(Glyph g, int i);

	/**
	 * Appends the child Glyph g at the end of the list of children.
	 * @param g the Glyph to append.
	 * @throws UnsupportedOperationsException if the insert operation is not supported
	 */
	void append(Glyph g);

	/**
	 * Removes the Glyph from the list of children.
	 * @param g the GlyRh to remove.
	 * @throws UnsupportedOperationsException if the remove operation is not supported
	 */
	void remove(Glyph g);

	/**
	 * Getter method for retrieving the Glyph's parent object.
	 * @return the CompositeGlyph that is a parent of the Glyph, or null if none
	 */
	CompositeGlyph getParent();

	/**
	 * Sets the position of the Glyph.
	 * @param p the position to set the Glyph to.
	 */
	void setPosition(Point p);

	/**
	 * Getter method for the Glyph's position.
	 * @return a Point containing the Glyph's (x,y) coordinates.
	 */
	Point getPosition();

	/**
	 * Sets the parent of the Glyph.
	 * @param g the CompositeGlyph that is the parent of the Glyph.
	 */
	void setParent(CompositeGlyph g);

	/**
	 * @return the Command to perform when the Glyph is clicked.
	 */
	Command click();

	/**
	 * Initiates a request to find the Glyph that intersects the x,y pair passed-in.
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return the Glyph that is found or null if not found
	 */
	Glyph find(int x, int y);

	/**
	 * Accepts the GlyphVisitor object for analysis.
	 * @param v the GlyphVisitor object to accept.
	 */
	void accept(GlyphVisitor v);

}
