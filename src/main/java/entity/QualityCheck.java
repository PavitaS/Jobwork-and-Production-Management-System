package entity;

import jakarta.persistence.*;
@Entity
public class QualityCheck {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="production_id")
	private Production production;
	private int goodQuantity;
	private int reworkQuantity;
	private int scrapQuantity;
	private String checkDate;
	private String remarks;
	public QualityCheck() {
		
	}
	
	public QualityCheck(Production production,int goodQuantity,int reworkQuantity,int scrapQuantity,String checkDate,String remarks) {
		this.production=production;
		this.goodQuantity=goodQuantity;
		this.reworkQuantity=reworkQuantity;
		this.scrapQuantity=scrapQuantity;
		this.checkDate=checkDate;
		this.remarks=remarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public int getGoodQuantity() {
		return goodQuantity;
	}

	public void setGoodQuantity(int goodQuantity) {
		this.goodQuantity = goodQuantity;
	}

	public int getReworkQuantity() {
		return reworkQuantity;
	}

	public void setReworkQuantity(int reworkQuantity) {
		this.reworkQuantity = reworkQuantity;
	}

	public int getScrapQuantity() {
		return scrapQuantity;
	}

	public void setScrapQuantity(int scrapQuantity) {
		this.scrapQuantity = scrapQuantity;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
