/**
 * Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW3
 *
 * Pattern/Participant: AbstractFactory(87): ConcreteFactory
 * Pattern/Participant: Singleton(127): Singleton
 * Pattern/Participant: FactoryMethod(187): ConcreteCreator
 * Provides methods for instantiating objects with a "Red" look and feel.
 */
public final class RedFactory extends GUIFactory {
	private static final RedFactory instance = new RedFactory();

	/**
	 * Static block which allows the class to register its instance with the parent class.
	 */
	static {
		GUIFactory.register("red",instance);
	}

	private RedFactory() { }

	/**
	 * GUIFactory#newButton(Window,CompositeGlyph)
	 */
	public Button newButton(Window w, CompositeGlyph c) {
		return new RedButton(w,c);
	}

	/**
	 * GUIFactory#newLabel(Window, CompositeGlyph)
	 */
	public Label newLabel(Window w, CompositeGlyph c) {
		return new RedLabel(w,c);
	}

	/*
	 *Pattern/Participant: AbstractFactory(87): ConcreteProduct
	 *Pattern/Participant: FactoryMethod(187): ConcreteProduct
	 * A class for representing red labels.
	 */
	private class RedLabel extends Label {
		/**
		 * Instantiates a red Label Embellishment and initializes
		 * the Window pointer and the embellished CompositeGlyph
		 * w the Window to draw on
		 * c the CompositeGlyph to embellish with a label
		 */
		private RedLabel(Window w, CompositeGlyph c) {
			super(w,c,"red");
		}
	}

	/*
	 *Pattern/Participant: AbstractFactory(87): ConcreteProduct
	 *Pattern/Participant: FactoryMethod(107): ConcreteProduct
	 * A class for representing red buttons.
	 */
	private class RedButton extends Button {

		/**
		 * Instantiates a red Button Embellishment and initializes
		 * the Window pointer and the embellished CompositeGlyph
		 * w the Window to draw on
		 * c the CompositeGlyph to embellish with a button
		 */
		private RedButton(Window w, CompositeGlyph c) {
			super(w,c,"red");
		}
	}
}
