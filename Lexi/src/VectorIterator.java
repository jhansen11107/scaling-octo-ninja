/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW6
 *
 * @param <T> the type of objects in a Vector to iterate over
 * Pattern/Participant: Iterator(257): ConcreteIterator
 */

import java.util.*;

public class VectorIterator<T extends Aggregate<T>> implements Iterator<T> {
	private Vector<T> v;
	private T item;
	
	/**
	 * Creates a new Iterator object for java.util.Vector objects.
	 * @param vector the vector to iterate over.
	 */
	public VectorIterator(Vector<T> vector) {
		v = vector;
	}

	/**
	 * @see Iterator#first()
	 */
	public void first() {
		item = v.firstElement();
	}

	/**
	 * @see Iterator#next()
	 */
	public void next() {
		try {
			item = v.get(v.indexOf(item)+1);
		} catch (ArrayIndexOutOfBoundsException e) {
			item = null;
		}
	}

	/**
	 * @see Iterator#isDone()
	 */
	public boolean isDone() {
		return item==null;
	}

	/**
	 * @see Iterator#currentItem()
	 */
	public T currentItem() {
		return item;
	}
	

}
