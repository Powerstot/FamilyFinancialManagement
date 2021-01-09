package view_basic;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import domain.User;
import service.UserService;
import service.UserServiceImpl;
import view_manager.ManagerFrame;
/**
 * 登录窗口
 * @author Powers
 *
 */
public class LoginFrame extends JFrame {
	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JButton btnRegist;
	private JButton btnManager;
	private JLabel bgimg;
	private JPasswordField txtPassword;
	
	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		UserService service = new UserServiceImpl();
		
		//设置图标
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u7528\u6237\u767B\u5F55");
		  
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 335);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblUsername.setBounds(53, 25, 123, 47);
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsername.setFont(new Font("宋体", Font.PLAIN, 30));
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("\u7528\u6237\u540D\u5E94\u4E3A6-18\u4F4D\u6570\u5B57\u5B57\u6BCD\u7EC4\u6210");
		txtUsername.setFont(new Font("宋体", Font.PLAIN, 20));
		txtUsername.setBounds(190, 35, 236, 37);
		contentPane.add(txtUsername);
		txtUsername.setColumns(32);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("宋体", Font.PLAIN, 20));
		txtPassword.setBounds(190, 111, 236, 37);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("\u767B\u5F55");

		
		//win10UI消息提示框
				try {
		            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
		                | UnsupportedLookAndFeelException e) {
		            e.printStackTrace();
		        }
		//登录事件
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User LoginUser = new User();
				//调用login方法,传入输入框中的用户名和密码
				LoginUser = service.Login(txtUsername.getText(),txtPassword.getText());
				if(LoginUser != null) {
					JOptionPane.showMessageDialog(null, "登录成功，欢迎您，"+LoginUser.getUserUsername());
					MenuFrame menuframe = new MenuFrame(LoginUser);
					menuframe.setVisible(true);
					menuframe.setLocationRelativeTo(null);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "登录失败，用户名或密码错误");
				}
				//清空输入框内容
				txtUsername.setText("");
				txtPassword.setText("");
				
			}
		});
		btnLogin.setBounds(79, 175, 123, 48);
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setFont(new Font("宋体", Font.BOLD, 30));
		btnLogin.setForeground(Color.BLACK);
		contentPane.add(btnLogin);
		
		lblPassword = new JLabel("\u5BC6\u7801\uFF1A");
		lblPassword.setBounds(82, 101, 90, 47);
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 30));
		contentPane.add(lblPassword);
		
		btnRegist = new JButton("\u6CE8\u518C");
		//注册
		btnRegist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistFrame registframe = new RegistFrame();
				registframe.setVisible(true);
				registframe.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		btnRegist.setBounds(270, 175, 123, 48);
		btnRegist.setBackground(Color.ORANGE);
		btnRegist.setForeground(Color.BLACK);
		btnRegist.setFont(new Font("宋体", Font.BOLD, 30));
		contentPane.add(btnRegist);
		
		btnManager = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
		//管理员登录
		btnManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User LoginUser = new User();
				//调用ManagerLogin方法,传入输入框中的用户名和密码
				LoginUser = service.ManagerLogin(txtUsername.getText(),txtPassword.getText());
				if(LoginUser != null) {
					JOptionPane.showMessageDialog(null, "登录成功,欢迎您，管理员"+LoginUser.getUserUsername());
					ManagerFrame frame = new ManagerFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "登录失败，用户名或密码错误，请使用管理员账号登录");
				}
				//清空输入框内容
				txtUsername.setText("");
				txtPassword.setText("");
			}
		});
		btnManager.setBounds(79, 236, 123, 42);
		btnManager.setBackground(Color.LIGHT_GRAY);
		btnManager.setForeground(Color.BLACK);
		btnManager.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(btnManager);
		
		
		ImageIcon img = new ImageIcon("img\\login_body.jpg");
		bgimg = new JLabel(img);
		bgimg.setBounds(0,-63, 490, 430);
		contentPane.add(bgimg);
		
		JLabel lblErrorMsg = new JLabel("");
		lblErrorMsg.setFont(new Font("宋体", Font.PLAIN, 18));
		lblErrorMsg.setForeground(Color.RED);
		lblErrorMsg.setBounds(270, 236, 188, 42);
		contentPane.add(lblErrorMsg);
		
		
	}
}
