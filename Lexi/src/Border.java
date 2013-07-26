/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW2
 *
 * Pattern/Participant: Decorator(175): ConcreteDecorator
 * Decorates a CompositeGlyph by adding a border.
 */
import java.awt.Point;


public class Border extends Embellishment {
	private static int BORDER_WIDTH = 3;

	/**
	 * Instantiates a Border Embellishment and initializes
	 * the Window pointer and the embellished CompositeGlyph
	 * @param w the Window to draw on
	 * @param c the CompositeGlyph to embellish with a scroll bar
	 */
	public Border(Window w, CompositeGlyph c) {
		super(w,c);
	}

	/**
	 * Instantiates a Border Embellishment, initializes
	 * the Window pointer, the embellished CompositeGlyph,
	 * and the parent pointer
	 * @param parent the parent CompositeGlyph to set
	 * @param w the Window to draw on
	 * @param c the CompositeGlyph to embellish with a scroll bar
	 */
	public Border(CompositeGlyph parent, CompositeGlyph c, Window w) {
		this(w,c);
		if (parent != null) {
			setParent(parent);
			parent.append(this);
		}
	}

	/**
	 * Draws the CompositeGlyph and a border
	 * @param w the Window to draw on
	 */
	public void draw(Window w) {
		c.draw(w);
		w.addBorder(position.x, position.y, position.x+bounds(w).width,
				position.y+bounds(w).height, BORDER_WIDTH);
	}

	/**
	 * Sets the bounds of the Border and of the
	 * CompositeGlyph it embellishes
	 * @param bounds the bounds of the Border Embellishment
	 */
	public void setBounds(Rect bounds) {
		this.widthAndHeight = new Rect(bounds.width+(2*BORDER_WIDTH),bounds.height+(2*BORDER_WIDTH));
		c.setBounds(bounds);
	}

	/**
	 * Returns the bounds of the Border
	 * @param w Window to use for size computations
	 * @return the bounds of the Embellishment
	 */
	public Rect bounds(Window w) {
		return new Rect(c.bounds(w).width+(2*BORDER_WIDTH),c.bounds(w).height+(2*BORDER_WIDTH));
	}

	/**
	 * Sets the position of the Border and the embellished
	 * CompositeGlyph
	 * @param p the position of the Border
	 */
	public void setPosition(Point p) {
		this.position = p;
		c.setPosition(new Point(p.x+BORDER_WIDTH,p.y+BORDER_WIDTH));
	}
}