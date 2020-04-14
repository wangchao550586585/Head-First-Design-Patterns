package BehavioralPattern.J_Iterator.a;

import java.util.ArrayList;

import BehavioralPattern.J_Iterator.MenuItem;

public class PancakeHouseMenu {
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

	/*public ArrayList getMenuItems() {
		return menuItems;
	}*/
	public Iterator createIterator() {
		return new PancakeHouseMenuIterator(menuItems);
	}
}
