package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import model.Custom;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.CustomService;
import dao.BasketDao;
import dao.CustomDao;
import dao.UserDao;
import dto.CustomDTO;

@Service
public class CustomServiceImpl implements CustomService {

	@Inject
	CustomDao customDao;

	@Inject
	BasketDao basketDao;

	@Inject
	UserDao userDao;

	@Transactional
	public List<CustomDTO> getAll() {
		List<CustomDTO> dtos = new ArrayList<>();
		for (Custom Custom : customDao.getAll()) {
			dtos.add(new CustomDTO(Custom.getId(), Custom.getUser(), Custom
					.getGoods(), Custom.getTimeOfCustom(), Custom
					.getPriceOfOrder()));
		}
		return dtos;
	}

	@Transactional
	public Custom getByID(Long id) {
		Custom Custom = customDao.getByID(id);
		if (Custom != null) {
			return Custom;
		} else {
			return new Custom();
		}

	}

	@Transactional
	public Custom update(Custom Custom) {
		return customDao.update(Custom);
	}

	@Transactional
	public void delete(Custom custom) {
		customDao.delete(custom);
	}

	@Transactional
	public void add(Custom custom) {
		customDao.add(custom);
	}

}
