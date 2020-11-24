package XLO.Swing.Util;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.border.Border;

import XLO.Swing.Assembly.XLOBorder;

/**
 * 
 * @author XiaoLOrange
 * @time 2020年9月14日
 * @title 批量设置控件属性
 */

public class SetUIUtil {
	
	/**
	 * 设置控件的字体大小
	 * @param font
	 * @param assembly
	 */
	public void setFontSize(Font font, JComponent... assembly) {
		for (int i = 0; i < assembly.length; i++){
			assembly[i].setFont(font);
		}
	}
	public void setFontSize(int size, JComponent... assembly) {
		Font font = new Font(null, Font.PLAIN, size);
		for (int i = 0; i < assembly.length; i++){
			assembly[i].setFont(font);
		}
	}

	/**
	 * 设置圆角
	 * @param arch
	 * @param assembly
	 */
	public void setRoundBorders(JComponent... assembly){
		XLOBorder border = new XLOBorder();
		for (int i = 0; i < assembly.length; i++){
			assembly[i].setBorder(border);
		}
	}
	public void setRoundBorders(Border border, JComponent... assembly){
		for (int i = 0; i < assembly.length; i++){
			assembly[i].setBorder(border);
		}
	}
	public void setRoundBorders(int arch, JComponent... assembly){
		XLOBorder border = new XLOBorder(arch);
		for (int i = 0; i < assembly.length; i++){
			assembly[i].setBorder(border);
		}
	}

}
