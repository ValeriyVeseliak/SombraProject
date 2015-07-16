package service;

import java.util.List;

import dto.CathegoryDTO;
import model.Cathegory;

public interface CathegoryService {

	public void add(Cathegory cathegory);

	public Cathegory update(Cathegory cathegory);

	public Cathegory getByID(Long id);

	public List<CathegoryDTO> getAll();

	public void delete(Cathegory cathegory);
	
	public Cathegory getCathegoryByName(String cathName);
}
