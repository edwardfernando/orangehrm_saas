package efs.thesis.saas.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.dao.ApprovalStatusDAO;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class ApprovalStatusEditor extends PropertyEditorSupport {

	@Autowired
	private ApprovalStatusDAO dao;
	
	public void setAsText(String id) throws IllegalArgumentException{
		if(CommonUtil.validateParam(id)){
			setValue(dao.findById(Integer.parseInt(id)));
		}
	}
	
}
