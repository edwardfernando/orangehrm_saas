package efs.thesis.common.transformer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import efs.thesis.common.annotation.FormElement;
import efs.thesis.common.db.model.Model;
import efs.thesis.common.db.model.PlainModel;
import efs.thesis.common.enumtype.FormType;
import efs.thesis.common.mvc.form.CrudForm;
import efs.thesis.common.pojo.HtmlAttribute;
import efs.thesis.common.util.ClassUtil;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.util.DateUtil;
import efs.thesis.common.util.SessionCookieUtil;
import efs.thesis.saas.dao.CrudDAO;
import efs.thesis.saas.model.Fields;
import efs.thesis.saas.model.FieldsValue;
import efs.thesis.saas.model.L10n;
import efs.thesis.saas.model.Translation;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class EntityTransformer {

	public static <T extends Model> Map<String, HtmlAttribute> transformAndFill(Model model, CrudDAO dao) throws Exception{
		Map<String, HtmlAttribute> map = new HashMap<String, HtmlAttribute>();
		L10n locale = SessionCookieUtil.getDefaultLocale();
		
		for(Field f : model.getClass().getDeclaredFields()){
			
			Fields fields = (Fields) dao.execUniqueNamedQuery("findFieldsByNameAndModule", new Object[]{f.getName(), model.getClass().getSimpleName()});
			Translation translation = (Translation)dao.execUniqueNamedQuery("findTranslationByI18NAndL10N", 
					new Object[]{
						locale, 
						new StringBuffer(model.getClass().getSimpleName()).append(".").append(f.getName()).toString()
						}
					);
			
			for(Annotation annotation : f.getAnnotations()){
				if(annotation instanceof FormElement){
					
					FormElement elem = (FormElement)annotation;
					
					HtmlAttribute att = new HtmlAttribute();
					
					att.setName(f.getName());
					att.setType(elem.type());
					att.setFilterable(elem.filterable());
					att.setAttributeType(f.getType());
					att.setAllowInput(elem.allowInput());
					
					att.setListed(elem.listed());
					att.setAlias(elem.alias().isEmpty() ? f.getName() : elem.alias());
					if(CommonUtil.validateParam(translation)){
						att.setI18n(translation.getValue());
						att.setAlias(translation.getValue());
					}
					
					Method method = model.getClass().getMethod(ClassUtil.constructGetter(f.getName()));
					Object ob = method.invoke(model);
					
					if(ob instanceof Date){
						ob = DateUtil.format((Date)ob);
					}
					
					att.setValue(ob);
					
					if(ob instanceof PlainModel){
						att.setId(((PlainModel)ob).getId().toString());
					}else{
						att.setId(f.getName());
					}
					
					if(CommonUtil.validateParam(fields)){
						att.setCoorX(fields.getCoorX());
						att.setCoorY(fields.getCoorY());
					}
					
					att.setEntity(model.getClass());
					map.put(f.getName(), att);
				}
			}
		}
		
		return map;
	}
	
	public static <T extends Model> Map<String, HtmlAttribute> transform(Class<T> entity, CrudDAO dao) throws Exception{
		Map<String, HtmlAttribute> map = new HashMap<String, HtmlAttribute>();
		L10n locale = SessionCookieUtil.getDefaultLocale();
		
		for(Field field : entity.getDeclaredFields()){
			
			Fields fields = (Fields) dao.execUniqueNamedQuery("findFieldsByNameAndModule", new Object[]{field.getName(), entity.getSimpleName()});
			Translation translation = (Translation)dao.execUniqueNamedQuery("findTranslationByI18NAndL10N", 
					new Object[]{
						locale, 
						new StringBuffer(entity.getSimpleName()).append(".").append(field.getName()).toString()
					});
			
			for(Annotation annotation : field.getAnnotations()){
				if(annotation instanceof FormElement){
					FormElement elem = (FormElement)annotation;
					
					HtmlAttribute att = new HtmlAttribute();
					att.setName(field.getName());
					att.setType(elem.type());
					att.setFilterable(elem.filterable());
					att.setAttributeType(field.getType());
					att.setListed(elem.listed());
					att.setEntity(entity);
					att.setAllowInput(elem.allowInput());
					
					if(CommonUtil.validateParam(fields)){
						att.setCoorX(fields.getCoorX());
						att.setCoorY(fields.getCoorY());
					}
					
					att.setAlias(elem.alias().isEmpty() ? field.getName() : elem.alias());
					if(CommonUtil.validateParam(translation)){
						att.setI18n(translation.getValue());
						att.setAlias(translation.getValue());
					}
					
					map.put(field.getName(), att);
				}
			}
		}
		return map;
	}
	
	public static <T extends Model> Model toEntity(Class<T> entity, CrudForm form, CrudDAO dao) throws Exception{
		Model model = entity.newInstance();
		
		if(model instanceof PlainModel && form.getEntity() != null){ //set ID if exist
			Method getId = model.getClass().getDeclaredMethod("setId", Integer.class);
			getId.invoke(model, ((PlainModel)form.getEntity()).getId());
		}
		
		for(Map.Entry<String, HtmlAttribute> entry : form.getAttributes().entrySet()){

			if(entry.getValue().getAllowInput()){
				Method method = model.getClass().getDeclaredMethod(ClassUtil.constructSetter(entry.getKey()), entry.getValue().getAttributeType());
				Object value = entry.getValue().getValue();
				
				//Gimana kalau tipe data lain?
				if(entry.getValue().getAttributeType() == Boolean.class && value == null){
					value = Boolean.FALSE;
				}
				
				if(CommonUtil.validateParamWithZeroPosibility(value) && isModelInstance(entry.getValue().getAttributeType())){ //ini berarti attribute tersebut instance dari Model/PlainModel. Ambil objek ybs dari DB melalui DAO
					dao.setDomainClass(entry.getValue().getAttributeType());
					value = dao.findById(Integer.parseInt(value.toString()));//load from DAO
//					System.out.println(value);
				}else{
					value = toAppropriateType(entry.getValue().getAttributeType(), value);
				}
					
				System.out.println(entry.getKey() + " >" + value);
				
				method.invoke(model, value);
			}
			
				
		}
		
		return model;
	}
	
	public static List<HtmlAttribute> getAdditionalFields(String type, Model model, CrudDAO dao) throws Exception{
		List<HtmlAttribute> additionals = new ArrayList<HtmlAttribute>();
		List<Fields> list = (List<Fields>) dao.execListNamedQuery("findAdditionalFieldsByModule", new Object[]{type});
		
		for(Fields f : list){
			HtmlAttribute att = new HtmlAttribute();
			att.setName(f.getName());
			att.setType(getFormType(f.getFieldsType().getName()));
			att.setCoorX(f.getCoorX());
			att.setCoorY(f.getCoorY());
			att.setAlias(f.getName());
			att.setVisible(f.getIsVisible());
			
			FieldsValue fv = null;
			if(model != null){
				fv = (FieldsValue) dao.execUniqueNamedQuery("findFieldValueByFieldsNameAndEntityId", new Object[]{f.getName(), ((PlainModel)model).getId()});
			}
			att.setValue(fv == null ? "" : fv.getValue());
			
			additionals.add(att);
		}
		
		return additionals;
	}
	
	public static FormType getFormType(String type){
		if(type.equals(FormType.LABEL)){
			return FormType.LABEL;
		}else if(type.equals(FormType.TEXT)){
			return FormType.TEXT;
		}else if(type.equals(FormType.PASSWORD)){
			return FormType.PASSWORD;
		}else if(type.equals(FormType.TEXTAREA)){
			return FormType.TEXTAREA;
		}else if(type.equals(FormType.POPUP)){
			return FormType.POPUP;
		}else if(type.equals(FormType.DATE)){
			return FormType.DATE;
		}else if(type.equals(FormType.CHECKBOX)){
			return FormType.CHECKBOX;
		}else{
			return FormType.TEXT;
		}
	}
	
	public static Object toAppropriateType(Class<?> type, Object value){
		Object object = null;
		
		if(type == Boolean.class){
			object = Boolean.valueOf(value.toString());
		}else if(type == Integer.class){
			object = Integer.parseInt(value.toString());
		}else if(type == Long.class){
			object = Long.valueOf(value.toString());
		}else if(type == Date.class){
			object = DateUtil.toDate(value.toString());
		}else if(type == String.class){
			object = String.valueOf(value);
		}
		
		return object;
	}
	
	public static boolean isModelInstance(Class<?> clazz){
		return clazz.getSuperclass() == PlainModel.class || clazz.getSuperclass() == Model.class;
	}
	
}

