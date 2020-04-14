package BehavioralPattern.F_Command.a;


/**
 * 命令模式：将请求封装成对象，以便使用不同的请求，队列或者日志来参数化其他对象，命令模式也支持可撤销的操作
 * 场景：队列请求(线程从队列中一个个删除命令对象，然后调用命令对象的execute方法)，线程池，日程安排,事务系统(日志回滚)
 */
public class Main {

	public static void main(String[] args) {
		// 电灯对象(接受者)
		Light light = new Light();
		// 创建命令，将接受者传给它
		LightOnCommand command = new LightOnCommand(light);

		// 遥控器(调用者)
		SimpleRemoteControl remote = new SimpleRemoteControl();
		// 命令传给调用者
		remote.setCommand(command);
		// 按下按钮
		remote.buttonWasPressed();

	}
}
