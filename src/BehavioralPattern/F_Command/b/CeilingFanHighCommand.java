package BehavioralPattern.F_Command.b;

public class CeilingFanHighCommand implements Command {
	CeilingFan ceilingFan;
	// 方便追踪之前的状态
	int prevSpeed;

	public CeilingFanHighCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	public void execute() {
		prevSpeed = ceilingFan.getSpeed();
		ceilingFan.high();
	}

	public void undo() {
		if (prevSpeed == CeilingFan.HIGH)
			ceilingFan.high();
		else if (prevSpeed == CeilingFan.MEDIUM)
			ceilingFan.medium();
		else if (prevSpeed == CeilingFan.LOW)
			ceilingFan.low();
		else if (prevSpeed == CeilingFan.OFF)
			ceilingFan.off();
	}

}
