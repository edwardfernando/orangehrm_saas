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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import efs.thesis.common.annotation.AutoCrud;
import efs.thesis.common.annotation.FormElement;
import efs.thesis.common.db.model.PlainModel;
import efs.thesis.common.enumtype.FormType;

/**
 * JsEvent generated by hbm2java
 */

@AutoCrud
@Entity
@Table(name = "JS_EVENT")
public class JsEvent extends PlainModel implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.TEXT, listed = true)
	private String name;
	private Set<FieldsJsScript> fieldsJsScripts = new HashSet<FieldsJsScript>(0);

	public JsEvent() {
	}

	public JsEvent(String name, Set<FieldsJsScript> fieldsJsScripts) {
		this.name = name;
		this.fieldsJsScripts = fieldsJsScripts;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jsEvent")
	public Set<FieldsJsScript> getFieldsJsScripts() {
		return this.fieldsJsScripts;
	}

	public void setFieldsJsScripts(Set<FieldsJsScript> fieldsJsScripts) {
		this.fieldsJsScripts = fieldsJsScripts;
	}

	@Override
	public String toString() {
		return getName();
	}

}