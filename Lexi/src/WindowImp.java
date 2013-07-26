/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW4
 *
 * Pattern/Participant: Bridge(151): Implementor
 * Generic interface for classes that provide an implementation
 * of window functionality.
 */

interface WindowImp {

	/**
	 * Draws a character.
	 * c the char to draw
	 * x the x position of c
	 * y the y position of c
	 */
	void drawCharacter(char c, int x, int y);
	/**
	 * Drawsa  rectangle.
	 *x the x position of the upper-left corner of the rectangle
	 *y the y position of the upper-left corner of the rectangle
	 *width the width of the rectangle
	 *height the height of the rectangle
	 */
	void drawRectangle(int x, int y, int width, int height);

	/**
	 * Determines a character's width.
	 * c the character to determine the width of
	 * the width of a character as drawn by the Windowimp.
	 */
	int charWidth(char c);
	/**
	 * Determines a character's height.
	 * c the character to determine the height of
	 * the height of a character as drawn by the Windowimp.
	 */
	int charHeight(char c);
	/**
	 * Called when the Window sets its own actual contents.
	 * Re-instantiates and clears the frame and pane objects.
	 */
	void setContents();

	/**
	 * Draws a border.
	 * xl the x position of the left side of the border
	 * yl the y position of the top of the border
	 *
	 *
	 *
	 *x2 the x position of the right side of the border
	 *y2 the y position of the bottom of the border
	 *width the thickness of the border
	 */

	void addBorder(int x1, int y1, int x2, int y2, int width);
	/**
	 * Draws a scroll bar.
	 * x the x position of the left side of the scroll bar
	 * y the y position of the top of the scroll bar
	 * tnln:~r~1m width the width of the scroll bar
	 * height the height of the scroll bar
	 */
	void addScrollBar(int x, int y, int width, int height);
	/**
	 * Draws a button.
	 * x the x position of the upper-left corner of the button
	 * y the position of the upper-left corner of the button
	 * width the width of the button's entire area
	 * height the height of the button's entire area
	 * color the color to shade the button area
	 */
	void drawButton(int x, int y, int width, int height, String color);
	/**
	 * Draws a label.
	 * x the x position of the upper-left corner of the label
	 * ~n:~r~1m y the y position of the upper-left corner of the label
	 * width the width of the label's entire area
	 * height the height of the label's entire area
	 * color the color to shade the label's boundaries
	 */
	void drawLabel(int x, int y, int width, int height, String color);
	
    int getFontSize();
    void setFontSize(int size);

    void repaint();
}