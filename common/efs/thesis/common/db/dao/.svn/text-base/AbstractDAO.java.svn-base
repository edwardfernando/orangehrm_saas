/**
 * 
 */
package efs.thesis.common.db.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import efs.thesis.common.pagination.Filterable;
import efs.thesis.common.pagination.gridquery.GridViewQuery;
import efs.thesis.common.util.HibernateUtil;


/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */
public abstract class AbstractDAO<T> implements Filterable {

	public abstract Class<T> getDomainClass();
	
	public final Session getSession(){
		return SessionFactoryUtils.getSession(HibernateUtil.getSessionFactory(), true);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session session = getSession();
		try{
			session.beginTransaction();
			return (List<T>) session.createQuery("from " + getDomainClass().getName() + " x order by x.id asc").list();
		}catch (HibernateException e) {
			session.getTransaction().rollback();
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public T findById(Integer id) {
		Session session = getSession();
		try{
			Query query = session.createQuery("from " + getDomainClass().getSimpleName() + " domain where domain.id =:id");
			query.setLong("id", id);
			return (T) query.uniqueResult();}
		catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public void insertOrUpdate(T obj) {
		Session session = getSession();
		try{
			session.saveOrUpdate(obj);
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}
	
	public Integer insert(T obj) {
		Session session = getSession();
		try{
			return (Integer) session.save(obj);
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public void update(T obj) {
		Session session = getSession();
		try{
			session.update(obj);
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public void delete(T obj) {
		Session session = getSession();
		try{
			session.delete(obj);
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}
	
	public Object execUnique(String query){
		Session session = getSession();
		try{
			return session.createQuery(query).uniqueResult();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public Object execUnique(String query, Object[] parameters) throws Exception {
		Session session = getSession();
		try{
			Query object = session.createQuery(query);
			setParameters(object, parameters);
			return object.uniqueResult();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}
	
	public Object execList(String query){
		Session session = getSession();
		try{
			return session.createQuery(query).list();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}	
	}
	
	public Object execList(String query, Object[] parameters) throws Exception {
		Session session = getSession();
		try{
			Query object = session.createQuery(query);
			setParameters(object, parameters);
			return object.list();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public Object execUnique(Query query){
		try{
			return query.uniqueResult();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}
	
	public Object execList(Query query){
		try{
			return query.list();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}
	
	public Object execUniqueNamedQuery(String namedQuery){
		Session session = getSession();
		try{
			return session.getNamedQuery(namedQuery).uniqueResult();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}	
	}
	
	public Object execListNamedQuery(String namedQuery){
		Session session = getSession();
		try{
			return session.getNamedQuery(namedQuery).list();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}	
	}
	
	public Object execUniqueNamedQuery(String namedQuery, Object[] parameters) throws Exception{
		Session session = getSession();
		try{
			Query object = session.getNamedQuery(namedQuery);
			setParameters(object, parameters);
			return object.uniqueResult();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}	
	}
	
	public Object execListNamedQuery(String namedQuery, Object[] parameters) throws Exception{
		Session session = getSession();
		try{
			Query object = session.getNamedQuery(namedQuery);
			setParameters(object, parameters);
			return object.list();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}	
	}
	
	@SuppressWarnings("unchecked")
	public List<T> filter(GridViewQuery query) {
		query.setFilterable(this);
		query.setSession(getSession());
		return query.execute();
	}

	public Long count(GridViewQuery query) {
		query.setFilterable(this);
		query.setSession(getSession());
		return query.count();
	}
	
	private void setParameters(Query query, Object parameters[]) throws Exception {
	    if (parameters == null || parameters.length==0){
	        return;
	    }
	    
	    for (int i = 0; i < parameters.length; i++) {
	    	if (parameters[i] == null) {
	            throw new Exception("Query Parameter at position " + (i+1) + " is null");
	        }
	    	query.setParameter(i, parameters[i]);
		}
	}
}
