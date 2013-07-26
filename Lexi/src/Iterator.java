/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW6
 * 
 * Pattern/Participant: Iterator(257): Iterator
 * Interface for access and traversal.
 * @param <T> the type to iterate over
 */
public interface Iterator<T extends Aggregate<T>> {
	/**
	 * Initializes the Iterator to point at the first/root object
	 * in its traversal.
	 */
	void first();
	
	/**
	 * Causes the Iterator to traverse to the next object
	 * in its traversal.
	 */
	void next();
	
	/**
	 * Whether or not the Iterator is at the end of its traversal.
	 * @return true if done traversing, false otherwise
	 */
	boolean isDone();
	
	/**
	 * Returns a point to the current item in the traversal.
	 * @return the current item in the traversal.
	 */
	T currentItem();
}
