package view_income;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import service.WorkService;
import service.WorkServiceImpl;
/**
 * ��ѯ������Ϣ���չʾ����
 * @author Powers
 *
 */
public class IncomeQueryResultFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IncomeQueryResultFrame(String way,String value) {
		WorkService service = new WorkServiceImpl();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		setTitle("\u67E5\u8BE2\u7ED3\u679C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		//��ѯ�������ݵ�table
		//����service��������ѯָ��������Ϣ��List����
		List list = null;
		if("byPayee".equals(way)) {
			list = service.showByPayee(value);
		}else if("byContent".equals(way)) {
			list = service.showByContent(value);
		}else if("byDate".equals(way)) {
			list = service.showByDate(value);
		}else if("byMoney".equals(way)){
			list = service.showByMoney(value);
		}
		//��ʼ�������Ϣ
		String[] titles = {"������","�տ���","��������","��������","������"};
		Object[][] userinfo = new Object [list.size()][5];
		//����List���ϣ���ȡÿһ��map��ÿһ����Ϣ
		int i = 0,j = 0;
		for(Object maps:list) {
			Map map = (Map)maps;
			Set<String> key = map.keySet();
			for (String values : key) {
	            userinfo[i][j] = map.get(values);
	            j++;
	        }
			j=0;
			i++;
		}
				
		DefaultTableModel tableModel = new DefaultTableModel(userinfo,titles); 
		JTable table = new JTable(tableModel);
		JScrollPane scr = new JScrollPane(table);
		scr.setLocation(8, 133);
		scr.setSize(766, 332);
		contentPane.add(scr);
	}

}
