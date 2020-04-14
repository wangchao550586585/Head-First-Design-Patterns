package BehavioralPattern.F_Command.b;


/**
 * 实现打开电灯的命令
 *
 */
public class StereoOnWithCDCommand implements Command {

	Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.on();
		stereo.setCD();
	}

	@Override
	public void undo() {
		stereo.off();
	}
}
