package BehavioralPattern.F_Command.a;


/**
 * 实现打开电灯的命令
 *
 */
public class LightOnCommand implements Command {
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}
