package StructuralPattern.G_Adapter.a;

/**
 *适配器模式：将一个类的接口(或多个类)，转换成客户期望的另一个接口，适配器让原本接口不兼容的类可以合作无间
 *对象适配器
 *		使用对象组合，以修改的接口包装被适配者
 *		被适配者的任何子类都可以搭配适配器使用
 *类适配器
 *		使用多重继承
 *		通过扩展2个类，适配器使得火鸡可以响应鸭子的请求(将对鸭子方法的调用转接到火鸡方法)
 *		不需要实现整个被适配者，必要时候可以覆盖被适配者的行为
 *		不需要被适配者对象
 */
public class Main {
	public static void main(String[] args) {
		MallardDuck mallardDuck = new MallardDuck();
		WildTurkey wildTurkey = new WildTurkey();
		TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);

		wildTurkey.gobble();
		wildTurkey.fly();

		pringDuck(mallardDuck);
		pringDuck(turkeyAdapter);
	}

	private static void pringDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
