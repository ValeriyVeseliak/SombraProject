package dao;

import model.Cathegory;

public interface CathegoryDao extends BaseDao<Cathegory> {

	public Cathegory getCathegoryByName(String cathName);

}
