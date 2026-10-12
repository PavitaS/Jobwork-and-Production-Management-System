package entity;

import jakarta.persistence.*;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phone_No;
	private String email;
	private String address;
	
	public Customer() {
		
	}
	
	public Customer(String name,String phone_No,String email, String address) {
		this.name=name;
		this.phone_No= phone_No;
		this.email=email;
		this.address=address;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_No() {
		return phone_No;
	}

	public void setPhone_No(String phone_No) {
		this.phone_No = phone_No;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
