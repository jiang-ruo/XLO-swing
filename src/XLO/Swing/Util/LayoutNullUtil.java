package XLO.Swing.Util;

import java.awt.Component;
import java.awt.Container;

/**
 * 
 * @author XiaoLOrange
 * @date 2020.09.02
 * @date 2020.10.16 添加批量设置有序控件
 * @title 设置awt和swing控件位置
 *
 */

public class LayoutNullUtil {
	
	private Container panel;
	
	public LayoutNullUtil(Container panel) {
		this.panel = panel;
	}
	
	/**
	 * 将控件添加到默认面板的指定位置，并设置长宽
	 * @param e
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void addElement(Component e, int x, int y, int width, int height) {
		addElement(this.panel, e, x, y, width, height);
	}
	
	/**
	 * 批量添加控件
	 * @param x_offset 控件和上一个控件X方向的偏移量
	 * @param y_offset 控件和上一个控件Y方向的偏移量
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param es
	 */
	public void addElement(int x_offset, int y_offset, int x, int y, int width, int height, Component... es) {
		for (int i = 0; i < es.length; i++) {
			addElement(this.panel, es[i], x, y, width, height);
			x += x_offset;
			y += y_offset;
		}
	}
	
	/**
	 * 将控件添加到指定面板的指定位置，并设置长宽
	 * @param e
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public static void addElement(Container panel, Component e, int x, int y, int width, int height) {
		panel.setLayout(null);
		e.setBounds(x, y, width, height);
		panel.add(e);
	}
	
}
