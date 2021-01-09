package view_basic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import domain.User;
import service.UserService;
import service.UserServiceImpl;
import javax.swing.JPasswordField;
/**
 * 用户注册窗口
 * @author Powers
 *
 */
public class RegistFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JButton btnRegist;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblPasswordAgain;
	private JLabel lblLoginbtn;
	private JButton btnLogin;
	private JPasswordField txtPassword;
	private JPasswordField txtPasswordAgain;
	
	/**
	 * Create the frame.
	 */
	public RegistFrame() {
		
		//设置图标
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u7528\u6237\u6CE8\u518C");
		  
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 535);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblUsername.setBounds(116, 69, 123, 47);
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsername.setFont(new Font("宋体", Font.PLAIN, 30));
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("\u7528\u6237\u540D\u5E94\u4E3A6-18\u4F4D\u6570\u5B57\u5B57\u6BCD\u7EC4\u6210");
		txtUsername.setFont(new Font("宋体", Font.PLAIN, 20));
		txtUsername.setBounds(286, 82, 236, 37);
		contentPane.add(txtUsername);
		txtUsername.setColumns(32);
		
		lblPassword = new JLabel("\u5BC6\u7801\uFF1A");
		lblPassword.setBounds(145, 123, 90, 47);
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 30));
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("宋体", Font.PLAIN, 20));
		txtPassword.setBounds(286, 133, 236, 37);
		contentPane.add(txtPassword);

		lblPasswordAgain = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblPasswordAgain.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPasswordAgain.setFont(new Font("宋体", Font.PLAIN, 30));
		lblPasswordAgain.setBounds(85, 182, 150, 47);
		contentPane.add(lblPasswordAgain);
		
		txtPasswordAgain = new JPasswordField();
		txtPasswordAgain.setFont(new Font("宋体", Font.PLAIN, 20));
		txtPasswordAgain.setBounds(286, 192, 236, 37);
		contentPane.add(txtPasswordAgain);
		
		btnRegist = new JButton("\u6CE8\u518C");
		//win10UI消息提示框
				try {
		            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
		                | UnsupportedLookAndFeelException e) {
		            e.printStackTrace();
		        }
		UserService service = new UserServiceImpl();
		//添加注册事件
		btnRegist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtPassword.getText().equals("") && !txtPasswordAgain.getText().equals("") && !txtEmail.getText().equals("") 
						&& !txtUsername.getText().equals("")) {
					if(txtPassword.getText().equals(txtPasswordAgain.getText())) {
						User user = new User();
						User RegistUser = new User();
						RegistUser.setUserUsername(txtUsername.getText());
						RegistUser.setUserPassword(txtPassword.getText());
						RegistUser.setUserEmail(txtEmail.getText());
						
						int result = service.Regist(RegistUser);
						if(result == 1) {
							JOptionPane.showMessageDialog(null, "注册成功");
							LoginFrame loginframe = new LoginFrame();
							loginframe.setVisible(true);
							loginframe.setLocationRelativeTo(null);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "注册失败,用户名已存在");
						}
					}else {
						JOptionPane.showMessageDialog(null, "两次输入的密码不一致");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "请将表格填写完整再注册");
				}
			}
		});
		btnRegist.setBounds(232, 348, 123, 48);
		btnRegist.setBackground(Color.ORANGE);
		btnRegist.setForeground(Color.BLACK);
		btnRegist.setFont(new Font("宋体", Font.BOLD, 30));
		contentPane.add(btnRegist);
		
		
		lblEmail = new JLabel("\u90AE\u7BB1\uFF1A");
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setFont(new Font("宋体", Font.PLAIN, 30));
		lblEmail.setBounds(146, 239, 90, 47);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("\u90AE\u7BB1\u5E94\u4E3A\u5305\u542B@\u7B26\u53F7\u7531\u6570\u5B57\u5B57\u6BCD\u7EC4\u6210");
		txtEmail.setFont(new Font("宋体", Font.PLAIN, 20));
		txtEmail.setColumns(32);
		txtEmail.setBounds(286, 248, 236, 37);
		contentPane.add(txtEmail);
		
		
		
		lblLoginbtn = new JLabel("\u5DF2\u6709\u8D26\u53F7\uFF1F");
		lblLoginbtn.setForeground(Color.RED);
		lblLoginbtn.setFont(new Font("宋体", Font.ITALIC, 20));
		lblLoginbtn.setBounds(372, 433, 100, 55);
		contentPane.add(lblLoginbtn);
		
		btnLogin = new JButton("\u7ACB\u5373\u767B\u5F55");
		//返回登录
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				loginframe.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnLogin.setForeground(Color.RED);
		btnLogin.setFont(new Font("宋体", Font.ITALIC, 20));
		btnLogin.setBounds(469, 447, 123, 27);
		contentPane.add(btnLogin);
		
		ImageIcon img = new ImageIcon("img\\Regist_body.jpg");
		JLabel bgimg = new JLabel(img);
		bgimg.setBounds(0, 0, 606, 488);
		contentPane.add(bgimg);
		
	}
}