package com.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.impl.IProductService;
import com.crm.biz.impl.IStorageService;
import com.crm.dao.StorageDAO;
import com.crm.dao.impl.IStorageDAO;
import com.crm.entity.Product;
import com.crm.entity.Storage;
import com.crm.form.StorageForm;
import com.crm.util.PageModel;


public class StorageAction extends DispatchAction implements java.io.Serializable {
	private IStorageService storageService;
	private IProductService productService;
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public void setStorageService(IStorageService storageService) {
		this.storageService = storageService;
	}
	
	public ActionForward toStorageListForPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StorageForm storageForm = (StorageForm) form;
		PageModel<Storage> pageModel = storageForm.getPageModel();
		int currPage = pageModel.getCurrPage()==0?1:pageModel.getCurrPage();
		int pageSize = pageModel.getMaxRecord()==0?2:pageModel.getMaxRecord();
		Storage currStorage = new Storage();
		BeanUtils.copyProperties(currStorage, storageForm);
		String[] strs=null;
		System.out.println(storageForm.getStkWarehouse()+"============"+storageForm.getStkProductName());
		if (storageForm.getStkProductName()!=null&&!storageForm.getStkProductName().equalsIgnoreCase("")) {
			strs = productService.getProductByName(storageForm.getStkProductName());
		}
		
		//productService.getOddProdId(storageForm.getStkProdId()
	    pageModel = storageService.getPageModel(strs,currStorage, currPage, pageSize);
	    List<Storage> storageList = pageModel.getResultList();
		Product product=null;
		for (Storage storage : storageList) {
			product = productService.getOddProdId(storage.getStkProdId());
			storage.setStkProductName(product.getProdName());
		}
	    storageForm.setPageModel(pageModel);
	    
	    return mapping.findForward("toStorageList");
	}
	public ActionForward toStorageList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StorageForm storageForm = (StorageForm) form;
		List<Storage> storageList = storageService.getStorageAll();
		Product product=null;
		for (Storage storage : storageList) {
			product = productService.getOddProdId(storage.getStkProdId());
			storage.setStkProductName(product.getProdName());
		}
		storageForm.setStorageList(storageList);
		
		return mapping.findForward("toStorageList");
	}
	
}