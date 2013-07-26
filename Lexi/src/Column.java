/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW1
 *
 * Pattern/Participant: Composite(163): Composite
 * An implementation of the Column Glyph.
 */
import java.awt.Point;

public class Column extends CompositeGlyph {

	/**
	 * Instantiates a Column Glyph and initializes the Column's parent pointer
	 * @param window the window the column's children will appear on
	 * @param parent the Column's parent CompositeGlyph
	 */
	public Column(CompositeGlyph parent, Window w) {
		super(w);
		if (parent != null) {
			setParent(parent);
			parent.append(this);
		}

	}

	/**
	 * Instantiates a Column Glyph with a sequence of strings. Each
	 * string is inserted in a new Row which is in turn inserted into
	 * the Column.
	 * @param parent the Row's parent CompositeGlyph
	 * @param window the window the row's children will appear on
	 * @param strings the string sequence to insert into the new rows
	 */
	public Column(CompositeGlyph parent, String[] strings, Window w) {
		super(w);
		for (int i=0; i < strings.length; i++) {
			append(new Row(null,strings[i],w));
			children.get(children.size()-1).setParent(this);
		}
		if (parent != null) {
			setParent(parent);
			parent.append(this);
		}
	}

	/**
	 * Instantiates a Column Glyph with a sequence of strings. Each
	 * string is inserted in a new Row which is in turn inserted into
	 * the Column.
	 *
	 * @param window the window the Column's children will appear on
	 * @param s the string sequence to insert into the new rows
	 */

	public Column(Window w, String[] strings) {
		super(w);
		for (int i=0; i < strings.length; i++) {
			append(new Row(null,strings[i],w));
			children.get(children.size()-1).setParent(this);
		}
	}

	/**
	 * Sets the position of the Column Glyph, and the position of the Glyph's
	 * children.
	 * @param p the new position of the Column
	 */
	public void setPosition(Point p) {
		int offset = p.y-position.y;
		for (Glyph g : children) {
			g.setPosition(new Point(p.x,g.getPosition().y+offset));
		}

		this.position = p;
	}

	/**
	 * @see Composition#xCoefficient()
	 */
	public int xCoefficient() {
		return 0;
	}

	/**
	 * @see Composition#yCoefficient()
	 */
	public int yCoefficient() {
		return 1;
	}
}
