package entity;

import jakarta.persistence.*;
@Entity
public class Production {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="job_order_id")
	private JobOrder jobOrder;
	private int productQuantity;
	private int pendingQuantity;
	private String productionDate;
	private String remarks;
	
	public Production() {
		
	}
	public Production(JobOrder jobOrder,int productQuantity,int pendingQuantity,String productionDate,String remarks) {
		this.jobOrder = jobOrder;
		this.productQuantity=productQuantity;
		this.pendingQuantity=pendingQuantity;
		this.productionDate=productionDate;
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

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getPendingQuantity() {
		return pendingQuantity;
	}

	public void setPendingQuantity(int pendingQuantity) {
		this.pendingQuantity = pendingQuantity;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
