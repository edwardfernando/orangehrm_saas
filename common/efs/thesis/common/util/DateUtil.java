package efs.thesis.common.util;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.joda.time.DateTime;
import org.springframework.web.servlet.support.RequestContext;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class DateUtil {
	
	private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	
	public static synchronized String format(Date date){
		return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
	}
	
	public static synchronized Date now(){
		return new Date();
	}
	
	public static synchronized String nowFormatted(){
		return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(now());
	}
	
	public static synchronized String nowFormatted(String format){
		return new SimpleDateFormat(format).format(now());
	}
	
	public static synchronized Date toDate(String date){
		Date result = null;

		if (date != null && !date.equals(""))
		{
			String x[] = date.split("/");
			if (x.length == 3)
			{
				DateTime dt = new DateTime(Integer.parseInt(x[2]), Integer.parseInt(x[1]), Integer.parseInt(x[0]), 0, 0, 0, 0);
				result = dt.toDate();
			}
		}

		return result;
	}
	
	public static synchronized String getCurrentMonthString(){
		return new SimpleDateFormat("MMMMM").format(now());
	}
	
	public static synchronized int getCurrentDate(){
		return new DateTime().getDayOfMonth();
	}

	public static synchronized int getCurrentMonth(){
		return new DateTime().getMonthOfYear();
	}

	public static synchronized int getCurrentYear(){
		return new DateTime().getYear(); 
	}
	
	@SuppressWarnings("deprecation")
	public static synchronized Time toTime(String time){
		Time result = null;
		
		if(time != null && !time.equals("")){
			String x[] = time.split(" ");
			String completeHour = x[0]; //hour
			String amPm = x[1]; //amPm

			String[] splittedHour = completeHour.split(":");
			
			int hour = Integer.parseInt(splittedHour[0]);
			int minute = Integer.parseInt(splittedHour[1]);
			int second = 0;
			
			if(amPm.equalsIgnoreCase("PM")){
				hour += 12;
			}
			
			result = new Time(hour, minute, second);
		}
		
		return result;
	}
	
	public static synchronized Map<Integer, String> getDates(){
		Map<Integer, String> dates = new HashMap<Integer, String>();
		
		for(int d = 1; d <=31; d++){
			dates.put(d, String.valueOf(d));
		}
		
		return dates;
	}
	
	public static synchronized Map<Integer, String> getMonths(){
		RequestContext ctx = new RequestContext(CommonUtil.getHttpRequest());
		Map<Integer, String> months = new HashMap<Integer, String>();
		
//		months.put(1, ctx.getMessage("whm.common.months.january"));
//		months.put(2, ctx.getMessage("whm.common.months.february"));
//		months.put(3, ctx.getMessage("whm.common.months.march"));
//		months.put(4, ctx.getMessage("whm.common.months.april"));
//		months.put(5, ctx.getMessage("whm.common.months.may"));
//		months.put(6, ctx.getMessage("whm.common.months.june"));
//		months.put(7, ctx.getMessage("whm.common.months.july"));
//		months.put(8, ctx.getMessage("whm.common.months.august"));
//		months.put(9, ctx.getMessage("whm.common.months.september"));
//		months.put(10, ctx.getMessage("whm.common.months.october"));
//		months.put(11, ctx.getMessage("whm.common.months.november"));
//		months.put(12, ctx.getMessage("whm.common.months.december"));
		
		return months;
	}
	
	public static synchronized Map<Integer, Integer> getYears(){
		Map<Integer, Integer> years = new TreeMap<Integer, Integer>();

		for(int y = 1922; y <= new DateTime().getYear(); y++){
			years.put(y, y);
		}
		
		return years;
	}	
	
	public static final synchronized Date toEndDate(Date date)
    {
        DateTime dateTime = new DateTime(date);
        return new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),dateTime.dayOfMonth().getMaximumValue(),0,0,0,0).toDate();
    }
    
    public static final synchronized Date toStartDate(Date date)
    {
        DateTime dateTime = new DateTime(date);
        return new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),dateTime.dayOfMonth().getMinimumValue(),0,0,0,0).toDate();
    }
    
    public static final synchronized Date toEndDateInOneYear(Date date)
    {
        DateTime dateTime = new DateTime(date);
		DateTime dt = new DateTime(dateTime.getYear(), dateTime.monthOfYear().getMaximumValue(), dateTime.dayOfMonth().getMaximumValue(),0,0,0,0);
        return new DateTime(dt.getYear(), dt.monthOfYear().getMaximumValue(), dt.dayOfMonth().getMaximumValue(),0,0,0,0).toDate();
    }
    
    public static final synchronized Date toStartDateInOneYear(Date date)
    {
        DateTime dateTime = new DateTime(date);
        return new DateTime(dateTime.getYear(), dateTime.monthOfYear().getMinimumValue(), dateTime.dayOfMonth().getMinimumValue(),0,0,0,0).toDate();
    }
}
