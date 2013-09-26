/**
 * 
 */
package efs.thesis.common.pagination;

import java.util.List;

import efs.thesis.common.pagination.gridquery.GridViewQuery;


/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */
public interface Filterable {
	public List filter(GridViewQuery query);
	public Long count(GridViewQuery query);
}
