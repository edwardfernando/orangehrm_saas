package efs.thesis.saas.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.dao.ContactDetailsDAO;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class ContactDetailsEditor extends PropertyEditorSupport {

	private ContactDetailsDAO dao;
	
	public void setAsText(String id) throws IllegalArgumentException{
		if(CommonUtil.validateParam(id)){
			setValue(dao.findById(Integer.parseInt(id)));
		}
	}
	
}
