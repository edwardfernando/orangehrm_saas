package efs.thesis.common.validator;

import org.springframework.validation.Errors;

import efs.thesis.common.pojo.HtmlAttribute;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public abstract class Validator {

	public abstract void validate(HtmlAttribute att, Errors err) throws Exception;
	
	protected String getFieldName(String name){
		return new StringBuffer("attributes['").append(name).append("'].value").toString();
	}
}
