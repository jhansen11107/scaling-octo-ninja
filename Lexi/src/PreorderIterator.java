/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW6
 * 
 * Pattern/Participant: Iterator(257): ConcreteIterator
 * Iterates over a collection in a preorder manner.
 */


import java.util.Stack;

public class PreorderIterator<T extends Aggregate<T>> implements Iterator<T> {
	private Stack<Iterator<T>> stack;
	private T root;
	
	/**
	 * Creates a new PreorderIterator.
	 * @param root the root of the collection to traverse in a preorder
	 * manner.
	 */
	public PreorderIterator(T root) {
		stack = new Stack<Iterator<T>>();
		this.root = root;
	}
	
	/**
	 * @see Iterator#first()
	 */
	public void first() {
		Iterator<T> rootIterator = root.createIterator();
		rootIterator.first();
		stack.push(rootIterator);
	}
	
	/**
	 * @see Iterator#next()
	 */
	public void next() {
		Iterator<T> topIterator = stack.peek().currentItem().createIterator();
		topIterator.first();
		stack.push(topIterator);
		while (!stack.isEmpty() && stack.peek().isDone()) {
			stack.pop();
			if (!stack.isEmpty() && !stack.peek().isDone()) {
				stack.peek().next();
			}
		}
	}
	
	/**
	 * @see Iterator#isDone()
	 */
	public boolean isDone() {
		return stack.isEmpty();
	}
	
	/**
	 * @see Iterator#currentItem()
	 */
	public T currentItem() {
		return stack.peek().currentItem();
	}
}
