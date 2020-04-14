package BehavioralPattern.I_TemplateMethod.a;


public abstract class CaffeineBeverage {
	/**
	 * 模板方法,必须final以免子类改变这个算法的顺序
	 *  原因如下: 
	 *  	1:他是方法 
	 *  	2：用作一个算法(制作饮料)的模板
	 *  	3:算法里，每一个步骤都被一个方法代表了
	 *  	4：方法由这个类和子类处理
	 */
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		//使用钩子：被声明在抽象类中的方法，只有空和默认的实现。可以决定要不要覆盖方法，如果不提供自己的方法，抽象类提供一个默认的实现
		//子类必须提供实现不使用钩子，子类可以有选择的决定是否实现，则可以使用钩子
		if (customerWantsCondiments())
			addCondiments();
	}

	/*因为咖啡和茶处理这些方法的做法不同，所以声明抽象
	需要子类提供的方法，必须在超类声明抽象*/
	abstract void addCondiments();

	abstract void brew();

	public void boilWater() {
		System.out.println("把水煮沸");
	}

	public void pourInCup() {
		System.out.println("把饮料倒进杯子");
	}

	public boolean customerWantsCondiments() {
		return true;
	}
}
