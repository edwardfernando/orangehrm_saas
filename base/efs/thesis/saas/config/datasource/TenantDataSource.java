package efs.thesis.saas.config.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import efs.thesis.common.pojo.TenantContext;
import efs.thesis.saas.model.config.Tenants;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class TenantDataSource {
	
	private static TenantDataSource tenantDataSource;
	private TenantDataSource(){}
	
	public Map<String, TenantContext> getTenantContextMap(){
		Map<String, TenantContext> tenants = new HashMap<String, TenantContext>();
		Connection con = getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			
			StringBuffer query = new StringBuffer("SELECT t.ID, t.NAME, con.URL, con.USERNAME, con.PASSWORD, enc.ENCRYPTION_KEY, t.ALIAS FROM TENANTS t ");
			query.append("JOIN DB_CONNECTION con ");
			query.append("ON t.ID = con.TENANTS_ID ");
			query.append("JOIN ENCRYPTION_KEY enc ");
			query.append("ON t.ID = enc.TENANTS_ID ");
			
			rs = st.executeQuery(query.toString());
			
			while(rs.next()){
				TenantContext ctx = new TenantContext();
				ctx.setTenantId(rs.getInt(1));
				ctx.setTenantName(rs.getString(2));
				ctx.setUrlConnection(rs.getString(3));
				ctx.setUsername(rs.getString(4));
				ctx.setPassword(rs.getString(5));
				ctx.setEncryptionKey(rs.getString(6));
				ctx.setTenantAlias(rs.getString(7));
				
				tenants.put(rs.getString(7), ctx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				st.close();
			}catch (SQLException e){}
			
			try {
				rs.close();
			} catch (SQLException e) {}
			
			try {
				con.close();
			} catch (SQLException e) {}
		}
		return tenants;
	}
	
	public TenantContext getTenantContextById(Integer id){
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		TenantContext ctx = null;
		try {
			
			StringBuffer query = new StringBuffer("SELECT t.ID, t.NAME, con.URL, con.USERNAME, con.PASSWORD, enc.ENCRYPTION_KEY, t.ALIAS FROM TENANTS t ");
			query.append("JOIN DB_CONNECTION con ");
			query.append("ON t.ID = con.TENANTS_ID ");
			query.append("JOIN ENCRYPTION_KEY enc ");
			query.append("ON t.ID = enc.TENANTS_ID ");
			query.append("WHERE t.ID = ? ");
			
			ps = con.prepareStatement(query.toString());
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while(rs.next()){
				ctx = new TenantContext();
				ctx.setTenantId(rs.getInt(1));
				ctx.setTenantName(rs.getString(2));
				ctx.setUrlConnection(rs.getString(3));
				ctx.setUsername(rs.getString(4));
				ctx.setPassword(rs.getString(5));
				ctx.setEncryptionKey(rs.getString(6));
				ctx.setTenantAlias(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				ps.close();
			}catch (SQLException e){}
			
			try {
				rs.close();
			} catch (SQLException e) {}
			
			try {
				con.close();
			} catch (SQLException e) {}
		}
		return ctx;
	}
	
	public TenantContext getTenantContextByAlias(String alias){
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		TenantContext ctx = null;
		try {
			
			StringBuffer query = new StringBuffer("SELECT t.ID, t.NAME, con.URL, con.USERNAME, con.PASSWORD, enc.ENCRYPTION_KEY, t.ALIAS FROM TENANTS t ");
			query.append("JOIN DB_CONNECTION con ");
			query.append("ON t.ID = con.TENANTS_ID ");
			query.append("JOIN ENCRYPTION_KEY enc ");
			query.append("ON t.ID = enc.TENANTS_ID ");
			query.append("WHERE t.ALIAS = ? ");
			
			ps = con.prepareStatement(query.toString());
			ps.setString(1, alias);
			
			rs = ps.executeQuery();
			while(rs.next()){
				ctx = new TenantContext();
				ctx.setTenantId(rs.getInt(1));
				ctx.setTenantName(rs.getString(2));
				ctx.setUrlConnection(rs.getString(3));
				ctx.setUsername(rs.getString(4));
				ctx.setPassword(rs.getString(5));
				ctx.setEncryptionKey(rs.getString(6));
				ctx.setTenantAlias(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				ps.close();
			}catch (SQLException e){}
			
			try {
				rs.close();
			} catch (SQLException e) {}
			
			try {
				con.close();
			} catch (SQLException e) {}
		}
		return ctx;
	}
	
	public Tenants getTenantById(Integer id){
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Tenants tenants = null;
		try {
			ps = con.prepareStatement("SELECT * FROM TENANTS WHERE id = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while(rs.next()){
				tenants = new Tenants(
						rs.getInt("ID"), 
						rs.getString("NAME"), 
						rs.getString("ADRESS"), 
						rs.getString("PHONE"), 
						rs.getString("EMAIL"), 
						rs.getString("FAX"),
						rs.getString("ALIAS"), 
						rs.getInt("L10N_ID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				ps.close();
			}catch (SQLException e){}
			
			try {
				rs.close();
			} catch (SQLException e) {}
			
			try {
				con.close();
			} catch (SQLException e) {}
		}
		return tenants;
	}
	
	public Tenants getTenantByAlias(String alias){
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Tenants tenants = null;
		try {
			ps = con.prepareStatement("SELECT * FROM TENANTS WHERE ALIAS = ?");
			ps.setString(1, alias);
			
			rs = ps.executeQuery();
			while(rs.next()){
				tenants = new Tenants(
						rs.getInt("ID"), 
						rs.getString("NAME"), 
						rs.getString("ADRESS"), 
						rs.getString("PHONE"), 
						rs.getString("EMAIL"), 
						rs.getString("FAX"),
						rs.getString("ALIAS"), 
						rs.getInt("L10N_ID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				ps.close();
			}catch (SQLException e){}
			
			try {
				rs.close();
			} catch (SQLException e) {}
			
			try {
				con.close();
			} catch (SQLException e) {}
		}
		return tenants;
	}
	
	public Connection getConnection(){
		Connection con = null;
		Context envContext = null;
		try{
			envContext = new InitialContext();
			Context initContex = (Context) envContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)initContex.lookup("jdbc/dbConnection");
			con = ds.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(NamingException e){
			e.printStackTrace();
		}
		return con;
	}
	
	public static TenantDataSource instance(){
		if(tenantDataSource == null){
			tenantDataSource = new TenantDataSource();
		}
		return tenantDataSource;
	}
	
}
