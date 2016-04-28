package com.crm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.impl.IProductService;
import com.crm.dao.impl.IProductDAO;
import com.crm.entity.Product;
import com.crm.form.ProductForm;
import com.crm.util.PageModel;



public class ProductAction extends DispatchAction implements java.io.Serializable {
	private IProductService productService;

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public ActionForward toProductList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProductForm productForm = (ProductForm) form;
		productForm.setProductList(productService.getProductAll());
		return mapping.findForward("toProduct");
	}
public ActionForward toProductLsitForPage(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	ProductForm productForm = (ProductForm) form;
	PageModel<Product> pageModel =	productForm.getPageModel();
	int currPage = 1;
	if (pageModel.getCurrPage()!=0) {
		currPage= pageModel.getCurrPage();
	}
	int pageSize = 2;
	if (pageModel.getMaxRecord()!=0) {
		pageSize = pageModel.getMaxRecord();
	}
	Product product = new Product();
	BeanUtils.copyProperties(product, productForm);
	pageModel  = productService.getProductPageModel(product, currPage, pageSize);
	productForm.setPageModel(pageModel);
	return mapping.findForward("toProduct");
}
}