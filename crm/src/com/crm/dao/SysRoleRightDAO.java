package com.crm.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ISysRoleRightDAO;
import com.crm.entity.SysRoleRight;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysRoleRight entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.dao.SysRoleRightAction
 * @author MyEclipse Persistence Tools
 */

public class SysRoleRightDAO extends HibernateDaoSupport implements ISysRoleRightDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysRoleRightDAO.class);
	// property constants
	public static final String RF_UPDATE_DATETIME = "rfUpdateDatetime";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleRightDAO#save(com.crm.entity.SysRoleRight)
	 */
	public void save(SysRoleRight transientInstance) {
		log.debug("saving SysRoleRight instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleRightDAO#delete(com.crm.entity.SysRoleRight)
	 */
	public void delete(SysRoleRight persistentInstance) {
		log.debug("deleting SysRoleRight instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleRightDAO#findById(java.lang.Long)
	 */
	public SysRoleRight findById(java.lang.Long id) {
		log.debug("getting SysRoleRight instance with id: " + id);
		try {
			SysRoleRight instance = (SysRoleRight) getHibernateTemplate().get(
					"com.crm.entity.SysRoleRight", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleRightDAO#findByExample(com.crm.entity.SysRoleRight)
	 */
	public List findByExample(SysRoleRight instance) {
		log.debug("finding SysRoleRight instance by example");
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
	 * @see com.crm.dao.ISysRoleRightDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SysRoleRight instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SysRoleRight as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleRightDAO#findByRfUpdateDatetime(java.lang.Object)
	 */
	public List findByRfUpdateDatetime(Object rfUpdateDatetime) {
		return findByProperty(RF_UPDATE_DATETIME, rfUpdateDatetime);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleRightDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all SysRoleRight instances");
		try {
			String queryString = "from SysRoleRight";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleRightDAO#merge(com.crm.entity.SysRoleRight)
	 */
	public SysRoleRight merge(SysRoleRight detachedInstance) {
		log.debug("merging SysRoleRight instance");
		try {
			SysRoleRight result = (SysRoleRight) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleRightDAO#attachDirty(com.crm.entity.SysRoleRight)
	 */
	public void attachDirty(SysRoleRight instance) {
		log.debug("attaching dirty SysRoleRight instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleRightDAO#attachClean(com.crm.entity.SysRoleRight)
	 */
	public void attachClean(SysRoleRight instance) {
		log.debug("attaching clean SysRoleRight instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISysRoleRightDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ISysRoleRightDAO) ctx.getBean("SysRoleRightDAO");
	}
}