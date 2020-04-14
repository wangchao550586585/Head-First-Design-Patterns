package CreationalPattern.D_Factory.d_AbstractFactory;

/**
 * 由于做披萨做法有差异，使用其他厂商的盒子等等
 * 解决让披萨制作局限于pizzaStore类，同时又能让加盟店依然可以自由制作该地区风味的披萨
 */
public abstract class PizzaStore {

	public final Pizza orderPizza(String type) {
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	// 让子类决定创建何种口味风格的披萨,此方法如同工厂
	//工厂方法用来处理对象的创建，并将这样的行为封装在子类中，这样客户程序中关于超类的代码和子类对象创建代码解耦了
	protected abstract Pizza createPizza(String type);
}
