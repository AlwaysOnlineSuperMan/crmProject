package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.IProductService;
import com.crm.dao.impl.IProductDAO;
import com.crm.entity.Product;
import com.crm.util.PageModel;



public class ProductService implements java.io.Serializable, IProductService {
	private IProductDAO productDAO;

	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	//依照产品编号查询产品信息
	public Product getOddProdId(Long id){
		Product  product = productDAO.findById(id);
		return product;
	}
	public List<Product> getProductAll(){
		return productDAO.findAll();
	}
	public PageModel<Product> getProductPageModel(Product product, int page,
			int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.getPageModel(product, page, pageSize);
	}
	public String[] getProductByName(String productName) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.getProductByName(productName);
	}
}