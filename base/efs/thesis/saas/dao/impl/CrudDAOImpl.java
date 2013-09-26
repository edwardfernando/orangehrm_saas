package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.CrudDAO;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@SuppressWarnings("rawtypes")
@Component
public class CrudDAOImpl extends AbstractDAO implements CrudDAO {

	private Class domainClass;

	public void setDomainClass(Class domainClass) {
		this.domainClass = domainClass;
	}
	
	@Override
	public Class getDomainClass() {
		return domainClass;
	}
}
