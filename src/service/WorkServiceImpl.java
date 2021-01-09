package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.WorkDao;
import dao.WorkDaoImpl;
import domain.Income;
import domain.Pay;

/**
 * 收入支出业务接口实现类
 * @author Powers
 *
 */
public class WorkServiceImpl implements WorkService {
	WorkDao dao = new WorkDaoImpl();
	//收入业务实现
	/**
	 * 获取所有收入
	 */
	@Override
	public List showAllIncome() {
		return  dao.findAllIncome();
	}
	/**
	 * 添加收入
	 */
	@Override
	public void addIncome(Income income) {
		dao.addIncome(income);
	}
	/**
	 * 修改收入
	 */
	@Override
	public void updateIncome(Income income) {
		dao.updateIncome(income);
		
	}
	/**
	 * 删除收入
	 */
	@Override
	public void deleteIncome(Income income) {
		dao.deleteIncome(income);
		
	}
	/**
	 * 通过收款人获取收入
	 */
	@Override
	public List showByPayee(String payee) {
		return dao.findByPayee(payee);
	}
	/**
	 * 通过首款内容获取收入
	 */
	@Override
	public List showByContent(String content) {
		return dao.findByContent(content);
	}
	/**
	 * 通过收款日期获取收入
	 */
	@Override
	public List showByDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dao.findByDate(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过收款金额获取收入
	 */
	@Override
	public List showByMoney(String money) {
		return dao.findByMoney(Integer.valueOf(money));
	}
	//支出业务实现
	/**
	 * 添加支出
	 */
	@Override
	public void addPay(Pay pay) {
		dao.addPay(pay);
		
	}
	/**
	 * 删除支出
	 */
	@Override
	public void deletePay(Pay pay) {
		dao.deletePay(pay);
		
	}
	/**
	 * 修改支出
	 */
	@Override
	public void updatePay(Pay pay) {
		dao.updatePay(pay);
		
	}
	/**
	 * 通过付款人获取支出
	 */
	@Override
	public List showByPayer(String payer) {
		return dao.findByPayer(payer);
	}
	/**
	 * 通过支出内容获取支出
	 */
	@Override
	public List showPayByContent(String content) {
		return dao.findPayByContent(content);
	}
	/**
	 * 通过支出日期获取支出
	 */
	@Override
	public List showPayByDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dao.findPayByDate(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过支出金额获取支出
	 */
	@Override
	public List showPayByMoney(String money) {
		return dao.findPayByMoney(Integer.valueOf(money));
	}
	/**
	 * 获得所有支出
	 */
	@Override
	public List showAllPay() {
		return dao.findAllPay();
	}
	/**
	 * 获得总收入
	 */
	@Override
	public int showTotalIncome() {
		return dao.getTotalIncome();
	}
	/**
	 * 获得总支出
	 */
	@Override
	public int showTotalPay() {
		return dao.getTotalPay();
	}
	/**
	 * 获得总利润
	 */
	@Override
	public int showTotalProfit() {
		return (dao.getTotalIncome() - dao.getTotalPay());
	}
	/**
	 * 通过年，月获取月收入
	 */
	@Override
	public int showMonthIncome(String year, String month) {
		return dao.getMonthIncome(year,month);
	}
	/**
	 * 通过年，月获取月支出
	 */
	@Override
	public int showMonthPay(String year, String month) {
		return dao.getMonthPay(year,month);
	}
	/**
	 * 通过日期获取日收入
	 */
	@Override
	public int showDayIncome(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dao.getDayIncome(sdf.parse(date));
		} catch (ParseException e) {
			
		}
		return 0;
	}
	/**
	 * 通过日期获取日支出
	 */
	@Override
	public int showDayPay(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dao.getDayPay(sdf.parse(date));
		} catch (ParseException e) {
			
		}
		return 0;
	}
	
}
