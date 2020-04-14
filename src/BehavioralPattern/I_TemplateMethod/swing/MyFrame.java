package BehavioralPattern.I_TemplateMethod.swing;

import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.JFrame;

/**
 * swing
 */
public class MyFrame extends JFrame {
	//update是模板方法
	public MyFrame(String title) throws HeadlessException {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);
	}

	//默认paint是钩子，覆盖paint，添加一条消息
	public void paint(Graphics g) {
		super.paint(g);
		String msg = "哈哈";
		g.drawString(msg, 100, 100);
	}

	public static void main(String[] args) {
		new MyFrame("哈哈");
	}

}
