package BehavioralPattern.L_State.a;

/**
 * 状态模式：允许对象在内部状态改变时改变它的行为，对象看起来好像修改了他的类
 * 与策略模式不同的时，策略模式，用户可以主动指定context所要组合的策对象，通常都只有一个最适当的策略对象，
 * 状态模式将一群行为封装在状态对象中，context行为可以随时委托给其中行为，但是context的客户不知道状态对象
 *状态模转化可以由state类或context类控制
 *
 * 添加每10次，赠送一次糖果状态，看b包
 */
public class Main {
	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);
		System.out.println(gumballMachine);

		// 投钱-->拿糖果
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine);

		// 投钱-->退钱-->拿糖果
		gumballMachine.insertQuarter();
		gumballMachine.ejectQuarter();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine);

		// 投钱-->拿糖果-->投钱-->拿糖果-->退钱
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.ejectQuarter();
		System.out.println(gumballMachine);

		// 投钱-->投钱-->拿糖果-->投钱-->拿糖果-->投钱-->拿糖果
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine);
	}
}
