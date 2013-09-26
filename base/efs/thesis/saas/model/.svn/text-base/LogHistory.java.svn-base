package efs.thesis.saas.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import efs.thesis.common.db.model.PlainModel;

@Entity
@Table(name = "LOG_HISTORY")
public class LogHistory extends PlainModel implements Serializable {
	
	private Integer id;
	private String logMessage;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "LOG_MESSAGE")
	public String getLogMessage() {
		return logMessage;
	}
	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}
	
	@Override
	public String toString() {
		return getId().toString();
	}
}
