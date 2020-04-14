package StructuralPattern.G_Adapter.b;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator {
	Enumeration enu;

	public EnumerationIterator(Enumeration enu) {
		this.enu = enu;
	}

	public boolean hasNext() {

		return enu.hasMoreElements();
	}

	public Object next() {
		return enu.nextElement();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
