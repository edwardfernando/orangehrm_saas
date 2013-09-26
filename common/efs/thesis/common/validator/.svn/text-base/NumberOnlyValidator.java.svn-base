package efs.thesis.common.validator;

import java.lang.annotation.Annotation;

import org.springframework.validation.Errors;

import efs.thesis.common.annotation.validator.NumberOnly;
import efs.thesis.common.pojo.HtmlAttribute;
import efs.thesis.common.util.NumberUtil;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class NumberOnlyValidator extends Validator {

	@Override
	public void validate(HtmlAttribute att, Errors err) throws Exception {
		for(Annotation annot : att.getEntity().getDeclaredField(att.getName()).getAnnotations()){
			if(annot instanceof NumberOnly){
				numberOnly(att, err);
			}
		}
	}
	
	private void numberOnly(HtmlAttribute att, Errors err){
		if(!NumberUtil.isNumber(att.getValue().toString())){
			err.rejectValue(getFieldName(att.getName()), "", "Field " + att.getName() + " only accepts numebrs.");
			return;
		}
	}
}
