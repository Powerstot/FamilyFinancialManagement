package view_pay;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * 修改支出信息窗口
 * @author Powers
 *
 */
public class PayUpdateFrame extends JFrame {
	private JPanel contentPane;
	private JTextField txtPayer;
	private JTextField txtPayContent;
	private JTextField txtPayMoney;
	private JTextField txtPayDate;
	private JTextField txtPayId;

	/**
	 * Create the frame.
	 */
	public PayUpdateFrame() {
		WorkService service = new WorkServiceImpl();
		Pay pay = new Pay();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u4FEE\u6539\u652F\u51FA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayer = new JLabel("\u4ED8\u6B3E\u4EBA\uFF1A");
		lblPayer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayer.setBounds(49, 60, 72, 18);
		contentPane.add(lblPayer);
		
		txtPayer = new JTextField();
		txtPayer.setToolTipText("\u8F93\u5165\u4ED8\u6B3E\u4EBA\u59D3\u540D");
		txtPayer.setBounds(151, 57, 206, 24);
		contentPane.add(txtPayer);
		txtPayer.setColumns(10);
		
		JLabel lblPayContent = new JLabel("\u652F\u51FA\u5185\u5BB9\uFF1A");
		lblPayContent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayContent.setBounds(35, 97, 86, 18);
		contentPane.add(lblPayContent);
		
		JLabel lblPayDate = new JLabel("\u652F\u51FA\u65E5\u671F\uFF1A");
		lblPayDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayDate.setBounds(40, 139, 84, 18);
		contentPane.add(lblPayDate);
		
		JLabel lblPayMoney = new JLabel("\u652F\u51FA\u91D1\u989D\uFF1A");
		lblPayMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayMoney.setBounds(34, 181, 90, 18);
		contentPane.add(lblPayMoney);
		
		txtPayContent = new JTextField();
		txtPayContent.setToolTipText("\u586B\u5199\u652F\u51FA\u5185\u5BB9");
		txtPayContent.setColumns(10);
		txtPayContent.setBounds(151, 94, 206, 24);
		contentPane.add(txtPayContent);
		
		txtPayMoney = new JTextField();
		txtPayMoney.setToolTipText("\u4EC5\u6570\u5B57");
		txtPayMoney.setColumns(10);
		txtPayMoney.setBounds(149, 176, 206, 24);
		contentPane.add(txtPayMoney);
		
		txtPayDate = new JTextField();
		txtPayDate.setToolTipText("\u8F93\u5165\u683C\u5F0F\uFF1Axxxx-xx-xx");
		txtPayDate.setColumns(10);
		txtPayDate.setBounds(150, 135, 206, 24);
		contentPane.add(txtPayDate);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//确定按钮
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
			             "确定修改吗？", "确认", JOptionPane.YES_NO_OPTION); 
				if(flag == 0) {
					if(!txtPayId.getText().equals("") && !txtPayer.getText().equals("") && !txtPayContent.getText().equals("") && !txtPayDate.getText().equals("") && !txtPayMoney.getText().equals("")) {
						//封装income
						pay.setPayId(Integer.valueOf(txtPayId.getText()));
						pay.setPayPayer(txtPayer.getText());
						pay.setPayContent(txtPayContent.getText());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							pay.setPayDate(sdf.parse(txtPayDate.getText()));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						pay.setPayMoney(Integer.valueOf(txtPayMoney.getText()));
						//调用方法
						service.updatePay(pay);
						JOptionPane.showMessageDialog(null, "修改成功！");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "请将表格填写完整后再修改数据！");
					}
					
					
				}else {
					
				}
			}
		});
		btnTrue.setBounds(82, 213, 113, 27);
		contentPane.add(btnTrue);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		//取消按钮
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(213, 212, 113, 27);
		contentPane.add(btnCancel);
		
		JLabel lblPayId = new JLabel("\u652F\u51FA\u7F16\u53F7\uFF1A");
		lblPayId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayId.setBounds(37, 24, 84, 18);
		contentPane.add(lblPayId);
		
		txtPayId = new JTextField();
		txtPayId.setToolTipText("\u8F93\u5165\u8981\u4FEE\u6539\u7684\u652F\u51FA\u7F16\u53F7");
		txtPayId.setColumns(10);
		txtPayId.setBounds(151, 21, 206, 24);
		contentPane.add(txtPayId);
	}

}
