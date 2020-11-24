package XLO.Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author XiaoLOrange
 * @time 2020.09.15
 * @title
 */

public class ButtonAction implements ActionListener {

	XLOBtnAction panel;

	public ButtonAction(XLOBtnAction panel){
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			Thread.sleep(20);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}

		String action = e.getActionCommand();
		this.panel.BtnClickAction(action);
	}

}
