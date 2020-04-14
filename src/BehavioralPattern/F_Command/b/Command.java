package BehavioralPattern.F_Command.b;

/**
 * 命令接口
 *
 */
public interface Command {
	void execute();
	
	void undo();
}
