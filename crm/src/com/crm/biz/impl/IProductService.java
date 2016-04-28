package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.Product;
import com.crm.util.PageModel;

public interface IProductService {
		
	//���ղ�Ʒ��Ų�ѯ��Ʒ��Ϣ
	public abstract Product getOddProdId(Long id);
	public abstract List<Product> getProductAll();
	public abstract PageModel<Product> getProductPageModel(Product product,int page,int pageSize)throws Exception;
	public abstract String[] getProductByName(String productName)throws Exception;
}