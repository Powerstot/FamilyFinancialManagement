package view_basic;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import domain.User;
import service.WorkService;
import service.WorkServiceImpl;
import view_income.IncomeAddFrame;
import view_income.IncomeDeleteFrame;
import view_income.IncomeQueryFrame;
import view_income.IncomeUpdateFrame;
import view_pay.PayAddFrame;
import view_pay.PayDeleteFrame;
import view_pay.PayQueryFrame;
import view_pay.PayUpdateFrame;
import view_statistic.ExcelFrame;
import view_statistic.TotalIncomeDayFrame;
import view_statistic.TotalIncomeMonthFrame;
import view_statistic.TotalPayDayFrame;
import view_statistic.TotalPayMonthFrame;
/**
 * 登录成功后进入的主菜单窗口
 * @author Powers
 *
 */
public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public MenuFrame(User user) {
		WorkService service = new WorkServiceImpl();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 882, 26);
		contentPane.add(menuBar);
		
		JMenu incomeMenu = new JMenu("\u6536\u5165");
		incomeMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(incomeMenu);
		
		JMenuItem addIncomeItem = new JMenuItem("\u6DFB\u52A0\u6536\u5165");
		//添加收入
		addIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeAddFrame iaframe = new IncomeAddFrame();
				iaframe.setVisible(true);
				iaframe.setLocationRelativeTo(null);
			}
		});
		addIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		incomeMenu.add(addIncomeItem);
		
		JMenuItem updateIncomeItem = new JMenuItem("\u4FEE\u6539\u6536\u5165");
		//修改收入
		updateIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeUpdateFrame iuframe = new IncomeUpdateFrame();
				iuframe.setVisible(true);
				iuframe.setLocationRelativeTo(null);
			}
		});
		updateIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		incomeMenu.add(updateIncomeItem);
		
		JMenuItem deleteIncomeItem = new JMenuItem("\u5220\u9664\u6536\u5165");
		//删除收入
		deleteIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeDeleteFrame idframe = new IncomeDeleteFrame();
				idframe.setVisible(true);
				idframe.setLocationRelativeTo(null);
			}
		});
		deleteIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		incomeMenu.add(deleteIncomeItem);
		
		JMenuItem findIncomeItem = new JMenuItem("\u67E5\u627E\u6536\u5165");
		//查找收入
		findIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeQueryFrame iqframe = new IncomeQueryFrame();
				iqframe.setVisible(true);
				iqframe.setLocationRelativeTo(null);
			}
		});
		findIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		incomeMenu.add(findIncomeItem);
		
		JMenu payMenu = new JMenu("\u652F\u51FA");
		payMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(payMenu);
		
		JMenuItem addPayItem = new JMenuItem("\u6DFB\u52A0\u652F\u51FA");
		//添加支出
		addPayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayAddFrame paframe = new PayAddFrame();
				paframe.setVisible(true);
				paframe.setLocationRelativeTo(null);
			}
		});
		addPayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		payMenu.add(addPayItem);
		
		JMenuItem updatePayItem = new JMenuItem("\u4FEE\u6539\u652F\u51FA");
		//修改支出
		updatePayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayUpdateFrame puframe = new PayUpdateFrame();
				puframe.setVisible(true);
				puframe.setLocationRelativeTo(null);
			}
		});
		updatePayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		payMenu.add(updatePayItem);
		
		JMenuItem deletePayItem = new JMenuItem("\u5220\u9664\u652F\u51FA");
		//删除支出
		deletePayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayDeleteFrame pdframe = new PayDeleteFrame();
				pdframe.setVisible(true);
				pdframe.setLocationRelativeTo(null);
			}
		});
		deletePayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		payMenu.add(deletePayItem);
		
		JMenuItem findPayItem = new JMenuItem("\u67E5\u8BE2\u652F\u51FA");
		//查询支出
		findPayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayQueryFrame pqframe = new PayQueryFrame();
				pqframe.setVisible(true);
				pqframe.setLocationRelativeTo(null);
			}
		});
		findPayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		payMenu.add(findPayItem);
		
		JMenu statisticMenu = new JMenu("\u7EDF\u8BA1");
		statisticMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(statisticMenu);
		
		JMenuItem allIncomeItem = new JMenuItem("\u603B\u6536\u5165");
		//总收入
		allIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = service.showTotalIncome();
				JOptionPane.showMessageDialog(null, "总收入："+result);
			}
		});
		allIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(allIncomeItem);
		
		JMenuItem allPayItem = new JMenuItem("\u603B\u652F\u51FA");
		//总支出
		allPayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = service.showTotalPay();
				JOptionPane.showMessageDialog(null, "总支出："+result);
			}
		});
		allPayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(allPayItem);
		
		JMenuItem allProfitItem = new JMenuItem("\u603B\u5229\u6DA6");
		//总利润
		allProfitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = service.showTotalProfit();
				JOptionPane.showMessageDialog(null, "总利润："+result);
			}
		});
		allProfitItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(allProfitItem);
		
		JMenuItem monthIncomeItem = new JMenuItem("\u6708\u6536\u5165");
		//月收入
		monthIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getUserIsvip() == 1) {
					TotalIncomeMonthFrame timframe = new TotalIncomeMonthFrame();
					timframe.setVisible(true);
					timframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "您还不是会员，还不能使用此功能哦~");
				}
			}
		});
		monthIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(monthIncomeItem);
		
		JMenuItem monthPayItem = new JMenuItem("\u6708\u652F\u51FA");
		//月支出
		monthPayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getUserIsvip() == 1) {
					TotalPayMonthFrame tpmframe = new TotalPayMonthFrame();
					tpmframe.setVisible(true);
					tpmframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "您还不是会员，还不能使用此功能哦~");
				}
			}
		});
		monthPayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(monthPayItem);
		
		JMenuItem dayIncomeItem = new JMenuItem("\u65E5\u6536\u5165");
		//日收入
		dayIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getUserIsvip() == 1) {
					TotalIncomeDayFrame tidframe = new TotalIncomeDayFrame();
					tidframe.setVisible(true);
					tidframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "您还不是会员，还不能使用此功能哦~");
				}
				
			}
		});
		dayIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(dayIncomeItem);
		
		JMenuItem dayPayItem = new JMenuItem("\u65E5\u652F\u51FA");
		//日支出
		dayPayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getUserIsvip() == 1) {
					TotalPayDayFrame tpdframe = new TotalPayDayFrame();
					tpdframe.setVisible(true);
					tpdframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "您还不是会员，还不能使用此功能哦~");
				}
			}
		});
		dayPayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(dayPayItem);
		
		JMenuItem excelItem = new JMenuItem("\u7EDF\u8BA1\u62A5\u8868");
		//统计报表
		excelItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelFrame frame = new ExcelFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		excelItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(excelItem);
		
		JMenu exitMenu = new JMenu("\u9000\u51FA");
		exitMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(exitMenu);
		
		JMenuItem exitAcountItem = new JMenuItem("\u9000\u51FA\u8D26\u53F7");
		//win10UI消息提示框
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
		//退出账号
		exitAcountItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
				             "真的要退出该账号吗？", "确认", JOptionPane.YES_NO_OPTION); 
				if(flag == 0) {
					LoginFrame loginframe = new LoginFrame();
					loginframe.setVisible(true);
					loginframe.setLocationRelativeTo(null);
					dispose();
				}
			}
		});
		exitAcountItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		exitMenu.add(exitAcountItem);
		
		JMenuItem exitItem = new JMenuItem("\u9000\u51FA\u7A0B\u5E8F");
		//退出程序
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
				             "真的要退出程序吗？", "确认", JOptionPane.YES_NO_OPTION); 
				if(flag == 0) {
					dispose();
				}
			}
		});
		exitItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		exitMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("\u7A97\u53E3");
		windowMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(windowMenu);
		
		JMenuItem refreshItem = new JMenuItem("\u5237\u65B0");
		//刷新
		refreshItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame frame = new MenuFrame(user);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		refreshItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		windowMenu.add(refreshItem);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(-2, 22, 884, 106);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5BB6\u5EAD\u8D22\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 40));
		lblNewLabel.setBounds(1, 3, 881, 102);
		panelTitle.add(lblNewLabel);
		
		//展示收入数据到table
		//调用service方法，获得所有收入信息的List集合
		List list = service.showAllIncome();
		//初始化表格信息
		String[] titles = {"收入编号","收款人","收款内容","收款日期","收款金额"};
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
		scr.setSize(860, 240);
		contentPane.add(scr);
		
		//展示支出数据到table2
		List list2 = service.showAllPay();
		//初始化表格信息
		String[] titles2 = {"支出编号","付款人","支出内容","支出日期","支出金额"};
		Object[][] userinfo2 = new Object [list2.size()][5];
		//遍历List集合，获取每一个map即每一条信息
		i = 0;j = 0;
		for(Object maps:list2) {
			Map map = (Map)maps;
			Set<String> key = map.keySet();
			for (String values : key) {
	            userinfo2[i][j] = map.get(values);
	            j++;
	        }
			j=0;
			i++;
		}
		DefaultTableModel tableModel2 = new DefaultTableModel(userinfo2,titles2);  
		JTable table2 = new JTable(tableModel2);
		JScrollPane scr2 = new JScrollPane(table2);
		scr2.setBounds(8, 386, 860, 240);
		contentPane.add(scr2);
		
		
	}
}
