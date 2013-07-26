/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW4
 *
 * Pattern/Participant: AbstractFactory(87): AbstractFactory
 * Pattern/Participant: Singleton(127): Singleton
 * Pattern/Participant: FactoryMethod(187): Creator
 * Provides interface for other, concrete factories.
 */

import java.util.HashMap;

abstract class WindowImpFactory {
	private static WindowImpFactory instance;
	private static final HashMap<String,WindowImpFactory> registry = new HashMap<String,WindowImpFactory>();

	/**
	 * Factory method for creation of new Windowimp objects.
	 * @param w the Window handle that the Windowimp object
	 * @param will hold a reference to.
	 * @param title the Window title.
	 */
	public abstract WindowImp newWindowImp(String title, Window w);
	/**
	 * Provides the single point of access for acqu1r1ng concrete WindowImpFactory
	 * instances. Requires that the "LexiWindow" environment variable is set.
	 * the single concrete WindowImpFactory instance for the current JVM.
	 */
	public static WindowImpFactory instance() {
		if (instance==null) {
			String windowName = System.getenv("LexiWindow");
			try {
				/*
				 * We want to force the class loader to initialize the subclass named
				 * by the LexiWindow environment variable (if it exists) and execute
				 * any static blocks contained therein, which should contain
				 *a call to WindowImpFactory.register( ... ).
				 */
				Class.forName(windowName.substring(0,1).toUpperCase() + windowName.substring(1) + "Factory");
			} catch (ClassNotFoundException e) { }
			instance = registry.get(windowName);
		}
		return instance;
	}

	/**
	 * Method called by subclasses to register their concrete instance with the
	 * registry of WindowImpFactory objects in this class.
	 * @param windowimpName the name of the window implementation to associate the factory with
	 * @param factory the instance of the subclass to register
	 */
	protected static void register(String windowImpName, WindowImpFactory factory) {
		registry.put(windowImpName, factory);
	}

	/**
	 * Create method for Windowimp object creation. This method simply returns the
	 * results of the factory method.
	 * w the Window handle that the Windowimp object
	 * will hold a reference to.
	 * @param title the Window title.
	 * @param the Windowimp returned from the result of the factory method.
	 */
	public WindowImp createWindowImp(String title, Window w) {
		WindowImp wi = newWindowImp(title,w);
		return wi;
	}
}
