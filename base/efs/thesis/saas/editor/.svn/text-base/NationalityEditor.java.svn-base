package efs.thesis.saas.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.dao.NationalityDAO;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class NationalityEditor extends PropertyEditorSupport {

	@Autowired
	private NationalityDAO nationalityDAO;
	
	public void setAsText(String id) throws IllegalArgumentException{
		if(CommonUtil.validateParam(id)){
			setValue(nationalityDAO.findById(Integer.parseInt(id)));
		}
	}
	
}
