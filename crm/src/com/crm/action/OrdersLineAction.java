package com.crm.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.ProductService;
import com.crm.biz.impl.IOrdersLineService;
import com.crm.biz.impl.IOrdersService;
import com.crm.biz.impl.IProductService;
import com.crm.entity.Orders;
import com.crm.entity.OrdersLine;
import com.crm.entity.Product;
 
public class OrdersLineAction extends DispatchAction implements java.io.Serializable {

	private IOrdersLineService ordersLineService;
	
	private IOrdersService ordersService;
	
	private IProductService productService;
	
	
	public IProductService getProductService() {
		return productService;
	}
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public void setOrdersService(IOrdersService ordersService) {
		this.ordersService = ordersService;
	}
	public void setOrdersLineService(IOrdersLineService ordersLineService) {
		this.ordersLineService = ordersLineService;
	}
//在订单历史界面点击订单详细进入
	public ActionForward getByOrderId(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long odrId  =Long.valueOf(request.getParameter("odrId"));
		//
		
		Orders orders = ordersService.getByOrderId(odrId);
		request.setAttribute("order", orders);
		//依照订单编号查找到此条订单详情
		List<OrdersLine> line = ordersLineService.getOrderId(odrId);
		request.setAttribute("line", line);
		List<Long> id = new ArrayList<Long>(); 
		for (OrdersLine ordersLine : line) {
			id.add(ordersLine.getOddProdId());	
			System.out.println(ordersLine.getOddProdId());
		}
		System.out.println("--------"+id.size());
		List<Product> pro =  new ArrayList<Product>();
		for (Long long1 : id) {
			Product product = productService.getOddProdId(long1);
			pro.add(product);
		}
		System.out.println(pro.size());
		request.setAttribute("list", pro);
		return mapping.findForward("list");
	}

}