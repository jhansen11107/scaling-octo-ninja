/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW5
 *
 * Pattern/Participant: Abstract Factory(87): AbstractProduct
 * Pattern/Participant: Factory Method(107): Product
 * Pattern/Participant: Chain of Responsibility(233): ConcreteHandler1
 * Provides interface for other, concrete buttons.
 */
import java.awt.Point;

public abstract class Button extends Embellishment {
	private String color;
	private Command command;

	/**
	 * Instantiates a Button Embellishment and initializes
	 * the Window pointer and the embellished CompositeGlyph
	 * @param w the Window to draw on
	 * @param c the CompositeGlyph to embellish with a button
	 * @param color the color of the button
	 */
	public Button(Window w, CompositeGlyph c, String color) {
		super(w,c);
		this.color = color;
	}

	/**
	 * Instantiates a Button Embellishment, initializes
	 * the Window pointer, the embellished CompositeGlyph,
	 * and the parent pointer
	 * @param parent the parent CompositeGlyph to set
	 * @param w the Window to draw on
	 * @param c the CompositeGlyph to embellish with a button
	 * @param color the color of the button
	 */
	public Button(CompositeGlyph parent, CompositeGlyph c, Window w, String color) {
		this(w,c,color);
		if (parent != null) {
			setParent(parent);
			parent.append(this);
		}
	}

	/**
	 * Draws the embellished CompositeGlyph and a button surrounding it.
	 * @param w the Window to draw on
	 */
	public void draw(Window w) {
		w.drawButton(position.x, position.y, bounds(w).width, bounds(w).height, color);
		c.draw(w);
	}

	/**

	 * Sets the bounds of the Button and of the
	 * CompositeGlyph it embellishes
	 * @param bounds the bounds of the Button Embellishment
	 */
	public void setBounds(Rect bounds) {
		this.widthAndHeight = bounds;
		c.setBounds(bounds);
	}

	/**
	 * Returns the bounds of the Button
	 * @param w Window to use for size computations
	 * @return the bounds of the Button
	 */
	public Rect bounds(Window w) {
		return new Rect(c.bounds(w).width,c.bounds(w).height);
	}

	/**
	 * Sets the position of the Button and the embellished
	 * CompositeGlyph
	 * @param p the position of the Button
	 */
	public void setPosition(Point p) {
		this.position = p;
		c.setPosition(p);
	}
	
	/**
	 * Sets the Command object that should be returned when the Button's
	 * click() method is called.
	 * @param c the Command object to return
	 */
	public void setCommand(Command c) {
		command = c;
	}
	
	/**
	 * If the button intersects the x,y pair, it is found, so return
	 * a self-reference.
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return the Button that is found
	 */
	public Glyph find(int x, int y) {
		if (intersects(new Point(x,y))) {
			return this;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns a Command to execute when the button is clicked.
	 * @return the Command to execute when the button is clicked. 
	 */
	public Command click() {
		return command;
	}
}
