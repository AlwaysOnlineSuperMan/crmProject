package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ICstLostDAO;
import com.crm.entity.CstLinkman;
import com.crm.entity.CstLost;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstLost entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.CstLost
 * @author MyEclipse Persistence Tools
 */

public class CstLostDAO extends HibernateDaoSupport implements ICstLostDAO {
	private static final Logger log = LoggerFactory.getLogger(CstLostDAO.class);
	// property constants
	public static final String LST_CUST_NAME = "lstCustName";
	public static final String LST_CUST_MANAGER_ID = "lstCustManagerId";
	public static final String LST_CUST_MANAGER_NAME = "lstCustManagerName";
	public static final String LST_DELAY = "lstDelay";
	public static final String LST_REASON = "lstReason";
	public static final String LST_STATUS = "lstStatus";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#save(com.crm.entity.CstLost)
	 */
	public void save(CstLost transientInstance) {
		log.debug("saving CstLost instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#delete(com.crm.entity.CstLost)
	 */
	public void delete(CstLost persistentInstance) {
		log.debug("deleting CstLost instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#findById(java.lang.Long)
	 */
	public CstLost findById(java.lang.Long id) {
		log.debug("getting CstLost instance with id: " + id);
		try {
			CstLost instance = (CstLost) getHibernateTemplate().get(
					"com.crm.entity.CstLost", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#findByExample(com.crm.entity.CstLost)
	 */
	public List findByExample(CstLost instance) {
		log.debug("finding CstLost instance by example");
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
	 * @see com.crm.dao.ICstLostDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CstLost instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstLost as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#findByLstCustName(java.lang.Object)
	 */
	public List findByLstCustName(Object lstCustName) {
		return findByProperty(LST_CUST_NAME, lstCustName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#findByLstCustManagerId(java.lang.Object)
	 */
	public List findByLstCustManagerId(Object lstCustManagerId) {
		return findByProperty(LST_CUST_MANAGER_ID, lstCustManagerId);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#findByLstCustManagerName(java.lang.Object)
	 */
	public List findByLstCustManagerName(Object lstCustManagerName) {
		return findByProperty(LST_CUST_MANAGER_NAME, lstCustManagerName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#findByLstDelay(java.lang.Object)
	 */
	public List findByLstDelay(Object lstDelay) {
		return findByProperty(LST_DELAY, lstDelay);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#findByLstReason(java.lang.Object)
	 */
	public List findByLstReason(Object lstReason) {
		return findByProperty(LST_REASON, lstReason);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#findByLstStatus(java.lang.Object)
	 */
	public List findByLstStatus(Object lstStatus) {
		return findByProperty(LST_STATUS, lstStatus);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all CstLost instances");
		try {
			String queryString = "from CstLost";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#merge(com.crm.entity.CstLost)
	 */
	public CstLost merge(CstLost detachedInstance) {
		log.debug("merging CstLost instance");
		try {
			CstLost result = (CstLost) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#attachDirty(com.crm.entity.CstLost)
	 */
	public void attachDirty(CstLost instance) {
		log.debug("attaching dirty CstLost instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public void saveOrUpdate(CstLost transientInstance) {
		log.debug("saving CstLost instance");
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
	
	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLostDAO#attachClean(com.crm.entity.CstLost)
	 */
	public void attachClean(CstLost instance) {
		log.debug("attaching clean CstLost instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ICstLostDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ICstLostDAO) ctx.getBean("CstLostDAO");
	}
}