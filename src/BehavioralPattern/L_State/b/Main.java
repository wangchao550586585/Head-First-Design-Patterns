package BehavioralPattern.L_State.b;

/**
 *还存在如下问题:
 *	1:重复代码，如错误信息不会给用户看，可以把所有错误行为写的通用
 *	2：dispense()即使没有25分，当转动曲柄后也会执行，可使用布尔值or异常处理
 *	3：状态转换都放在状态类中了，可以放在糖果机中
 *	4：实例GumballMachine过多后，要将状态实例移到静态实例变量中
 */
public class Main {
	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);
		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine);
	}
}
