package com.threads.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String getCurrentDateTime()
	{
		 Date date = new Date();
	     SimpleDateFormat dateForm = new SimpleDateFormat("hh:mm:ss");
	     return dateForm.format(date);
	}

}
