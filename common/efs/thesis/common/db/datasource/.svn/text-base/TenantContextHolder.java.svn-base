package efs.thesis.common.db.datasource;


/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */


public class TenantContextHolder {
	
//	private static ThreadLocal<Map<String, TenantContext>> holder = new ThreadLocal<Map<String,TenantContext>>();
//	
//	
//	public static TenantContext getContext(String alias){
//		return holder.get().get(alias);
//	}
//	
//	public static void set(String alias, TenantContext ctx){
//		Map<String, TenantContext> map = holder.get();
//		map.put(alias, ctx);
//		
//		holder.set(map);
//	}
	
//	private static ThreadLocal<TenantContext> schemaHolder = new ThreadLocal<TenantContext>();
//
//	public static void setSchema(TenantContext context){
//		schemaHolder.set(context);
//	}
//	
//	public static TenantContext getContext(){
//		TenantContext ctx = schemaHolder.get();
//		return ctx;
//	}
//	
//	public static void clear(){
//		schemaHolder.remove();
//	}
	
	private static ThreadLocal<String> schemaHolder = new ThreadLocal<String>();
	
	public static void set(String alias){
		schemaHolder.set(alias);
	}
	
	public static String get(){
		return schemaHolder.get();
	}
}
