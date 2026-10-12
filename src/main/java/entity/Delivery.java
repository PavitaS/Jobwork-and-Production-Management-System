package entity;

import jakarta.persistence.*;
@Entity
public class Delivery {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="job_order_id")
	private JobOrder jobOrder;
	private int deliveredQuantity;
	private String deliveryDate;
	private String deliverStatus;
	private String remarks;
	
	public Delivery() {
		
	}
	
	public Delivery(JobOrder jobOrder,int deliveredQuantity,String deliveryDate,String deliverStatus,String remarks) {
		this.jobOrder=jobOrder;
		this.deliveredQuantity=deliveredQuantity;
		this.deliveryDate=deliveryDate;
		this.deliverStatus=deliverStatus;
		this.remarks=remarks;
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

	public int getDeliveredQuantity() {
		return deliveredQuantity;
	}

	public void setDeliveredQuantity(int deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliverStatus() {
		return deliverStatus;
	}

	public void setDeliverStatus(String deliverStatus) {
		this.deliverStatus = deliverStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
