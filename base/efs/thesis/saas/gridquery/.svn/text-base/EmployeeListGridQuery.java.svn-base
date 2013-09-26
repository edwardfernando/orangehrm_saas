package efs.thesis.saas.gridquery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import efs.thesis.common.pagination.gridquery.AbstractGridViewQuery;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.dao.EmployeeDAO;
import efs.thesis.saas.filter.EmployeeListFilterCriteria;

public class EmployeeListGridQuery extends AbstractGridViewQuery {

	@Override
	public Long count() {
		EmployeeDAO dao = (EmployeeDAO) getFilterable();
		EmployeeListFilterCriteria criteria = (EmployeeListFilterCriteria) getFilterCriteria();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(e) from Employee e ");
		
		if(!criteria.getShowAll()){
			buffer.append("inner join e.jobs j ");
		}
		
		buffer.append("where e.id is not null ");
		
		if(CommonUtil.validateParamWithZeroPosibility(criteria.getId())){
			buffer.append("and e.id = :id ");
		}
		
		if(CommonUtil.validateParam(criteria.getEmployeeName())){
			buffer.append("and e.firstName like :firstName ");
		}
		
		if(CommonUtil.validateParam(criteria.getSupervisorName())){
			buffer.append("and e.employee.firstName like :spvFirstName ");
		}
		
		if(!criteria.getShowAll() && CommonUtil.validateParamWithZeroPosibility(criteria.getJobTitle())){
			buffer.append("and j.id = :jobTitle ");
		}
		
		if(!criteria.getShowAll() && CommonUtil.validateParamWithZeroPosibility(criteria.getEmploymentStatus())){
			buffer.append("and j.employmentStatus.id = :employmentStatus ");
		}
		
		buffer.append("order by e.id ");
		
		Session session = getSession();
		Query query = session.createQuery(buffer.toString());
		
		if(CommonUtil.validateParamWithZeroPosibility(criteria.getId())){
			query.setInteger("id", criteria.getId());
		}
		
		if(CommonUtil.validateParam(criteria.getEmployeeName())){
			query.setString("firstName", "%" + criteria.getEmployeeName() + "%");
		}
		
		if(CommonUtil.validateParam(criteria.getSupervisorName())){
			query.setString("spvFirstName", "%" + criteria.getSupervisorName() + "%");
		}
		
		if(!criteria.getShowAll() && CommonUtil.validateParamWithZeroPosibility(criteria.getJobTitle())){
			query.setInteger("jobTitle", Integer.parseInt(criteria.getJobTitle()));
		}
		
		if(!criteria.getShowAll() && CommonUtil.validateParamWithZeroPosibility(criteria.getEmploymentStatus())){
			query.setInteger("employmentStatus", Integer.parseInt(criteria.getEmploymentStatus()));
		}
		
		Long count = Long.valueOf(0);
		Object obj = dao.execUnique(query);
		if(null != obj){
			count = (Long)obj;
		}
		return count;
	}

	@Override
	public List execute() {
		EmployeeDAO dao = (EmployeeDAO) getFilterable();
		EmployeeListFilterCriteria criteria = (EmployeeListFilterCriteria) getFilterCriteria();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select e from Employee e ");
		
		if(!criteria.getShowAll()){
			buffer.append("inner join e.jobs j ");
		}
		
		buffer.append("where e.id is not null ");
		
		if(CommonUtil.validateParamWithZeroPosibility(criteria.getId())){
			buffer.append("and e.id = :id ");
		}
		
		if(CommonUtil.validateParam(criteria.getEmployeeName())){
			buffer.append("and e.firstName like :firstName ");
		}
		
		if(CommonUtil.validateParam(criteria.getSupervisorName())){
			buffer.append("and e.employee.firstName like :spvFirstName ");
		}
		
		if(!criteria.getShowAll() && CommonUtil.validateParamWithZeroPosibility(criteria.getJobTitle())){
			buffer.append("and j.id = :jobTitle ");
		}
		
		if(!criteria.getShowAll() && CommonUtil.validateParamWithZeroPosibility(criteria.getEmploymentStatus())){
			buffer.append("and j.employmentStatus.id = :employmentStatus ");
		}
		
		buffer.append("order by e.id ");
		
		Session session = getSession();
		Query query = session.createQuery(buffer.toString());
		
		if(CommonUtil.validateParamWithZeroPosibility(criteria.getId())){
			query.setInteger("id", criteria.getId());
		}
		
		if(CommonUtil.validateParam(criteria.getEmployeeName())){
			query.setString("firstName", "%" + criteria.getEmployeeName() + "%");
		}
		
		if(CommonUtil.validateParam(criteria.getSupervisorName())){
			query.setString("spvFirstName", "%" + criteria.getSupervisorName() + "%");
		}
		
		if(!criteria.getShowAll() && CommonUtil.validateParamWithZeroPosibility(criteria.getJobTitle())){
			query.setInteger("jobTitle", Integer.parseInt(criteria.getJobTitle()));
		}
		
		if(!criteria.getShowAll() && CommonUtil.validateParamWithZeroPosibility(criteria.getEmploymentStatus())){
			query.setInteger("employmentStatus", Integer.parseInt(criteria.getEmploymentStatus()));
		}
		
		query.setFirstResult(criteria.start());
		query.setMaxResults(criteria.getMax());
		
		return (List) dao.execList(query);
	}

}
