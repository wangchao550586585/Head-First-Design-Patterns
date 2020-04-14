package BehavioralPattern.J_Iterator.b;

import java.util.ArrayList;
import java.util.Iterator;

import BehavioralPattern.J_Iterator.MenuItem;

/**
 *解决开放-闭合原则
 */
public class Waitress2 {
	ArrayList menus;

	public Waitress2(ArrayList menus) {
		this.menus = menus;
	}

	public void printMent() {
		Iterator menuIterator = menus.iterator();
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			printMenu(menu.createIterator());
		}
	}

	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.println(menuItem);
		}
	}
}
