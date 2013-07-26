/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW6
 * 
 * Pattern/Participant: Iterator(257): ConcreteIterator
 * Iterator for objects that can't be iterated over.
 */

public class NullIterator<T extends Aggregate<T>> implements Iterator<T> {

	/**
	 * @see Iterator#first()
	 */
	public void first() { }

	/**
	 * @see Iterator#next()
	 */
	public void next() { }

	/**
	 * Always returns false.
	 * @return false.
	 */
	public boolean isDone() { 
		return true;
	}

	/**
	 * @see Iterator#currentItem()
	 */
	public T currentItem() {
		return null;
	}

}
