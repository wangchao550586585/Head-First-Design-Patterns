package A;
/*
 * 1：让鸭子飞
 * 	解决方案：Duck类添加fly()
 * 	缺点：所有的鸭子都飞
 * 2：让部分鸭子会飞
 * 	解决方案：不会飞的鸭子覆盖fly()
 *  缺点：如果有鸭子不会飞不会叫，要覆盖所有方法
 * 3：不覆盖所有方法就能解决问题
 * 	解决方案：fly()提取出来，放入Flyable接口中，会飞的鸭子继承
 * 	缺点：会飞的鸭子都继承接口后，都需要提供实现,无法达到复用
 * 
 *设计原则1：找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起。 
 *
 * 
 * 
 */
public abstract class Duck {
	//所有的鸭子都会呱呱叫和游泳
	public void quack() {
		System.out.println("呱呱叫");
	}

	public void swin() {
		System.out.println("游泳");
	}

	public abstract void display();//因为每一种鸭子的外观都不同，所以display是抽象的
}

class MallardDuck extends Duck {

	public void display() {
		System.out.println("外观绿头");
	}
}

class RedheadDuck extends Duck {

	public void display() {
		System.out.println("外观红头");
	}
}