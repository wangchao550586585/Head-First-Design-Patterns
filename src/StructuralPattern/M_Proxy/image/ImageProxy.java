package StructuralPattern.M_Proxy.image;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * 设计CD封面虚拟代理 
 * 1：imageProxy创建imageIcon，开始从网上加载图片 
 * 2：加载过程中，imageProxy显示CD加载中
 * 3：图像加载完毕，imageProxy把所有方法委托给真正的imageIcon对象 
 * 4：用户请求新的图片，就创建新的代理，重复过程
 */
public class ImageProxy implements Icon {
	ImageIcon imageIcon;
	URL imageURL;
	Thread retrievalThread;
	boolean retrieving = false;

	public ImageProxy(URL imageURL) {
		this.imageURL = imageURL;
	}

	// 可以用状态模式优化
	public int getIconWidth() {
		if (imageIcon != null) {
			return imageIcon.getIconWidth();
		} else
			return 800;
	}

	// 可以用状态模式优化
	public int getIconHeight() {
		if (imageIcon != null) {
			return imageIcon.getIconHeight();
		} else {
			return 600;
		}
	}

	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		if (imageIcon != null)
			imageIcon.paintIcon(c, g, x, y);
		else {
			g.drawString("正在加载请等待", x + 300, y + 190);
			// 如果没有取出图片
			if (!retrieving) {
				retrieving = true;
				// 加载图片同步的话，会耗在这里，不能进行其他操作，所以采用多开线程异步加载图片
				retrievalThread = new Thread(new Runnable() {
					public void run() {
						try {
							// 构造器会在图片加载完后才返回
							imageIcon = new ImageIcon(imageURL, "CD Conver");
							// 图像加载好后，重绘
							c.repaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				retrievalThread.start();
			}
		}
	}

}
