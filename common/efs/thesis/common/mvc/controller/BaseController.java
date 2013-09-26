/**
 * 
 */
package efs.thesis.common.mvc.controller;

import org.springframework.ui.ModelMap;

import efs.thesis.common.db.model.Model;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */
public abstract class BaseController<T extends Model> {

	public abstract String index(ModelMap mv);
	public abstract String preadd(ModelMap mv);
	public abstract String add(ModelMap mv, T obj);
	public abstract String preedit(ModelMap mv, Integer id);
	public abstract String edit(ModelMap mv, T obj);
	public abstract String delete(ModelMap mv, Integer id);
	
}
