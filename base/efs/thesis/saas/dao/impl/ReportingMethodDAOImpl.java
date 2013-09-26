package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.ReportingMethodDAO;
import efs.thesis.saas.model.ReportingMethod;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class ReportingMethodDAOImpl extends AbstractDAO<ReportingMethod> implements ReportingMethodDAO {

	@Override
	public Class<ReportingMethod> getDomainClass() {
		return ReportingMethod.class;
	}

}
