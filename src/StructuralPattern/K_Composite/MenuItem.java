package StructuralPattern.K_Composite;

import java.util.Iterator;

/**
 *菜单项(叶子节点)
 *菜单项如何实现createIterator
 *方案1：直接返回null,这样做后客户代码需要每次判断这个方法是否返回的null
 *方案2：返回迭代器，hasNext()永远返回false
 */
public class MenuItem extends MenuComponent {
	String name;
	String description;
	boolean vegetarian;
	double price;

	public MenuItem(String name, String description, boolean vegetarian,
			double price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", description=" + description
				+ ", vegetarian=" + vegetarian + ", price=" + price + "]";
	}

	@Override
	public Iterator createIterator() {
		return new NullIterator();
	}

}
