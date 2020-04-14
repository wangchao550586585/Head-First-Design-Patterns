package BehavioralPattern.I_TemplateMethod.Applet;

import java.applet.Applet;
import java.awt.Graphics;

public class MyApplet extends Applet {
	String message;

	// init钩子用来进行applet初始化动作
	public void init() {
		message = "hello world";
		// applet类的一个具体方法，可让applet的上层组件知道这个applet要重绘
		repaint();
	}

	@Override
	public void start() {
		message = "start";
		repaint();
	}

	@Override
	public void stop() {
		message = "stop";
		repaint();
	}

	@Override
	public void destroy() {
	}

	public void paint(Graphics g) {

	}
}
