package dao;

import java.util.Date;
import java.util.List;

import domain.Income;
import domain.Pay;

/**
 * 收入支出连接数据库接口
 * @author Powers
 *
 */
public interface WorkDao {
	public List findAllIncome();
	
	//收入相关方法
	/**
	 * 添加收入信息
	 * @param income 收入对象
	 */
	public void addIncome(Income income);
	/**
	 * 修改收入信息
	 * @param income 收入对象
	 */
	public void updateIncome(Income income);
	/**
	 * 删除收入信息
	 * @param income 收入对象
	 */
	public void deleteIncome(Income income);
	/**
	 * 通过收款人查找收入信息
	 * @param payee 收款人
	 * @return list 收入对象list集合
	 */
	public List findByPayee(String payee);
	/**
	 * 通过收入内容查找收入信息
	 * @param content 收入内容
	 * @return list 收入对象list集合
	 */
	public List findByContent(String content);
	/**
	 * 通过收入日期查找收入信息
	 * @param date 收入日期
	 * @return list 收入对象list集合
	 */
	public List findByDate(Date date);
	/**
	 * 通过收入金额查找收入信息
	 * @param money 收入金额
	 * @return list 收入对象list集合
	 */
	public List findByMoney(Integer money);
	//支出相关方法
	/**
	 * 添加支出
	 * @param pay 支出对象
	 */
	public void addPay(Pay pay);
	/**
	 * 删除支出
	 * @param pay 支出对象
	 */
	public void deletePay(Pay pay);
	/**
	 * 修改支出
	 * @param pay 支出对象
	 */
	public void updatePay(Pay pay);
	/**
	 * 通过付款人获得支出对象
	 * @param payer 付款人
	 * @return list 支出对象list集合
	 */
	public List findByPayer(String payer);
	/**
	 * 通过支出内容获取支出对象
	 * @param content 支出内容
	 * @return list 支出对象list集合
	 */
	public List findPayByContent(String content);
	/** 
	 * 通过支出日期获得支出对象
	 * @param date 支出日期
 	 * @return list 支出对象list集合
	 */
	public List findPayByDate(Date date);
	/**
	 * 通过支出金额获取支出对象
	 * @param money 支出金额
	 * @return list 支出对象list集合
	 */
	public List findPayByMoney(Integer money);
	/**
	 * 获取所有支出对象
	 * @return list 支出对象list集合
	 */
	public List findAllPay();
	/**
	 * 获取总收入
	 * @return int 总收入
	 */
	public int getTotalIncome();
	/**
	 * 获取总支出
	 * @return int 总支出
	 */
	public int getTotalPay();
	/**
	 * 通过年，月获取月收入
	 * @param year 年
	 * @param month 月
	 * @return int 月收入
	 */
	public int getMonthIncome(String year, String month);
	/**
	 * 通过年，月获取月支出
	 * @param year 年
	 * @param month 月
	 * @return int 月支出
	 */
	public int getMonthPay(String year, String month);
	/**
	 * 通过日期获得日收入
	 * @param date 日期
	 * @return int 日收入
	 */
	public int getDayIncome(Date date);
	/**
	 * 通过日期获得日支出
	 * @param date 日期
	 * @return int 日支出
	 */
	public int getDayPay(Date date);

	
}
