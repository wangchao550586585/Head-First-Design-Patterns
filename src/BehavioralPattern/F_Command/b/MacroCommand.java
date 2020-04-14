package BehavioralPattern.F_Command.b;

/**
 * 使用宏命令执行一堆任务
 */
public class MacroCommand implements Command {
	Command[] commands;

	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		for (int i = commands.length - 1; i >= 0; i--) {
			commands[i].execute();
		}
	}

	@Override
	public void undo() {
		for (int i = commands.length - 1; i >= 0; i--) {
			commands[i].undo();
		}
	}

}
