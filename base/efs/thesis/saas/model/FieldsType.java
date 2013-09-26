package efs.thesis.saas.model;

// Generated Mar 13, 2013 12:38:40 PM by Hibernate Tools 3.2.1.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import efs.thesis.common.annotation.AutoCrud;
import efs.thesis.common.annotation.FormElement;
import efs.thesis.common.db.model.PlainModel;
import efs.thesis.common.enumtype.FormType;

/**
 * FieldsType generated by hbm2java
 */

@AutoCrud
@Entity
@Table(name = "FIELDS_TYPE")
@NamedQuery(name = "findFieldsTypeByName", query = "from FieldsType ft where ft.name = ?")
public class FieldsType extends PlainModel implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.TEXT, filterable = true, listed = true)
	private String name;
	
	@FormElement(type = FormType.TEXT, filterable = true, listed = true)
	private String code;
	
	private Set<HtmlAttributesMapping> htmlAttributesMappings = new HashSet<HtmlAttributesMapping>(0);
	private Set<Fields> fieldses = new HashSet<Fields>(0);

	public FieldsType() {
	}

	public FieldsType(String name, String code,
			Set<HtmlAttributesMapping> htmlAttributesMappings,
			Set<Fields> fieldses) {
		this.name = name;
		this.code = code;
		this.htmlAttributesMappings = htmlAttributesMappings;
		this.fieldses = fieldses;
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

	@Column(name = "CODE", length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fieldsType")
	public Set<HtmlAttributesMapping> getHtmlAttributesMappings() {
		return this.htmlAttributesMappings;
	}

	public void setHtmlAttributesMappings(
			Set<HtmlAttributesMapping> htmlAttributesMappings) {
		this.htmlAttributesMappings = htmlAttributesMappings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fieldsType")
	public Set<Fields> getFieldses() {
		return this.fieldses;
	}

	public void setFieldses(Set<Fields> fieldses) {
		this.fieldses = fieldses;
	}

	@Override
	public String toString() {
		return getName();
	}

}
