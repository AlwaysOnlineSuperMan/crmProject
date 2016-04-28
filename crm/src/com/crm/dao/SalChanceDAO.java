package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ISalChanceDAO;
import com.crm.entity.SalChance;

/**
 * A data access object (DAO) providing persistence and search support for
 * SalChance entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.SalChance
 * @author MyEclipse Persistence Tools
 */

public class SalChanceDAO extends HibernateDaoSupport implements ISalChanceDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SalChanceDAO.class);
	// property constants
	public static final String CHC_SOURCE = "chcSource";
	public static final String CHC_CUST_NAME = "chcCustName";
	public static final String CHC_TITLE = "chcTitle";
	public static final String CHC_RATE = "chcRate";
	public static final String CHC_LINKMAN = "chcLinkman";
	public static final String CHC_TEL = "chcTel";
	public static final String CHC_DESC = "chcDesc";
	public static final String CHC_CREATE_ID = "chcCreateId";
	public static final String CHC_CREATE_BY = "chcCreateBy";
	public static final String CHC_DUE_ID = "chcDueId";
	public static final String CHC_DUE_TO = "chcDueTo";
	public static final String CHC_STATUS = "chcStatus";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#save(com.crm.entity.SalChance)
	 */
	public void save(SalChance transientInstance) {
		log.debug("saving SalChance instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#save(com.crm.entity.SalChance)
	 */
	public boolean updDispatch(SalChance salChanceObject) {
		try {
		
			String queryString = "update SalChance model set " +
				"model.chcStatus=2,"+
				"model.chcDueId=:chcDueId,"+
				"model.chcDueTo=:chcDueTo,"+
				"model.chcDueDate=:chcDueDate,"+
				"model.chcUpdateDatetime=:CurplaUpdateDatetime"+
				" where model.chcId=:chcId " +
				" and " +
				" model.chcUpdateDatetime=:chcUpdateDatetime";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("chcDueId", salChanceObject.getChcDueId());
			query.setParameter("chcDueTo", salChanceObject.getChcDueTo());
			query.setParameter("chcDueDate", salChanceObject.getChcDueDate());
			query.setParameter("CurplaUpdateDatetime", new Timestamp(System.currentTimeMillis()));
			query.setParameter("chcId", salChanceObject.getChcId());
			query.setParameter("chcUpdateDatetime",salChanceObject.getChcUpdateDatetime());
			
			
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public boolean loseSalChance(SalChance salChanceObject) {
		try {
		
			String queryString = "update SalChance model set " +
				"model.chcStatus=4,"+
				"model.chcUpdateDatetime=:CurplaUpdateDatetime"+
				" where model.chcId=:chcId";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("CurplaUpdateDatetime", new Timestamp(System.currentTimeMillis()));
			query.setParameter("chcId", salChanceObject.getChcId());
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public boolean successSalChance(SalChance salChanceObject) {
		try {
		
			String queryString = "update SalChance model set " +
				"model.chcStatus=3,"+
				"model.chcUpdateDatetime=:CurplaUpdateDatetime"+
				" where model.chcId=:chcId";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("CurplaUpdateDatetime", new Timestamp(System.currentTimeMillis()));
			query.setParameter("chcId", salChanceObject.getChcId());
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#save(com.crm.entity.SalChance)
	 */
	public boolean saveOrUpdate(SalChance salChanceObject) {
		try {
			//,model.chcCreateDate=:chcCreateDate
			String queryString = "update SalChance model set " +
				"model.chcSource=:chcSource," +
				"model.chcCustName=:chcCustName," +
				"model.chcRate=:chcRate," +
				"model.chcTitle=:chcTitle," +
				"model.chcLinkman=:chcLinkman," +
				"model.chcTel=:chcTel," +
				"model.chcDesc=:chcDesc," +
				"model.chcUpdateDatetime=:CurplaUpdateDatetime"+
				" where model.chcId=:chcId " +
				" and " +
				" model.chcUpdateDatetime=:chcUpdateDatetime";
				/*"model.chcCreateId=:chcCreateId," +
				"model.chcCreateBy=:chcCreateBy,model.chcDueId=:chcDueId," +
				"model.chcDueTo=:chcDueTo,model.chcDueDate=:chcDueDate,model.chcStatus=:chcStatus," +*/
			Query query = this.getSession().createQuery(queryString);
			
			
			query.setParameter("chcSource", salChanceObject.getChcSource());
			query.setParameter("chcCustName", salChanceObject.getChcCustName());
			query.setParameter("chcRate", salChanceObject.getChcRate());
			query.setParameter("chcTitle", salChanceObject.getChcTitle());
			query.setParameter("chcLinkman", salChanceObject.getChcLinkman());
			query.setParameter("chcTel", salChanceObject.getChcTel());
			query.setParameter("chcDesc", salChanceObject.getChcDesc());
			query.setParameter("CurplaUpdateDatetime", new Timestamp(System.currentTimeMillis()));
			query.setParameter("chcId", salChanceObject.getChcId());
			query.setParameter("chcUpdateDatetime",salChanceObject.getChcUpdateDatetime());
			
			
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#delete(com.crm.entity.SalChance)
	 */
	public void delete(SalChance persistentInstance) {
		log.debug("deleting SalChance instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#delete(com.crm.entity.SalChance)
	 */
	public boolean delete(Long chcId) {
		try {
			String queryString = "delete from SalChance model where model.chcId=:chcId";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("chcId", chcId);
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findById(java.lang.Long)
	 */
	public SalChance findById(java.lang.Long id) {
		log.debug("getting SalChance instance with id: " + id);
		try {
			SalChance instance = (SalChance) getHibernateTemplate().get(
					"com.crm.entity.SalChance", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByExample(com.crm.entity.SalChance)
	 */
	public List findByExample(SalChance instance) {
		log.debug("finding SalChance instance by example");
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

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SalChance instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SalChance as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcSource(java.lang.Object)
	 */
	public List findByChcSource(Object chcSource) {
		return findByProperty(CHC_SOURCE, chcSource);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcCustName(java.lang.Object)
	 */
	public List findByChcCustName(Object chcCustName) {
		return findByProperty(CHC_CUST_NAME, chcCustName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcTitle(java.lang.Object)
	 */
	public List findByChcTitle(Object chcTitle) {
		return findByProperty(CHC_TITLE, chcTitle);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcRate(java.lang.Object)
	 */
	public List findByChcRate(Object chcRate) {
		return findByProperty(CHC_RATE, chcRate);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcLinkman(java.lang.Object)
	 */
	public List findByChcLinkman(Object chcLinkman) {
		return findByProperty(CHC_LINKMAN, chcLinkman);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcTel(java.lang.Object)
	 */
	public List findByChcTel(Object chcTel) {
		return findByProperty(CHC_TEL, chcTel);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcDesc(java.lang.Object)
	 */
	public List findByChcDesc(Object chcDesc) {
		return findByProperty(CHC_DESC, chcDesc);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcCreateId(java.lang.Object)
	 */
	public List findByChcCreateId(Object chcCreateId) {
		return findByProperty(CHC_CREATE_ID, chcCreateId);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcCreateBy(java.lang.Object)
	 */
	public List findByChcCreateBy(Object chcCreateBy) {
		return findByProperty(CHC_CREATE_BY, chcCreateBy);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcDueId(java.lang.Object)
	 */
	public List findByChcDueId(Object chcDueId) {
		return findByProperty(CHC_DUE_ID, chcDueId);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcDueTo(java.lang.Object)
	 */
	public List findByChcDueTo(Object chcDueTo) {
		return findByProperty(CHC_DUE_TO, chcDueTo);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findByChcStatus(java.lang.Object)
	 */
	public List findByChcStatus(Object chcStatus) {
		return findByProperty(CHC_STATUS, chcStatus);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all SalChance instances");
		try {
			String queryString = "from SalChance";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#merge(com.crm.entity.SalChance)
	 */
	public SalChance merge(SalChance detachedInstance) {
		log.debug("merging SalChance instance");
		try {
			SalChance result = (SalChance) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#attachDirty(com.crm.entity.SalChance)
	 */
	public void attachDirty(SalChance instance) {
		log.debug("attaching dirty SalChance instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#attachClean(com.crm.entity.SalChance)
	 */
	public void attachClean(SalChance instance) {
		log.debug("attaching clean SalChance instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISalChanceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ISalChanceDAO) ctx.getBean("SalChanceDAO");
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findAll()
	 */
	public Long findPropertyCount(String custName,String chcTitle,String chcLinkman
			,int pageSize,int transmitPage,Long userRoleID,Long usrID,String chcStatus){
		log.debug("count() finding all SalChance instances");
		try {
			String queryString ="select count(model) from SalChance model where 1=1 ";
			Query query = findProperty(queryString,custName, chcTitle, chcLinkman,userRoleID,usrID,chcStatus);
			return  (Long)query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	private Query findProperty(String queryString,String custName, String chcTitle,
			String chcLinkman, Long userRoleID,Long usrID,String chcStatus) throws HibernateException,
			DataAccessResourceFailureException, IllegalStateException {
		//销售经理usrRoleId=2指派给客服经理usrRoleId=3
		// 状态：1--未指派；2--已指派；3--开发成功；4--终止开发。
		if (chcStatus.equalsIgnoreCase("true")) {
			queryString+=" and model.chcStatus = 1";
		}else{
			queryString+=" and model.chcStatus <> 1 ";
		} 
		
		if (userRoleID==3 && chcStatus.equalsIgnoreCase("true")) {
			//客服经理 没有指派
			queryString+=" and model.chcCreateId=:CreateId ";
		}else if (userRoleID==3 && chcStatus.equalsIgnoreCase("false")) {
			//客服经理 已经指派
			queryString+=" and model.chcDueId=:chcDueId";
		}else if(userRoleID==2){
			//销售经理
		}else {
			//没有访问权限
			queryString +=" and 1=2 ";
		}
		if (custName!=null && !custName.equals("")) {
			queryString+=" and model.chcCustName like :chcCustName ";
		}
		if (chcTitle!=null && !chcTitle.equals("")) {
			queryString+=" and model.chcTitle like :chcTitle ";
		}
		if (chcLinkman!=null && !chcLinkman.equals("")) {
			queryString+=" and model.chcLinkman like :chcLinkman ";
		}
		
		Query query = this.getSession().createQuery(queryString);
		
		if (userRoleID==3 && chcStatus.equalsIgnoreCase("false")) {
			query.setParameter("chcDueId", usrID);
		}
		if (userRoleID==3 && chcStatus.equalsIgnoreCase("true")) {
			query.setParameter("CreateId", usrID);
		}
		if (custName!=null && !custName.equals("")) {
			query.setParameter("chcCustName", "%"+custName+"%");
		}
		if (chcTitle!=null && !chcTitle.equals("")) {
			query.setParameter("chcTitle", "%"+chcTitle+"%");
		}
		if (chcLinkman!=null && !chcLinkman.equals("")) {
			
			query.setParameter("chcLinkman", "%"+chcLinkman+"%");
		}
		return query;
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalChanceDAO#findPropertyList
	 */
	public List findPropertyList(String custName,String chcTitle,String chcLinkman
			,int pageSize,int transmitPage,Long userRoleID,Long usrID,String chcStatus){
		log.debug("finding all SalChance instances");
		try {
			
			String queryString ="from SalChance model where 1=1 ";
			Query query = findProperty(queryString,custName, chcTitle, chcLinkman,userRoleID,usrID,chcStatus);
			query.setMaxResults(pageSize);
			query.setFirstResult((transmitPage-1)*pageSize);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	

}