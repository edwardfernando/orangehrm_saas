package efs.thesis.saas.model;

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

@AutoCrud
@Entity
@Table(name = "L10N_TYPE")
public class L10NType extends PlainModel implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.TEXT, listed = true)
	private String name;
	
	private Set<L10n> l10Ns = new HashSet<L10n>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "l10NType")
	public Set<L10n> getL10Ns() {
		return l10Ns;
	}

	public void setL10Ns(Set<L10n> l10Ns) {
		this.l10Ns = l10Ns;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
}
