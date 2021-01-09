package view_pay;

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
 * 查询支出信息窗口
 * @author Powers
 *
 */
public class PayQueryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPayer;
	private JTextField txtPayContent;
	private JTextField txtPayDate;
	private JTextField txtPayMoney;

	/**
	 * Create the frame.
	 */
	public PayQueryFrame() {
		WorkService service = new WorkServiceImpl();
		Pay pay = new Pay();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u67E5\u8BE2\u652F\u51FA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQueryPayer = new JButton("\u67E5\u8BE2");
		//byPayee查询按钮
		btnQueryPayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtPayer.getText().equals("")) {
					PayQueryResultFrame pqrframe = new PayQueryResultFrame("byPayee",txtPayer.getText());
					pqrframe.setVisible(true);
					pqrframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "付款人不能为空！");
				}
			}
		});
		btnQueryPayer.setBounds(319, 18, 99, 27);
		contentPane.add(btnQueryPayer);
		
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
		
		txtPayer = new JTextField();
		txtPayer.setToolTipText("\u8F93\u5165\u4ED8\u6B3E\u4EBA\u59D3\u540D");
		txtPayer.setColumns(10);
		txtPayer.setBounds(117, 19, 189, 24);
		contentPane.add(txtPayer);
		
		JLabel lblPayer = new JLabel("\u4ED8\u6B3E\u4EBA\uFF1A");
		lblPayer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayer.setBounds(15, 22, 72, 18);
		contentPane.add(lblPayer);
		
		JLabel lblPayContent = new JLabel("\u652F\u51FA\u5185\u5BB9\uFF1A");
		lblPayContent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayContent.setBounds(3, 62, 86, 18);
		contentPane.add(lblPayContent);
		
		txtPayContent = new JTextField();
		txtPayContent.setToolTipText("\u586B\u5199\u652F\u51FA\u5185\u5BB9");
		txtPayContent.setColumns(10);
		txtPayContent.setBounds(117, 62, 189, 24);
		contentPane.add(txtPayContent);
		
		JLabel lblPayDate = new JLabel("\u652F\u51FA\u65E5\u671F\uFF1A");
		lblPayDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayDate.setBounds(6, 107, 84, 18);
		contentPane.add(lblPayDate);
		
		txtPayDate = new JTextField();
		txtPayDate.setToolTipText("\u8F93\u5165\u683C\u5F0F\uFF1Axxxx-xx-xx");
		txtPayDate.setColumns(10);
		txtPayDate.setBounds(116, 103, 190, 24);
		contentPane.add(txtPayDate);
		
		JLabel lblPayMoney = new JLabel("\u652F\u51FA\u91D1\u989D\uFF1A");
		lblPayMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayMoney.setBounds(0, 149, 90, 18);
		contentPane.add(lblPayMoney);
		
		txtPayMoney = new JTextField();
		txtPayMoney.setToolTipText("\u4EC5\u6570\u5B57");
		txtPayMoney.setColumns(10);
		txtPayMoney.setBounds(115, 144, 189, 24);
		contentPane.add(txtPayMoney);
		
		JButton btnQueryContent = new JButton("\u67E5\u8BE2");
		//byContent查询按钮
		btnQueryContent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtPayContent.getText().equals("")) {
					PayQueryResultFrame pqrframe = new PayQueryResultFrame("byContent",txtPayContent.getText());
					pqrframe.setVisible(true);
					pqrframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "支出内容不能为空！");
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
				if(!txtPayDate.getText().equals("")) {
					PayQueryResultFrame pqrframe = new PayQueryResultFrame("byDate",txtPayDate.getText());
					pqrframe.setVisible(true);
					pqrframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "支出日期不能为空！");
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
				if(!txtPayMoney.getText().equals("")) {
					PayQueryResultFrame pqrframe = new PayQueryResultFrame("byMoney",txtPayMoney.getText());
					pqrframe.setVisible(true);
					pqrframe.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "支出金额不能为空！");
				}
			}
		});
		btnQueryMoney.setBounds(319, 145, 99, 27);
		contentPane.add(btnQueryMoney);
	}
}
