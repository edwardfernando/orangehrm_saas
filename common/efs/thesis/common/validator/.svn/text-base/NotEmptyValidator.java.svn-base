package efs.thesis.common.validator;

import java.lang.annotation.Annotation;

import org.springframework.validation.Errors;

import efs.thesis.common.annotation.validator.NotEmpty;
import efs.thesis.common.pojo.HtmlAttribute;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class NotEmptyValidator extends Validator {

	@Override
	public void validate(HtmlAttribute att, Errors err) throws Exception {
		for(Annotation annot : att.getEntity().getDeclaredField(att.getName()).getAnnotations()){
			if(annot instanceof NotEmpty){
				notEmpty(att, err);
			}
		}
	}
	
	private void notEmpty(HtmlAttribute att, Errors err){
		if(att.getValue().toString().isEmpty()){
			err.rejectValue(getFieldName(att.getName()), "", "Field " + att.getName() +" can not be empty.");
			return;
		}
	}
}
