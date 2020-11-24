package XLO.Swing.Assembly;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * @author XiaoLOrange
 * @title 表格基类。
 * @time 2020.09.14
 */

public abstract class XLOTableModel extends JScrollPane {

	private DefaultTableModel tableModel;
	private JTable table;

	/**
	 * 每次新建表格时需要重置的属性
	 */
	private String[] Header;
	//列宽
	private int[] widths;

	public XLOTableModel(){
		this.table = new JTable(tableModel);
		//将表格加入滚东框
		this.setViewportView(this.table);
		//更改表格内容
		NewTable();
	}

	/**
	 * 设置表头。
	 * @param title
	 */
	public void setHeader(String... title){
		int col = title.length;
		if(col == 0) return;
		//记录表头
		this.Header = title;
		//显示表头。
		this.tableModel.setColumnCount(col);
		this.tableModel.setColumnIdentifiers(title);
	}

	/**
	 * 设置表格中的显示内容
	 * @param rows
	 */
	public void show(ArrayList<Object[]> rows){
		NewTable();
		for (int i = 0; i < rows.size(); i++){
			this.tableModel.addRow(rows.get(i));
		}
	}

	/**
	 * 重置表格/该页面
	 */
	private void NewTable(){
		//初始化并设置单元格不可编辑。
		this.tableModel = getNewDefaultTableModel();
		//给表格添加表头
		if(this.Header != null){
			setHeader(this.Header);
		}
		//初始化表格。
		this.table.setModel(this.tableModel);

		//设置列宽。
		setColWidth();
	}

	/**
	 * 重新实例化DefaultTableModel
	 * @return
	 */
	private DefaultTableModel getNewDefaultTableModel(){
		return new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
	}

	/**
	 * 绑定鼠标点击事件
	 */
	public void addTableMouseListener(MouseListener listener){
		this.table.addMouseListener(listener);
	}

	/**
	 * 
	 * @return 返回选中行的行数
	 */
	public int getSelectedRow(){
		return this.table.getSelectedRow();
	}

	/**
	 * 获取选中行的信息
	 * @return 返回Object数组。
	 */
	public Object[] getSelectRowInfo(){
		int row = this.table.getSelectedRow();
		//用户没有选中任何行时row为-1
		if(row == -1) return null;
		if(this.Header.length == 0) return null;

		//
		Object[] info = new Object[this.Header.length];
		for(int i = 0; i < this.Header.length; i++){
			info[i] = this.tableModel.getValueAt(row, i);
		}

		return info;
	}

	/**
	 * 设置表格的行高。
	 * @param height
	 */
	public void setRowHeight(int height){
		this.table.setRowHeight(height);
	}

	/**
	 * 设置每列的列宽
	 * @param widths
	 */
	public void setColWidth(int... widths){
		this.widths = widths;
		setColWidth();
	}
	private void setColWidth(){
		if(this.widths == null) return;
		int len = this.Header.length > this.widths.length ? this.widths.length : this.Header.length;
		for (int i = 0; i < len; i++){
			this.table.getColumnModel().getColumn(i).setPreferredWidth(this.widths[i]);
		}
	}

	/**
	 * 更多操作可以获取tableModel对象设置
	 * @return
	 */
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	/**
	 * 更多操作可以获取jTable对象设置。
	 * @return
	 */
	public JTable getTable() {
		return table;
	}

}
