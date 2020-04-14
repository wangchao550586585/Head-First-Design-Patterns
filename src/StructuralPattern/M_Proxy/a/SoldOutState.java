package StructuralPattern.M_Proxy.a;

public class SoldOutState implements State {
	GumballMonitor.GumballMachine gumballMachine;

	public SoldOutState(GumballMonitor.GumballMachine gumballMachine) {
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
