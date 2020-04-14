package BehavioralPattern.F_Command.b;


/**
 * 实现打开电灯的命令
 *
 */
public class LightOffCommand implements Command {
	Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

}