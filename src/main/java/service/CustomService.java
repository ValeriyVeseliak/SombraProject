package service;

import java.util.List;

import dto.CustomDTO;
import model.Custom;

public interface CustomService {
	
	public void add(Custom Custom);

	public Custom update(Custom Custom);

	public Custom getByID(Long id);

	public List<CustomDTO> getAll();

	public void delete(Custom Custom);
}
