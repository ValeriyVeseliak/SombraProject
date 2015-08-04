package service;

import java.util.List;

import dto.GoodDTO;
import model.Cathegory;
import model.Good;

public interface GoodService {
	
	public void add(Good good);

	public Good update(Good good);

	public Good getByID(Long id);

	public List<GoodDTO> getAll();

	public void delete(Good good);
	
	public List<GoodDTO> getGoodByCathegory(Cathegory cathegory);
	
	public Double getMaxPrice();
	
	public List<GoodDTO> searchGoodFromCathegory(String keyword, Cathegory cathegory);
	
	public List<GoodDTO> searchGoodFromAll(String keyword);
}
