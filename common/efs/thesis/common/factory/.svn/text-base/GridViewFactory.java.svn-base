package efs.thesis.common.factory;

import efs.thesis.common.pagination.criteria.FilterCriteria;
import efs.thesis.common.pagination.gridquery.GridViewQuery;

/**
 * @author Edward Fernando
 * IT Plus Common Framework, 2012
 */

public class GridViewFactory {
	
	public static synchronized GridViewQuery create(FilterCriteria filter, Class<? extends GridViewQuery> clazz){
		GridViewQuery query = null;
		
		try{
			query = clazz.newInstance();
			query.setFilterCriteria(filter);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return query;
	}
	
}
