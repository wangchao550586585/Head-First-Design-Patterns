package CreationalPattern.D_Factory.d_AbstractFactory;

/**
 * 抽象工厂模式:使用对象组合，提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类
 * 工厂方法：PizzaIngredientFactory提供创建所有材料接口，每个方法都被声明为抽象，而子类的方法覆盖这些方法来创建某些对象
 * 
 */
public class Main {
	public static void main(String[] args) {
		PizzaStore nyPizzaStore = new NYPizzaStore();
		nyPizzaStore.orderPizza("cheese");

	}
}
