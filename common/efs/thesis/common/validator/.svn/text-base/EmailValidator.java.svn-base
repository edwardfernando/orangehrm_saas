package efs.thesis.common.validator;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;

import efs.thesis.common.annotation.validator.Email;
import efs.thesis.common.pojo.HtmlAttribute;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class EmailValidator extends Validator {

	private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public void validate(HtmlAttribute att, Errors err) throws Exception {
		for(Annotation annot : att.getEntity().getDeclaredField(att.getName()).getAnnotations()){
			if(annot instanceof Email){
				validateEmail(att, err);
			}
		}
	}

	
	private void validateEmail(HtmlAttribute att, Errors err){
		boolean result = Pattern.compile(EMAIL_PATTERN).matcher(att.getValue().toString()).matches();
		if(!result){
			err.rejectValue(getFieldName(att.getName()), "", "Not a valid email.");
			return;
		}
	}
}
