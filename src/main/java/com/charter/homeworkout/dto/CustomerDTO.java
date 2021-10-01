package com.charter.homeworkout.dto;

/**
 * 
 * @author mmangane
 * @Description: This is DTO class
 */

public class CustomerDTO { 
	
	private Integer custId;
	private Integer noOfTrx = 1;
	private String custName;
	private String custTrxDate;
	private Double trxAmt;
	
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
	public String getCustTrxDate() {
		return custTrxDate;
	}
	public void setCustTrxDate(String custTrxDate) {
		this.custTrxDate = custTrxDate;
	}
	public Double getTrxAmt() {
		return trxAmt;
	}
	public void setTrxAmt(Double trxAmt) {
		this.trxAmt = trxAmt;
	}
	public Integer getNoOfTrx() {
		return noOfTrx;
	}
	public void setNoOfTrx(Integer noOfTrx) {
		this.noOfTrx = noOfTrx;
	}
	public CustomerDTO(Integer custId, Integer noOfTrx, String custName, String custTrxDate, Double trxAmt) {
		super();
		this.custId = custId;
		this.noOfTrx = noOfTrx;
		this.custName = custName;
		this.custTrxDate = custTrxDate;
		this.trxAmt = trxAmt;
	}
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerDTO [custId=" + custId + ", noOfTrx=" + noOfTrx + ", custName=" + custName + ", custTrxDate="
				+ custTrxDate + ", trxAmt=" + trxAmt + "]";
	}
	

}
