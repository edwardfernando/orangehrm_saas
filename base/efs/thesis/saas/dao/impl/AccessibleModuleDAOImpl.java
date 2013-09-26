package efs.thesis.saas.dao.impl;

import org.springframework.stereotype.Component;

import efs.thesis.common.db.dao.AbstractDAO;
import efs.thesis.saas.dao.AccessibleModuleDAO;
import efs.thesis.saas.model.AccessibleModule;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class AccessibleModuleDAOImpl extends AbstractDAO<AccessibleModule> implements AccessibleModuleDAO {

	@Override
	public Class<AccessibleModule> getDomainClass() {
		return AccessibleModule.class;
	}

	@Override
	public AccessibleModule getByUrl(String url) throws Exception {
		return (AccessibleModule)execUnique("from AccessibleModule am where am.url = ?", new Object[]{url});		
	}
}
