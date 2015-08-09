package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "CustomGood", joinColumns = { @JoinColumn(name = "customId", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "goodId", nullable = false) })
	private Set<Good> goods;

	private Date timeOfCustom;

	private double priceOfOrder;

	public Custom() {
	}

	public Custom(User user, Set<Good> goods) {
		this.user = user;
		this.goods = goods;
	}

	public Custom(User user, Set<Good> goods, Date timeOfCustom,
			double priceOfOrder) {
		this.user = user;
		this.goods = goods;
		this.timeOfCustom = timeOfCustom;
		this.priceOfOrder = priceOfOrder;
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

	public Set<Good> getGoods() {
		return goods;
	}

	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}

	public double getPriceOfOrder() {
		return priceOfOrder;
	}

	public void setPriceOfOrder(double priceOfOrder) {
		this.priceOfOrder = priceOfOrder;
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
		if (Double.doubleToLongBits(priceOfOrder) != Double
				.doubleToLongBits(other.priceOfOrder))
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
