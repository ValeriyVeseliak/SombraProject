package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;

//Замовлення
@Entity
@NamedQueries({

})
public class Custom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST, targetEntity = User.class)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "CustomGood", joinColumns = { @JoinColumn(name = "customId", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "goodId", nullable = false) })
	private List<Good> goods;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Basket basket;

	private Date timeOfCustom;

	public Custom() {
	}

	public Custom(User user, List<Good> goods) {
		this.user = user;
		this.goods = goods;
	}

	public Custom(User user, List<Good> goods, Basket basket, Date timeOfCustom) {
		this.user = user;
		this.goods = goods;
		this.basket = basket;
		this.timeOfCustom = timeOfCustom;
	}

	public Date getTimeOfCustom() {
		return timeOfCustom;
	}

	public void setTimeOfCustom(Date timeOfCustom) {
		this.timeOfCustom = timeOfCustom;
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

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((timeOfCustom == null) ? 0 : timeOfCustom.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Custom other = (Custom) obj;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (timeOfCustom == null) {
			if (other.timeOfCustom != null)
				return false;
		} else if (!timeOfCustom.equals(other.timeOfCustom))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
}
