import java.util.HashMap;

/**
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW3
 *
 * Pattern/Participant: AbstractFactory(87): AbstractFactory
 * Pattern/Participant: Singleton(127): Singleton
 * Pattern/Participant: FactoryMethod(187): Creator
 * Provides interface for other, concrete factories.
 */

abstract class GUIFactory {
	private static GUIFactory instance;
	private static final HashMap<String,GUIFactory> registry = new HashMap<String,GUIFactory>();

	/**
	 * Factory method for creation of new Button Glyphs.
	 * Button Glypbs embellish other CompositeGlyphs.
	 * @param w the Window the Button will appear on.
	 * @param c the CompositeGlyph to embellish
	 * @return a concrete Button object produced by the single
	 * concrete GUIFactory instance
	 */
	abstract Button newButton(Window w, CompositeGlyph c);

	/**
	 * Factory method for creation of new Label Glyphs.
	 * Label Glyphs embellish other CompositeGlyphs.
	 * @param w the Window the Label will appear on.
	 * @param c the CompositeGlyph to embellish
	 * @return a concrete Label object produced by the single
	 * concrete GUIFactory instance
	 */
	abstract Label newLabel(Window w, CompositeGlyph c);

	/**
	 * Provides the single point of access for acqu1r1ng concrete GUIFactory
	 * instances. Requires that the "lexilookandfeel" environment variable is set.
	 * @return the single concrete GUIFactory instance for the current JVM.
	 */
	public static GUIFactory instance() {
		if (instance==null) {
			String lookAndFeelName = System.getenv("lexilookandfeel");
			try {

				/*
				 * We want to force the class loader to initialize the subclass named
				 * by the lexilookandfeel environment variable (if it exists) and execute
				 * any static blocks contained therein, which should contain
				 *a call to GUIFactory.register( ... ).
				 */

				Class.forName(lookAndFeelName.substring(0,1).toUpperCase() +
						lookAndFeelName.substring(1) + "Factory");
			} catch (ClassNotFoundException e) { }
			instance = registry.get(lookAndFeelName);
		}
		return instance;
	}

	/**
	 * Method called by subclasses to register their concrete instance with the
	 * registry of GUIFactory objects in this class.
	 * @param lookAndFeelName the name of the look&feel to associate the factory with
	 * @param factory the instance of the subclass to register
	 */
	protected static void register(String lookAndFeelName, GUIFactory factory) {
		registry.put(lookAndFeelName, factory);
	}

	/**
	 * Create method for Button object creation. This method simply returns the
	 * results of the factory method.
	 * @param w the Window the Button will appear on.
	 * @param c the CompositeGlyph the Button will embellish
	 * @return the Button returned from the result of the factory method.
	 */
	public Button createButton(Window w, CompositeGlyph c) {
		Button b = newButton(w, c);
		return b;
	}
	/**

	 * Create method for Button object creation. This method simply returns the
	 * results of the factory method.
	 * @param w the Window the Button will appear on.
	 * @param c the CompositeGlyph the Button will embellish
	 * @return the Button returned from the result of the factory method.
	 */
	public Label createLabel(Window w, CompositeGlyph c) {
		Label l = newLabel(w, c);
		return l;
	}
}
