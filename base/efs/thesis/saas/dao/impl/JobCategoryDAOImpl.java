package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.JobCategoryDAO;
import efs.thesis.saas.model.JobCategory;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class JobCategoryDAOImpl extends AbstractDAO<JobCategory> implements JobCategoryDAO {

	@Override
	public Class<JobCategory> getDomainClass() {
		return JobCategory.class;
	}

}
