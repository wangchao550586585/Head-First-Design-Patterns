package BehavioralPattern.J_Iterator.a;

import BehavioralPattern.J_Iterator.MenuItem;

public class DinerMenuIterator implements Iterator {
	MenuItem[] items;
	int position = 0;

	public DinerMenuIterator(MenuItem[] items) {
		this.items = items;
	}

	public boolean hasNext() {
		return (position >= items.length || items[position] == null) ? false
				: true;
	}

	public Object next() {
		return items[position++];
	}
}
