package efs.thesis.saas.gridquery;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import efs.thesis.common.pagination.gridquery.AbstractGridViewQuery;
import efs.thesis.common.pojo.HtmlAttribute;
import efs.thesis.common.transformer.EntityTransformer;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.dao.CrudDAO;
import efs.thesis.saas.filter.CrudFilterCriteria;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class CrudGridQuery extends AbstractGridViewQuery {

	@SuppressWarnings("rawtypes")
	@Override
	public Long count() {
		CrudDAO dao = (CrudDAO)getFilterable();
		CrudFilterCriteria criteria = (CrudFilterCriteria)getFilterCriteria();
		Class clazz = dao.getDomainClass();

		StringBuffer buffer = new StringBuffer("select count(o) ");
		buffer.append("from ").append(clazz.getSimpleName()).append(" o where o.id is not null ");
		
		for(Map.Entry<String, HtmlAttribute> entry : criteria.getCrudForm().getAttributes().entrySet()){
			if(entry.getValue().isListed() && CommonUtil.validateParamWithZeroPosibility(entry.getValue().getValue())){
				buffer.append("and o.").append(entry.getKey());
				if(EntityTransformer.isModelInstance(entry.getValue().getAttributeType())){
					buffer.append(" = :");
				}else{
					buffer.append(" like :");	
				}
				buffer.append(entry.getKey()).append(" ");
			}
		}
		
		
		Session session = getSession();
		Query query = session.createQuery(buffer.toString());
		for(Map.Entry<String, HtmlAttribute> entry : criteria.getCrudForm().getAttributes().entrySet()){
			if(entry.getValue().isListed() && CommonUtil.validateParamWithZeroPosibility(entry.getValue().getValue())){
				Object param = null;
				
				if(EntityTransformer.isModelInstance(entry.getValue().getAttributeType()) || entry.getValue().getAttributeType().isAssignableFrom(Date.class)){
					param = entry.getValue().getValue();
				}else{
					param = "%" + entry.getValue().getValue() + "%";
				}
				
				query.setParameter(entry.getKey(), param);
			}
		}
		
		Long count = Long.valueOf(0);
		Object obj = dao.execUnique(query);
		if(null != obj){
			count = (Long)obj;
		}
		return count;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List execute() {
		CrudDAO dao = (CrudDAO)getFilterable();
		CrudFilterCriteria criteria = (CrudFilterCriteria)getFilterCriteria();
		Class clazz = dao.getDomainClass();
		
		
		StringBuffer buffer = new StringBuffer("select o, o.id");
		Iterator it = criteria.getCrudForm().getAttributes().entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, HtmlAttribute> entry = (Map.Entry<String, HtmlAttribute>)it.next();
			if(entry.getValue().isListed()){
				buffer.append(", o.").append(entry.getValue().getName());
			}
		}
		buffer.append(" from ").append(clazz.getSimpleName()).append(" o where o.id is not null ");
		
		for(Map.Entry<String, HtmlAttribute> entry : criteria.getCrudForm().getAttributes().entrySet()){
			if(entry.getValue().isListed() && CommonUtil.validateParamWithZeroPosibility(entry.getValue().getValue())){
				buffer.append("and o.").append(entry.getKey());
				if(EntityTransformer.isModelInstance(entry.getValue().getAttributeType())){
					buffer.append(" = :");
				}else{
					buffer.append(" like :");	
				}
				buffer.append(entry.getKey()).append(" ");
			}
		}
		
		
		Session session = getSession();
		Query query = session.createQuery(buffer.toString());
		for(Map.Entry<String, HtmlAttribute> entry : criteria.getCrudForm().getAttributes().entrySet()){
			if(entry.getValue().isListed() && CommonUtil.validateParamWithZeroPosibility(entry.getValue().getValue())){
				Object param = null;
				
				if(EntityTransformer.isModelInstance(entry.getValue().getAttributeType()) || entry.getValue().getAttributeType().isAssignableFrom(Date.class)){
					param = entry.getValue().getValue();
				}else{
					param = "%" + entry.getValue().getValue() + "%";
				}
				
				query.setParameter(entry.getKey(), param);
			}
		}

		query.setFirstResult(criteria.start());
		query.setMaxResults(criteria.getMax());
		
		return (List)dao.execList(query);
	}

}
