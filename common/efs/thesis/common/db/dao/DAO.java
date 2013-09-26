/**
 * 
 */
package efs.thesis.common.db.dao;

import java.util.List;

import org.hibernate.Query;


/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public interface DAO<T> {
	List<T> findAll();
	T findById(Integer id);
	Object execUnique(String query);
	Object execUnique(String query, Object[] parameters) throws Exception ;
	void insertOrUpdate(T obj);
	Integer insert(T obj);
	void update(T obj);
	void delete(T obj);
	Object execList(String query);
	Object execList(String query, Object[] parameters) throws Exception;
	Object execUnique(Query query);
	Object execList(Query query);
	Object execUniqueNamedQuery(String namedQuery);
	
	Object execListNamedQuery(String namedQuery);
	
	Object execUniqueNamedQuery(String namedQuery, Object[] parameters) throws Exception;
	
	Object execListNamedQuery(String namedQuery, Object[] parameters) throws Exception;
}