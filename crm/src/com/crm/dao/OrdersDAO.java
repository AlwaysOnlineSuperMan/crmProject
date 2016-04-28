package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.jms.Session;

import org.hibernate.LockMode;

import org.hibernate.Query;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.IOrdersDAO;
import com.crm.entity.CstLinkman;
import com.crm.entity.Orders;
import com.crm.entity.OrdersLine;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orders entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.Orders
 * @author MyEclipse Persistence Tools
 */

public class OrdersDAO extends HibernateDaoSupport implements IOrdersDAO {
	private static final Logger log = LoggerFactory.getLogger(OrdersDAO.class);
	// property constants
	public static final String ODR_CUSTOMER = "odrCustomer";
	public static final String ODR_ADDR = "odrAddr";
	public static final String ODR_STATUS = "odrStatus";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#save(com.crm.entity.Orders)
	 */
	public void save(Orders transientInstance) {
		log.debug("saving Orders instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#delete(com.crm.entity.Orders)
	 */
	public void delete(Orders persistentInstance) {
		log.debug("deleting Orders instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#findById(java.lang.Long)
	 */
	public Orders findById(java.lang.Long id) {
		log.debug("getting Orders instance with id: " + id);
		try {
			Orders instance = (Orders) getHibernateTemplate().get(
					"com.crm.entity.Orders", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List<Orders> findByName(String custName) {
		try {
			String queryString = "from Orders model where model.odrCustomer=:custName";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("custName", custName);
			List list = query.list();
			return list;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#findByExample(com.crm.entity.Orders)
	 */
	public List findByExample(Orders instance) {
		log.debug("finding Orders instance by example");
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
	 * @see com.crm.dao.IOrdersDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Orders instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orders as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#findByOdrCustomer(java.lang.Object)
	 */
	public List findByOdrCustomer(Object odrCustomer) {
		return findByProperty(ODR_CUSTOMER, odrCustomer);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#findByOdrAddr(java.lang.Object)
	 */
	public List findByOdrAddr(Object odrAddr) {
		return findByProperty(ODR_ADDR, odrAddr);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#findByOdrStatus(java.lang.Object)
	 */
	public List findByOdrStatus(Object odrStatus) {
		return findByProperty(ODR_STATUS, odrStatus);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Orders instances");
		try {
			String queryString = "from Orders";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public String[] Select() {
		log.debug("finding all Orders instances");
		try {
			String queryString = 
					"select odr_customer,sum(odd_count * odd_price) from dbo.orders o inner join dbo.orders_line ol on o.odr_id = ol.odd_id group by odr_customer";
			/*String  queryString ="select o.odrCustomer,sum(ol.oddCount*ol.oddPrice) " +
					" from Orders o inner join " +
					" OrdersLine ol" +
					" on o.odrId = ol.oddId " +
					" group by o.odrCustomer";
			Query query = this.getSession().createQuery(queryString);
			String[] str=query.getReturnAliases();*/
			SQLQuery sqlQuery = this.getSession().createSQLQuery(queryString);
			/*sqlQuery.addEntity("dbo.orders",Orders.class);
			sqlQuery.addEntity("dbo.orders_line",OrdersLine.class);*/
			String[] str = sqlQuery.getReturnAliases();
			for (int i = 0; i < str.length; i++) {
				String string = str[i];
				System.out.println("====="+string);
				
			}
			return str;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#merge(com.crm.entity.Orders)
	 */
	public Orders merge(Orders detachedInstance) {
		log.debug("merging Orders instance");
		try {
			Orders result = (Orders) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#attachDirty(com.crm.entity.Orders)
	 */
	public void attachDirty(Orders instance) {
		log.debug("attaching dirty Orders instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IOrdersDAO#attachClean(com.crm.entity.Orders)
	 */
	public void attachClean(Orders instance) {
		log.debug("attaching clean Orders instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
 public List list(){
	 try {
		List list=(List) getSession().createSQLQuery("select  a.odr_customer,sum(b.odd_price*b.odd_count) from dbo.orders a inner join dbo.orders_line b on a.odr_id=b.odd_order_id group by a.odr_customer").list();
		return list;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
 }
	public static IOrdersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IOrdersDAO) ctx.getBean("OrdersDAO");
	}


}