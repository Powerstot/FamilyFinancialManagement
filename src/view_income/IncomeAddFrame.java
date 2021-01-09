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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 添加收入信息窗口
 * @author Powers
 *
 */
public class IncomeAddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPayee;
	private JTextField txtIncomeContent;
	private JTextField txtIncomeMoney;
	private JTextField txtIncomeDate;
	
	/**
	 * Create the frame.
	 */
	public IncomeAddFrame() {
		WorkService service = new WorkServiceImpl();
		Income income = new Income();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u6DFB\u52A0\u6536\u5165");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayee = new JLabel("\u6536\u6B3E\u4EBA\uFF1A");
		lblPayee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayee.setBounds(43, 35, 72, 18);
		contentPane.add(lblPayee);
		
		txtPayee = new JTextField();
		txtPayee.setToolTipText("\u8F93\u5165\u4ED8\u6B3E\u4EBA\u59D3\u540D");
		txtPayee.setBounds(145, 32, 206, 24);
		contentPane.add(txtPayee);
		txtPayee.setColumns(10);
		
		JLabel lblIncomeContent = new JLabel("\u6536\u5165\u5185\u5BB9\uFF1A");
		lblIncomeContent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeContent.setBounds(31, 75, 86, 18);
		contentPane.add(lblIncomeContent);
		
		JLabel lblIncomeDate = new JLabel("\u6536\u5165\u65E5\u671F\uFF1A");
		lblIncomeDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeDate.setBounds(34, 120, 84, 18);
		contentPane.add(lblIncomeDate);
		
		JLabel lblIncomeMoney = new JLabel("\u6536\u5165\u91D1\u989D\uFF1A");
		lblIncomeMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncomeMoney.setBounds(28, 162, 90, 18);
		contentPane.add(lblIncomeMoney);
		
		txtIncomeContent = new JTextField();
		txtIncomeContent.setToolTipText("\u586B\u5199\u6536\u5165\u5185\u5BB9");
		txtIncomeContent.setColumns(10);
		txtIncomeContent.setBounds(145, 75, 206, 24);
		contentPane.add(txtIncomeContent);
		
		txtIncomeMoney = new JTextField();
		txtIncomeMoney.setToolTipText("\u4EC5\u6570\u5B57");
		txtIncomeMoney.setColumns(10);
		txtIncomeMoney.setBounds(143, 157, 206, 24);
		contentPane.add(txtIncomeMoney);
		
		txtIncomeDate = new JTextField();
		txtIncomeDate.setToolTipText("\u8F93\u5165\u683C\u5F0F\uFF1Axxxx-xx-xx");
		txtIncomeDate.setColumns(10);
		txtIncomeDate.setBounds(144, 116, 206, 24);
		contentPane.add(txtIncomeDate);
		
		JButton btnTrue = new JButton("\u786E\u5B9A");
		btnTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//确定按钮
		btnTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = JOptionPane.showConfirmDialog(null,
			             "确定添加吗？", "确认", JOptionPane.YES_NO_OPTION); 
				if(flag == 0) {
					if(!txtPayee.getText().equals("") && !txtIncomeContent.getText().equals("") && !txtIncomeDate.getText().equals("") && !txtIncomeMoney.getText().equals("")) {
						//封装income
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
						service.addIncome(income);
						JOptionPane.showMessageDialog(null, "添加成功！");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "请将表格填写完整后再添加数据！");
					}
					
					
				}else {
					
				}
			}
		});
		btnTrue.setBounds(82, 207, 113, 27);
		contentPane.add(btnTrue);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		//取消按钮
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
