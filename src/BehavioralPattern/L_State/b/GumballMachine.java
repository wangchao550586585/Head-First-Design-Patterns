package BehavioralPattern.L_State.b;

public class GumballMachine {
	// 状态映射到类上
	State soldOutState;
	State soldState;
	State noQuarterState;
	State hasQuarterState;
	State winnerState;

	State state = soldOutState;
	int count = 0;

	public GumballMachine(int count) {
		this.count = count;
		soldOutState = new SoldOutState(this);
		soldState = new SoldState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		winnerState = new WinnerState(this);
		if (count > 0)
			state = noQuarterState;
	}

	public void insertQuarter() {
		state.insertQuarter();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void releaseBall() {
		System.out.println("出售一个糖果");
		if (count != 0)
			count--;
	}

	/**
	 * 补充糖果
	 */
	public void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}

	// //////////////

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getState() {
		return state;
	}

	public int getCount() {
		return count;
	}

	public State getWinnerState() {
		return winnerState;
	}

	@Override
	public String toString() {
		return "GumballMachine [state=" + state + ", count=" + count + "]";
	}

}
