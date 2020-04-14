package BehavioralPattern.A_Strategy;

/**
 * 策略模式 定义了算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户
 * 优点：鸭子的行为被封装到了一组类中，可以轻易扩展以及改变，以及在运行时也可以改变行为
 * 
 * 解决复用问题 1：分开变化和不变化的部分。 2：建立2组类(完全原理Duck类)，fly相关类/quack相关类，每一组类实现各自的动作
 * 
 * 这样的设计， 可以让飞行和呱呱叫的动作被其他的对象复用，因为这些行为已经与鸭子类无关了。 而我们可以新增一些行为，
 * 不会影响到既有的行为类，也不会影响“使用”到飞行行为的鸭子类
 *
 *
 * 设计原则2：针对接口编程，而不是针对实现编程。 接口是一个“
 * 概念”，也是一种Java的interface构造。你可以在不涉及JavaAinterface的情况下，
 * “针对接口编程”，关键就在多态。利用多态，程序可以针对超类型编程，执行时会根据实际状况执行到真正的行为，不会被绑死在超类型的行为
 * 上。“针对超类型编程”这句话，可以更明确地说成“变 量的声明类型应该是超类型，通常是一个抽象类或者是一 个接口，如此，只要是具体实现此超类型的类所产生的对
 * 象，都可以指定给这个变量。这也意味着，声明类时不用 理会以后执行时的真正对象类型！”
 * 
 * 虽然我们把行为设定成具体的类 （通过实例化类似Quack或FlyWithWings的 行为类，并把它指定到行为引用变量中），
 * 但是还是可以在运行时“轻易地”改变它。 所以，目前的做法还是很有弹性的，只是 初始化实例变量的做法不够弹性罢了。
 *
 * 每个鸭子都有FlyBehavior/QuackBehavior，将飞行和呱呱委托给他们处理，这就是组合。 设计原则3：多用组合，少用继承
 * 使用组合建立系统具有很大弹性，不仅可以将算法族封装成类，更可以在运行时动态改变行为。
 *
 * 在这里鸭子的一组行为改成一族算法，算法代表鸭子能做的事。不同的飞法or叫法
 */
class Main {
	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		duck.performFly();
		// 动态设定行为 添加set方法 在运行时想改变鸭子的行为，只需调用鸭子的setter方法就可以
		duck.setFlyBehavior(new FlyNoWay());
		duck.performFly();
	}
}

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	// 鸭子对象不处理嘎嘎叫，而是委托给QuackBehavior引用的对象
	public void performQuack() {
		quackBehavior.quack();
	}

	public void performFly() {
		flyBehavior.fly();
	}

	// 动态设定行为

	public void swin() {
		System.out.println("游泳");
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public abstract void display();
}

class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	public void display() {
		System.out.println("我是绿鸭");
	}

}

//
interface FlyBehavior {
	void fly();
}

class FlyWithWings implements FlyBehavior {

	public void fly() {
		System.out.println("实现鸭子飞行");
	}

}

class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("鸭子不飞");
	}

}

//
interface QuackBehavior {
	void quack();
}

class Quack implements QuackBehavior {
	public void quack() {
		System.out.println("鸭子嘎嘎叫");
	}

}
