package efs.thesis.saas.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.dao.CountryDAO;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class CountryEditor extends PropertyEditorSupport {

	@Autowired
	private CountryDAO countryDAO;
	
	public void setAsText(String id) throws IllegalArgumentException{
		if(CommonUtil.validateParam(id)){
			setValue(countryDAO.findById(Integer.parseInt(id)));
		}
	}
}
