package efs.thesis.common.validator;

import java.lang.annotation.Annotation;

import org.springframework.validation.Errors;

import efs.thesis.common.annotation.validator.NotNull;
import efs.thesis.common.pojo.HtmlAttribute;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class NotNullValidator extends Validator {

	@Override
	public void validate(HtmlAttribute att, Errors err) throws Exception {
		for(Annotation annot : att.getEntity().getDeclaredField(att.getName()).getAnnotations()){
			if(annot instanceof NotNull){
				notNull(att, err);
			}
		}
	}
	
	private void notNull(HtmlAttribute att, Errors err){
		if(null == att.getValue()){
			err.rejectValue(getFieldName(att.getName()), "", "Can not be null.");
			return;
		}
	}
}