 /**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW1
 *
 * Pattern/Participant: Strategy(315): Context
 * The interface for objects of type Composition.
 */
interface Composition extends Glyph {
 /**
 * Sets the Composition's Compositor.
 * @param compositor the Compositor to set
 */
 void setCompositor(Compositor compositor);

 /**
 * Coefficient used for positioning children of the Composition.
 * A value of 1 is used for Compositions intending to position adjacent children
 * further and further along the x-axis. A value of 0 is used for Compositions
 * intending to position adjacent children at the same point along the x-axis.
 * @return the x coefficient used for positioning children of the Composition
 */
 int xCoefficient();

 /**
 * Coefficient used for positioning children of the Composition.
 * A value of 1 is used for Compositions intending to position adjacent children
 * further and further along the y-axis. A value of 0 is used for Compositions
 * intending to position adjacent children at the same point along the y-axis.
 * @return the y coefficient used for positioning children of the Composition
 */
 int yCoefficient();

 /**
 * Grows the width and height of the cursor object according
 * to the width and height of the child Glyph.
 * @param cursor the cursor to modify
 * @param child the Glyph to use to grow the cursor with
 */
 void moveCursor(Rect cursor, Glyph child);

}