package efs.thesis.saas.dao.impl;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.dao.JobCategoryDAO;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class JobCategoryEditor extends PropertyEditorSupport {
	
	@Autowired
	private JobCategoryDAO dao;
	
	public void setAsText(String id) throws IllegalArgumentException{
		if(CommonUtil.validateParam(id)){
			setValue(dao.findById(Integer.parseInt(id)));
		}
	}
}
