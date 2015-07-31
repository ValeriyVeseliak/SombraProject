package dto;

import java.util.Date;
import java.util.Set;

import model.Good;
import model.User;

public class CustomDTO {
	private Long id;
	private User user;
	private Set<Good> goods;
	private Date date;
	private Double priceOfOrder;

	public CustomDTO(Long id, User user, Set<Good> set, Date date,
			Double priceOfOrder) {
		this.id = id;
		this.user = user;
		this.goods = set;
		this.date = date;
		this.priceOfOrder = priceOfOrder;
	}

	public Double getPriceOfOrder() {
		return priceOfOrder;
	}

	public void setPriceOfOrder(Double priceOfOrder) {
		this.priceOfOrder = priceOfOrder;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Good> getGoods() {
		return goods;
	}

	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
