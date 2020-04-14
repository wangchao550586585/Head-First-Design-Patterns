package CreationalPattern.D_Factory.a;


/**
 * 只适用一个地区的披萨店，当在别地建立披萨店时，由于地区口味差异，一个工厂无法满足。 解决方案，根据地区建立多个工厂
 *
 */
public class SimplePizzaFactory {
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		}
		return pizza;
	}
}
