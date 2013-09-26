package efs.thesis.common.validator;

import java.lang.annotation.Annotation;

import org.springframework.validation.Errors;

import efs.thesis.common.annotation.validator.IntegerOnly;
import efs.thesis.common.pojo.HtmlAttribute;
import efs.thesis.common.util.NumberUtil;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class IntegerOnlyValidator extends Validator {

	@Override
	public void validate(HtmlAttribute att, Errors err) throws Exception {
		for(Annotation annot : att.getEntity().getDeclaredField(att.getName()).getAnnotations()){
			if(annot instanceof IntegerOnly){
				integerOnly(att, err);
			}
		}
	}
	
	private void integerOnly(HtmlAttribute att, Errors err){
		if(!NumberUtil.isInteger(att.getValue().toString())){
			err.rejectValue(getFieldName(att.getName()), "", "Field " + att.getName() + " only accepts integer.");
			return;
		}
	}
	
}
