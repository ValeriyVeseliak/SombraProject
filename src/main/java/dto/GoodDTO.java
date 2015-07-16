package dto;

import model.Cathegory;

public class GoodDTO {
	private Long id;
	private String goodName;
	private Double price;
	private String description;
	private Cathegory cathegory;
	public GoodDTO(Long id, String goodName, Double price, String description,
			Cathegory cathegory) {
		this.id = id;
		this.goodName = goodName;
		this.price = price;
		this.description = description;
		this.cathegory = cathegory;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Cathegory getCathegory() {
		return cathegory;
	}
	public void setCathegory(Cathegory cathegory) {
		this.cathegory = cathegory;
	}
	
	
}
