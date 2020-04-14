package StructuralPattern.M_Proxy.b;

import java.rmi.Naming;

public class GumballMonitorTestDrive {
	public static void main(String[] args) {
		String[] location = { "//127.0.0.1:6600/gumballMachine" };
		GumballMonitor[] monitor = new GumballMonitor[location.length];
		try {
			for (int i = 0; i < location.length; i++) {
				GumballMachineRemote mechine = (GumballMachineRemote) Naming
						.lookup(location[i]);
				monitor[i] = new GumballMonitor(mechine);
			}
		} catch (Exception e) {
		}
		for (int i = 0; i < monitor.length; i++) {
			monitor[i].report();
		}
	}
}
