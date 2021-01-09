package view_income;

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
 * 查询收入信息窗口
 * @author Powers
 *
 */
public class IncomeQueryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPayee;
	private JTextField txtIncomeContent;
	private JTextField txtIncomeDate;
	private JTextField txtIncomeMoney;

	/**
	 * Create the frame.
	 */
	public IncomeQueryFrame() {
		WorkService service = new WorkServiceImpl();
		Income income = new Income();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u67E5\u8BE2\u6536\u5165");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQueryPayee = new JButton("\u67E5\u8BE2");
		//byPayee查询按钮
		btnQueryPayee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtPayee.getText().equals("")) {
					IncomeQueryResultFrame iqrframe = new IncomeQueryResultFrame("byPayee",txtPayee.getText());
					iqrframe.setVisible(true);
					iqrframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "收款人不能为空！");
				}
			}
		});
		btnQueryPayee.setBounds(319, 18, 99, 27);
		contentPane.add(btnQueryPayee);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		//取消按钮
				btnCancel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
		btnCancel.setBounds(151, 205, 113, 27);
		contentPane.add(btnCancel);
		
		txtPayee = new JTextField();
		txtPayee.setToolTipText("\u8F93\u5165\u4ED8\u6B3E\u4EBA\u59D3\u540D");
		txtPayee.setColumns(10);
		txtPayee.setBounds(117, 19, 189, 24);
		contentPane.add(txtPayee);
		
		JLabel lblPayee = new JLabel("\u6536\u6B3E\u4EBA\uFF1A");
		lblPayee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayee.setBounds(15, 22, 72, 18);
		contentPane.add(lblPayee);
		
		JLabel lblIncomeContent = new JLabel("\u6536\u5165\u5185\u5BB9\uFF1A");
		lblIncomeContent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeContent.setBounds(3, 62, 86, 18);
		contentPane.add(lblIncomeContent);
		
		txtIncomeContent = new JTextField();
		txtIncomeContent.setToolTipText("\u586B\u5199\u6536\u5165\u5185\u5BB9");
		txtIncomeContent.setColumns(10);
		txtIncomeContent.setBounds(117, 62, 189, 24);
		contentPane.add(txtIncomeContent);
		
		JLabel lblIncomeDate = new JLabel("\u6536\u5165\u65E5\u671F\uFF1A");
		lblIncomeDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeDate.setBounds(6, 107, 84, 18);
		contentPane.add(lblIncomeDate);
		
		txtIncomeDate = new JTextField();
		txtIncomeDate.setToolTipText("\u8F93\u5165\u683C\u5F0F\uFF1Axxxx-xx-xx");
		txtIncomeDate.setColumns(10);
		txtIncomeDate.setBounds(116, 103, 190, 24);
		contentPane.add(txtIncomeDate);
		
		JLabel lblIncomeMoney = new JLabel("\u6536\u5165\u91D1\u989D\uFF1A");
		lblIncomeMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeMoney.setBounds(0, 149, 90, 18);
		contentPane.add(lblIncomeMoney);
		
		txtIncomeMoney = new JTextField();
		txtIncomeMoney.setToolTipText("\u4EC5\u6570\u5B57");
		txtIncomeMoney.setColumns(10);
		txtIncomeMoney.setBounds(115, 144, 189, 24);
		contentPane.add(txtIncomeMoney);
		
		JButton btnQueryContent = new JButton("\u67E5\u8BE2");
		//byContent查询按钮
		btnQueryContent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtIncomeContent.getText().equals("")) {
					IncomeQueryResultFrame iqrframe = new IncomeQueryResultFrame("byContent",txtIncomeContent.getText());
					iqrframe.setVisible(true);
					iqrframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "收入内容不能为空！");
				}
			}
		});
		btnQueryContent.setBounds(319, 58, 99, 27);
		contentPane.add(btnQueryContent);
		
		JButton btnQueryDate = new JButton("\u67E5\u8BE2");
		//byDate查询按钮
		btnQueryDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtIncomeDate.getText().equals("")) {
					IncomeQueryResultFrame iqrframe = new IncomeQueryResultFrame("byDate",txtIncomeDate.getText());
					iqrframe.setVisible(true);
					iqrframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "收入日期不能为空！");
				}
			}
		});
		btnQueryDate.setBounds(319, 103, 99, 27);
		contentPane.add(btnQueryDate);
		
		JButton btnQueryMoney = new JButton("\u67E5\u8BE2");
		//byMoney查询按钮
		btnQueryMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtIncomeMoney.getText().equals("")) {
					IncomeQueryResultFrame iqrframe = new IncomeQueryResultFrame("byMoney",txtIncomeMoney.getText());
					iqrframe.setVisible(true);
					iqrframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "收入金额不能为空！");
				}
			}
		});
		btnQueryMoney.setBounds(319, 145, 99, 27);
		contentPane.add(btnQueryMoney);
	}
}
