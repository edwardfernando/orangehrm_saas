package efs.thesis.common.db.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.security.crypto.bcrypt.BCrypt;

import efs.thesis.common.pojo.TenantContext;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.config.datasource.TenantDataSource;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class TenatAwareDatabaseConnection extends BasicDataSource {
	
	private Map<String, DataSource> dataSource = new ConcurrentHashMap<String, DataSource>();
	
	public TenatAwareDatabaseConnection(){}
	
	protected String lookupKey(){
		
		String key = "";
		String ctx = TenantContextHolder.get();
		if(CommonUtil.validateParam(ctx)){
			key = ctx;
		}
		
		return key;
	}
	
	protected DataSource getTargetSource() throws SQLException{
		String key = lookupKey();
		DataSource ds = null;
		ds = dataSource.get(key);
		
		if(ds == null){
			ds = createDataSource();
			dataSource.put(lookupKey(), ds);
		}
		
		Logger.getGlobal().info("Get DataSource from : " + key);
		return ds;
	}
	
	protected DataSource createDataSource(){
		BasicDataSource bsd = new BasicDataSource();
		
		bsd.setUrl("jdbc:mysql://localhost:3306/orangehrm_saas?characterEncoding=UTF-8");
		bsd.setUsername("root");
		bsd.setPassword("");

		
		if(CommonUtil.validateParam(lookupKey())){
//			TenantContext ctx = TenantContextHolder.get();
			TenantContext ctx = TenantDataSource.instance().getTenantContextByAlias(lookupKey());
			
			bsd.setUrl(ctx.getUrlConnection());
			bsd.setUsername(ctx.getUsername());
			bsd.setPassword(ctx.getPassword());
		}
		
		bsd.setDriverClassName("com.mysql.jdbc.Driver");
		
		bsd.setInitialSize(1);
		bsd.setMaxActive(100);
		bsd.setMaxIdle(5);
		bsd.setMinIdle(1);
		bsd.setMaxWait(1000);

		bsd.setRemoveAbandoned(true);
		bsd.setRemoveAbandonedTimeout(60);
		bsd.setLogAbandoned(true);
		
		bsd.setValidationQuery("SELECT 1");
		bsd.setTestOnBorrow(true);
		bsd.setTestWhileIdle(true);
		bsd.setTimeBetweenEvictionRunsMillis(10000);
		bsd.setMinEvictableIdleTimeMillis(60000);
		
		return bsd;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return getTargetSource().getConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}
	
	public void close(){
		try {
			Connection c = getConnection();
			Logger.getGlobal().info("Closing connection : " + c.getSchema());
			c.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		String pass = "edward";
		String key = BCrypt.gensalt();
		System.out.println(key);
		
		System.out.println(BCrypt.hashpw(pass, key));
		System.out.println(BCrypt.checkpw("edward1", BCrypt.gensalt()));
		System.out.println(BCrypt.checkpw("edward", key));
	}

}
