package CreationalPattern.D_Factory.c_FactoryMethod;


/**
 *工厂方法模式： 定义一个创建对象的接口，但由子类决定要实例化的类是哪一个，工厂方法让类把实例化推迟到子类
 *依赖倒置原则:要依赖抽象，不要依赖具体类，不能让高层组件依赖底层组件，高层和底层都应该依赖于抽象
 *在应用工厂方法之后，高层组件(pizzaStore)和底层组件(具体的pizza类)都依赖Pizza抽象，遵循了此原则
 *指导方针：
 *		1：变量不能持有具体类的引用(如果采用new就会持有具体类的引用，可以采用工厂避免)
 *		2：不要让类派生自具体类(如果派生自具体类就会依赖具体类)
 *		3：不要覆盖基类中已实现的方法(如果覆盖基类已实现的方法，那么基类就不是适合被继承的抽象，基类中的实现方法，应该由子类共享)
 */
public class Main {

	public static void main(String[] args) {
		ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
		Pizza orderPizza = chicagoPizzaStore.orderPizza("pepperoni");
		System.out.println(orderPizza.getName());
	}
}
