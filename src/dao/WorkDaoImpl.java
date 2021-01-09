package dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import domain.Income;
import domain.Pay;
import utils.JDBCUtils;

/**
 * 收入支出连接数据库接口实现类
 * @author Powers
 *
 */
public class WorkDaoImpl implements WorkDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	@Override
	public List findAllIncome() {
		String sql = "select * from income order by income_id asc";
		return template.queryForList(sql);
	}
	//收入相关方法实现
	@Override
	public void addIncome(Income income) {
		String sql = "insert into income values(null,?,?,?,?)";
		template.update(sql,income.getIncomePayee(),income.getIncomeContent(),income.getIncomeDate(),income.getIncomeMoney());
	}
	@Override
	public void updateIncome(Income income) {
		String sql = "update income set income_payee = ?,income_content = ?,income_date = ?,income_money = ? where income_id = ?";
		template.update(sql,income.getIncomePayee(),income.getIncomeContent(),income.getIncomeDate(),income.getIncomeMoney(),income.getIncomeId());
		
	}
	@Override
	public void deleteIncome(Income income) {
		String sql = "delete from income where income_id = ?";
		template.update(sql,income.getIncomeId());
	}
	@Override
	public List findByPayee(String payee) {
		String sql = "select * from income where income_payee = ?";
		return template.queryForList(sql,payee);
	}
	@Override
	public List findByContent(String content) {
		String sql = "select * from income where income_content = ?";
		return template.queryForList(sql,content);
	}
	@Override
	public List findByDate(Date date) {
		String sql = "select * from income where income_date = ?";
		return template.queryForList(sql,date);
	}
	@Override
	public List findByMoney(Integer money) {
		String sql = "select * from income where income_money = ?";
		return template.queryForList(sql,money);
	}
	//支出相关方法实现
	@Override
	public void addPay(Pay pay) {
		String sql = "insert into pay values(null,?,?,?,?)";
		template.update(sql,pay.getPayPayer(),pay.getPayContent(),pay.getPayDate(),pay.getPayMoney());
	}
	@Override
	public void deletePay(Pay pay) {
		String sql = "delete from pay where pay_id = ?";
		template.update(sql,pay.getPayId());
		
	}
	@Override
	public void updatePay(Pay pay) {
		String sql = "update pay set pay_payer = ?,pay_content = ?,pay_date = ?,pay_money = ? where pay_id = ?";
		template.update(sql,pay.getPayPayer(),pay.getPayContent(),pay.getPayDate(),pay.getPayMoney(),pay.getPayId());
	}
	@Override
	public List findByPayer(String payer) {
		String sql = "select * from pay where pay_payer = ?";
		return template.queryForList(sql,payer);
	}
	@Override
	public List findPayByContent(String content) {
		String sql = "select * from pay where pay_content = ?";
		return template.queryForList(sql,content);
	}
	@Override
	public List findPayByDate(Date date) {
		String sql = "select * from pay where pay_date = ?";
		return template.queryForList(sql,date);
	}
	@Override
	public List findPayByMoney(Integer money) {
		String sql = "select * from pay where pay_money = ?";
		return template.queryForList(sql,money);
	}
	@Override
	public List findAllPay() {
		String sql = "select * from pay order by pay_id asc";
		return template.queryForList(sql);
	}
	@Override
	public int getTotalIncome() {
		String sql = "select sum(income_money) from income";
		return template.queryForObject(sql, Integer.class);
	}
	@Override
	public int getTotalPay() {
		String sql = "select sum(pay_money) from pay";
		return template.queryForObject(sql, Integer.class);
	}
	@Override
	public int getMonthIncome(String year, String month) {
		String sql = "select sum(income_money) from income where year(income_date) = ? and month(income_date) = ?";
		int result = 0;
		try {
			result = template.queryForObject(sql, Integer.class, year,month);
		}catch(Exception e) {
			
		}
		return result;
	}
	@Override
	public int getMonthPay(String year, String month) {
		String sql = "select sum(pay_money) from pay where year(pay_date) = ? and month(pay_date) = ?";
		int result = 0;
		try {
			result = template.queryForObject(sql, Integer.class, year,month);
		}catch(Exception e) {
			
		}
		return result;
	}
	@Override
	public int getDayIncome(Date date) {
		String sql = "select sum(income_money) from income where income_date = ?";
		int result = 0;
		try {
			result = template.queryForObject(sql, Integer.class,date);
		}catch(Exception e) {
			
		}
		return result;
	}
	@Override
	public int getDayPay(Date date) {
		String sql = "select sum(pay_money) from pay where pay_date = ?";
		int result = 0;
		try {
			result = template.queryForObject(sql,Integer.class,date);
		}catch(Exception e) {
			
		}
		return result;
	}
	
	
}
