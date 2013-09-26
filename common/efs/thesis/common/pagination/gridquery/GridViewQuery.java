/**
 * 
 */
package efs.thesis.common.pagination.gridquery;

import java.util.List;

import org.hibernate.Session;

import efs.thesis.common.pagination.Filterable;
import efs.thesis.common.pagination.criteria.FilterCriteria;


/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */
public interface GridViewQuery {
	public Filterable getFilterable();
	public void setFilterable(Filterable filterable);
	
	public FilterCriteria getFilterCriteria();
	public void setFilterCriteria(FilterCriteria filterCriteria);
	
	public void setSession(Session session);
	public Session getSession();
	
	public Long count();
	public List execute();
}
