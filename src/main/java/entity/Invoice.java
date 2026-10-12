package entity;

import jakarta.persistence.*;
@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="job_order_id")
	
	private JobOrder jobOrder;
	private int billedQuantity;
	private double totalAmount;
	private String invoiceDate;
	private String invoiceStatus;
	
	public Invoice() {
		
	}
	public Invoice(JobOrder jobOrder,int billedQuantity,double totalAmount,String invoiceDate,String invoiceStatus) {
		this.jobOrder=jobOrder;
		this.billedQuantity=billedQuantity;
		this.totalAmount=totalAmount;
		this.invoiceDate=invoiceDate;
		this.invoiceStatus=invoiceStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JobOrder getJobOrder() {
		return jobOrder;
	}

	public void setJobOrder(JobOrder jobOrder) {
		this.jobOrder = jobOrder;
	}

	public int getBilledQuantity() {
		return billedQuantity;
	}

	public void setBilledQuantity(int billedQuantity) {
		this.billedQuantity = billedQuantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	
}
