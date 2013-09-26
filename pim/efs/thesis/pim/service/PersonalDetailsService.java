/**
 * 
 */
package efs.thesis.pim.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import efs.thesis.saas.dao.EmployeeDAO;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class PersonalDetailsService {

	@Autowired
	private EmployeeDAO dao;
	
	public Map<String, Object> findById(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("employee", dao.findById(id));
		return map;
	}
}
