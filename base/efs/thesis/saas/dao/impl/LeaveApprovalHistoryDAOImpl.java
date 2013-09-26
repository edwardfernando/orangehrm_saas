package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.LeaveApprovalHistoryDAO;
import efs.thesis.saas.model.LeaveApprovalHistory;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class LeaveApprovalHistoryDAOImpl extends AbstractDAO<LeaveApprovalHistory> implements LeaveApprovalHistoryDAO {

	@Override
	public Class<LeaveApprovalHistory> getDomainClass() {
		return LeaveApprovalHistory.class;
	}

}
