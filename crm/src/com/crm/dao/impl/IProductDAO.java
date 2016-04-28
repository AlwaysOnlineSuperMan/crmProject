package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.Product;
import com.crm.util.PageModel;

public interface IProductDAO {

	public abstract void save(Product transientInstance);

	public abstract void delete(Product persistentInstance);

	public abstract Product findById(java.lang.Long id);

	public abstract List findByExample(Product instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByProdName(Object prodName);

	public abstract List findByProdType(Object prodType);

	public abstract List findByProdBatch(Object prodBatch);

	public abstract List findByProdUnit(Object prodUnit);

	public abstract List findByProdPrice(Object prodPrice);

	public abstract List findByProdMemo(Object prodMemo);

	public abstract List findAll();

	public abstract Product merge(Product detachedInstance);

	public abstract void attachDirty(Product instance);

	public abstract void attachClean(Product instance);
	public PageModel<Product> getPageModel(Product product,int page,int pageSize);
	public String[] getProductByName(String productName);

}