package StructuralPattern.M_Proxy.b;

/**
 * 10次抽中一次的游戏
 */
public class WinnerState implements State {

	transient GumballMachine gumballMachine;

	public WinnerState(GumballMachine gumballMachine) {
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
		System.out.println("恭喜你获得2个糖果");
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				System.out.println("糖果已售空");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}

		}
	}

}
