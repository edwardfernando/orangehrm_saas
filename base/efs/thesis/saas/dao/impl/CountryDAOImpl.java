package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.CountryDAO;
import efs.thesis.saas.model.Country;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class CountryDAOImpl extends AbstractDAO<Country> implements CountryDAO {

	@Override
	public Class<Country> getDomainClass() {
		return Country.class;
	}

}
