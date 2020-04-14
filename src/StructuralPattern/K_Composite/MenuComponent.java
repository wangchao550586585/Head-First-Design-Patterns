package StructuralPattern.K_Composite;

import java.util.Iterator;

//提供默认实现，所以使用抽象类
public abstract class MenuComponent {

	/*
	 * 组合方法
	 */
	public void add(MenuComponent component) {
		throw new UnsupportedOperationException();
	}

	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}

	/*
	 * 操作方法，被菜单项和菜单使用
	 */
	public String getName() {
		throw new UnsupportedOperationException();

	}

	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		throw new UnsupportedOperationException();

	}

	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}

	public void print() {
		throw new UnsupportedOperationException();
	}

	public abstract Iterator createIterator();
}
