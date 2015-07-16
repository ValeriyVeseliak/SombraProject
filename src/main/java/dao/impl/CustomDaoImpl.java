package dao.impl;

import model.Custom;

import org.springframework.stereotype.Repository;

import dao.CustomDao;


@Repository
public class CustomDaoImpl extends BaseDaoImpl<Custom> implements CustomDao {

	public CustomDaoImpl() {
		super(Custom.class);
	}

}
