package work_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.WorkDao;
import dao.WorkDaoImpl;
import domain.Income;
/**
 * ҵ��dao������
 * @author Powers
 *
 */
public class workDaoTest {
	WorkDao dao = new WorkDaoImpl();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * ����������
	 */
	@Test
	public void addIncomeTest() {
		Income income = null;
		try {
			income = new Income("����","����",sdf.parse("2000-01-01"),10000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.addIncome(income);
		System.out.println("addOK");
	}
	/**
	 * �޸��������
	 */
	@Test
	public void updateIncomeTest() {
		Income income = null;
		try {
			income = new Income(1,"����","����",sdf.parse("2000-01-02"),100);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.updateIncome(income);
		System.out.println("updateOK");
	}
	/**
	 * ɾ���������
	 */
	@Test
	public void deleteIncomeTest() {
		Income income = new Income();
		income.setIncomeId(7);
		dao.deleteIncome(income);
		System.out.println("deleteOK");
	}
	/**
	 * ��ѯ�������
	 */
	@Test
	public void findByPayeeTest() {
		List list = dao.findByPayee("����");
		System.out.println(list);
		System.out.println("queryOK");
	}
}
