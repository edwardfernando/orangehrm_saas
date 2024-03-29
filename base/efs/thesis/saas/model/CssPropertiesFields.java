package efs.thesis.saas.model;

// Generated Mar 13, 2013 12:38:40 PM by Hibernate Tools 3.2.1.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import efs.thesis.common.db.model.Model;

/**
 * CssPropertiesFields generated by hbm2java
 */
@Entity
@Table(name = "CSS_PROPERTIES_FIELDS")
public class CssPropertiesFields extends Model implements java.io.Serializable {

	private CssPropertiesFieldsId id;
	private Fields fields;
	private CssProperties cssProperties;
	private String value;

	public CssPropertiesFields() {
	}

	public CssPropertiesFields(CssPropertiesFieldsId id, Fields fields,
			CssProperties cssProperties) {
		this.id = id;
		this.fields = fields;
		this.cssProperties = cssProperties;
	}

	public CssPropertiesFields(CssPropertiesFieldsId id, Fields fields,
			CssProperties cssProperties, String value) {
		this.id = id;
		this.fields = fields;
		this.cssProperties = cssProperties;
		this.value = value;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cssPropertiesId", column = @Column(name = "CSS_PROPERTIES_ID", nullable = false)),
			@AttributeOverride(name = "fieldsId", column = @Column(name = "FIELDS_ID", nullable = false)) })
	public CssPropertiesFieldsId getId() {
		return this.id;
	}

	public void setId(CssPropertiesFieldsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIELDS_ID", nullable = false, insertable = false, updatable = false)
	public Fields getFields() {
		return this.fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CSS_PROPERTIES_ID", nullable = false, insertable = false, updatable = false)
	public CssProperties getCssProperties() {
		return this.cssProperties;
	}

	public void setCssProperties(CssProperties cssProperties) {
		this.cssProperties = cssProperties;
	}

	@Column(name = "VALUE")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return getValue();
	}

}
