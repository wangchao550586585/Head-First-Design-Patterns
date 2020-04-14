package StructuralPattern.C_Decorator;

/** 饮料类 */
public abstract class Beverage {
	public static final int TALL = 10;
	public static final int GRANDE = 20;
	public static final int VENTI = 25;
	String deScription = "未知饮料";
	int size;

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size == 0 ? TALL : size;
	}

	public String getDeScription() {
		return deScription;
	}

	abstract double cost();

}

/** 调料装饰类 */
abstract class CondimentDecorator extends Beverage {
	public abstract String getDeScription();
}

/** 饮料代码 */
class Espresso extends Beverage {

	public Espresso() {
		deScription = "Espersso";
	}

	double cost() {
		return 1.99;
	}

}

class HouseBlend extends Beverage {
	public HouseBlend() {
		deScription = "HouseBlend";
	}

	double cost() {
		return 1.99;
	}
}

/** 调料代码 */
class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDeScription() {
		// 利用委托，得到饮料叙述，然后在后面附加叙述Mocha
		return beverage.getDeScription() + ",Mocha";
	}

	double cost() {
		return 20 + beverage.cost();
	}
}

class Whip extends CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDeScription() {
		// 利用委托，得到饮料叙述，然后在后面附加叙述Mocha
		return beverage.getDeScription() + ",Whip";
	}

	double cost() {
		return 20 + beverage.cost();
	}
}

// 根据大小收取相应的费用
class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public int getSize() {
		return beverage.getSize();
	}

	public String getDeScription() {
		return beverage.getDeScription() + ",Soy";
	}

	double cost() {
		double cost = beverage.cost();
		if (getSize() == Beverage.TALL) {
			cost += .10;
		} else if (getSize() == Beverage.GRANDE) {
			cost += .15;
		} else if (getSize() == Beverage.VENTI) {
			cost += .20;
		}
		return cost;
	}

}