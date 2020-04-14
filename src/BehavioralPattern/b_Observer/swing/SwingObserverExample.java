package BehavioralPattern.b_Observer.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
	JFrame frame;

	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}

	public void go() {
		frame = new JFrame();
		JButton jButton = new JButton("你确定吗？");
		jButton.addActionListener(new AngelListener());
		jButton.addActionListener(new DevilListen());
		frame.getContentPane().add(BorderLayout.CENTER, jButton);

	}

	class AngelListener implements ActionListener {
		//类似update()
		public void actionPerformed(ActionEvent e) {
			System.out.println("确定");
		}

	}

	class DevilListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("确定");
		}

	}

}
