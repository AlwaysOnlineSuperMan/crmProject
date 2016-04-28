package com.crm.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.chainsaw.Main;

import com.crm.biz.impl.ICstCustomerService;
import com.crm.dao.CstCustomerDAO;
import com.crm.dao.impl.ICstCustomerDAO;
import com.crm.entity.CstCustomer;
import com.crm.entity.SalChance;



public class CstCustomerService implements java.io.Serializable, ICstCustomerService {
	private ICstCustomerDAO  cstCustomerDAO;

	public ICstCustomerDAO getCstCustomerDAO() {
		return cstCustomerDAO;
	}

	public void setCstCustomerDAO(ICstCustomerDAO cstCustomerDAO) {
		this.cstCustomerDAO = cstCustomerDAO;
	}
	//查询全部客户信息
	public List<CstCustomer> getCstCustomerList() throws Exception{
		List<CstCustomer> list = cstCustomerDAO.findAll();
		return list;
	}
	//进入客户信息编辑页面
	public CstCustomer getCustNo(String custNo) throws Exception{
		CstCustomer cstCustomer = cstCustomerDAO.findByNo(custNo);
		return cstCustomer;
	}
	//保存客户信息
	public void saveOrUpdate(CstCustomer cstCustomer) throws Exception{
		cstCustomerDAO.saveOrUpdate(cstCustomer);
	}
	public CstCustomer getUsers(String uid) throws Exception{
		return cstCustomerDAO.findById(uid);
	}

	public String getNewCustNo() throws Exception{
		return cstCustomerDAO.getNewCustNo();
	}
	public void addCustomer(CstCustomer cstCustomer) throws Exception{
		SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyyMMdd");
		Long millis = System.currentTimeMillis();
		String sj = simpleDateFormat.format(new Date(millis));
		String MaxCustNo=getNewCustNo();
		String maxSj=MaxCustNo.substring(2, 10);
		String newCustNo = "KH";
		System.out.println("MaxCustNo="+MaxCustNo);
		//KH201412050001
		//20141205
		if (sj.equalsIgnoreCase(maxSj)&&maxSj!=null) {
			System.out.println("1"+MaxCustNo.substring(10,14));
			int number=Integer.parseInt(("1"+MaxCustNo.substring(10,14)).trim())+1;
			String str =number+"";
			newCustNo+=sj+str.substring(1,5);
		}else{
			newCustNo+=sj+"0001";
		}
		System.out.println(newCustNo);
		cstCustomer.setCustNo(newCustNo);
		cstCustomerDAO.saveOrUpdate(cstCustomer);
	}
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}

	public void delByNo(String custNo) throws Exception{
		
		cstCustomerDAO.delByNo(custNo);
	}

	public CstCustomer getCstCustomerId(Long id)throws Exception {
		CstCustomer c = (CstCustomer) cstCustomerDAO.findByCustManagerId(id).get(0);
		return c;
		 
	}

	public List<CstCustomer> getcstcustName(String name) {
		List<CstCustomer> list =  cstCustomerDAO.getcstcustname(name);
		return list;
	}

}