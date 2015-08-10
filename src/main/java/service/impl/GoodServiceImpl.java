package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import model.Cathegory;
import model.Good;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.GoodService;
import dao.CathegoryDao;
import dao.GoodDao;
import dto.GoodDTO;

@Service
public class GoodServiceImpl implements GoodService {

	@Inject
	GoodDao goodDao;

	@Inject
	CathegoryDao cathegoryDao;
	
	@Transactional
	public List<GoodDTO> getAll() {
		List<GoodDTO> dtos = new ArrayList<>();
		for (Good good : goodDao.getAll()) {
			dtos.add(new GoodDTO(good.getId(), good.getGoodName(), good
					.getPrice(), good.getDescription(), good.getIsAvailable(),
					good.getCathegory()));
		}
		return dtos;
	}

	@Transactional
	public Good getByID(Long id) {
		Good good = goodDao.getByID(id);
		if (good != null) {
			return good;
		} else {
			return new Good();
		}
	}

	@Transactional
	public Good update(Good good) {
		return goodDao.update(good);
	}

	@Transactional
	public void delete(Good good) {
		goodDao.delete(good);
	}

	@Transactional
	public void add(Good good) {
		goodDao.add(good);
	}

	@Transactional
	public List<GoodDTO> getGoodByCathegory(Cathegory cathegory) {
		List<GoodDTO> dtos = new ArrayList<GoodDTO>();
		for (Good good : goodDao.getGoodByCathegory(cathegory)) {
			dtos.add(new GoodDTO(good.getId(), good.getGoodName(), good
					.getPrice(), good.getDescription(), good.getIsAvailable(),
					good.getCathegory()));
		}
		return dtos;

	}

	@Transactional
	public Double getMaxPrice() {
		return goodDao.getMaxPrice();
	}

	@Transactional
	public List<GoodDTO> searchGoodFromCathegory(String keyword,
			Cathegory cathegory) {
		List<GoodDTO> dtos = new ArrayList<GoodDTO>();
		List<Good> goods = goodDao.searchGoodFromCathegory(keyword, cathegory);
		for (Good good : goods) {
			dtos.add(new GoodDTO(good.getId(), good.getGoodName(), good
					.getPrice(), good.getDescription(), good.getIsAvailable(),
					good.getCathegory()));
		}
		return dtos;
	}

	@Transactional
	public List<GoodDTO> searchGoodFromAll(String keyword) {
		List<GoodDTO> dtos = new ArrayList<GoodDTO>();
		List<Good> goods = goodDao.searchGoodFromAll(keyword);
		for (Good good : goods) {
			dtos.add(new GoodDTO(good.getId(), good.getGoodName(), good
					.getPrice(), good.getDescription(), good.getIsAvailable(),
					good.getCathegory()));
		}
		return dtos;
	}

	

}
