package BehavioralPattern.I_TemplateMethod.a;

public class Tea extends CaffeineBeverage {

	public void addCondiments() {
		System.out.println("加柠檬");
	}

	public void brew() {
		System.out.println("用沸水浸泡茶叶");
	}

}
