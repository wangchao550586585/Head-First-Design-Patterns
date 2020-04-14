package StructuralPattern.M_Proxy.a;

public class Main {
	public static void main(String[] args) {
		int count = 0;
		if (args.length < 2) {
			System.out.println("请输入糖果数量和库存");
			System.exit(1);
		}
		count = Integer.parseInt(args[1]);
		GumballMonitor.GumballMachine gumballMachine = new GumballMonitor.GumballMachine(args[0], count);

		GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);
		gumballMonitor.report();
	}
}
