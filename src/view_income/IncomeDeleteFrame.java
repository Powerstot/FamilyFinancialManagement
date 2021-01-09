package view_income;

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

import domain.Income;
import service.WorkService;
import service.WorkServiceImpl;
/**
 * ɾ��������Ϣ����
 * @author Powers
 *
 */
public class IncomeDeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtIncomeId;

	/**
	 * Create the frame.
	 */
	public IncomeDeleteFrame() {
		WorkService service = new WorkServiceImpl();
		Income income = new Income();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u5220\u9664\u6536\u5165");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIncomeId = new JLabel("\u6536\u5165\u7F16\u53F7\uFF1A");
		lblIncomeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeId.setFont(new Font("����", Font.PLAIN, 25));
		lblIncomeId.setBounds(14, 80, 138, 58);
		contentPane.add(lblIncomeId);
		
		txtIncomeId = new JTextField();
		txtIncomeId.setToolTipText("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u6536\u5165\u7F16\u53F7");
		txtIncomeId.setBounds(166, 94, 233, 31);
		contentPane.add(txtIncomeId);
		txtIncomeId.setColumns(10);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//ȷ����ť
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
			             "ȷ��ɾ����", "ȷ��", JOptionPane.YES_NO_OPTION); 
				if(flag == 0) {
					if(!txtIncomeId.getText().equals("")) {
						//��װincome
						income.setIncomeId(Integer.valueOf(txtIncomeId.getText()));
						//���÷���
						service.deleteIncome(income);
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
