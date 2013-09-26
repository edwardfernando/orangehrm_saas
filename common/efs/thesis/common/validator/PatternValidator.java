package efs.thesis.common.validator;

import java.lang.annotation.Annotation;

import org.springframework.validation.Errors;

import efs.thesis.common.annotation.validator.Pattern;
import efs.thesis.common.pojo.HtmlAttribute;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class PatternValidator extends Validator {

	@Override
	public void validate(HtmlAttribute att, Errors err) throws Exception {
		for(Annotation annot : att.getEntity().getDeclaredField(att.getName()).getAnnotations()){
			if(annot instanceof Pattern){
				validatePattern(att, (Pattern) annot, err);
			}
		}
	}
	
	private void validatePattern(HtmlAttribute att, Pattern pattern, Errors err){
		boolean result = java.util.regex.Pattern.compile(pattern.pattern()).matcher(att.getValue().toString()).matches();
		if(!result){
			err.rejectValue(getFieldName(att.getName()), "", "Not matches with specified pattern (" + pattern + ")");
			return;
		}
	}
}
