package BehavioralPattern.L_State.b;

public class SoldOutState implements State {
	GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("糖果已售空");
	}

	public void ejectQuarter() {
		System.out.println("糖果已售空");
	}

	public void turnCrank() {
		System.out.println("糖果已售空");
	}

	public void dispense() {
		System.out.println("糖果已售空");
	}

}
