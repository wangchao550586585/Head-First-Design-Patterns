package StructuralPattern.N_Composite.duck.observer;

public class Quackologist implements Observer {

	@Override
	public void update(QuackObservable duck) {
		//打印呱呱叫的鸭子
		System.out.println(duck);
	}

}
