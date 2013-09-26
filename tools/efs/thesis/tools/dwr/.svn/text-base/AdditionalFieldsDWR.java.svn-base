package efs.thesis.tools.dwr;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import efs.thesis.saas.dao.CrudDAO;
import efs.thesis.saas.model.Fields;
import efs.thesis.saas.model.FieldsValue;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@RemoteProxy(name = "additionalFieldsDWR")
public class AdditionalFieldsDWR {

	@Autowired
	private CrudDAO dao;
	
	@RemoteMethod
	public void saveAdditionalFields(String[] elements, String module, Integer id) throws Exception{
		try{
			for(String elem : elements){
				String[] split = elem.split(",");
				String name = split[0];
				String value = split[1];

				Fields fields = (Fields)dao.execUniqueNamedQuery("findFieldsByNameAndModule", new Object[]{name, module});
				FieldsValue fv = (FieldsValue)dao.execUniqueNamedQuery("findFieldValueByFieldsNameAndEntityId", new Object[]{name, id});
				
				if(fv == null){
					fv = new FieldsValue();
					fv.setFields(fields);
				}
				
				fv.setEntityId(id);
				fv.setValue(value);
				dao.insertOrUpdate(fv);
			}
			System.out.println(" >> ini ajax!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
