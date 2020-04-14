package StructuralPattern.C_Decorator;

/**
 * 设计原则:类应该对扩展开放，对修改关闭。 
 * 装饰者模式:动态地将责任和行为附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案。 
 * 		  
 * 装饰者模式特点:
 * 1:装饰者和被装饰对象有相同的超类型。 
 * 2:可以用一个或多个装饰者包装一个对象。
 * 3:既然装饰者和被装饰对象有相同的超类型，所以在任何需要原始对象（被包装的）的场合， 
 * 4:可以用装饰过的对象代替它。
 * 5:装饰者可以在所委托被装饰者的行为之前与/或之后，加上自己的行为，以达到特定的目的。
 * 6:对象可以在任何时候被装饰，所以可以在运行时动态地、不限量地用你喜欢的装饰者来装饰对象。
 * 7:装饰者会导致设计中出现许多小对象，如果过度使用，会让程序变得很复杂。
 * 
 * 在这里使用继承达到"类型匹配"而不是继承"行为"
 */
public class Main {
	public static void main(String[] args) {
		// 订一杯espresso不需要调料
		Espresso espresso = new Espresso();
		System.out.println(espresso.getDeScription() + " " + espresso.cost());

		Beverage beverage1 = new HouseBlend();
		beverage1 = new Mocha(beverage1);
		beverage1 = new Mocha(beverage1);
		beverage1 = new Whip(beverage1);
		System.out.println(beverage1.getDeScription() + " " + beverage1.cost());
	}
}
