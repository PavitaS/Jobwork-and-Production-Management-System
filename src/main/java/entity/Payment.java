package entity;
import jakarta.persistence.*;
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="invoice_id")
	private Invoice invoice;
	private double paidAmount;
	private String paymentDate;
	private String paymentMode;
	private String paymentStatus;
	
	public Payment() {
		
	}
	public Payment(Invoice invoice,double paidAmount,String paymentDate,String paymentMode,String paymentStatus) {
		this.invoice=invoice;
		this.paidAmount=paidAmount;
		this.paymentDate=paymentDate;
		this.paymentMode=paymentMode;
		this.paymentStatus=paymentStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
}
