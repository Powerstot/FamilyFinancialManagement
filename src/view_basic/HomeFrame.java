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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * 程序主界面
 * @author Powers
 *
 */
public class HomeFrame extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheadFrame frame = new TheadFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public HomeFrame() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u5BB6\u5EAD\u8D22\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("     \u5BB6\u5EAD\u8D22\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		lblTitle.setBackground(Color.LIGHT_GRAY);
		lblTitle.setForeground(Color.ORANGE);
		lblTitle.setFont(new Font("楷体", Font.BOLD, 35));
		lblTitle.setBounds(265, 88, 517, 87);
		contentPane.add(lblTitle);
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		//登录事件
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				loginframe.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnLogin.setFont(new Font("宋体", Font.BOLD, 25));
		btnLogin.setBounds(451, 220, 136, 42);
		contentPane.add(btnLogin);
		
		JButton btnRegist = new JButton("\u6CE8\u518C");
		//注册事件
		btnRegist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistFrame registframe = new RegistFrame();
				registframe.setVisible(true);
				registframe.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnRegist.setFont(new Font("宋体", Font.BOLD, 25));
		btnRegist.setBounds(451, 303, 136, 42);
		contentPane.add(btnRegist);
		
		JLabel bgimg;
		ImageIcon img = new ImageIcon("img\\home_body.png");
		bgimg = new JLabel(img);
		bgimg.setBounds(0, 0, 782, 493);
		contentPane.add(bgimg);
	}
}
