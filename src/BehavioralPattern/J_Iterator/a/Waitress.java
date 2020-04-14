package BehavioralPattern.J_Iterator.a;

import BehavioralPattern.J_Iterator.MenuItem;

/**
 * 招待类
 */
public class Waitress {
	PancakeHouseMenu houseMenu;
	DinerMenu dinerMenu;

	public Waitress(PancakeHouseMenu houseMenu, DinerMenu dinerMenu) {
		this.houseMenu = houseMenu;
		this.dinerMenu = dinerMenu;
	}

	public void printMent() {
		/*遍历，数组和集合遍历方式不一样，复杂遍历操作
		MenuItem[] houseMenu.getMenuItems();
		ArrayList dinerMenu.getMenuItems();*/

		Iterator houseMenuIterator = houseMenu.createIterator();
		Iterator dinerMenuIterator = dinerMenu.createIterator();
		printMenu(houseMenuIterator);
		System.out.println("=========");
		printMenu(dinerMenuIterator);
	}

	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.println(menuItem);
		}
	}
}
