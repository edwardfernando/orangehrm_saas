package efs.thesis.common.mvc.form;

import java.util.HashMap;
import java.util.Map;

import efs.thesis.common.db.model.Model;
import efs.thesis.common.pojo.HtmlAttribute;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class CrudForm {
	
	private Model entity;
	private Map<String, HtmlAttribute> attributes = new HashMap<String, HtmlAttribute>();

	public CrudForm() {
	}
	
	public CrudForm(Map<String, HtmlAttribute> attributes) {
		this.attributes = attributes;
	}
	
	public CrudForm(Model entity, Map<String, HtmlAttribute> attributes) {
		this.entity = entity;
		this.attributes = attributes;
	}

	public Model getEntity() {
		return entity;
	}
	public void setEntity(Model entity) {
		this.entity = entity;
	}
	
	public Map<String, HtmlAttribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, HtmlAttribute> attributes) {
		this.attributes = attributes;
	}
	
}
