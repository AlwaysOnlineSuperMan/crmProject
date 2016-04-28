package com.crm.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ISysRightDAO;
import com.crm.entity.SysRight;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysRight entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.SysRight
 * @author MyEclipse Persistence Tools
 */

public class SysRightDAO extends HibernateDaoSupport implements ISysRightDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysRightDAO.class);
	// property constants
	public static final String RIGHT_PARENT_CODE = "rightParentCode";
	public static final String RIGHT_TYPE = "rightType";
	public static final String RIGHT_TEXT = "rightText";
	public static final String RIGHT_URL = "rightUrl";
	public static final String RIGHT_TIP = "rightTip";
	public static final String RIGHT_UPDATE_DATETIME = "rightUpdateDatetime";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#save(com.crm.entity.SysRight)
	 */
	public void save(SysRight transientInstance) {
		log.debug("saving SysRight instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#delete(com.crm.entity.SysRight)
	 */
	public void delete(SysRight persistentInstance) {
		log.debug("deleting SysRight instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#findById(java.lang.String)
	 */
	public SysRight findById(java.lang.String id) {
		log.debug("getting SysRight instance with id: " + id);
		try {
			SysRight instance = (SysRight) getHibernateTemplate().get(
					"com.crm.entity.SysRight", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#findByExample(com.crm.entity.SysRight)
	 */
	public List findByExample(SysRight instance) {
		log.debug("finding SysRight instance by example");
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
	 * @see com.crm.dao.ISysRightDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SysRight instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysRight as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#findByRightParentCode(java.lang.Object)
	 */
	public List findByRightParentCode(Object rightParentCode) {
		return findByProperty(RIGHT_PARENT_CODE, rightParentCode);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#findByRightType(java.lang.Object)
	 */
	public List findByRightType(Object rightType) {
		return findByProperty(RIGHT_TYPE, rightType);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#findByRightText(java.lang.Object)
	 */
	public List findByRightText(Object rightText) {
		return findByProperty(RIGHT_TEXT, rightText);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#findByRightUrl(java.lang.Object)
	 */
	public List findByRightUrl(Object rightUrl) {
		return findByProperty(RIGHT_URL, rightUrl);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#findByRightTip(java.lang.Object)
	 */
	public List findByRightTip(Object rightTip) {
		return findByProperty(RIGHT_TIP, rightTip);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#findByRightUpdateDatetime(java.lang.Object)
	 */
	public List findByRightUpdateDatetime(Object rightUpdateDatetime) {
		return findByProperty(RIGHT_UPDATE_DATETIME, rightUpdateDatetime);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all SysRight instances");
		try {
			String queryString = "from SysRight";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#merge(com.crm.entity.SysRight)
	 */
	public SysRight merge(SysRight detachedInstance) {
		log.debug("merging SysRight instance");
		try {
			SysRight result = (SysRight) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#attachDirty(com.crm.entity.SysRight)
	 */
	public void attachDirty(SysRight instance) {
		log.debug("attaching dirty SysRight instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRightDAO#attachClean(com.crm.entity.SysRight)
	 */
	public void attachClean(SysRight instance) {
		log.debug("attaching clean SysRight instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISysRightDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ISysRightDAO) ctx.getBean("SysRightDAO");
	}
}