package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = Cathegory.GET_CATHEGORY_BY_NAME, query = "Select c from Cathegory as c Where c.cathName=:cathName")
})
public class Cathegory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cathName;
	
	@OneToMany(mappedBy = "cathegory")
	private Set<Good> goods = new HashSet<Good>();
	
	public static final String GET_CATHEGORY_BY_NAME = "Cathegory.getCathegoryByName";
	
	public Cathegory(){
	}

	public Cathegory(String cathName) {
		this.cathName = cathName;
	}

	public Cathegory(String cathName, Set<Good> goods) {
		this.cathName = cathName;
		this.goods = goods;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCathName() {
		return cathName;
	}

	public void setCathName(String cathName) {
		this.cathName = cathName;
	}

	public Set<Good> getGoods() {
		return goods;
	}

	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cathName == null) ? 0 : cathName.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cathegory other = (Cathegory) obj;
		if (cathName == null) {
			if (other.cathName != null)
				return false;
		} else if (!cathName.equals(other.cathName))
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
		return true;
	}
	
	
	
}
