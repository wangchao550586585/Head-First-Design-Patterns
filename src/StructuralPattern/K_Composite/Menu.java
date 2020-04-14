package StructuralPattern.K_Composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 菜单类:可以持有菜单项(叶子节点)和其他菜单(子节点)
 */
public class Menu extends MenuComponent {
	ArrayList menuComponents = new ArrayList();
	String name;
	String description;

	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void add(MenuComponent component) {
		menuComponents.add(component);
	}

	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}

	public MenuComponent getChild(int i) {
		return (MenuComponent) menuComponents.get(i);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	/*
	因为菜单是一个组合，包含菜单项和其他菜单，所以print应该打印它所包含的一切。
	内部迭代器
	 */
	public void print() {
		System.out.println(getName() + " " + getDescription());
		Iterator iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menu = (MenuComponent) iterator.next();
			menu.print();
		}
	}

	/*
	外部迭代器，所以需要维护组合递归结构的位置，采用栈维护
	 */
	@Override
	public Iterator createIterator() {
		return new CompositeIterator(menuComponents.iterator());
	}
}
