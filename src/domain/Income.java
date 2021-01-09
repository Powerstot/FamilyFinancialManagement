package domain;

import java.util.Date;
/**
 * 收入实体类
 * @author Powers
 *
 */
public class Income {
	private int incomeId;//收入编号
	private String incomePayee;//收款人
	private String incomeContent;//收入内容
	private Date incomeDate;//收入日期
	private int incomeMoney;//收入金额
	public Income(int incomeId, String incomePayee, String incomeContent, Date incomeDate, int incomeMoney) {
		super();
		this.incomeId = incomeId;
		this.incomePayee = incomePayee;
		this.incomeContent = incomeContent;
		this.incomeDate = incomeDate;
		this.incomeMoney = incomeMoney;
	}
	public Income( String incomePayee, String incomeContent, Date incomeDate, int incomeMoney) {
		super();
		this.incomePayee = incomePayee;
		this.incomeContent = incomeContent;
		this.incomeDate = incomeDate;
		this.incomeMoney = incomeMoney;
	}
	public Income() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	public String getIncomePayee() {
		return incomePayee;
	}
	public void setIncomePayee(String incomePayee) {
		this.incomePayee = incomePayee;
	}
	public String getIncomeContent() {
		return incomeContent;
	}
	public void setIncomeContent(String incomeContent) {
		this.incomeContent = incomeContent;
	}
	public Date getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}
	public int getIncomeMoney() {
		return incomeMoney;
	}
	public void setIncomeMoney(int incomeMoney) {
		this.incomeMoney = incomeMoney;
	}
	@Override
	public String toString() {
		return "Income [incomeId=" + incomeId + ", incomePayee=" + incomePayee + ", incomeContent=" + incomeContent
				+ ", incomeDate=" + incomeDate + ", incomeMoney=" + incomeMoney + "]";
	}
	
	
}
