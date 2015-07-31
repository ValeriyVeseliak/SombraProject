package dto;

import java.util.Set;

import model.Good;

public class CathegoryDTO {
	private Long id;
	private String cathName;
	private Set<Good> goods;

	public CathegoryDTO(String cathName) {
		this.cathName = cathName;
	}

	public CathegoryDTO(Long id, String cathName, Set<Good> goods) {
		this.id = id;
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

}
