package efs.thesis.tools.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import efs.thesis.common.db.model.Model;
import efs.thesis.common.factory.FilterCriteriaFactory;
import efs.thesis.common.factory.GridViewFactory;
import efs.thesis.common.mvc.form.CrudForm;
import efs.thesis.common.pagination.FilterPaging;
import efs.thesis.common.pagination.criteria.FilterCriteria;
import efs.thesis.common.pojo.HtmlAttribute;
import efs.thesis.common.transformer.EntityTransformer;
import efs.thesis.common.util.ClassUtil;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.dao.CrudDAO;
import efs.thesis.saas.gridquery.CrudGridQuery;
import efs.thesis.saas.model.AccessibleModule;
import efs.thesis.saas.model.CssClass;
import efs.thesis.saas.model.Fields;
import efs.thesis.saas.model.FieldsType;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class CrudService {

	@Autowired
	private CrudDAO dao;

	@Autowired
	private FilterCriteriaFactory filterCriteriaFactory;
	
	public Map<String, Object> load(String type) throws Exception {
		Class<? extends Model> clazz = ClassUtil.toClass(type);
		
		Map<String, HtmlAttribute> htmls = EntityTransformer.transform(clazz, dao);
		FilterCriteria criteriax = filterCriteriaFactory.create(type, htmls);

		Map<String, Object> map = new HashMap<String, Object>();
		dao.setDomainClass(clazz);
		List<Object> list = FilterPaging.filter(dao, GridViewFactory.create(criteriax, CrudGridQuery.class));
		
		map.put("criteria", criteriax);
		map.put("htmls", htmls);
		map.put("crud_list", list);
		map.put("type", type);
		map.put("popupMode", CommonUtil.getHttpRequest().getParameter("popup") != null);
		map.put("target", CommonUtil.getHttpRequest().getParameter("target"));
		
		dao.setDomainClass(CssClass.class);
		map.put("css", dao.findAll());
		
		return map;
	}
	
	public Map<String, Object> add(String type) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, HtmlAttribute> htmls = EntityTransformer.transform(ClassUtil.toClass(type), dao);
		
		map.put("modelAttribute", new CrudForm(htmls));
		map.put("type", type);
		map.put("mode", "add");
		map.put("additionalFields", EntityTransformer.getAdditionalFields(type, null, dao));
		
		return map;
	}
	
	public Map<String, Object> edit(String type, Integer id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		dao.setDomainClass(ClassUtil.toClass(type));
		
		Model model = (Model)dao.findById(id);
		Map<String, HtmlAttribute> htmls = EntityTransformer.transformAndFill(model, dao);
		
		map.put("modelAttribute", new CrudForm(model, htmls));
		map.put("type", type);
		map.put("mode", "edit");
		map.put("currentModel", model);
		
		map.put("additionalFields", EntityTransformer.getAdditionalFields(type, model, dao));
		
		return map;
	}
	
	public Map<String, Object> getAdditionalFields(String type, Integer id) throws Exception {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public void save(String type, CrudForm form) throws Exception{
		Model model = EntityTransformer.toEntity(ClassUtil.toClass(type), form, dao);
		dao.insertOrUpdate(model);
	}
	
	@SuppressWarnings("unchecked")
	public void delete(String type, Integer id) throws Exception {
		dao.setDomainClass(ClassUtil.toClass(type));
		dao.delete(dao.findById(id));
	}
	
	public void saveConfiguration(String type, CrudForm form) throws Exception{
		HttpServletRequest request = CommonUtil.getHttpRequest();
		
		for(Map.Entry<String, HtmlAttribute> att : form.getAttributes().entrySet()){
			String fieldName = att.getValue().getName();
			
			String position = request.getParameter(fieldName + "-position");
			if(CommonUtil.validateParam(position)){
				
				String[] splitted = position.trim().split(",");
				int x = Integer.valueOf(splitted[0].replace("px", ""));
				int y = Integer.valueOf(splitted[1].replace("px", ""));
				
				Fields fields = (Fields)dao.execUniqueNamedQuery("findFieldsByNameAndModule", new Object[]{fieldName, type});
				FieldsType fieldsType = (FieldsType)dao.execUniqueNamedQuery("findFieldsTypeByName", new Object[]{att.getValue().getType().toString()});
				
				if(CommonUtil.validateParam(fields)){
					fields.setCoorX(x);
					fields.setCoorY(y);
					fields.setIsAdditional(false);
					fields.setFieldsType(fieldsType);
//					fields.setIsActive(true);
//					fields.setIsVisible(true);
//					fields.setIsDeletable(true);
					dao.update(fields);
				}else{
					AccessibleModule module = (AccessibleModule)dao.execUniqueNamedQuery("findAccessibleModuleByName", new Object[]{type});
					
					Fields newFields = new Fields();
					newFields.setName(fieldName);
					newFields.setCoorX(x);
					newFields.setCoorY(y);
					newFields.setIsAdditional(false);
					newFields.setAccessibleModule(module);
					newFields.setFieldsType(fieldsType);
//					newFields.setIsActive(true);
//					newFields.setIsVisible(true);
//					newFields.setIsDeletable(true);
					dao.insert(newFields);
				}
			}
			
		}
	}
	
	
}
