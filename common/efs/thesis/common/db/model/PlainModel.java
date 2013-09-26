package efs.thesis.common.db.model;

import javax.persistence.MappedSuperclass;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@MappedSuperclass
public abstract class PlainModel extends Model {
	
	public abstract Integer getId();
	
}
