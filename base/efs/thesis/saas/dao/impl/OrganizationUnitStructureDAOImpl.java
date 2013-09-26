package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.OrganizationUnitStructureDAO;
import efs.thesis.saas.model.OrganizationUnitStructure;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class OrganizationUnitStructureDAOImpl extends AbstractDAO<OrganizationUnitStructure> implements OrganizationUnitStructureDAO {

	@Override
	public Class<OrganizationUnitStructure> getDomainClass() {
		return OrganizationUnitStructure.class;
	}

}
