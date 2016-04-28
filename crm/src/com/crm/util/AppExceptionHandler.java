package com.crm.util;

import org.apache.struts.action.ExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.config.ExceptionConfig;



/**
 * 个性化异常处理类
 */
public class AppExceptionHandler extends ExceptionHandler {
    public ActionForward execute(
            Exception ex,
            ExceptionConfig ae,
            ActionMapping mapping,
            ActionForm formInstance,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException {
        
        if (!(ex instanceof AppException )) {
        	System.out.println("1111111");
            return super.execute(ex, ae, mapping, formInstance, request, response);
            
        }
        System.out.println("22222222");
        AppException  errCodeEx =(AppException) ex;
        ActionForward forward = null;
        ActionMessage error = null;
        String property = null;

        // Build the forward from the exception mapping if it exists
        // or from the form input
        ////配置文件中的path
        if (ae.getPath() != null) {
            forward = new ActionForward(ae.getPath());
        } else {
        	//如果没有找到path，转到input配置的路径
            forward = mapping.getInputForward();
        }
        
        //----------处理个性化异常-------------
        AppException ece =(AppException) ex;
        String errorCode =ece.getErrorCode();
        error = new ActionMessage(errorCode, ece.getArgs());
        property = error.getKey();
        //-----------------------------------
        
        logException(ex);

        // Store the exception
        request.setAttribute(Globals.EXCEPTION_KEY, ex);
        storeException(request, property, error, forward, ae.getScope());

        return forward;
    }

}
