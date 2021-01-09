package service;

import java.util.List;

import domain.Income;
import domain.Pay;

/**
 * 收入支出业务接口
 * @author Powers
 *
 */
public interface WorkService {
	public List showAllIncome();
	//收入业务
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
	 * @return list 收入的list集合
	 */
	public List showByPayee(String payee);
	/**
	 * 通过收入内容查找收入信息
	 * @param content 收入内容
	 * @return list 收入的list集合
	 */
	public List showByContent(String content);
	/**
	 * 通过收入日期查找收入信息
	 * @param date 收入日期
	 * @return list 收入的list集合
	 */
	public List showByDate(String date);
	/**
	 * 通过收入金额查找收入信息
	 * @param money 收入金额
	 * @return list 收入的list集合
	 */
	public List showByMoney(String money);
	//支出业务
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
	 * 通过付款人获取支出对象
	 * @param payer 付款人
	 * @return list 支出的list集合
	 */
	public List showByPayer(String payer);
	/**
	 * 通过支出内容获取支出对象
	 * @param content 支出内容 
	 * @return list 支出的list集合
	 */
	public List showPayByContent(String content);
	/**
	 * 通过支出日期获取支出对象
	 * @param date 支出日期
	 * @return list 支出的list集合
	 */
	public List showPayByDate(String date);
	/**
	 * 通过支出金额获取支出对象
	 * @param money 支出金额
	 * @return list 支出的list集合
	 */
	public List showPayByMoney(String money);
	/**
	 * 获取所有的支出对象
	 * @return list 支出的list集合
	 */
	public List showAllPay();
	/**
	 * 获取总收入
	 * @return int 总收入
	 */
	public int showTotalIncome();
	/**
	 * 获取总支出
	 * @return int 总支出
	 */
	public int showTotalPay();
	/**
	 * 获取总利润
	 * @return int 总利润
	 */
	public int showTotalProfit();
	/**
	 * 根据年，月获取月收入
	 * @param year 年
	 * @param month 月
	 * @return int 月收入
	 */
	public int showMonthIncome(String year, String month);
	/**
	 * 根据年，月获取月支出
	 * @param year 年
	 * @param month 月
	 * @return int 月支出
	 */
	public int showMonthPay(String year, String month);
	/**
	 * 根据日期获取日收入
	 * @param date 日期
	 * @return int 日收入
	 */
	public int showDayIncome(String date);
	/**
	 * 根据日期获取日支出
	 * @param date 日期
	 * @return int 日支出
	 */
	public int showDayPay(String date);
	
}
