// @author Josh Hansen
import java. awt. Point;

public class SimpleCompositor implements Compositor {
	private Composition composition;

	/**
	 * Sets the Composition object to compose
	 * composition the Composition to compose
	 */
	public void setComposition(Composition composition) {
		this.composition = composition;
	}

	/**
	 * Composes the Compositor's Composition object using a basic algorithm.
	 * w the Window to draw the Composition on
	 */
	public void compose() {
		/*
		 * Iterate through the Composition's children, computing widths and heights,
		 * and adjusting positions accordingly.
		 */
		Rect cursor = new Rect(0,0);
		int xc = composition.xCoefficient();
		int yc = composition.yCoefficient();
		Iterator<Glyph> i = composition.createIterator();
		
		for (i.first(); !i.isDone(); i.next()) {
			Glyph child = i.currentItem();
			Point position = composition.getPosition();
			child.setPosition(new Point(position.x + (cursor.width*xc), position.y +(cursor.height*yc)));
			composition.moveCursor(cursor,child);
		}
		//Set the Composition's width and height
		composition.setBounds(cursor);
		//Process the Composition's parent
		if (composition.getParent() != null) {
			composition.getParent().compositor.compose();
		}
	}
}