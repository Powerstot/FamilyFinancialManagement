package view_pay;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import service.WorkService;
import service.WorkServiceImpl;
/**
 * 查询支出信息展示窗口
 * @author Powers
 *
 */
public class PayQueryResultFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PayQueryResultFrame(String way,String value) {
		WorkService service = new WorkServiceImpl();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u67E5\u8BE2\u7ED3\u679C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		//查询收入数据到table
		//调用service方法，查询指定收入信息的List集合
		List list = null;
		if("byPayee".equals(way)) {
			list = service.showByPayer(value);
		}else if("byContent".equals(way)) {
			list = service.showPayByContent(value);
		}else if("byDate".equals(way)) {
			list = service.showPayByDate(value);
		}else if("byMoney".equals(way)){
			list = service.showPayByMoney(value);
		}
		//初始化表格信息
		String[] titles = {"支出编号","付款人","支出内容","支出日期","支出金额"};
		Object[][] userinfo = new Object [list.size()][5];
		//遍历List集合，获取每一个map即每一条信息
		int i = 0,j = 0;
		for(Object maps:list) {
			Map map = (Map)maps;
			Set<String> key = map.keySet();
			for (String values : key) {
	            userinfo[i][j] = map.get(values);
	            j++;
	        }
			j=0;
			i++;
		}
				
		DefaultTableModel tableModel = new DefaultTableModel(userinfo,titles); 
		JTable table = new JTable(tableModel);
		JScrollPane scr = new JScrollPane(table);
		scr.setLocation(8, 133);
		scr.setSize(766, 332);
		contentPane.add(scr);
	}

}
