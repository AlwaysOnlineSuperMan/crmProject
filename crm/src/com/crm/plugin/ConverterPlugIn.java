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
	//tomcat停止的时候
	public void destroy() {

	}
	//Struts在启动的时候，会自动的new出来这个插件的对象，并且调用init()方法
	public void init(ActionServlet servlet, ModuleConfig config)
			throws ServletException {
		System.out.println("ConverterPlugIn.init()开始");
		//ConvertUtils.register(new UtilDateConverter(), java.util.Date.class);
		ConvertUtils.register(new SqlTimestampConverter(null),Timestamp.class);
		System.out.println("ConverterPlugIn.init()结束");
	}

}
