package StructuralPattern.M_Proxy.image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageProxyTestDrive {
	ImageComponent imageComponent;
	JFrame frame = new JFrame("CD Conver Viewer");
	JMenuBar menuBar;
	JMenu menu;
	Hashtable<String, String> cds = new Hashtable<String, String>();

	public static void main(String[] args) throws MalformedURLException {
		ImageProxyTestDrive imageProxyTestDrive = new ImageProxyTestDrive();
	}

	public ImageProxyTestDrive() throws MalformedURLException {
		cds.put("location1",
				"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2381824688,2178874543&fm=23&gp=0.jpg");
		cds.put("location2",
				"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2840077993,1894827125&fm=23&gp=0.jpg");
		cds.put("location3",
				"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4036133786,144124081&fm=23&gp=0.jpg");

		URL url = new URL((String) cds.get("location1"));
		menuBar = new JMenuBar();
		menu = new JMenu("Favorite CD");
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		for (Enumeration e = cds.keys(); e.hasMoreElements();) {
			String name = (String) e.nextElement();
			JMenuItem jMenuItem = new JMenuItem(name);
			menu.add(jMenuItem);
			jMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					imageComponent.setIcon(new ImageProxy(getCDUrl(e
							.getActionCommand())));
					frame.repaint();
				}
			});

		}

		// 建立框架和菜单
		ImageProxy imageProxy = new ImageProxy(url);
		imageComponent = new ImageComponent(imageProxy);
		frame.getContentPane().add(imageComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	private URL getCDUrl(String name) {
		try {
			return new URL((String) cds.get(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
