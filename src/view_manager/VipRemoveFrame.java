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
import javax.swing.border.EmptyBorder;

import service.UserService;
import service.UserServiceImpl;
/**
 * 移除会员功能
 * @author Powers
 *
 */
public class VipRemoveFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserId;

	/**
	 * Create the frame.
	 */
	public VipRemoveFrame() {
		UserService service = new UserServiceImpl();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u79FB\u9664\u4F1A\u5458");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		lblUserId.setBounds(42, 73, 89, 18);
		contentPane.add(lblUserId);
		
		txtUserId = new JTextField();
		txtUserId.setToolTipText("\u8BF7\u8F93\u5165\u6570\u5B57");
		txtUserId.setBounds(145, 70, 181, 24);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//确定
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtUserId.getText().equals("")) {
					int flag = service.removeVip(Integer.valueOf(txtUserId.getText()));
					if(flag == 1) {
						JOptionPane.showMessageDialog(null, "移除成功！");
					}else {
						JOptionPane.showMessageDialog(null, "移除失败！");
					}
				}else {
					JOptionPane.showMessageDialog(null, "用户编号不能为空！");
				}
			}
		});
		btnTrue.setBounds(59, 124, 113, 27);
		contentPane.add(btnTrue);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		//取消
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(186, 124, 113, 27);
		contentPane.add(btnCancel);
	}

}
