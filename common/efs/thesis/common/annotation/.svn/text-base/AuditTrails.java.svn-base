package efs.thesis.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import efs.thesis.common.db.model.PlainModel;
import efs.thesis.common.enumtype.AuditTrailsActionType;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface AuditTrails {
	public Class<? extends PlainModel> className();
	public AuditTrailsActionType actionType();
}
