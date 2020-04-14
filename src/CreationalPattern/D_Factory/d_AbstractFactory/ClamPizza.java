package CreationalPattern.D_Factory.d_AbstractFactory;


public class ClamPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;

	public ClamPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {
		//需要的材料跟工厂要，不同风味的披萨可以使用原料工厂处理地区差异,而不需要设计不同的类进行处理
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		cheese = ingredientFactory.createClam();
	}

}
