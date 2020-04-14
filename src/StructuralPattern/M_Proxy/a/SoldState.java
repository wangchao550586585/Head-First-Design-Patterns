package StructuralPattern.M_Proxy.a;

public class SoldState implements State {
	GumballMonitor.GumballMachine gumballMachine;

	public SoldState(GumballMonitor.GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("请等待正在出糖果");
	}

	public void ejectQuarter() {
		System.out.println("对不起，正在转动曲柄");
	}

	public void turnCrank() {
		System.out.println("不能转动2次曲柄");
	}

	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("糖果售空");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

}
