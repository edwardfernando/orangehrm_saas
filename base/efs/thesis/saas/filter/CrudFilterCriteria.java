package efs.thesis.saas.filter;

import efs.thesis.common.mvc.form.CrudForm;
import efs.thesis.common.pagination.criteria.AbstractFilterCriteria;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class CrudFilterCriteria extends AbstractFilterCriteria {

	private CrudForm crudForm = new CrudForm();
//	private Map<String, String> filterList = new HashMap<String, String>();
	
	public CrudFilterCriteria() {
	}
	public CrudFilterCriteria(CrudForm form) {
		this.crudForm = form;
	}
	public CrudForm getCrudForm() {
		return crudForm;
	}
	public void setCrudForm(CrudForm crudForm) {
		this.crudForm = crudForm;
	}

//	public Map<String, String> getFilterList() {
//		return filterList;
//	}
//	public void setFilterList(Map<String, String> filterList) {
//		this.filterList = filterList;
//	}
}
