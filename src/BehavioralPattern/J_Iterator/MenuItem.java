package BehavioralPattern.J_Iterator;

public class MenuItem {
	String name;
	String description;
	boolean vagetarian;
	double price;

	/**
	 * @param name
	 *            菜名
	 * @param description
	 *            描述
	 * @param vagetarian
	 *            是否为素食
	 * @param price
	 *            价格
	 */
	public MenuItem(String name, String description, boolean vagetarian,
			double price) {
		this.name = name;
		this.description = description;
		this.vagetarian = vagetarian;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVagetarian() {
		return vagetarian;
	}

	public void setVagetarian(boolean vagetarian) {
		this.vagetarian = vagetarian;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", description=" + description
				+ ", vagetarian=" + vagetarian + ", price=" + price + "]";
	}

}
