package StructuralPattern.K_Composite;

import java.util.Iterator;

public class Waitress {
	MenuComponent allMenus;

	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}

	public void printMenu() {
		allMenus.print();
	}

	public void printVegetarianMenu() {
		Iterator createIterator = allMenus.createIterator();
		System.out.println("打印素食菜单");
		while (createIterator.hasNext()) {
			MenuComponent next = (MenuComponent) createIterator.next();
			try {
				if (next.isVegetarian()) {
					next.print();
				}
				//只在菜单上实现了isVegetarian，菜单项调用时候会抛出此异常
				//也可以在菜单项实现isVegetarian()，返回false，但是跟不支持查看素食意义不一样，推荐这种
			} catch (UnsupportedOperationException e) {
			}
		}
	}

}
