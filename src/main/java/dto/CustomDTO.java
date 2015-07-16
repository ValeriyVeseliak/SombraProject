package dto;

import java.util.Date;
import java.util.List;

import model.Good;
import model.User;

public class CustomDTO {
	private Long id;
	private User user;
	private List<Good> goods;
	private Date date;
	public CustomDTO(Long id, User user, List<Good> goods, Date date) {
		this.id = id;
		this.user = user;
		this.goods = goods;
		this.date = date;
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
	public List<Good> getGoods() {
		return goods;
	}
	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
