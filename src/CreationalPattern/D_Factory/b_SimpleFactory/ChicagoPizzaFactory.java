package CreationalPattern.D_Factory.b_SimpleFactory;

public class ChicagoPizzaFactory implements SimplePizzaFactory {
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
