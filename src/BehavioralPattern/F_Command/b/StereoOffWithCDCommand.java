package BehavioralPattern.F_Command.b;


/**
 * 实现打开电灯的命令
 *
 */
public class StereoOffWithCDCommand implements Command {

	Stereo stereo;

	public StereoOffWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.off();
	}

	@Override
	public void undo() {
		stereo.on();
	}
}
