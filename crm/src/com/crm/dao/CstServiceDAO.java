package com.crm.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ICstServiceDAO;
import com.crm.entity.CstService;
import com.crm.entity.SalChance;
import com.crm.form.CstServiceForm;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstService entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.dao.CstServiceAction
 * @author MyEclipse Persistence Tools
 */

public class CstServiceDAO extends HibernateDaoSupport implements ICstServiceDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CstServiceDAO.class);
	// property constants
	public static final String SVR_TYPE = "svrType";
	public static final String SVR_TITLE = "svrTitle";
	public static final String SVR_CUST_NAME = "svrCustName";
	public static final String SVR_STATUS = "svrStatus";
	public static final String SVR_REQUEST = "svrRequest";
	public static final String SVR_CREATE_ID = "svrCreateId";
	public static final String SVR_CREATE_BY = "svrCreateBy";
	public static final String SVR_DUE_ID = "svrDueId";
	public static final String SVR_DUE_TO = "svrDueTo";
	public static final String SVR_DEAL = "svrDeal";
	public static final String SVR_DEAL_ID = "svrDealId";
	public static final String SVR_DEAL_BY = "svrDealBy";
	public static final String SVR_RESULT = "svrResult";
	public static final String SVR_SATISFY = "svrSatisfy";
	public static final String SVR_UPDATE_DATETIME = "svrUpdateDatetime";

	protected void initDao() {
		// do nothing
	}
	//保存
	public void save(CstService transientInstance) {
		log.debug("saving CstService instance");
		try {
			System.out.println(transientInstance);
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	//删除
	public void delete(CstService persistentInstance) {
		log.debug("deleting CstService instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	//按ID查询
	public CstService findById(java.lang.Long id) {
		log.debug("getting CstService instance with id: " + id);
		try {
			System.out.println("====="+id);
			CstService instance = (CstService) getHibernateTemplate().get(
					"com.crm.entity.CstService", id);
			System.out.println(instance);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	//按实体查询
	@SuppressWarnings("unchecked")
	public List findByExample(CstService instance) {
		log.debug("finding CstService instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	//按属性查询
	@SuppressWarnings("unchecked")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CstService instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstService as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public void attachDirty(CstService instance) {
		log.debug("attaching dirty CstService instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	//创建服务
	public int addCstService(CstService service) {
		int count = 0;
		Session session = this.getSession();
		session.save(service);
		return count;
	}
	//删除
	public int del(Long svrId) {
		try {
			String queryString = "delete from CstService model where model.svrId=:svrId";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("svrId", svrId);
			return query.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	// 分配查询所有
	public List<CstService> getAllService() {
		log.debug("finding all CstService instances");
		try {
			String queryString = "from CstService where svrStatus='新创建' order by svrCreateDate desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	//分配中高级查询
	public List<CstService> selService(CstService service,String svrCreateDate1,String svrCreateDate2) {
		String sql="select * from cst_service where svr_status='"+service.getSvrStatus()+"'";
		if(service.getSvrType()!=null && !"".equals(service.getSvrType())){
			sql+=" and svr_type like '%"+service.getSvrType()+"%'";
		}
		if(service.getSvrTitle()!=null && !"".equals(service.getSvrTitle())){
			sql+=" and svr_title like '%"+service.getSvrTitle()+"%'";
		}
		if(service.getSvrCustName()!=null && !"".equals(service.getSvrCustName())){
			sql+=" and svr_cust_name like '%"+service.getSvrCustName()+"%'";
		}
		if(service.getSvrStatus()!=null&&"".equals(service.getSvrStatus())){
			sql=" and svr_status like '%"+service.getSvrStatus()+"%'";
		}
		if(svrCreateDate1!=null&&!svrCreateDate1.equals("")&&svrCreateDate2!=null&&!svrCreateDate2.equals("")){
			sql+=" and svr_create_date > '"+svrCreateDate1+"' and svr_create_date < '"+svrCreateDate2+"'";
		}
		List<CstService> list = getSession().createSQLQuery(sql).addEntity(CstService.class).list();
		return list;
	}
	//处理页面的查询
	public List<CstService> getAllServiceChuLi() {
		log.debug("finding all CstService instances");
		try {
			String queryString = "from CstService where svrStatus='已分配' order by svrCreateDate desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	//反馈页面的查询
	public List<CstService> getAllServiceFanKui() {
		log.debug("finding all CstService instances");
		try {
			String queryString = "from CstService where svrStatus='已处理' order by svrCreateDate desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public String getsql(String sql,CstService cs,String svrCreateDate1,String svrCreateDate2){
		if(cs.getSvrStatus()!=null&&!cs.getSvrStatus().equals("")){
			sql+=" and c.svr_status='"+cs.getSvrStatus()+"'";
		}
		if(cs.getSvrCustName()!=null&&!cs.getSvrCustName().equals("")){
			sql+=" and svr_cust_name = '"+cs.getSvrCustName()+"'";
		}
		if(cs.getSvrTitle()!=null&&!cs.getSvrTitle().equals("")){
			sql+=" and svr_title like '%"+cs.getSvrTitle()+"%'";
		}
		if(cs.getSvrType()!=null&&!cs.getSvrType().equals("")&&!cs.getSvrType().equals("null")){
			sql+=" and svr_type = '"+cs.getSvrType()+"'";
		}
		if(svrCreateDate1!=null&&!svrCreateDate1.equals("")&&svrCreateDate2!=null&&!svrCreateDate2.equals("")){
			sql+=" and svr_create_date > '"+svrCreateDate1+"' and svr_create_date < '"+svrCreateDate2+"'";
		}
		return sql;
	}
	//查询当前状态下的的全部信息
	public List<CstService> listAll(CstService cs,String svrCreateDate1,String svrCreateDate2) {
		//log.debug("deleting CstService instance");
		try {
			String sql = "select c.* from cst_service c where 1=1";
			sql=getsql(sql,cs,svrCreateDate1,svrCreateDate2);
			SQLQuery query = this.getSession().createSQLQuery(sql);
			query.addEntity("c", CstService.class);
			List<CstService> list=query.list();
			System.out.println(list.size());
			return list;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	//归档页面的查询
	public List<CstService> getAllServiceGuiDang() {
		log.debug("finding all CstService instances");
		try {
			String queryString = "from CstService where svrStatus='已归档' order by svrCreateDate desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List<CstService> finByService() {
		Session session = this.getSession();
		String sql = "select * from dbo.cst_service where svr_status='新创建' order by svr_create_date desc";
		SQLQuery q = session.createSQLQuery(sql);
		List<CstService> list = q.list();
		return list;
	}
	//杨泽通的DAO
	public List findAll() {
		log.debug("finding all CstService instances");
		try {
			String queryString = "from CstService";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<String[]> findServicByDict(){
		List<String[]> list = new ArrayList<String[]>();
		try {
			String sql="select b.dict_item,count(b.dict_item) from "+ 
						" dbo.bas_dict b left join dbo.cst_service s "+ 
						" on b.dict_item = s.svr_type "+ 
						" where b.dict_type='服务类型'"+ 
						" group by b.dict_item";
		
			SQLQuery  sqlQuery =this.getSession().createSQLQuery(sql);
			list = sqlQuery.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/*public void edits(Integer fid, String svrDeal) {
		System.out.println(fid);
		System.out.println(svrDeal);
		String queryString = "update dbo.cst_service set svr_deal='"+svrDeal+"' where svr_id="+fid;
		SQLQuery query = this.getSession().createSQLQuery(queryString);
	//	query.setParameter("svrDeal", svrDeal);
	//	query.setParameter("fid", fid);
		query.executeUpdate();
	}*/
	public void update2(String svrResult,int svrSatisfy,int svrId) {
		//log.debug("deleting CstService instance");
		try {
			String sql = "update cst_service set svr_result='"+svrResult+"',svr_satisfy="+svrSatisfy+",svr_status=3 where svr_id="+svrId;
			SQLQuery query = this.getSession().createSQLQuery(sql);
			int a = query.executeUpdate();
			System.out.println(a);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
}