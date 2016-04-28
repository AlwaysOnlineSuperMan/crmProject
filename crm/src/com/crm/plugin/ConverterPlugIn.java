package com.crm.plugin;

import java.sql.Timestamp;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.crm.converter.UtilDateConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;


public class ConverterPlugIn implements PlugIn {
	//tomcatֹͣ��ʱ��
	public void destroy() {

	}
	//Struts��������ʱ�򣬻��Զ���new�����������Ķ��󣬲��ҵ���init()����
	public void init(ActionServlet servlet, ModuleConfig config)
			throws ServletException {
		System.out.println("ConverterPlugIn.init()��ʼ");
		//ConvertUtils.register(new UtilDateConverter(), java.util.Date.class);
		ConvertUtils.register(new SqlTimestampConverter(null),Timestamp.class);
		System.out.println("ConverterPlugIn.init()����");
	}

}
