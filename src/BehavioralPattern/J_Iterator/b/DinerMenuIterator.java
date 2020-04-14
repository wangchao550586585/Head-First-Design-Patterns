package BehavioralPattern.J_Iterator.b;

import java.util.Iterator;

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

	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException("你不能删除");
		}
		if (items[position - 1] != null) {
			for (int i = position - 1; i < items.length - 1; i++) {
				items[i] = items[i + 1];
			}
			items[items.length - 1] = null;
		}
	}
}
