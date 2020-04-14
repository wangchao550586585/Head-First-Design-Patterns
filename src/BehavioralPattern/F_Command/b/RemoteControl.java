package BehavioralPattern.F_Command.b;

import java.util.Arrays;


public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;
	// 记录执行命令的前一个对象，方便撤销动作
	Command undoCommand;

	/**
	 * 初始化遥控器7个开与关的命令
	 */
	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		NoCommand noCommand = new NoCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		// 一开始没有前一个动作，初始化
		undoCommand = noCommand;
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}

	// 执行撤销方法
	public void undoButtonWasPushed() {
		undoCommand.undo();
	}

	@Override
	public String toString() {
		return "RemoteControl [onCommands=" + Arrays.toString(onCommands)
				+ ", offCommands=" + Arrays.toString(offCommands) + "]";
	}

}
