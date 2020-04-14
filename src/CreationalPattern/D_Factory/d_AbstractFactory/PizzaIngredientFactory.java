package CreationalPattern.D_Factory.d_AbstractFactory;

public interface PizzaIngredientFactory {

	public Dough createDough();

	public String createSauce();

	public String createCheese();

	public String createClam();
}
