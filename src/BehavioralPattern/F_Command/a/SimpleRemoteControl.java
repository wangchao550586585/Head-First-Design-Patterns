package BehavioralPattern.F_Command.a;



public class SimpleRemoteControl {
	Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void buttonWasPressed() {
		command.execute();
	}
}
