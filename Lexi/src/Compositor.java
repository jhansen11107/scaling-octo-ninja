/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW1
 *
 * Pattern/Participant: Strategy(315): Strategy
 * Interface for abstract Compositor objects.
 */

interface Compositor {
	/**
	 * Sets the Compositor's Composition pointer.
	 * @param c the Composition object to be composed by compose().
	 */
	void setComposition(Composition c);

	/**
	 * Composes the Compostior's Composition object. Not very useful
	 * unless setComposition has been previously called.
	 */
	void compose();
}