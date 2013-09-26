package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.ApprovalStatusDAO;
import efs.thesis.saas.model.ApprovalStatus;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class ApprovalStatusDAOImpl extends AbstractDAO<ApprovalStatus> implements ApprovalStatusDAO {

	@Override
	public Class<ApprovalStatus> getDomainClass() {
		return ApprovalStatus.class;
	}

}
