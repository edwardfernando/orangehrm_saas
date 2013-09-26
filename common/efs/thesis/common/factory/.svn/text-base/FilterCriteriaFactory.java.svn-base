package efs.thesis.common.factory;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import efs.thesis.common.db.model.PlainModel;
import efs.thesis.common.mvc.form.CrudForm;
import efs.thesis.common.pagination.criteria.AbstractFilterCriteria;
import efs.thesis.common.pagination.criteria.FilterCriteria;
import efs.thesis.common.pojo.HtmlAttribute;
import efs.thesis.common.transformer.EntityTransformer;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.util.DateUtil;
import efs.thesis.common.util.UrlUtil;
import efs.thesis.saas.dao.CrudDAO;
import efs.thesis.saas.filter.CrudFilterCriteria;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */


@Component
public class FilterCriteriaFactory {

	@Autowired
	private CrudDAO dao; 
	
	public FilterCriteria create(String type, Map<String, HtmlAttribute> map) throws ClassNotFoundException{
		
		FilterCriteria filterCriteria = null;
		try{
			for(Map.Entry<String, HtmlAttribute> entry : map.entrySet()){
				
				HttpServletRequest request = CommonUtil.getHttpRequest();
				String param = request.getParameter(entry.getKey());

				if(CommonUtil.validateParam(param)){
					if(EntityTransformer.isModelInstance(entry.getValue().getAttributeType())){
						dao.setDomainClass(entry.getValue().getAttributeType());
						PlainModel model = (PlainModel) dao.findById(Integer.parseInt(param.toString()));
						map.get(entry.getKey()).setValue(model);
					}else{
						map.get(entry.getKey()).setValue(EntityTransformer.toAppropriateType(entry.getValue().getAttributeType(), param));
					}
				}
				
			}
			
			filterCriteria = new CrudFilterCriteria(new CrudForm(map));
			
			HttpServletRequest request = CommonUtil.getHttpRequest();
			filterCriteria.setPage(CommonUtil.getValidPageIndex(request.getParameter("page")));
			filterCriteria.setUrl(UrlUtil.generateParamBased(request));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return filterCriteria;
	}
	
	public FilterCriteria create(Class<? extends AbstractFilterCriteria> filter){
		HttpServletRequest request = CommonUtil.getHttpRequest();
		
		AbstractFilterCriteria criteria = null;
		
		try{
			criteria = filter.newInstance();
			
			Field[] fields = filter.getDeclaredFields();
			for (Field field : fields) {
				
				String param = request.getParameter(field.getName());
				if(CommonUtil.validateParam(param)){
					field.setAccessible(true);
					
					if(field.getType().equals(String.class)){
						field.set(criteria, param);
					}else if(field.getType().equals(Long.class)){
						field.set(criteria, CommonUtil.getValidLongParam(param));
					}else if(field.getType().equals(Date.class)){
						field.set(criteria, DateUtil.toDate(param));
					}else if(field.getType().equals(Integer.class)){
						field.set(criteria, CommonUtil.getValidIntegerParam(param));
					}else if(field.getType().equals(Boolean.class)){
						field.set(criteria, Boolean.valueOf(param));
					}
					
				}
			}

			criteria.setTarget(CommonUtil.getValidTarget(request.getParameter("target")));
			criteria.setPage(CommonUtil.getValidPageIndex(request.getParameter("page")));
			criteria.setUrl(UrlUtil.generateParamBased(request));
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return criteria;
	}
	
}
