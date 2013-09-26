package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.ContactDetailsTypeDAO;
import efs.thesis.saas.model.ContactDetailsType;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class ContactDetailsTypeDAOImpl extends AbstractDAO<ContactDetailsType> implements ContactDetailsTypeDAO {

	@Override
	public Class<ContactDetailsType> getDomainClass() {
		return ContactDetailsType.class;
	}

}
