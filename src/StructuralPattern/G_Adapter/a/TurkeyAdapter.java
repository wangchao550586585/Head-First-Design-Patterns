package StructuralPattern.G_Adapter.a;

/**
 * 火鸡适配器:伪装鸭子
 */
public class TurkeyAdapter implements Duck {
	Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		//火鸡飞行距离近，飞行五次伪装鸭子飞的距离
		for (int i = 0; i < 5; i++)
			turkey.fly();
	}

}
