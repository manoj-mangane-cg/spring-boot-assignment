package com.charter.homeworkout.vo;

public class CustomerPointVO {
	
	private Integer custId;
	private String custName;
	private Integer noOfTrx;
	private Integer trxPoint;
	private String trxMonthYear;
	private Double totalTrxAmt;
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Integer getNoOfTrx() {
		return noOfTrx;
	}
	public void setNoOfTrx(Integer noOfTrx) {
		this.noOfTrx = noOfTrx;
	}
	public Integer getTrxPoint() {
		return trxPoint;
	}
	public void setTrxPoint(Integer trxPoint) {
		this.trxPoint = trxPoint;
	}
	public String getTrxMonthYear() {
		return trxMonthYear;
	}
	public void setTrxMonthYear(String trxMonthYear) {
		this.trxMonthYear = trxMonthYear;
	}
	public Double getTotalTrxAmt() {
		return totalTrxAmt;
	}
	public void setTotalTrxAmt(Double totalTrxAmt) {
		this.totalTrxAmt = totalTrxAmt;
	}
	public CustomerPointVO(Integer custId, String custName, Integer noOfTrx, Integer trxPoint, String trxMonthYear,
			Double totalTrxAmt) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.noOfTrx = noOfTrx;
		this.trxPoint = trxPoint;
		this.trxMonthYear = trxMonthYear;
		this.totalTrxAmt = totalTrxAmt;
	}
	
	
	
}
