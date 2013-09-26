package efs.thesis.common.validator;

import java.lang.annotation.Annotation;

import org.springframework.validation.Errors;

import efs.thesis.common.annotation.validator.Min;
import efs.thesis.common.pojo.HtmlAttribute;
import efs.thesis.common.util.NumberUtil;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class MinValidator extends Validator {

	@Override
	public void validate(HtmlAttribute att, Errors err) throws Exception {
		for(Annotation annot : att.getEntity().getDeclaredField(att.getName()).getAnnotations()){
			if(annot instanceof Min){
				validateMin(att, (Min) annot, err);
			}
		}
	}
	
	private void validateMin(HtmlAttribute att, Min min, Errors err){
		if(!NumberUtil.isNumber(att.getValue().toString())){
			err.rejectValue(getFieldName(att.getName()), "", "Field " + att.getName() + " only accepts numbers.");
			return;
		}
		
		if(Double.valueOf(att.getValue().toString()) < min.min()){
			err.rejectValue(getFieldName(att.getName()), "", "Minimun number is " + min.min());
			return;
		}
	}
}
