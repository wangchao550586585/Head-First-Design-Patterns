package StructuralPattern.N_Composite.duck;

import StructuralPattern.N_Composite.duck.adapter.Goose;
import StructuralPattern.N_Composite.duck.adapter.GooseAdapter;
import StructuralPattern.N_Composite.duck.composite_iterator.Flock;
import StructuralPattern.N_Composite.duck.decker.QuackCounter;
import StructuralPattern.N_Composite.duck.factory.CountingDuckFactory;
import StructuralPattern.N_Composite.duck.observer.Quackologist;

/**
 * 复合模式:结合2个或者以上模式，组成一个解决方案，解决一再发生的问题
 * mvc:模型利用"观察者模式"让控制器和视图可以随最新状态改变而更新
 * 视图和控制器实现"策略模式"，
 * 控制器是视图的行为，可以更换控制器更换行为
 * 视图使用组合模式管理窗口，按钮以及其他组件
 */
public class DuckSimulator {

	public static void main(String[] args) {
		DuckSimulator duckSimulator = new DuckSimulator();
		duckSimulator.simulator();
		duckSimulator.simulator1();

		CountingDuckFactory countingDuckFactory = new CountingDuckFactory();
		duckSimulator.simulator2(countingDuckFactory);
		duckSimulator.simulator3(countingDuckFactory);
		duckSimulator.simulator4(countingDuckFactory);
	}

	/*
	 * 适配器模式
	 */
	public void simulator() {
		Quackable mallardDuck = new MallardDuck();
		Quackable duckCall = new DuckCall();
		Quackable redheadDuck = new RedheadDuck();
		Quackable rubberDuck = new RubberDuck();
		// 适配器模式
		Quackable gooseAdapter = new GooseAdapter(new Goose());

		simulator(mallardDuck);
		simulator(duckCall);
		simulator(redheadDuck);
		simulator(rubberDuck);
		simulator(gooseAdapter);
	}

	/*
	 * 使用装饰者模式统计鸭子叫次数
		缺点：必须装饰对象才能获得被装饰的行为
		解决：工厂模式
	 */
	public void simulator1() {
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		Quackable gooseAdapter = new QuackCounter(new GooseAdapter(new Goose()));

		simulator(mallardDuck);
		simulator(duckCall);
		simulator(redheadDuck);
		simulator(rubberDuck);
		simulator(gooseAdapter);
		System.out.println(QuackCounter.getNumberOfQuacks());
	}

	/*
	 * 工厂模式管理鸭子
	 * 只能个别管理鸭子，无法管理一群鸭子
	 * 解决：组合模式
	 */
	private void simulator2(CountingDuckFactory duckFactory) {
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseAdapter = duckFactory.createGooseDuck();

		simulator(duckCall);
		simulator(mallardDuck);
		simulator(redheadDuck);
		simulator(rubberDuck);
		simulator(gooseAdapter);
		System.out.println(QuackCounter.getNumberOfQuacks());
	}

	/*
	 *组合模式+迭代器模式管理一群鸭子 
	 */
	private void simulator3(CountingDuckFactory duckFactory) {
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseAdapter = duckFactory.createGooseDuck();

		// 这个flock是主群
		Flock flockOfDucks = new Flock();
		flockOfDucks.add(duckCall);
		flockOfDucks.add(mallardDuck);
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseAdapter);

		// 创建绿头鸭群
		Flock flockOfMallards = new Flock();
		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();
		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);

		// 绿头鸭群加入主群
		flockOfDucks.add(flockOfMallards);

		System.out.println("测试绿头鸭群");
		simulator(flockOfMallards);
		System.out.println("测试一整群");
		simulator(flockOfDucks);
		System.out.println(QuackCounter.getNumberOfQuacks());
	}

	/*
	 * 观察者模式：观察每只鸭叫的情况
	 */
	private void simulator4(CountingDuckFactory duckFactory) {
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseAdapter = duckFactory.createGooseDuck();

		// 这个flock是主群
		Flock flockOfDucks = new Flock();
		flockOfDucks.add(duckCall);
		flockOfDucks.add(mallardDuck);
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseAdapter);

		// 创建绿头鸭群
		Flock flockOfMallards = new Flock();
		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();
		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);

		// 绿头鸭群加入主群
		flockOfDucks.add(flockOfMallards);

		Quackologist quackologist = new Quackologist();
		flockOfDucks.registerObserver(quackologist);
		simulator(flockOfDucks);
		System.out.println(QuackCounter.getNumberOfQuacks());
	}

	public void simulator(Quackable duck) {
		duck.quack();
	}
}
