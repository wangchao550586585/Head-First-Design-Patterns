package CreationalPattern.D_Factory.c_FactoryMethod;


public class ChicagoPizzaStore extends PizzaStore {
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new NYStyleCheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new NYStylePepperoniPizza();
		}
		return pizza;
	}
}
