package efs.thesis.common.util;

import org.apache.commons.lang.NumberUtils;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@SuppressWarnings("deprecation")
public class NumberUtil {

	public static boolean isInteger(String str){
		boolean result = true;
		try{
			Integer.parseInt(str);
		}catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}
	
	public static boolean isNumber(String str) {
		return NumberUtils.isNumber(str);
	}
	
}
