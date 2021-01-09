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
/**
 * 导出excel窗口
 * @author Powers
 *
 */
public class ExcelFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPath;
	private JButton btnPay;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public ExcelFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u5BFC\u51FAexcel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8DEF\u5F84\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(27, 55, 111, 65);
		contentPane.add(lblNewLabel);
		
		txtPath = new JTextField();
		txtPath.setToolTipText("\u4EE5.xlsx\u7ED3\u5C3E\uFF0C\u4F8B\u5982\uFF1Ad:\\\\income.xls");
		txtPath.setFont(new Font("宋体", Font.PLAIN, 20));
		txtPath.setBounds(152, 73, 212, 30);
		contentPane.add(txtPath);
		txtPath.setColumns(10);
		
		JButton btnIncome = new JButton("\u5BFC\u51FA\u6536\u5165");
		//导出收入
		btnIncome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtPath.getText().equals("") && txtPath.getText().endsWith(".xls")) {
					ExcelExportIncome excel = new ExcelExportIncome(txtPath.getText());
					JOptionPane.showMessageDialog(null, "导出成功！");
				}else {
					JOptionPane.showMessageDialog(null, "请输入正确的路径！");
				}
			}
		});
		btnIncome.setBounds(27, 168, 113, 27);
		contentPane.add(btnIncome);
		
		btnPay = new JButton("\u5BFC\u51FA\u652F\u51FA");
		//导出支出
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtPath.getText().equals("") && txtPath.getText().endsWith(".xls")) {
					ExcelExportPay excel = new ExcelExportPay(txtPath.getText());
					JOptionPane.showMessageDialog(null, "导出成功！");
				}else {
					JOptionPane.showMessageDialog(null, "请输入正确的路径！");
				}
			}
		});
		btnPay.setBounds(154, 168, 113, 27);
		contentPane.add(btnPay);
		
		btnCancel = new JButton("\u53D6\u6D88");
		//取消
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(281, 168, 113, 27);
		contentPane.add(btnCancel);
	}

}
