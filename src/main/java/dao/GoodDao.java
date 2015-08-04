package dao;

import java.util.List;

import model.Cathegory;
import model.Good;

public interface GoodDao extends BaseDao<Good> {

	public List<Good> getGoodByCathegory(Cathegory cathegory);

	public Double getMaxPrice();

	public List<Good> searchGoodFromCathegory(String keyword,
			Cathegory cathegory);

	public List<Good> searchGoodFromAll(String keyword);

}
