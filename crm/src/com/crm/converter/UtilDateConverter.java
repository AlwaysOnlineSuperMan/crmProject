package com.crm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

/**
 * java.util.Date的转换器，如果转换不成功，会返回一个null
 *
 */
public class UtilDateConverter implements Converter {

	public Object convert(Class type, Object value) {
		if(value == null) {//如果value是null，返回null
			return null;
		}
		//Timestamp
		if(value instanceof Date) {//如果value是Date的实例，直接返回value
			return value;
		}
		String strValue = value.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(strValue);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
