package efs.thesis.common.pojo;

import efs.thesis.common.db.model.Model;
import efs.thesis.common.enumtype.FormType;
import efs.thesis.common.util.CommonUtil;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */
public class HtmlAttribute {

	private Class<? extends Model> entity;
	private Class<?> attributeType;
	private String id;
	private String name;
	private String alias;
	private FormType type;
	private String cssClass;
	private String i18n;
	private boolean filterable;
	private boolean listed;
	private boolean allowInput;
	private Object value;
	private Integer coorX;
	private Integer coorY;
	private boolean isVisible;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FormType getType() {
		return type;
	}
	public void setType(FormType type) {
		this.type = type;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getI18n() {
		return i18n;
	}
	public void setI18n(String i18n) {
		this.i18n = i18n;
	}
	public boolean getFilterable() {
		return filterable;
	}
	public void setFilterable(boolean filterable) {
		this.filterable = filterable;
	}
	public Class<?> getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(Class<?> attributeType) {
		this.attributeType = attributeType;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public boolean isListed() {
		return listed;
	}
	public void setListed(boolean listed) {
		this.listed = listed;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Class<? extends Model> getEntity() {
		return entity;
	}
	public void setEntity(Class<? extends Model> entity) {
		this.entity = entity;
	}
	
	public int getCoorX() {
		return coorX;
	}
	public void setCoorX(int coorX) {
		this.coorX = coorX;
	}
	public int getCoorY() {
		return coorY;
	}
	public void setCoorY(int coorY) {
		this.coorY = coorY;
	}
	
	public String getStyle(){
		String style = "";
		if(CommonUtil.validateParam(coorX) && CommonUtil.validateParam(coorY)){
			style = new StringBuffer("top: ").append(coorY).append("px; left: ").append(coorX).append("px;").toString(); 
		}
		return style;
	}
	
	public String getPlainXYCoor(){
		String xy = "";
		if(CommonUtil.validateParam(coorX) && CommonUtil.validateParam(coorY)){
			xy = new StringBuffer("").append(coorX).append("px,").append(coorY).append("px").toString();
		}
		return xy;
	}
	
	public boolean getAllowInput() {
		return allowInput;
	}
	public void setAllowInput(boolean allowInput) {
		this.allowInput = allowInput;
	}
	
	public boolean getIsVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	@Override
	public String toString() {
		return "ini method to string";
//		return "HtmlAttribute [entity=" + entity + ", attributeType="
//				+ attributeType + ", id=" + id + ", name=" + name + ", alias="
//				+ alias + ", type=" + type + ", cssClass=" + cssClass
//				+ ", i18n=" + i18n + ", filterable=" + filterable + ", listed="
//				+ listed + ", value=" + value + "]";
	}
	
}
