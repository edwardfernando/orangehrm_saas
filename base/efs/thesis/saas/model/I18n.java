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
 * I18n generated by hbm2java
 */

@AutoCrud
@Entity
@Table(name = "I18N")
public class I18n extends PlainModel implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.TEXT, listed = true)
	private String key;
	
	private Set<Translation> translations = new HashSet<Translation>(0);

	public I18n() {
	}

	public I18n(String key) {
		this.key = key;
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

	@Column(name = "KEY_CODE")
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "i18n")
	public Set<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(Set<Translation> translations) {
		this.translations = translations;
	}

	@Override
	public String toString() {
		return getKey();
	}

}