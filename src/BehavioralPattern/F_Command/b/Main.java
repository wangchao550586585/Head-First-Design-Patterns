package BehavioralPattern.F_Command.b;

/**
 * 宏命令以及状态撤销
 * CeilingFan：可撤销状态
 */
public class Main {
	public static void main(String[] args) {
		RemoteControl remote = new RemoteControl();
		Light light = new Light();
		Stereo stereo = new Stereo();

		/**
		 * 创建电灯和音响的所有命令
		 */
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand = new LightOffCommand(light);
		StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(
				stereo);
		StereoOffWithCDCommand stereoOffWithCDCommand = new StereoOffWithCDCommand(
				stereo);

		// 命令加载到遥控器插槽中
		remote.setCommand(0, lightOnCommand, lightOffCommand);
		remote.setCommand(1, stereoOnWithCDCommand, stereoOffWithCDCommand);

		System.out.println(remote);

		remote.onButtonWasPushed(0);
		remote.offButtonWasPushed(0);
		remote.undoButtonWasPushed();
		remote.onButtonWasPushed(1);
		remote.offButtonWasPushed(1);

		System.out.println("===========");
		// 使用宏命令
		Command[] partyOn = { lightOnCommand, stereoOnWithCDCommand };
		Command[] partyOff = { lightOffCommand, stereoOffWithCDCommand };
		MacroCommand partOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
		remote.setCommand(2, partOnMacro, partyOffMacro);
		remote.onButtonWasPushed(2);
		remote.offButtonWasPushed(2);
		remote.undoButtonWasPushed();

	}
}
