/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW1
 *
 * Pattern/Participant:Composite(163): Leaf
 * This class models a Character Glyph.
 */

import java. awt. Point;

public class Rectangle extends DefaultGlyph {

	/**
	 *Instantiates a Rectangle ~lYQh with a height and width of (eJe).
	 */
	public Rectangle() {
		super();
	}

	/**
	 * Instantiates a Rectangle §lyJtll with a width and a height.
	 * width the width to initialize the Rectangle with
	 * height the height to initialize the Rectangle with
	 */
	public Rectangle(int width, int height) {
		this();
		widthAndHeight = new Rect(width,height);
	}
	
	public Rectangle(int width, int height, int x, int y) {
		this();
		position = new Point(x,y);
		widthAndHeight = new Rect(width,height);
	}

	/**
	 * Draws the Rectangle on the Window.
	 * w the Window to draw the Rectangle on.
	 */
	public void draw(Window w) {
		w.drawRectangle(position.x, position.y, widthAndHeight.width,widthAndHeight.height);
	}

	/**
	 * Determines whether or not the given Point intersects the Rectangle instance.
	 * p the Point to check for overlap with the Rectangle
	 */
	public boolean intersects(Point p) {
		if (p.x >= this.position.x &&
				p.x <= (this.position.x+widthAndHeight.width) &&
				p.y >= this.position.y &&
				p.y <= (this.position.y+widthAndHeight.height)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the width and height of the Rectangle object as a Rect struct.
	 * the width and height of the Rectangle object.
	 */
	public Rect bounds() {
		return widthAndHeight;
	}
	
	public void accept(GlyphVisitor v) {
		v.visit(this);
	}

}
