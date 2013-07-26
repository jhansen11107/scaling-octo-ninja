/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW4
 *
 * Pattern/Participant: Bridge(151): Abstraction
 * Pattern/Participant: Command(233): Invoker
 * Pattern/Participant: Command(233): Receiver
 * Pattern/Participant: Chain of Responsibility(223): Client
 * A class that provides an abstract Window interface.
 */

abstract class Window {
	private WindowImp imp;
	private Glyph contents;
	private KeyMap km;
	private static WindowImpFactory wif = WindowImpFactory.instance();

	/**
	 * Constructor for a generic Window abstraction, called through concrete
	 * subclasses.
	 * @param title the title to display above the Window
	 */
	public Window(String title) {
		imp = wif.createWindowImp(title, this);
	}

	/**
	 * Draws the Window's contents.
	 */
	public void draw() {
		contents.draw(this);
	}

	/**
	 * Sets the Window's contents.
	 * @param glyph the GlyQh that the Window contains
	 */
	public void setContents(Glyph glyph) {
		contents = glyph;
		imp.setContents();
	}

	/**
	 * Draws a character on the Window.
	 * @param c the char to draw
	 * @param x the x position of c
	 * @param y the y position of c
	 */
	public void drawCharacter(char c, int x, int y) {
		imp.drawCharacter(c, x, y);
	}

	/**
	 * Draws a rectangle on the Window.
	 */
	public void drawRectangle(int x, int y, int width, int height) {
		imp.drawRectangle(x, y, width, height);
	}

	/**
	 * Determines a character's width.
	 * @param c the character to determine the width of
	 * @return the width of a character as drawn on the Window.
	 */
	public int charWidth(char c) {
		return imp.charWidth(c);
	}

	/**
	 * Determines a character's height.
	 * @param c the character to determine the height of
	 * @return the height of a character as drawn on the Window.
	 */
	public int charHeight(char c) {
		return imp.charHeight(c);
	}

	public void addBorder(int x1, int y1, int x2, int y2, int width) {
		imp.addBorder(x1, y1, x2, y2, width);
	}

	public void addScrollBar(int x, int y, int width, int height) {
		imp.addScrollBar(x, y, width, height);
	}

	/**
	 * Draws a button on the Window.
	 * @param x the x position of the upper-left corner of the button
	 * @param y the position of the upper-left corner of the button
	 * @param width the width of the button's entire area
	 * @param height the height of the button's entire area
	 * @param color the color to shade the button area
	 */
	public void drawButton(int x, int y, int width, int height, String color) {
		imp.drawButton(x, y, width, height, color);
	}

	/**
	 * Draws a label on the Window.
	 * @param x the x position of the upper-left corner of the label
	 * @param y the y position of the upper-left corner of the label
	 * @param width the width of the label's entire area
	 * @param height the height of the label's entire area
	 */

	public void drawLabel(int x, int y, int width, int height, String color) {
		imp.drawLabel(x, y, width, height, color);
	}
	
	/**
	 * The font size of the characters in the Window
	 * @return the Window's font size
	 */
	public int getFontSize() {
		return imp.getFontSize();
	}
	
	/**
	 * Sets the font size of the characters in the Window
	 * @param size the font size to set
	 */
	public void setFontSize(int size) {
		imp.setFontSize(size);
		imp.repaint();
		contents.draw(this);
	}
	
	/**
	 * Initiates a click request to the Window's content tree and
	 * executes the Glyph that responds with a Command.
	 * @param x the x position of the click
	 * @param y the y position of the click
	 */
	public void click(int x, int y) {
		Glyph clickedGlyph = contents.find(x,y);
		if (clickedGlyph != null) {
			Command com = clickedGlyph.click();
			if (com != null) {
				com.execute();
				if (com.reversible()) {
					CommandHistory.instance().push(com);
				}
			}
		}
	}
	
	/**
	 * Queries the KeyMap for a Command for the given character and
	 * executes it if found.
	 * @param c the character that is a key for a Command in the KeyMap
	 */
	public void key(char c) {
		Command com = km.get(c);
		if (com != null) {
			com.execute();
			if (com.reversible()) {
				CommandHistory.instance().push(com);
			}
		}
	}
	
	public void setKeyMap(KeyMap km) {
		this.km = km;
	}
	
	public KeyMap getKeyMap() {
		return km;
	}
}