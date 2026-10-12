package entity;

import jakarta.persistence.*;
@Entity
public class JobOrder {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	private String productName;
	private int quantity;
	private double rate;
	private String status;
	
	public JobOrder() {}
	
	public JobOrder(Customer customer, String productName,int quantity, double rate, String status) {
		this.customer=customer;
		this.productName=productName;
		this.quantity=quantity;
		this.rate=rate;
		this.status=status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

