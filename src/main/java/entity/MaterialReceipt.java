package entity;

import jakarta.persistence.*;
@Entity
public class MaterialReceipt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="job_order_id")
	private JobOrder jobOrder;
	private int receivedQuantity;
	private String receivedDate;
	private String remarks;
	public MaterialReceipt() {
		
	}
	
	public MaterialReceipt(JobOrder jobOrder,int receivedQuantity, String receivedDate, String remarks) {
		this.jobOrder=jobOrder;
		this.receivedDate=receivedDate;
		this.receivedQuantity=receivedQuantity;
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

	public int getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(int receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
