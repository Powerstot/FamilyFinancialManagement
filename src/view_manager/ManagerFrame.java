package view_manager;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import domain.User;
import service.UserService;
import service.UserServiceImpl;
import view_basic.LoginFrame;
/**
 * ����Ա������
 * @author Powers
 *
 */
public class ManagerFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ManagerFrame() {
		UserService service = new UserServiceImpl();
		User user = new User();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u7528\u6236\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//չʾ�������ݵ�table
		//����service�������������������Ϣ��List����
		List list = service.showAllUser();
		//��ʼ�������Ϣ
		String[] titles = {"�û�id","�û���","�û�����","�û�����","�Ƿ����Ա","�Ƿ��Ա"};
		Object[][] userinfo = new Object [list.size()][6];
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
		contentPane.setLayout(null);
		JTable table = new JTable(tableModel);
		JScrollPane scr = new JScrollPane(table);
		scr.setLocation(5, 33);
		scr.setSize(672, 320);
		contentPane.add(scr);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 677, 26);
		contentPane.add(menuBar);
		
		JMenu userMenu = new JMenu("\u7528\u6237");
		userMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(userMenu);
		
		JMenuItem updateUserItem = new JMenuItem("\u4FEE\u6539\u7528\u6237");
		//�޸��û�
		updateUserItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserUpdateFrame frame = new UserUpdateFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		updateUserItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		userMenu.add(updateUserItem);
		
		JMenuItem deleteUserItem = new JMenuItem("\u5220\u9664\u7528\u6237");
		//ɾ���û�
		deleteUserItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDeleteFrame frame = new UserDeleteFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		deleteUserItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		userMenu.add(deleteUserItem);
		
		JMenuItem queryUserItem = new JMenuItem("\u67E5\u8BE2\u7528\u6237");
		//��ѯ�û�
		queryUserItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserQueryFrame frame = new UserQueryFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		queryUserItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		userMenu.add(queryUserItem);
		
		JMenu vipMenu = new JMenu("\u4F1A\u5458");
		vipMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(vipMenu);
		
		JMenuItem addVipItem = new JMenuItem("\u6DFB\u52A0\u4F1A\u5458");
		//��ӻ�Ա
		addVipItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VipAddFrame frame = new VipAddFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		addVipItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		vipMenu.add(addVipItem);
		
		JMenuItem removeVipItem = new JMenuItem("\u79FB\u9664\u4F1A\u5458");
		//�Ƴ���Ա
		removeVipItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VipRemoveFrame frame = new VipRemoveFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		removeVipItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		vipMenu.add(removeVipItem);
		
		JMenu managerMenu = new JMenu("\u7BA1\u7406\u5458");
		managerMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(managerMenu);
		
		JMenuItem addManagerItem = new JMenuItem("\u6DFB\u52A0\u7BA1\u7406\u5458");
		//��ӹ���Ա
		addManagerItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerAddFrame frame = new ManagerAddFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		addManagerItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		managerMenu.add(addManagerItem);
		
		JMenuItem removeManagerItem = new JMenuItem("\u79FB\u9664\u7BA1\u7406\u5458");
		//�Ƴ�����Ա
		removeManagerItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerRemoveFrame frame = new ManagerRemoveFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		removeManagerItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		managerMenu.add(removeManagerItem);
		
		JMenu exitMenu = new JMenu("\u9000\u51FA");
		exitMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(exitMenu);
		
		JMenuItem exitAccountItem = new JMenuItem("\u9000\u51FA\u8D26\u53F7");
		//�˳��˺�
		exitAccountItem.addActionListener(new ActionListener() {
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
		exitAccountItem.setFont(new Font("Dialog", Font.PLAIN, 20));
		exitMenu.add(exitAccountItem);
		
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
		exitItem.setFont(new Font("Dialog", Font.PLAIN, 20));
		exitMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("\u7A97\u53E3");
		windowMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(windowMenu);
		
		JMenuItem refreshItem = new JMenuItem("\u5237\u65B0");
		//ˢ��
		refreshItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerFrame frame = new ManagerFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
				dispose();
			}
		});
		refreshItem.setFont(new Font("Dialog", Font.PLAIN, 20));
		windowMenu.add(refreshItem);
	}
}
