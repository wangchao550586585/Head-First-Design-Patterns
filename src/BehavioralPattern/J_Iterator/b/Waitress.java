package BehavioralPattern.J_Iterator.b;

import java.util.Iterator;

import BehavioralPattern.J_Iterator.MenuItem;

/**
 * 招待类 提供菜单接口，解决招待依赖具体菜单问题 采用java内置迭代器
 * 每次新增菜单都需要修改pringMenu，违反开放-关闭原则，解决看Waitress2
 * */
public class Waitress {
	Menu houseMenu;
	Menu dinerMenu;
	Menu cafeMenu;

	public Waitress(Menu houseMenu, Menu dinerMenu, Menu cafeMenu) {
		this.houseMenu = houseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	public void printMenu() {
		Iterator houseMenuIterator = houseMenu.createIterator();
		Iterator dinerMenuIterator = dinerMenu.createIterator();
		Iterator cafeMenuIterator = cafeMenu.createIterator();
		printMenu(houseMenuIterator);
		System.out.println("=========");
		printMenu(dinerMenuIterator);
		System.out.println("=========");
		printMenu(cafeMenuIterator);
	}

	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.println(menuItem);
		}
	}
}
