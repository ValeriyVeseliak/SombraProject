package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import model.Cathegory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.CathegoryService;
import dao.CathegoryDao;
import dto.CathegoryDTO;

@Service
public class CathegoryServiceImpl implements CathegoryService {

	@Inject
	CathegoryDao cathegoryDao;

	@Transactional
	public List<CathegoryDTO> getAll() {
		List<CathegoryDTO> dtos = new ArrayList<>();
		for (Cathegory cathegory : cathegoryDao.getAll()) {
			dtos.add(new CathegoryDTO(cathegory.getId(), cathegory
					.getCathName(), cathegory.getGoods()));
		}
		return dtos;
	}

	@Transactional
	public Cathegory getByID(Long id) {
		Cathegory cathegory = cathegoryDao.getByID(id);
		if (cathegory != null) {
			return cathegory;
		} else {
			return new Cathegory();
		}

	}

	@Transactional
	public Cathegory update(Cathegory cathegory) {
		return cathegoryDao.update(cathegory);
	}

	@Transactional
	public void delete(Cathegory cathegory) {
		cathegoryDao.delete(cathegory);
	}

	@Transactional
	public Cathegory getCathegoryByName(String cathName) {
		return cathegoryDao.getCathegoryByName(cathName);
	}

	@Transactional
	public void add(Cathegory cathegory) {
		cathegoryDao.add(cathegory);
	}
}
