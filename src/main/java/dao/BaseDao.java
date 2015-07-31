package dao;

import java.util.List;

public interface BaseDao<E> {

	public void add(E element);

	public E update(E element);

	public E getByID(Long elementId);

	public List<E> getAll();

	public void delete(E element);
}
