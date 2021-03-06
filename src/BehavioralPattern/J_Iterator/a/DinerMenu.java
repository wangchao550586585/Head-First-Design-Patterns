package BehavioralPattern.J_Iterator.a;

import BehavioralPattern.J_Iterator.MenuItem;

public class DinerMenu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		addItem("鱼香肉丝", "没有鱼", false, 15);
		addItem("宫保鸡丁", "没有鸡", false, 17);
		addItem("红烧茄子", "有茄子", true, 18);
		addItem("南瓜饼", "没有南瓜", true, 5);
		addItem("麻婆豆腐", "有豆腐", true, 13);
		addItem("爆炒肥牛", "有牛肉", false, 30);
	}

	private void addItem(String name, String description, boolean vagetarian,
			int price) {
		MenuItem menuItem = new MenuItem(name, description, vagetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.out.println("菜单已满");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems++;
		}
	}

	/*不需要这个方法，因为这个方法会暴露内部实现
	public MenuItem[] getMenuItems() {
		return menuItems;
	}*/
	//返回迭代器接口，客户不需要知道餐厅菜单如何维护菜单项的，也不需要知道迭代器是如何实现的，客户只需要直接使用遍历菜单即可
	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}
}
