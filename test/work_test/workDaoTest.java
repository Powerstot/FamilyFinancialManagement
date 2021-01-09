package work_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.WorkDao;
import dao.WorkDaoImpl;
import domain.Income;
/**
 * 业务dao测试类
 * @author Powers
 *
 */
public class workDaoTest {
	WorkDao dao = new WorkDaoImpl();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 添加收入测试
	 */
	@Test
	public void addIncomeTest() {
		Income income = null;
		try {
			income = new Income("张三","工资",sdf.parse("2000-01-01"),10000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.addIncome(income);
		System.out.println("addOK");
	}
	/**
	 * 修改收入测试
	 */
	@Test
	public void updateIncomeTest() {
		Income income = null;
		try {
			income = new Income(1,"李四","工资",sdf.parse("2000-01-02"),100);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.updateIncome(income);
		System.out.println("updateOK");
	}
	/**
	 * 删除收入测试
	 */
	@Test
	public void deleteIncomeTest() {
		Income income = new Income();
		income.setIncomeId(7);
		dao.deleteIncome(income);
		System.out.println("deleteOK");
	}
	/**
	 * 查询收入测试
	 */
	@Test
	public void findByPayeeTest() {
		List list = dao.findByPayee("张三");
		System.out.println(list);
		System.out.println("queryOK");
	}
}
