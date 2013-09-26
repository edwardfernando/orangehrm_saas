package efs.thesis.common.pojo;

import java.io.Serializable;


/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class TenantContext implements Serializable {

	private static final long serialVersionUID = -3921316303143911600L;
	
	private Integer tenantId;
	private String tenantName;
	private String urlConnection;
	private String encryptionKey;
	private String username;
	private String password;
	private String tenantAlias;
	
	public Integer getTenantId() {
		return tenantId;
	}
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getUrlConnection() {
		return urlConnection;
	}
	public void setUrlConnection(String urlConnection) {
		this.urlConnection = urlConnection;
	}
	public String getEncryptionKey() {
		return encryptionKey;
	}
	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTenantAlias() {
		return tenantAlias;
	}
	public void setTenantAlias(String tenantAlias) {
		this.tenantAlias = tenantAlias;
	}
	
	@Override
	public String toString() {
		return "Tenant Alias : " + tenantAlias;
	}
	
}
