package efs.thesis.common.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.validation.Errors;

import efs.thesis.common.mvc.form.CrudForm;
import efs.thesis.common.pojo.HtmlAttribute;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class ValidatorUtil {
	
	private static ValidatorUtil instance;
	private List<Validator> validators = new ArrayList<Validator>();
	
	private ValidatorUtil(){
		validators.add(new EmailValidator());
		validators.add(new IntegerOnlyValidator());
		validators.add(new LengthValidator());
		validators.add(new MaxValidator());
		validators.add(new MinValidator());
		validators.add(new NotEmptyValidator());
		validators.add(new NotNullValidator());
		validators.add(new NumberOnlyValidator());
		validators.add(new PatternValidator());
	}
	
	public void validate(CrudForm form, Errors err) throws Exception {
		if(validators.isEmpty()){
			throw new Exception("There is no Validator registered.");
		}
		
		for(Map.Entry<String, HtmlAttribute> entry : form.getAttributes().entrySet()){
			for(Validator validator : validators){
				validator.validate(entry.getValue(), err);
			}	
		}
		
	}
	
	public static ValidatorUtil instance(){
		if(instance == null){
			instance = new ValidatorUtil();
		}
		return instance;
	}

	public List<Validator> getValidators() {
		return validators;
	}

	public void setValidators(List<Validator> validators) {
		this.validators = validators;
	}
	
	public void registerValidator(Validator validator){
		validators.add(validator);
	}
}
