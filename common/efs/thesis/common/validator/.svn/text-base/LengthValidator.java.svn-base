package efs.thesis.common.validator;

import java.lang.annotation.Annotation;

import org.springframework.validation.Errors;

import efs.thesis.common.annotation.validator.Length;
import efs.thesis.common.pojo.HtmlAttribute;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class LengthValidator extends Validator {

	@Override
	public void validate(HtmlAttribute att, Errors err) throws Exception{
		for(Annotation annot : att.getEntity().getDeclaredField(att.getName()).getAnnotations()){
			if(annot instanceof Length){
				validateLength(att, (Length) annot, err);
			}
		}
	}
	
	private void validateLength(HtmlAttribute att, Length length, Errors err){
		if(att.getValue().toString().length() < length.minLength()){
			err.rejectValue(getFieldName(att.getName()), "", "Length should be more than " + length.minLength() + ".");
			return;
		}
		
		if(att.getValue().toString().length() > length.maxLength()){
			err.rejectValue(getFieldName(att.getName()), "", "Length should be less than " + length.maxLength() + ".");
			return;
		}
	}
}
