package efs.thesis.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import efs.thesis.common.enumtype.FormType;


/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormElement {
	FormType type();
	boolean filterable() default false;
	boolean listed() default false;
	boolean allowInput() default true;
	String alias() default "";
	
}
