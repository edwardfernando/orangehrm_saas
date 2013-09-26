package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.NationalityDAO;
import efs.thesis.saas.model.Nationality;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class NationalityDAOImpl extends AbstractDAO<Nationality> implements NationalityDAO {

	@Override
	public Class<Nationality> getDomainClass() {
		return Nationality.class;
	}

}
