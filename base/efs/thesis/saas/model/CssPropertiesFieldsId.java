package efs.thesis.saas.model;

// Generated Mar 13, 2013 12:38:40 PM by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CssPropertiesFieldsId generated by hbm2java
 */
@Embeddable
public class CssPropertiesFieldsId implements java.io.Serializable {

	private int cssPropertiesId;
	private int fieldsId;

	public CssPropertiesFieldsId() {
	}

	public CssPropertiesFieldsId(int cssPropertiesId, int fieldsId) {
		this.cssPropertiesId = cssPropertiesId;
		this.fieldsId = fieldsId;
	}

	@Column(name = "CSS_PROPERTIES_ID")
	public int getCssPropertiesId() {
		return this.cssPropertiesId;
	}

	public void setCssPropertiesId(int cssPropertiesId) {
		this.cssPropertiesId = cssPropertiesId;
	}

	@Column(name = "FIELDS_ID")
	public int getFieldsId() {
		return this.fieldsId;
	}

	public void setFieldsId(int fieldsId) {
		this.fieldsId = fieldsId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CssPropertiesFieldsId))
			return false;
		CssPropertiesFieldsId castOther = (CssPropertiesFieldsId) other;

		return (this.getCssPropertiesId() == castOther.getCssPropertiesId())
				&& (this.getFieldsId() == castOther.getFieldsId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCssPropertiesId();
		result = 37 * result + this.getFieldsId();
		return result;
	}

}