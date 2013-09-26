package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.EmployeeLeavesDAO;
import efs.thesis.saas.model.EmployeeLeaves;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class EmployeeLeavesDAOImpl extends AbstractDAO<EmployeeLeaves> implements EmployeeLeavesDAO {

	@Override
	public Class<EmployeeLeaves> getDomainClass() {
		return EmployeeLeaves.class;
	}

}
