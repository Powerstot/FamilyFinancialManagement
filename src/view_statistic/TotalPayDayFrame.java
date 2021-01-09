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
 * 统计日支出窗口
 * @author Powers
 *
 */
public class TotalPayDayFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtDate;

	/**
	 * Create the frame.
	 */
	public TotalPayDayFrame() {
		WorkService service = new WorkServiceImpl();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u65E5\u652F\u51FA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("\u8F93\u5165\u65E5\u671F\uFF1A");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("宋体", Font.PLAIN, 20));
		lblDate.setBounds(14, 60, 101, 26);
		contentPane.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setToolTipText("\u8F93\u5165\u683C\u5F0F\uFF1Axxxx-xx-xx");
		txtDate.setBounds(126, 63, 175, 24);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//确认按钮
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtDate.getText().equals("")) {
					int result = service.showDayPay(txtDate.getText());
					JOptionPane.showMessageDialog(null,txtDate.getText()+"日收入："+result);
				}else {
					JOptionPane.showMessageDialog(null, "日期不能为空！");
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
	}
}
