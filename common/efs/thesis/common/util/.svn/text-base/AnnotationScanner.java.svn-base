package efs.thesis.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import efs.thesis.common.annotation.AutoCrud;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class AnnotationScanner {

	private static AnnotationScanner instance;
	private Map<String, Object> map = new ConcurrentHashMap<String, Object>();
	
	private AnnotationScanner(){
		init();
	}
	
	public void init(){
		if(map.isEmpty()){
			GenericApplicationContext context = new GenericApplicationContext();
			ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context, false);
			
			scanner.addIncludeFilter(new AnnotationTypeFilter(AutoCrud.class));
			scanner.scan("efs.thesis.saas.model");
			context.refresh();
		
			map = context.getBeansWithAnnotation(AutoCrud.class);
		}
	}
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public static AnnotationScanner instance(){
		if(instance == null){
			instance = new AnnotationScanner();
		}
		return instance;
	}
	
}
