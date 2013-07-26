import java.io.File;
import java.util.Vector;


public class IterableFile extends File implements Aggregate<IterableFile>{
	private static final long serialVersionUID = 8553235043203102494L;

	public IterableFile(String parent, String child) {
		super(parent, child);
	}
	
	public IterableFile(String filename) {
		super(filename);
	}
	
	public Iterator<IterableFile> createIterator() {
		if (this.isDirectory()) {
			Vector<IterableFile> v = new Vector<IterableFile>();
			for (File child : this.listFiles()) {
				v.add((IterableFile)child);
			}
			return new VectorIterator<IterableFile>(v);
		} else {
			return new NullIterator<IterableFile>();
		}
	}
	
	public void accept(DropOffVistor fv) {
		fv.visit(this);
	}

}
