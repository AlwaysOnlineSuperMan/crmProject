package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ICstLinkmanDAO;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstLinkman;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstLinkman entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.CstLinkman
 * @author MyEclipse Persistence Tools
 */

public class CstLinkmanDAO extends HibernateDaoSupport implements ICstLinkmanDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CstLinkmanDAO.class);
	// property constants
	public static final String LKM_CUST_NAME = "lkmCustName";
	public static final String LKM_NAME = "lkmName";
	public static final String LKM_SEX = "lkmSex";
	public static final String LKM_POSTION = "lkmPostion";
	public static final String LKM_TEL = "lkmTel";
	public static final String LKM_MOBILE = "lkmMobile";
	public static final String LKM_MEMO = "lkmMemo";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#save(com.crm.entity.CstLinkman)
	 */
	public void save(CstLinkman transientInstance) {
		log.debug("saving CstLinkman instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void saveOrUpdate(CstLinkman transientInstance) {
		log.debug("saving CstLinkman instance");
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
	
	public void update(CstCustomer transientInstance) {
		log.debug("saving CstCustomer instance");
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
	 * @see com.crm.dao.ICstLinkmanDAO#delete(com.crm.entity.CstLinkman)
	 */
	public void delete(CstLinkman persistentInstance) {
		log.debug("deleting CstLinkman instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public boolean delById(Long lkmId) {
		try {
			String queryString = "delete from CstLinkman model where model.lkmId=:lkmId";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("lkmId", lkmId);
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findById(java.lang.Long)
	 */
	public CstLinkman findById(java.lang.Long id) {
		log.debug("getting CstLinkman instance with id: " + id);
		try {
			CstLinkman instance = (CstLinkman) getHibernateTemplate().get(
					"com.crm.entity.CstLinkman", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List<CstLinkman> findByNo(String custNo) {
		try {
			String queryString = "from CstLinkman model where model.cstCustomer.custNo=:custNo";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("custNo", custNo);
			List list = query.list();
			return list;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findByExample(com.crm.entity.CstLinkman)
	 */
	public List findByExample(CstLinkman instance) {
		log.debug("finding CstLinkman instance by example");
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
	 * @see com.crm.dao.ICstLinkmanDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CstLinkman instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstLinkman as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findByLkmCustName(java.lang.Object)
	 */
	public List findByLkmCustName(Object lkmCustName) {
		return findByProperty(LKM_CUST_NAME, lkmCustName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findByLkmName(java.lang.Object)
	 */
	public List findByLkmName(Object lkmName) {
		return findByProperty(LKM_NAME, lkmName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findByLkmSex(java.lang.Object)
	 */
	public List findByLkmSex(Object lkmSex) {
		return findByProperty(LKM_SEX, lkmSex);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findByLkmPostion(java.lang.Object)
	 */
	public List findByLkmPostion(Object lkmPostion) {
		return findByProperty(LKM_POSTION, lkmPostion);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findByLkmTel(java.lang.Object)
	 */
	public List findByLkmTel(Object lkmTel) {
		return findByProperty(LKM_TEL, lkmTel);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findByLkmMobile(java.lang.Object)
	 */
	public List findByLkmMobile(Object lkmMobile) {
		return findByProperty(LKM_MOBILE, lkmMobile);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findByLkmMemo(java.lang.Object)
	 */
	public List findByLkmMemo(Object lkmMemo) {
		return findByProperty(LKM_MEMO, lkmMemo);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all CstLinkman instances");
		try {
			String queryString = "from CstLinkman";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#merge(com.crm.entity.CstLinkman)
	 */
	public CstLinkman merge(CstLinkman detachedInstance) {
		log.debug("merging CstLinkman instance");
		try {
			CstLinkman result = (CstLinkman) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#attachDirty(com.crm.entity.CstLinkman)
	 */
	public void attachDirty(CstLinkman instance) {
		log.debug("attaching dirty CstLinkman instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstLinkmanDAO#attachClean(com.crm.entity.CstLinkman)
	 */
	public void attachClean(CstLinkman instance) {
		log.debug("attaching clean CstLinkman instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ICstLinkmanDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ICstLinkmanDAO) ctx.getBean("CstLinkmanDAO");
	}

	public void update(CstLinkman transientInstance) {
		log.debug("saving CstCustomer instance");
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