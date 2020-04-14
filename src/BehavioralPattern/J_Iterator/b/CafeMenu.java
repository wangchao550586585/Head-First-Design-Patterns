package BehavioralPattern.J_Iterator.b;

import java.util.Hashtable;
import java.util.Iterator;

import BehavioralPattern.J_Iterator.MenuItem;

public class CafeMenu implements Menu {
	Hashtable menuItems = new Hashtable();

	public CafeMenu() {
		addItem("咖啡1", "咖啡1", true, 10);
		addItem("咖啡2", "咖啡2", true, 20);
		addItem("咖啡3", "咖啡3", true, 30);
		addItem("咖啡4", "咖啡4", true, 40);
	}

	private void addItem(String name, String description, boolean vagetarian,
			int price) {
		MenuItem menuItem = new MenuItem(name, description, vagetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}

	@Override
	public Iterator createIterator() {
		return menuItems.values().iterator();
	}

}
