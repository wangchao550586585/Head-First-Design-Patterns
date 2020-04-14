package BehavioralPattern.J_Iterator.b;

import java.util.ArrayList;
import java.util.Iterator;

import BehavioralPattern.J_Iterator.MenuItem;

public class PancakeHouseMenu implements Menu {
	ArrayList menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList();
		addItem("沙拉", "这是沙拉", true, 2.99);
		addItem("热干面", "这是热干面", true, 3.99);
		addItem("清汤面", "这是清汤面", true, 4.99);
		addItem("牛肉面", "这是牛肉面", false, 10.99);
	}

	private void addItem(String name, String description, boolean vagetarian,
			double price) {
		MenuItem menuItem = new MenuItem(name, description, vagetarian, price);
		menuItems.add(menuItem);
	}

	public Iterator createIterator() {
		return menuItems.iterator();
	}
}
