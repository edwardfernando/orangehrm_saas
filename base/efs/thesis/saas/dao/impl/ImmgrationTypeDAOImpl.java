package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.ImmigrationTypeDAO;
import efs.thesis.saas.model.ImmgirationType;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class ImmgrationTypeDAOImpl extends AbstractDAO<ImmgirationType> implements ImmigrationTypeDAO {

	@Override
	public Class<ImmgirationType> getDomainClass() {
		return ImmgirationType.class;
	}

}
