package efs.thesis.saas.model;

// Generated Mar 13, 2013 12:38:40 PM by Hibernate Tools 3.2.1.GA

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import efs.thesis.common.annotation.AutoCrud;
import efs.thesis.common.annotation.FormElement;
import efs.thesis.common.db.model.PlainModel;
import efs.thesis.common.enumtype.FormType;

/**
 * Languages generated by hbm2java
 */

@AutoCrud
@Entity
@Table(name = "LANGUAGES")
public class Languages extends PlainModel implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private Employee employee;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private LanguageCompetency languageCompetency;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private LanguageFluency languageFluency;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private Language language;
	
	@FormElement(type = FormType.TEXTAREA, listed = true)
	private String note;

	public Languages() {
	}

	public Languages(Employee employee, LanguageCompetency languageCompetency,
			LanguageFluency languageFluency, Language language) {
		this.employee = employee;
		this.languageCompetency = languageCompetency;
		this.languageFluency = languageFluency;
		this.language = language;
	}

	public Languages(Employee employee, LanguageCompetency languageCompetency,
			LanguageFluency languageFluency, Language language, String note) {
		this.employee = employee;
		this.languageCompetency = languageCompetency;
		this.languageFluency = languageFluency;
		this.language = language;
		this.note = note;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_COMPETENCY_ID")
	public LanguageCompetency getLanguageCompetency() {
		return this.languageCompetency;
	}

	public void setLanguageCompetency(LanguageCompetency languageCompetency) {
		this.languageCompetency = languageCompetency;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_FLUENCY_ID")
	public LanguageFluency getLanguageFluency() {
		return this.languageFluency;
	}

	public void setLanguageFluency(LanguageFluency languageFluency) {
		this.languageFluency = languageFluency;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID")
	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Column(name = "NOTE", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return getId().toString();
	}

}
