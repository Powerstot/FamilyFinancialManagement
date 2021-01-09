package view_manager;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import domain.User;
import service.UserService;
import service.UserServiceImpl;
/**
 * 查询用户窗口
 * @author Powers
 *
 */
public class UserQueryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;

	/**
	 * Create the frame.
	 */
	public UserQueryFrame() {
		UserService service = new UserServiceImpl();
		User user = new User();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u67E5\u8BE2\u7528\u6237");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 429, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbluserUsername = new JLabel("\u7528\u6237\u540D\uFF1A");
		lbluserUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lbluserUsername.setBounds(44, 76, 84, 27);
		contentPane.add(lbluserUsername);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		txtUsername.setBounds(136, 77, 171, 24);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//确定
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtUsername.getText().equals("")) {
					UserQueryResultFrame frame = new UserQueryResultFrame(txtUsername.getText());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "查询数据不能为空！");
				}
			}
		});
		btnTrue.setBounds(68, 141, 113, 27);
		contentPane.add(btnTrue);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		//取消
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(195, 141, 113, 27);
		contentPane.add(btnCancel);
	}
}
