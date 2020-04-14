package StructuralPattern.M_Proxy.b;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements
		GumballMachineRemote {
	State soldOutState;
	State soldState;
	State noQuarterState;
	State hasQuarterState;
	State winnerState;

	State state = soldOutState;
	String location;
	int count;

	public GumballMachine() throws RemoteException {
	}

	public GumballMachine(String location, int count) throws RemoteException {
		this.location = location;
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

	public void releaseBall() {
		System.out.println("Sell a candy");
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
	public void setState(State state) {
		this.state = state;
	}

	public String getLocation() {
		return location;
	}

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

	public Integer getCount() {
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
