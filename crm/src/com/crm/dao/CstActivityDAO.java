package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ICstActivityDAO;
import com.crm.entity.CstActivity;
import com.crm.entity.CstLinkman;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstActivity entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.entity.CstActivityAction
 * @author MyEclipse Persistence Tools
 */

public class CstActivityDAO extends HibernateDaoSupport implements ICstActivityDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CstActivityDAO.class);
	// property constants
	public static final String ATV_CUST_NAME = "atvCustName";
	public static final String ATV_PLACE = "atvPlace";
	public static final String ATV_TITLE = "atvTitle";
	public static final String ATV_DESC = "atvDesc";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#save(com.crm.entity.CstActivity)
	 */
	public void save(CstActivity transientInstance) {
		log.debug("saving CstActivity instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#delete(com.crm.entity.CstActivity)
	 */
	public void delete(CstActivity persistentInstance) {
		log.debug("deleting CstActivity instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#findById(java.lang.Long)
	 */
	public boolean delById(Long atvId) {
		try {
			String queryString = "delete from CstActivity model where model.atvId=:atvId";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("atvId", atvId);
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public CstActivity findById(java.lang.Long id) {
		log.debug("getting CstActivity instance with id: " + id);
		try {
			CstActivity instance = (CstActivity) getHibernateTemplate().get(
					"com.crm.entity.CstActivity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List<CstActivity> findByNo(String custNo) {
		try {
			String queryString = "from CstActivity model where model.cstCustomer.custNo=:custNo";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("custNo", custNo);
			List list = query.list();
			return list;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#findByExample(com.crm.entity.CstActivity)
	 */
	public List findByExample(CstActivity instance) {
		log.debug("finding CstActivity instance by example");
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
	 * @see com.crm.entity.ICstActivityDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CstActivity instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstActivity as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#findByAtvCustName(java.lang.Object)
	 */
	public List findByAtvCustName(Object atvCustName) {
		return findByProperty(ATV_CUST_NAME, atvCustName);
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#findByAtvPlace(java.lang.Object)
	 */
	public List findByAtvPlace(Object atvPlace) {
		return findByProperty(ATV_PLACE, atvPlace);
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#findByAtvTitle(java.lang.Object)
	 */
	public List findByAtvTitle(Object atvTitle) {
		return findByProperty(ATV_TITLE, atvTitle);
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#findByAtvDesc(java.lang.Object)
	 */
	public List findByAtvDesc(Object atvDesc) {
		return findByProperty(ATV_DESC, atvDesc);
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all CstActivity instances");
		try {
			String queryString = "from CstActivity";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#merge(com.crm.entity.CstActivity)
	 */
	public CstActivity merge(CstActivity detachedInstance) {
		log.debug("merging CstActivity instance");
		try {
			CstActivity result = (CstActivity) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#attachDirty(com.crm.entity.CstActivity)
	 */
	public void attachDirty(CstActivity instance) {
		log.debug("attaching dirty CstActivity instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.entity.ICstActivityDAO#attachClean(com.crm.entity.CstActivity)
	 */
	public void attachClean(CstActivity instance) {
		log.debug("attaching clean CstActivity instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ICstActivityDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ICstActivityDAO) ctx.getBean("CstActivityDAO");
	}

	public void saveOrUpdate(CstActivity transientInstance) {
		log.debug("saving CstActivity instance");
		try {
			/*String queryString = "update CstCustomer model set  where model.chcId";
			Query query = this.getSession().createQuery(queryString);
			query.executeUpdate();*/
			
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
	}
}