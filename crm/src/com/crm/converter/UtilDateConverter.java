package com.crm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

/**
 * java.util.Date��ת���������ת�����ɹ����᷵��һ��null
 *
 */
public class UtilDateConverter implements Converter {

	public Object convert(Class type, Object value) {
		if(value == null) {//���value��null������null
			return null;
		}
		//Timestamp
		if(value instanceof Date) {//���value��Date��ʵ����ֱ�ӷ���value
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
