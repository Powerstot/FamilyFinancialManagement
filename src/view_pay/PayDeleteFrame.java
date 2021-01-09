package view_pay;

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

import domain.Pay;
import service.WorkService;
import service.WorkServiceImpl;
/**
 * ɾ��֧����Ϣ����
 * @author Powers
 *
 */
public class PayDeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPayId;

	/**
	 * Create the frame.
	 */
	public PayDeleteFrame() {
		WorkService service = new WorkServiceImpl();
		Pay pay = new Pay();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u5220\u9664\u652F\u51FA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayId = new JLabel("\u652F\u51FA\u7F16\u53F7\uFF1A");
		lblPayId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayId.setFont(new Font("����", Font.PLAIN, 25));
		lblPayId.setBounds(14, 80, 138, 58);
		contentPane.add(lblPayId);
		
		txtPayId = new JTextField();
		txtPayId.setToolTipText("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u652F\u51FA\u7F16\u53F7");
		txtPayId.setBounds(166, 94, 233, 31);
		contentPane.add(txtPayId);
		txtPayId.setColumns(10);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//ȷ����ť
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
			             "ȷ��ɾ����", "ȷ��", JOptionPane.YES_NO_OPTION); 
				if(flag == 0) {
					if(!txtPayId.getText().equals("")) {
						//��װincome
						pay.setPayId(Integer.valueOf(txtPayId.getText()));
						//���÷���
						service.deletePay(pay);
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
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
