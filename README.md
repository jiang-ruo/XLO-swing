# XLO-swing
## 前言

​	最近整理java的学习笔记，在不起眼的角落处发现了这个搁置已久的swing快捷工具(黑历史)。

​	早期在学习swing的时候，尚且不知道有可视化swing开发工具，感觉GUI界面的开发十分的繁琐，打算开发一个swing快捷工具，提供快速布局、快速绑定样式、快速绑定监听、以及功能更强大的默认组件(自带滚动条的文本框，自带分页的表格等)。

​	因为学习周期过快，各种想法几乎都没有实现。在整理java学习笔记的时候，发现了这个小工具(姑且称之为工具😂😂)，便想着整理出一点接口出来也算是完成当时的初心。



## 什么是Swing

​	Swing是一个为JAVA设计的GUI工具包，是JAVA基础类的一部分。Swing是基于AWT的图形界面工具，采用纯JAVA实现，不依赖 各个平台的图形界面，对跨平台的支持十分出色。



## Swing 与 AWT的区别

1. AWT是基于本地方法的C/C++程序，Swing是基于AWT的Java程序。
2. 运行速度：AWT > Swing
3. Swing的各个控件跨平台表现相同，AWT的控件基于各个平台的各自的风格。



## 工具介绍

批量便捷摆放组件;

设置组件的字体与圆角;

表格组件：带有分页及滚动条;

批量绑定按钮与事件的工具;

```java
// 该工具类用于便捷放置组件的位置，同时将组件的Layout设为null
class XLO.Swing.Util.LayoutNUllUtil {

    /**
     * @param panel 组件将要绑定的面板
     * @param e 需要放置的组件
     * @param x 绑定的位置
     * @param y 绑定的位置
     * @param width 组件的长度
     * @param height 组件的高度
     */
    public static void addElement(Container panel, Component e, int x, inty, int width, int height);

    /**
     * @param e 需要放置的组件
     * @param x 绑定的位置
     * @param y 绑定的位置
     * @param width 组件的宽度
     * @param height 组件的高度
     */
    public void addElement(Component e, int x, inty, int width, int height);
    /**
     * 批量添加组件，
     * @param x_offset 控件和上一个控件X方向的偏移量
     * @param y_offset 控件和上一个控件Y方向的偏移量
     * @param x 第一个组件的位置
     * @param y 第一个组件的位置
     * @param width 所有组件的宽度
     * @param height 所有组件的高度
     * @param es 传入组件
     */
    public void addElement(int x_offset, int y_offset, int x, int y, int width, int height, Component... es);
}
```
```java
// 设置组件字体大小及圆角
// TODO: 用于快捷设置组件的各种属性
class XLO.Swing.Util.SetUIUtil {
    /**
     * 批量设置组件的字体大小，字体默认为Font.PLAIN
     * @param size 字体
     * @param assembly 需要设置字体的组件
     */
    public void setFontSize(int size, JComponent... assembly);
	/**
	 * 批量设置控件的字体属性
	 * @param font
	 * @param assembly
	 */
	public void setFontSize(Font font, JComponent... assembly);
    /**
	 * 设置组件的圆角，圆角弧度默认为XLO.Swing.Assembly.XLOBorder中的设置
	 * @param assembly
	 */
	public void setRoundBorders(JComponent... assembly);
    /**
	 * 批量设置控件的边框属性
	 * @param border
	 * @param assembly
	 */
    public void setRoundBorders(Border border, JComponent... assembly);
    /**
	 * 批量设置控件的边框属性
	 * @param arch 角度
	 * @param assembly
	 */
    public void setRoundBorders(int arch, JComponent... assembly);
}
```

```java
// 表格分页组件

// 表格基类，生成的表格带有滚动条
class XLO.Swing.Assembly.XLOTableModel {
    /**
	 * 设置表头。
	 * @param title
	 */
	public void setHeader(String... title);
   	/**
	 * 设置表格中的显示内容
	 * @param rows
	 */
	public void show(ArrayList<Object[]> rows);
    /**
	 * 绑定鼠标点击事件
	 */
	public void addTableMouseListener(MouseListener listener);
   	/**
	 * 
	 * @return 返回选中行的行数
	 */
	public int getSelectedRow();
	/**
	 * 获取选中行的内容
	 * @return 返回Object数组。
	 */
	public Object[] getSelectRowInfo();
	/**
	 * 设置表格的行高。
	 * @param height
	 */
	public void setRowHeight(int height);
	/**
	 * 设置每列的列宽
	 * @param widths
	 */
	public void setColWidth(int... widths);
}

// 表格分页组件
// PS：现在看来该组件的功能极度不健全，姑且添加以下带办事项(ε=ε=ε=┏(゜ロ゜;)┛逃)
// TODO：添加表格内容缓冲区，将每次添加的内容记录到缓冲区。
// TODO：保存总数据量。
// TODO：设置页码信息后重新计算总页码数量。
class XLO.Swing.Assembly.XLOTableModel {
	/**
	 * @param header 设置表头
	 */
    public XLOPageTable(String[] header);
	/**
	 * 用于在确定数据量但没有数据的情况下显示表格信息
	 * 调用该方法前需要设置表格每页数量，默认值为每页5条数据
	 * @param total
	 */
	public void setPage(int total);
	/**
	 * 表格当前页显示的信息。
	 * @param list
	 */
	public void setShowInfo(ArrayList<Object[]> list);
	/**
	 * 上一页
	 * @return
	 */
	public boolean previous();
	/**
	 * 下一页
	 * @return
	 */
	public boolean next();
	/**
	 * @return 总页码数量
	 */
	public int getPage();
	/**
	 * @return 获取当前页码
	 */
	public int getCurrentPage();
	/**
	 * @param currentPage 设置当前页码
	 */
	public void setCurrentPage(int currentPage);
	/**
	 * @return 每页显示个数
	 */
	public int getNum();
	/**
	 * 设置每页显示数量
	 */
	public void setNum(int num);
}
```

```java
// 批量边界绑定组件的工具
class XLO.Control.ButtonClickAction{
	/**
	 * 给一个按钮绑定监听
	 * @param btn 按钮
	 * @param command 点击按钮后getActionCommand的值
	 */
	public void setCommand(AbstractButton btn, String command);
	/**
	 * 多个按钮绑定监听，传入的按钮及command必须一一对应
	 * @param btns 按钮
	 * @param commands 点击按钮后getActionCommand的值
	 */
	public void setCommand(AbstractButton[] btns, String[] commands)
}
// 带有连点保护的command控制器
class XLO.Control.ButtonAction;
```



## 后记

​	虽然XLO-swing中只有寥寥无几的工具，但是以如今的视角看待这些工具，也是存在许多不足。发表并整理出接口文档以供大家学习使用。