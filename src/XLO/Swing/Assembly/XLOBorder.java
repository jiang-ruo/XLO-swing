package XLO.Swing.Assembly;

import javax.swing.border.Border;
import java.awt.*;

/**
 * @author XiaoLOrange
 * @title 设置awt和swing组件圆角
 * @time 2020.09.14
 */

public class XLOBorder implements Border {

	private int arcWidth = 15;
	private int arcHeight = 15;

	public XLOBorder(){}

	public XLOBorder(int arch){
		this.arcHeight = arch;
		this.arcWidth = arch;
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(0, 0, 0, 0);
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width,
							int height) {

		g.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, this.arcWidth, this.arcHeight);
	}


}
