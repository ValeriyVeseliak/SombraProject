package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = Good.GET_GOOD_BY_CATHEGORY, query="Select g from Good as g Where g.cathegory.cathName=:cathName"),
	@NamedQuery(name = Good.GET_GOOD_BY_PRICE,query="Select g from Good as g Where g.price=:price"),
	@NamedQuery(name = Good.GET_GOOD_BY_CATHEGORY_AND_PRICE, query = "Select g from Good as g Where g.cathegory=:cathegory And g.price<=:price"),
//	@NamedQuery(name = Good.GET_MAX_PRICE, query = "Select MAX(price) from Good as g")
})
public class Good {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String goodName;
	
	@Column(name = "price")
	private Double price;
	private String description;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cathegoryId")
	private Cathegory cathegory;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "BasketGood", joinColumns = { @JoinColumn(name = "goodId", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "basketId", nullable = false) })
	private List<Basket> basket;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "CustomGood", joinColumns = { @JoinColumn(name = "goodId", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "custoId", nullable = false) })
	private List<Custom> customs;
	
	
	public static final String GET_GOOD_BY_CATHEGORY = "Good.getGoodByCathegory";
	public static final String GET_GOOD_BY_PRICE = "Good.getGoodByPrice";
	public static final String GET_MAX_PRICE = "Good.getMaxPrice";
	public static final String GET_GOOD_BY_CATHEGORY_AND_PRICE = "Good.getFoodByCathegoryAndPrice";

	public Good() {
	}

	public Good(String goodName, Double price, String description,
			Cathegory cathegory) {
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
	

	public List<Basket> getBasket() {
		return basket;
	}

	public void setBasket(List<Basket> basket) {
		this.basket = basket;
	}

	public List<Custom> getCustoms() {
		return customs;
	}

	public void setCustoms(List<Custom> customs) {
		this.customs = customs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result
				+ ((cathegory == null) ? 0 : cathegory.hashCode());
		result = prime * result + ((customs == null) ? 0 : customs.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((goodName == null) ? 0 : goodName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Good other = (Good) obj;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		if (cathegory == null) {
			if (other.cathegory != null)
				return false;
		} else if (!cathegory.equals(other.cathegory))
			return false;
		if (customs == null) {
			if (other.customs != null)
				return false;
		} else if (!customs.equals(other.customs))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (goodName == null) {
			if (other.goodName != null)
				return false;
		} else if (!goodName.equals(other.goodName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	
	
	
	

}
