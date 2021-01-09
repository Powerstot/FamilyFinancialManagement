package view_income;

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

import domain.Income;
import service.WorkService;
import service.WorkServiceImpl;
/**
 * 修改收入信息窗口
 * @author Powers
 *
 */
public class IncomeUpdateFrame extends JFrame {
	private JPanel contentPane;
	private JTextField txtPayee;
	private JTextField txtIncomeContent;
	private JTextField txtIncomeMoney;
	private JTextField txtIncomeDate;
	private JTextField txtIncomeId;

	/**
	 * Create the frame.
	 */
	public IncomeUpdateFrame() {
		WorkService service = new WorkServiceImpl();
		Income income = new Income();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u4FEE\u6539\u6536\u5165");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayee = new JLabel("\u6536\u6B3E\u4EBA\uFF1A");
		lblPayee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayee.setBounds(49, 60, 72, 18);
		contentPane.add(lblPayee);
		
		txtPayee = new JTextField();
		txtPayee.setToolTipText("\u8F93\u5165\u6536\u6B3E\u4EBA\u59D3\u540D");
		txtPayee.setBounds(151, 57, 206, 24);
		contentPane.add(txtPayee);
		txtPayee.setColumns(10);
		
		JLabel lblIncomeContent = new JLabel("\u6536\u5165\u5185\u5BB9\uFF1A");
		lblIncomeContent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeContent.setBounds(35, 97, 86, 18);
		contentPane.add(lblIncomeContent);
		
		JLabel lblIncomeDate = new JLabel("\u6536\u5165\u65E5\u671F\uFF1A");
		lblIncomeDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeDate.setBounds(40, 139, 84, 18);
		contentPane.add(lblIncomeDate);
		
		JLabel lblIncomeMoney = new JLabel("\u6536\u5165\u91D1\u989D\uFF1A");
		lblIncomeMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeMoney.setBounds(34, 181, 90, 18);
		contentPane.add(lblIncomeMoney);
		
		txtIncomeContent = new JTextField();
		txtIncomeContent.setToolTipText("\u586B\u5199\u6536\u5165\u5185\u5BB9");
		txtIncomeContent.setColumns(10);
		txtIncomeContent.setBounds(151, 94, 206, 24);
		contentPane.add(txtIncomeContent);
		
		txtIncomeMoney = new JTextField();
		txtIncomeMoney.setToolTipText("\u4EC5\u6570\u5B57");
		txtIncomeMoney.setColumns(10);
		txtIncomeMoney.setBounds(149, 176, 206, 24);
		contentPane.add(txtIncomeMoney);
		
		txtIncomeDate = new JTextField();
		txtIncomeDate.setToolTipText("\u8F93\u5165\u683C\u5F0F\uFF1Axxxx-xx-xx");
		txtIncomeDate.setColumns(10);
		txtIncomeDate.setBounds(150, 135, 206, 24);
		contentPane.add(txtIncomeDate);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		//确定按钮
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
			             "确定修改吗？", "确认", JOptionPane.YES_NO_OPTION); 
				if(flag == 0) {
					if(!txtIncomeId.getText().equals("") && !txtPayee.getText().equals("") && !txtIncomeContent.getText().equals("") && !txtIncomeDate.getText().equals("") && !txtIncomeMoney.getText().equals("")) {
						//封装income
						income.setIncomeId(Integer.valueOf(txtIncomeId.getText()));
						income.setIncomePayee(txtPayee.getText());
						income.setIncomeContent(txtIncomeContent.getText());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							income.setIncomeDate(sdf.parse(txtIncomeDate.getText()));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						income.setIncomeMoney(Integer.valueOf(txtIncomeMoney.getText()));
						//调用方法
						service.updateIncome(income);
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
		
		JLabel lblIncomeId = new JLabel("\u6536\u5165\u7F16\u53F7\uFF1A");
		lblIncomeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeId.setBounds(37, 24, 84, 18);
		contentPane.add(lblIncomeId);
		
		txtIncomeId = new JTextField();
		txtIncomeId.setToolTipText("\u8F93\u5165\u8981\u4FEE\u6539\u7684\u6536\u5165\u7F16\u53F7");
		txtIncomeId.setColumns(10);
		txtIncomeId.setBounds(151, 21, 206, 24);
		contentPane.add(txtIncomeId);
	}

}
