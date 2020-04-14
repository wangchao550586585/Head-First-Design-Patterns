package CreationalPattern.D_Factory.d_AbstractFactory;


/*
 * 需要的材料跟工厂要，不同风味的披萨可以使用原料工厂处理地区差异,而不需要设计不同的类进行处理
 */
public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new CheesePizza(pizzaIngredientFactory);
			pizza.setName("cheese");
		} else if (type.equals("clam")) {
			pizza = new ClamPizza(pizzaIngredientFactory);
			pizza.setName("clam");
		}
		return pizza;
	}

}
