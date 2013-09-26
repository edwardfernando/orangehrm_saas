package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.DependentsTypeDAO;
import efs.thesis.saas.model.DependentsType;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class DependentsTypeDAOImpl extends AbstractDAO<DependentsType> implements DependentsTypeDAO {

	@Override
	public Class<DependentsType> getDomainClass() {
		return DependentsType.class;
	}

}
