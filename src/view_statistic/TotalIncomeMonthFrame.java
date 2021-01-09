package view_statistic;

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

import service.WorkService;
import service.WorkServiceImpl;
/**
 * 统计月收入窗口
 * @author Powers
 *
 */
public class TotalIncomeMonthFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMonth;
	private JTextField txtYear;
	
	/**
	 * Create the frame.
	 */
	public TotalIncomeMonthFrame() {
		WorkService service = new WorkServiceImpl();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u6708\u6536\u5165");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonth = new JLabel("\u8F93\u5165\u6708\uFF1A");
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setFont(new Font("宋体", Font.PLAIN, 20));
		lblMonth.setBounds(14, 60, 101, 26);
		contentPane.add(lblMonth);
		
		txtMonth = new JTextField();
		txtMonth.setToolTipText("\u8F93\u5165\u683C\u5F0F\uFF1Axx");
		txtMonth.setBounds(126, 63, 175, 24);
		contentPane.add(txtMonth);
		txtMonth.setColumns(10);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//确认按钮
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtYear.getText().equals("") && !txtMonth.getText().equals("")) {
					int result = service.showMonthIncome(txtYear.getText(),txtMonth.getText());
					JOptionPane.showMessageDialog(null,txtYear.getText()+"年"+txtMonth.getText()+"月收入："+result);
				}else {
					JOptionPane.showMessageDialog(null, "年份或月份不能为空！");
				}
			}
		});
		
		btnTrue.setBounds(53, 130, 113, 27);
		contentPane.add(btnTrue);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		//取消按钮
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(180, 130, 113, 27);
		contentPane.add(btnCancel);
		
		JLabel lblYear = new JLabel("\u8F93\u5165\u5E74\uFF1A");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setFont(new Font("宋体", Font.PLAIN, 20));
		lblYear.setBounds(14, 21, 101, 26);
		contentPane.add(lblYear);
		
		txtYear = new JTextField();
		txtYear.setToolTipText("\u8F93\u5165\u683C\u5F0F\uFF1Axxxx");
		txtYear.setColumns(10);
		txtYear.setBounds(126, 24, 175, 24);
		contentPane.add(txtYear);
	}
}
