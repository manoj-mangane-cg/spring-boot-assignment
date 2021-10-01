package com.charter.homeworkout.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomerUtils { 
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerUtils.class);
	
	/**
	 * @param trxAmount
	 * @return
	 */
	public static Integer calculatePoint(Double trxAmount) {
		int points = 0 ;
		
		int above100 = (int) (trxAmount - 100);
	    
	    if (above100 > 0) {
	    	points += (above100 * 2);
	    }    
	    if (trxAmount > 50) {
	    	points += 50;      
	    }
		return points;
	}
	
	

	/**
	 * @param dateInString
	 * @return int
	 */
	@SuppressWarnings("deprecation")
	public static int getMonthByDate(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
		Date date = null;
		int month = 0;
		try {
			date = formatter.parse(dateInString);
			month = date.getMonth()+1;
		} catch (ParseException e) {
			e.printStackTrace();
			month = 0;
		}
		return month;
		
	}
	
	/**
	 * @param dateInString
	 * @return int
	 */
	@SuppressWarnings("deprecation")
	public static int getYearByDate(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);

		Date date = null;
		int yr = 0;
		try {
			date = formatter.parse(dateInString);
			yr = date.getYear()+1900;
			
			} catch (ParseException e) {
			e.printStackTrace();
			yr = 0;
		}
		return yr;
		
	}
	
	
	/**
	 * @param list
	 * @return
	 */
	public static boolean isValidList(List<?> list) {
		boolean flag = false;
		try {
			if(null!=list && !list.isEmpty()) {
				flag = true;
			}
		} catch (Exception e) {
			LOG.error(e.getClass()+""+e);
		}
		return flag;
	}
	

	/**
	 * @param str
	 * @return
	 */
	public static double checkNullDouble(String str) {
		double number = 0.0;
		try {
			if (str.equalsIgnoreCase("")) {
				number=0.0;
			} else {
				number = Double.parseDouble(str);
			}
		} catch (Exception e) {
			number = 0.0;
			LOG.error(e.getClass()+""+e);
		}
		return number;
	}
	
	
}
