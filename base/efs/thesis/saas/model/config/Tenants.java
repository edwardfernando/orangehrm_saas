package efs.thesis.saas.model.config;

// Generated Apr 26, 2013 7:38:28 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import efs.thesis.common.annotation.AutoCrud;
import efs.thesis.common.annotation.FormElement;
import efs.thesis.common.enumtype.FormType;

/**
 * Tenants generated by hbm2java
 */

@AutoCrud
@Entity
@Table(name = "TENANTS", catalog = "orangehrm_saas_config")
public class Tenants implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.TEXT, listed = true)
	private String name;
	private String adress;
	private String phone;
	private String email;
	private String fax;
	private String alias;
	private Integer l10nId;
	private Set<DbConnection> dbConnections = new HashSet<DbConnection>(0);
	private Set<EncryptionKey> encryptionKeies = new HashSet<EncryptionKey>(0);

	public Tenants() {
	}

	public Tenants(Integer id, String name, String adress, String phone,
			String email, String fax, String alias, Integer l10nId) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.fax = fax;
		this.alias = alias;
		this.l10nId = l10nId;
	}

	public Tenants(String name, String adress, String phone, String email,
			String fax, Integer l10nId, Set<DbConnection> dbConnections,
			Set<EncryptionKey> encryptionKeies) {
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.fax = fax;
		this.l10nId = l10nId;
		this.dbConnections = dbConnections;
		this.encryptionKeies = encryptionKeies;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ADRESS")
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "PHONE", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "EMAIL", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "FAX", length = 45)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "L10N_ID")
	public Integer getL10nId() {
		return this.l10nId;
	}

	public void setL10nId(Integer l10nId) {
		this.l10nId = l10nId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tenants")
	public Set<DbConnection> getDbConnections() {
		return this.dbConnections;
	}

	public void setDbConnections(Set<DbConnection> dbConnections) {
		this.dbConnections = dbConnections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tenants")
	public Set<EncryptionKey> getEncryptionKeies() {
		return this.encryptionKeies;
	}

	public void setEncryptionKeies(Set<EncryptionKey> encryptionKeies) {
		this.encryptionKeies = encryptionKeies;
	}

	@Column(name = "ALIAS")
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	

}