package view_manager;

import java.awt.Font;
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
 * ɾ���û�����
 * @author Powers
 *
 */
public class UserDeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserId;

	/**
	 * Create the frame.
	 */
	public UserDeleteFrame() {
		UserService service = new UserServiceImpl();
		User user = new User();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u5220\u9664\u7528\u6237");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIncomeId = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		lblIncomeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeId.setFont(new Font("����", Font.PLAIN, 25));
		lblIncomeId.setBounds(14, 80, 138, 58);
		contentPane.add(lblIncomeId);
		
		txtUserId = new JTextField();
		txtUserId.setToolTipText("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u7528\u6237\u7F16\u53F7");
		txtUserId.setBounds(166, 94, 233, 31);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//ȷ����ť
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
			             "ȷ��ɾ����", "ȷ��", JOptionPane.YES_NO_OPTION); 
				if(flag == 0) {
					if(!txtUserId.getText().equals("")) {
						//���÷���
						int flag2 = service.deleteUser(Integer.valueOf(txtUserId.getText()));
						if(flag2 == 1) {
							JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
						}else {
							JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
						}
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "�뽫�����д��������ɾ�����ݣ�");
					}
					
					
				}else {
					
				}
			}
		});
		btnTrue.setBounds(82, 207, 113, 27);
		contentPane.add(btnTrue);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		//ȡ����ť
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(213, 206, 113, 27);
		contentPane.add(btnCancel);
	}

}
