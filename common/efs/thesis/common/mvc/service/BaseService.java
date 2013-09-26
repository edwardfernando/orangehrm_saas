/**
 * 
 */
package efs.thesis.common.mvc.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */
public abstract class BaseService {

	public Map<String, Object> getMap(){
		return new HashMap<String, Object>();
	}
	
	public abstract Map<String, Object> load();
	
}
