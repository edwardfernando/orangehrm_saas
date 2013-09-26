package efs.thesis.saas.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import efs.thesis.common.util.DateUtil;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class DateEditor extends PropertyEditorSupport {

	public void setAsText(String id) throws IllegalArgumentException{
		setValue(DateUtil.toDate(id));
	}
	
}
