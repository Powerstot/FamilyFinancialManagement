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
 * 修改用户窗口
 * @author Powers
 *
 */
public class UserUpdateFrame extends JFrame {
	private JPanel contentPane;
	private JTextField txtuserUsername;
	private JTextField txtuserPassword;
	private JTextField txtuserEmail;
	private JTextField txtUserId;

	/**
	 * Create the frame.
	 */
	public UserUpdateFrame() {
		UserService service = new UserServiceImpl();
		User user = new User();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u4FEE\u6539\u7528\u6237");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbluserUsername = new JLabel("\u7528\u6237\u540D\uFF1A");
		lbluserUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lbluserUsername.setBounds(49, 60, 72, 18);
		contentPane.add(lbluserUsername);
		
		txtuserUsername = new JTextField();
		txtuserUsername.setToolTipText("\u8F93\u5165\u6536\u6B3E\u4EBA\u59D3\u540D");
		txtuserUsername.setBounds(151, 57, 206, 24);
		contentPane.add(txtuserUsername);
		txtuserUsername.setColumns(10);
		
		JLabel lblIncomeContent = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		lblIncomeContent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeContent.setBounds(35, 97, 86, 18);
		contentPane.add(lblIncomeContent);
		
		JLabel lblIncomeDate = new JLabel("\u7528\u6237\u90AE\u7BB1\uFF1A");
		lblIncomeDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeDate.setBounds(40, 139, 84, 18);
		contentPane.add(lblIncomeDate);
		
		txtuserPassword = new JTextField();
		txtuserPassword.setToolTipText("\u8F93\u5165\u8981\u4FEE\u6539\u7684\u5BC6\u7801");
		txtuserPassword.setColumns(10);
		txtuserPassword.setBounds(151, 94, 206, 24);
		contentPane.add(txtuserPassword);
		
		txtuserEmail = new JTextField();
		txtuserEmail.setToolTipText("\u90AE\u7BB1\u5FC5\u987B\u6709@\u7B26\u53F7");
		txtuserEmail.setColumns(10);
		txtuserEmail.setBounds(150, 135, 206, 24);
		contentPane.add(txtuserEmail);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//确定按钮
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
			             "确定修改吗？", "确认", JOptionPane.YES_NO_OPTION); 
				if(flag == 0) {
					if(!txtUserId.getText().equals("") && !txtuserUsername.getText().equals("") && !txtuserPassword.getText().equals("") 
							&& !txtuserEmail.getText().equals("")) {
						//封装user
						user.setUserId(Integer.valueOf(txtUserId.getText()));
						user.setUserUsername(txtuserUsername.getText());
						user.setUserPassword(txtuserPassword.getText());
						user.setUserEmail(txtuserEmail.getText());
						
						//调用方法
						int flag2 = service.updateUser(user);
						if(flag2 == 1) {
							JOptionPane.showMessageDialog(null, "修改成功！");
						}else {
							JOptionPane.showMessageDialog(null, "修改失败！");
						}
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "请将表格填写完整后再修改数据！");
					}
				}else {
					
				}
			}
		});
		btnTrue.setBounds(74, 189, 113, 27);
		contentPane.add(btnTrue);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		//取消按钮
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(205, 188, 113, 27);
		contentPane.add(btnCancel);
		
		JLabel lblUserId = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		lblUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserId.setBounds(37, 24, 84, 18);
		contentPane.add(lblUserId);
		
		txtUserId = new JTextField();
		txtUserId.setToolTipText("\u8F93\u5165\u8981\u4FEE\u6539\u7684\u7528\u6237\u7F16\u53F7");
		txtUserId.setColumns(10);
		txtUserId.setBounds(151, 21, 206, 24);
		contentPane.add(txtUserId);
	}

}
