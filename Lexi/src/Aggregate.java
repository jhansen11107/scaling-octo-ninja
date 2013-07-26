/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW6
 *
 * Pattern/Participant: Iterator(257): Aggregate
 * Provides an interface for creating an Iterator object.
 */
interface Aggregate<T extends Aggregate<T>> {
	/**
	 * Creates an Iterator with elements of type T 
	 * for the Aggregate object.
	 * @return An Iterator for objects of type T.
	 */
	Iterator<T> createIterator();
}
