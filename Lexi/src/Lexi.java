/*
 * @author Josh Hansen
 * Course: COMPSCI 472
 * Semester: Fall 2012
 * Assignment: HW6
 *
 * Driver class and tests for Lexi.
 */
public class Lexi {
	static GUIFactory g = GUIFactory.instance();
	static Window w = new ApplicationWindow("HW6");
	static KeyMap km = new KeyMap();
	static Row top = new Row(null,w);
	static {
		km.put('i',new IncrementFontSizeCommand(w));
		km.put('d',new DecrementFontSizeCommand(w));
		km.put('u',new UndoCommand());
		km.put('r',new RedoCommand());
		km.put('w',new ComputeWordsCommand(new PreorderIterator<Glyph>(top)));
		w.setKeyMap(km);
	}
	

	public static void main(String[] args) {
		//hw6WordsTest1();
		//hw6WordsTest2();
		hw5HandoutTest();
	}
	
	static void hw6WordsTest1() {
		Border border = new Border(top,new Scrollbar(w,new Column(null, w)),w);
		new Row(border,"This is a row of words",w);
		new Row(border,"Here's a second row of words",w);
		
		w.setContents(top);
	}
	
	static void hw6WordsTest2() {
		Border border = new Border(top,new Scrollbar(w,new Column(null, w)),w);
		new Row(border,"word word word word word",w);
		border.append(g.createLabel(w, new Row(w,"label")));
		new Row(border,"word word otherword word",w);
		w.setContents(top);
	}

	static void hw5HandoutTest() {
		Border border = new Border(top,new Scrollbar(w,new Column(null, w)),w);
		Row r1 = new Row(border,w);
		r1.append(new Character('a'));
		r1.append(new Rectangle(10,20));

		Column c2 = new Column(r1,w);
		c2.append(new Character('X'));
		c2.append(g.createLabel(w,new Row(w,"pq")));
		c2.append(new Character('Z'));

		r1.append(new Character('b'));

		Row r2 = new Row(border,w);
		r2.append(new Character('x'));
		r2.append(new Rectangle(20,10));
		r2.append(new Character('y'));

		border.append(g.createButton(w, new Row(w,"PQ")));
		
		Row r3 = new Row(border,w);
		
		Button bplus = g.createButton(w, new Row(w,"+"));
		bplus.setCommand(new IncrementFontSizeCommand(w));
		r3.append(bplus);
		
		Button bminus = g.createButton(w, new Row(w,"-"));
		bminus.setCommand(new DecrementFontSizeCommand(w));
		r3.append(bminus);
		
		Button b14 = g.createButton(w, new Row(w,"14 "));
		SetFontSizeCommand sfsc14 = new SetFontSizeCommand(w);
		sfsc14.setNewFontSize(14);
		b14.setCommand(sfsc14);
		r3.append(b14);
		
		Button b20 = g.createButton(w, new Row(w,"20 "));
		SetFontSizeCommand sfsc20 = new SetFontSizeCommand(w);
		sfsc20.setNewFontSize(20);
		b20.setCommand(sfsc20);
		r3.append(b20);
		
		w.setContents(top);
	}
}
