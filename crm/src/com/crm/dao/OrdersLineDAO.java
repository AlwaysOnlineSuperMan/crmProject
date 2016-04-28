package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.IOrdersLineDAO;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstLinkman;
import com.crm.entity.Orders;
import com.crm.entity.OrdersLine;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrdersLine entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.OrdersLine
 * @author MyEclipse Persistence Tools
 */

public class OrdersLineDAO extends HibernateDaoSupport implements IOrdersLineDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrdersLineDAO.class);
	// property constants
	public static final String ODD_ORDER_ID = "oddOrderId";
	public static final String ODD_PROD_ID = "oddProdId";
	public static final String ODD_COUNT = "oddCount";
	public static final String ODD_UNIT = "oddUnit";
	public static final String ODD_PRICE = "oddPrice";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#save(com.crm.entity.OrdersLine)
	 */
	public void save(OrdersLine transientInstance) {
		log.debug("saving OrdersLine instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#delete(com.crm.entity.OrdersLine)
	 */
	public void delete(OrdersLine persistentInstance) {
		log.debug("deleting OrdersLine instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#findById(java.lang.Long)
	 */
	public OrdersLine findById(java.lang.Long id) {
		log.debug("getting OrdersLine instance with id: " + id);
		try {
			OrdersLine instance = (OrdersLine) getHibernateTemplate().get(
					"com.crm.entity.OrdersLine", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#findByExample(com.crm.entity.OrdersLine)
	 */
	public List findByExample(OrdersLine instance) {
		log.debug("finding OrdersLine instance by example");
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
	 * @see com.crm.dao.IOrdersLineDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding OrdersLine instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrdersLine as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#findByOddOrderId(java.lang.Object)
	 */
	public List findByOddOrderId(Object oddOrderId) {
		return findByProperty(ODD_ORDER_ID, oddOrderId);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#findByOddProdId(java.lang.Object)
	 */
	public List findByOddProdId(Object oddProdId) {
		return findByProperty(ODD_PROD_ID, oddProdId);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#findByOddCount(java.lang.Object)
	 */
	public List findByOddCount(Object oddCount) {
		return findByProperty(ODD_COUNT, oddCount);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#findByOddUnit(java.lang.Object)
	 */
	public List findByOddUnit(Object oddUnit) {
		return findByProperty(ODD_UNIT, oddUnit);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#findByOddPrice(java.lang.Object)
	 */
	public List findByOddPrice(Object oddPrice) {
		return findByProperty(ODD_PRICE, oddPrice);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all OrdersLine instances");
		try {
			String queryString = "from OrdersLine";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#merge(com.crm.entity.OrdersLine)
	 */
	public OrdersLine merge(OrdersLine detachedInstance) {
		log.debug("merging OrdersLine instance");
		try {
			OrdersLine result = (OrdersLine) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#attachDirty(com.crm.entity.OrdersLine)
	 */
	public void attachDirty(OrdersLine instance) {
		log.debug("attaching dirty OrdersLine instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersLineDAO#attachClean(com.crm.entity.OrdersLine)
	 */
	public void attachClean(OrdersLine instance) {
		log.debug("attaching clean OrdersLine instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IOrdersLineDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IOrdersLineDAO) ctx.getBean("OrdersLineDAO");
	}
}