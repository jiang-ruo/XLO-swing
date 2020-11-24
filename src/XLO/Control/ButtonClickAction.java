package XLO.Control;

import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

/**
 * 
 * @author XiaoLOrange
 * @date 2020.09.02
 * @title 绑定按钮的点击事件
 *
 */

public class ButtonClickAction {
	
	private ActionListener bca;
	
//	private Map<AbstractButton, String> cmd = new HashMap<AbstractButton, String>();
	
	public ButtonClickAction(ActionListener actionListener) {
		this.bca = actionListener;
	}
	
	/**
	 * 将一个按钮绑定监听
	 * @param btn 按钮
	 * @param command
	 */
	public void setCommand(AbstractButton btn, String command) {
//		cmd.put(btn, command);
		btn.setActionCommand(command);
		btn.addActionListener(this.bca);
	}
	
	/**
	 * 多个按钮绑定监听，传入数组。
	 * @param btns
	 * @param commands
	 * @throws Exception 
	 */
	public void setCommand(AbstractButton[] btns, String[] commands){
		if(btns.length != commands.length) {
			try {
				throwError("参数错误，传入的两个数组长度必须相同");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < btns.length; i++) {
//			cmd.put(btns[i], commands[i]);
			btns[i].setActionCommand(commands[i]);
			btns[i].addActionListener(this.bca);
		}
	}
	
	private void throwError(String str) throws Exception {
		throw new Exception(str);
	}
	
}
