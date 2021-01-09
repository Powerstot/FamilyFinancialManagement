package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.WorkDao;
import dao.WorkDaoImpl;
import domain.Income;
import domain.Pay;

/**
 * ����֧��ҵ��ӿ�ʵ����
 * @author Powers
 *
 */
public class WorkServiceImpl implements WorkService {
	WorkDao dao = new WorkDaoImpl();
	//����ҵ��ʵ��
	/**
	 * ��ȡ��������
	 */
	@Override
	public List showAllIncome() {
		return  dao.findAllIncome();
	}
	/**
	 * �������
	 */
	@Override
	public void addIncome(Income income) {
		dao.addIncome(income);
	}
	/**
	 * �޸�����
	 */
	@Override
	public void updateIncome(Income income) {
		dao.updateIncome(income);
		
	}
	/**
	 * ɾ������
	 */
	@Override
	public void deleteIncome(Income income) {
		dao.deleteIncome(income);
		
	}
	/**
	 * ͨ���տ��˻�ȡ����
	 */
	@Override
	public List showByPayee(String payee) {
		return dao.findByPayee(payee);
	}
	/**
	 * ͨ���׿����ݻ�ȡ����
	 */
	@Override
	public List showByContent(String content) {
		return dao.findByContent(content);
	}
	/**
	 * ͨ���տ����ڻ�ȡ����
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
	 * ͨ���տ����ȡ����
	 */
	@Override
	public List showByMoney(String money) {
		return dao.findByMoney(Integer.valueOf(money));
	}
	//֧��ҵ��ʵ��
	/**
	 * ���֧��
	 */
	@Override
	public void addPay(Pay pay) {
		dao.addPay(pay);
		
	}
	/**
	 * ɾ��֧��
	 */
	@Override
	public void deletePay(Pay pay) {
		dao.deletePay(pay);
		
	}
	/**
	 * �޸�֧��
	 */
	@Override
	public void updatePay(Pay pay) {
		dao.updatePay(pay);
		
	}
	/**
	 * ͨ�������˻�ȡ֧��
	 */
	@Override
	public List showByPayer(String payer) {
		return dao.findByPayer(payer);
	}
	/**
	 * ͨ��֧�����ݻ�ȡ֧��
	 */
	@Override
	public List showPayByContent(String content) {
		return dao.findPayByContent(content);
	}
	/**
	 * ͨ��֧�����ڻ�ȡ֧��
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
	 * ͨ��֧������ȡ֧��
	 */
	@Override
	public List showPayByMoney(String money) {
		return dao.findPayByMoney(Integer.valueOf(money));
	}
	/**
	 * �������֧��
	 */
	@Override
	public List showAllPay() {
		return dao.findAllPay();
	}
	/**
	 * ���������
	 */
	@Override
	public int showTotalIncome() {
		return dao.getTotalIncome();
	}
	/**
	 * �����֧��
	 */
	@Override
	public int showTotalPay() {
		return dao.getTotalPay();
	}
	/**
	 * ���������
	 */
	@Override
	public int showTotalProfit() {
		return (dao.getTotalIncome() - dao.getTotalPay());
	}
	/**
	 * ͨ���꣬�»�ȡ������
	 */
	@Override
	public int showMonthIncome(String year, String month) {
		return dao.getMonthIncome(year,month);
	}
	/**
	 * ͨ���꣬�»�ȡ��֧��
	 */
	@Override
	public int showMonthPay(String year, String month) {
		return dao.getMonthPay(year,month);
	}
	/**
	 * ͨ�����ڻ�ȡ������
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
	 * ͨ�����ڻ�ȡ��֧��
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
