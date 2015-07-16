package dao;

import java.util.List;

import model.Cathegory;
import model.Good;

public interface GoodDao extends BaseDao<Good>{
	
	public List<Good> getGoodByCathegory(Cathegory cathegory);
	
	public Good getGoodByPrice(Double price);
	
	public Double getMaxPrice();
	
	public List<Good> getGoodBySearch(String keyword, Cathegory cathegory);
	
	public Good getGoodByCathegoryAndPrice(Cathegory cathegory,Double price);
	
}
