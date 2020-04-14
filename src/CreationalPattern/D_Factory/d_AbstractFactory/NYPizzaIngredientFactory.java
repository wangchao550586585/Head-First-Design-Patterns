package CreationalPattern.D_Factory.d_AbstractFactory;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	// 可以创建具体的dough材料
	public Dough createDough() {
		return new ThickCrustDough();
	}

	public String createSauce() {
		return null;
	}

	public String createCheese() {
		return null;
	}

	public String createClam() {
		return null;
	}

}

class ThickCrustDough implements Dough {

}
