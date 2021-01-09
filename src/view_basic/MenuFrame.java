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
 * ��¼�ɹ����������˵�����
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
		//�������
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
		//�޸�����
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
		//ɾ������
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
		//��������
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
		//���֧��
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
		//�޸�֧��
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
		//ɾ��֧��
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
		//��ѯ֧��
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
		//������
		allIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = service.showTotalIncome();
				JOptionPane.showMessageDialog(null, "�����룺"+result);
			}
		});
		allIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(allIncomeItem);
		
		JMenuItem allPayItem = new JMenuItem("\u603B\u652F\u51FA");
		//��֧��
		allPayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = service.showTotalPay();
				JOptionPane.showMessageDialog(null, "��֧����"+result);
			}
		});
		allPayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(allPayItem);
		
		JMenuItem allProfitItem = new JMenuItem("\u603B\u5229\u6DA6");
		//������
		allProfitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = service.showTotalProfit();
				JOptionPane.showMessageDialog(null, "������"+result);
			}
		});
		allProfitItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(allProfitItem);
		
		JMenuItem monthIncomeItem = new JMenuItem("\u6708\u6536\u5165");
		//������
		monthIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getUserIsvip() == 1) {
					TotalIncomeMonthFrame timframe = new TotalIncomeMonthFrame();
					timframe.setVisible(true);
					timframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "�������ǻ�Ա��������ʹ�ô˹���Ŷ~");
				}
			}
		});
		monthIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(monthIncomeItem);
		
		JMenuItem monthPayItem = new JMenuItem("\u6708\u652F\u51FA");
		//��֧��
		monthPayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getUserIsvip() == 1) {
					TotalPayMonthFrame tpmframe = new TotalPayMonthFrame();
					tpmframe.setVisible(true);
					tpmframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "�������ǻ�Ա��������ʹ�ô˹���Ŷ~");
				}
			}
		});
		monthPayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(monthPayItem);
		
		JMenuItem dayIncomeItem = new JMenuItem("\u65E5\u6536\u5165");
		//������
		dayIncomeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getUserIsvip() == 1) {
					TotalIncomeDayFrame tidframe = new TotalIncomeDayFrame();
					tidframe.setVisible(true);
					tidframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "�������ǻ�Ա��������ʹ�ô˹���Ŷ~");
				}
				
			}
		});
		dayIncomeItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(dayIncomeItem);
		
		JMenuItem dayPayItem = new JMenuItem("\u65E5\u652F\u51FA");
		//��֧��
		dayPayItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getUserIsvip() == 1) {
					TotalPayDayFrame tpdframe = new TotalPayDayFrame();
					tpdframe.setVisible(true);
					tpdframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "�������ǻ�Ա��������ʹ�ô˹���Ŷ~");
				}
			}
		});
		dayPayItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		statisticMenu.add(dayPayItem);
		
		JMenuItem excelItem = new JMenuItem("\u7EDF\u8BA1\u62A5\u8868");
		//ͳ�Ʊ���
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
		//win10UI��Ϣ��ʾ��
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
		//�˳��˺�
		exitAcountItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
				             "���Ҫ�˳����˺���", "ȷ��", JOptionPane.YES_NO_OPTION); 
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
		//�˳�����
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
				             "���Ҫ�˳�������", "ȷ��", JOptionPane.YES_NO_OPTION); 
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
		//ˢ��
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
		lblNewLabel.setFont(new Font("����", Font.BOLD, 40));
		lblNewLabel.setBounds(1, 3, 881, 102);
		panelTitle.add(lblNewLabel);
		
		//չʾ�������ݵ�table
		//����service�������������������Ϣ��List����
		List list = service.showAllIncome();
		//��ʼ�������Ϣ
		String[] titles = {"������","�տ���","�տ�����","�տ�����","�տ���"};
		Object[][] userinfo = new Object [list.size()][5];
		//����List���ϣ���ȡÿһ��map��ÿһ����Ϣ
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
		
		//չʾ֧�����ݵ�table2
		List list2 = service.showAllPay();
		//��ʼ�������Ϣ
		String[] titles2 = {"֧�����","������","֧������","֧������","֧�����"};
		Object[][] userinfo2 = new Object [list2.size()][5];
		//����List���ϣ���ȡÿһ��map��ÿһ����Ϣ
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
