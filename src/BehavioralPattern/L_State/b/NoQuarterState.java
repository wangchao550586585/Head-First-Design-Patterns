package BehavioralPattern.L_State.b;

public class NoQuarterState implements State {
	GumballMachine gumballMachine;

	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("投入25分");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	public void ejectQuarter() {
		System.out.println("你需要投入25分");
	}

	public void turnCrank() {
		System.out.println("没钱，无法售出");
	}

	public void dispense() {
		System.out.println("你需要投入钱");
	}

}
