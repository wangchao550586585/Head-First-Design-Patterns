package BehavioralPattern.J_Iterator.a;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {
	ArrayList menuItems;
	int index = 0;

	public PancakeHouseMenuIterator(ArrayList menuItems) {
		this.menuItems = menuItems;
	}

	public boolean hasNext() {
		return (index >= menuItems.size() || menuItems.get(index) == null) ? false
				: true;
	}

	public Object next() {
		return menuItems.get(index++);
	}

}
