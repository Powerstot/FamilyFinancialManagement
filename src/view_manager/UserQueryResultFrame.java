package view_manager;

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

import service.UserService;
import service.UserServiceImpl;
/**
 * 查询用户结果展示窗口
 * @author Powers
 *
 */
public class UserQueryResultFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UserQueryResultFrame(String username) {
		UserService service = new UserServiceImpl();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u67E5\u8BE2\u7ED3\u679C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 779, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
		//展示收入数据到table
		//调用service方法，获得所有收入信息的List集合
		List list = service.showListByUsername(username);
		//初始化表格信息
		String[] titles = {"用户id","用户名","用户密码","用户邮箱","是否管理员","是否会员"};
		Object[][] userinfo = new Object [list.size()][6];
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
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		JTable table = new JTable(tableModel);
		JScrollPane scr = new JScrollPane(table);
		scr.setLocation(0, 0);
		scr.setSize(763, 290);
		contentPane.add(scr);
	}

}
