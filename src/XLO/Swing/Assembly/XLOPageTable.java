package XLO.Swing.Assembly;

import XLO.Swing.Assembly.XLOTableModel;

import java.util.ArrayList;

/**
 * @author XiaoLOrange
 * @time 2020.10.13
 * @title 便于分页的表格
 */

public class XLOPageTable extends XLOTableModel {

	//总页码
	private int page = 1;
	//当前页码
	private int currentPage = 1;
	//每页显示个数
	private int num = 5;
	
	public XLOPageTable() {
		
	}

	public XLOPageTable(String[] header){
		//设置表头
		super.setHeader(header);
	}

	/**
	 * 传入数据总条数,自动计算页面数量
	 * @param total
	 */
	public void setPage(int total){
		this.currentPage = 1;
		if(total == 0){
			this.page = 1;
		}else{
			this.page = total % this.num == 0 ? total / this.num : (total / this.num) + 1;
		}
	}

	/**
	 * 表格显示的信息。
	 * @param list
	 */
	public void setShowInfo(ArrayList<Object[]> list){
		if(list == null) return;
		ArrayList<Object[]> content = new ArrayList<>();
		if(list.size() > this.num){
			for(int i = 0; i < this.num; i++){
				content.add(list.get(i));
			}
		}else{
			content = list;
		}
		super.show(content);
	}

	/**
	 * 上一页
	 * @return
	 */
	public boolean previous(){
		if(currentPage <= 1){
			currentPage = 1;
			return false;
		}else{
			currentPage--;
			return true;
		}
	}

	/**
	 * 下一页
	 * @return
	 */
	public boolean next(){
		if(currentPage >= page){
			currentPage = page;
			return false;
		}else{
			currentPage++;
			return true;
		}
	}

	/**
	 * 获取总页码数量
	 * @return
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 获取当前页码
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	
	/**
	 * 设置当前页码
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		if(currentPage < 1 && currentPage > this.page) return;
		this.currentPage = currentPage;
	}

	/**
	 * 获取每页显示个数
	 * @return
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 设置每页显示数量
	 */
	public void setNum(int num) {
		this.num = num;
	}
}
