package CreationalPattern.D_Factory.b_SimpleFactory;

/**
 * 简单工厂模式
 * 建立多个工厂解决披萨店地区差异问题
 * 由于做披萨做法有差异，使用其他厂商的盒子等等
 */
public class Main {

	public static void main(String[] args) {
		// 工厂创建纽约风味的披萨
		NYPizzaFactory nyPizzaFactory = new NYPizzaFactory();
		PizzaStore pizzaStore = new PizzaStore(nyPizzaFactory);
		pizzaStore.orderPizza("cheese");

		// 工厂建立芝加哥风味的披萨
		ChicagoPizzaFactory chicagoPizzaFactory = new ChicagoPizzaFactory();
		pizzaStore = new PizzaStore(chicagoPizzaFactory);
		pizzaStore.orderPizza("cheese");
	}
}
