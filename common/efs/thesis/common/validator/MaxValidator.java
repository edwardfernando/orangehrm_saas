package efs.thesis.common.validator;

import java.lang.annotation.Annotation;

import org.springframework.validation.Errors;

import efs.thesis.common.annotation.validator.Max;
import efs.thesis.common.pojo.HtmlAttribute;
import efs.thesis.common.util.NumberUtil;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class MaxValidator extends Validator {

	@Override
	public void validate(HtmlAttribute att, Errors err) throws Exception {
		for(Annotation annot : att.getEntity().getDeclaredField(att.getName()).getAnnotations()){
			if(annot instanceof Max){
				validateMax(att, (Max) annot, err);
			}
		}
	}
	
	private void validateMax(HtmlAttribute att, Max max, Errors err){
		if(!NumberUtil.isNumber(att.getValue().toString())){
			err.rejectValue(getFieldName(att.getName()), "", "Field " + att.getName() + " only accepts numbers.");
			return;
		}
		
		if(Double.valueOf(att.getValue().toString()) > max.max()){
			err.rejectValue(getFieldName(att.getName()), "", "Maximun number is " + max.max());
			return;
		}
		
	}
}
