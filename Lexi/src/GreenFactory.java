/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW3
 *
 * Pattern/Participant: AbstractFactory(87): ConcreteFactory
 * Pattern/Participant: Singleton(127): Singleton
 * Pattern/Participant: FactoryMethod(197): ConcreteCreator
 * Provides methods for instantiating objects with a "Green" look and feel.
 */
public final class GreenFactory extends GUIFactory {
	private static final GreenFactory instance = new GreenFactory();

	/**
	 * Static block which allows the class to register its instance with the parent class.
	 */
	static {
		GUIFactory.register("green", instance);
	}

	private GreenFactory() { }

	/**
	 * GUIFactory#newButton(Window,CompositeGlyph)
	 */
	public Button newButton(Window w, CompositeGlyph c) {
		return new GreenButton(w,c);
	}

	/**
	 * GUIFactory#newLabel(Window, CompositeGlyph)
	 */
	public Label newLabel(Window w, CompositeGlyph c) {
		return new GreenLabel(w,c);
	}

	/*
	 *Pattern/Participant: AbstractFactory(87): ConcreteProduct
	 *Pattern/Participant: FactoryMethod(197): ConcreteProduct
	 * A class for representing green buttons.
	 */
	private class GreenButton extends Button {
		/**
		 * Instantiates a green Button Embellishment and initializes
		 * the Window pointer and the embellished CompositeGlyph
		 * w the Window to draw on
		 * c the CompositeGlyph to embellish with a button
		 */
		private GreenButton(Window w, CompositeGlyph c) {
			super(w,c,"green");

		}
	}

	/*
	 *Pattern/Participant: AbstractFactory(87): ConcreteProduct
	 *Pattern/Participant: FactoryMethod(107): ConcreteProduct
	 * A class for representing green labels.
	 */
	private class GreenLabel extends Label {
		/**
		 * Instantiates a green Label Embellishment and initializes
		 * the Window pointer and the embellished CompositeGlyph
		 * w the Window to draw on
		 * c the CompositeGlyph to embellish with a label
		 */
		private GreenLabel(Window w, CompositeGlyph c) {
			super(w,c,"green");
		}
	}
}