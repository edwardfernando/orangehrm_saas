package efs.thesis.common.aspect;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import efs.thesis.common.annotation.AuditTrails;
import efs.thesis.common.enumtype.AuditTrailsActionType;
import efs.thesis.common.pojo.Loggable;
import efs.thesis.saas.dao.LogHistoryDAO;
import efs.thesis.saas.model.LogHistory;


/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Aspect
@Component
@Transactional(rollbackFor=Exception.class)
public class AuditTrailsAspect{
	
	@Autowired
	private LogHistoryDAO logHistoryDAO;
	
	@AfterReturning("@annotation(auditTrails) && args(context,..)")
    public void audit(AuditTrails auditTrails, Loggable context) throws InterruptedException{
		auditTrails.actionType();
		
		LogHistory history = new LogHistory();
		history.setLogMessage(context.audit());
		
		logHistoryDAO.insert(history);
    }
	
	@AfterReturning("@annotation(auditTrails) && args(id,..)")
	public void audit(AuditTrails auditTrails, Integer id) throws InterruptedException{
		if(auditTrails.actionType() == AuditTrailsActionType.DELETE){
			LogHistory history = new LogHistory();
			history.setLogMessage("Delete " + auditTrails.className() + " with ID " + id);
			
			logHistoryDAO.insert(history);
		}
	}
}
