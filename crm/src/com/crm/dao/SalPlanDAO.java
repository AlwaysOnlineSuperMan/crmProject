package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ISalPlanDAO;
import com.crm.entity.SalPlan;

/**
 * A data access object (DAO) providing persistence and search support for
 * SalPlan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.SalPlan
 * @author MyEclipse Persistence Tools
 */

public class SalPlanDAO extends HibernateDaoSupport implements ISalPlanDAO {
	private static final Logger log = LoggerFactory.getLogger(SalPlanDAO.class);
	// property constants
	public static final String PLA_TODO = "plaTodo";
	public static final String PLA_RESULT = "plaResult";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#save(com.crm.entity.SalPlan)
	 */
	public void save(SalPlan transientInstance) {
		log.debug("saving SalPlan instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#save(com.crm.entity.SalPlan)
	 */
	public boolean addSave(SalPlan salPlan) {
		log.debug("saving SalPlan instance");
		try {
			/*String queryString = "insert into SalPlan(plaDate,plaTodo,salChance.chcId,plaUpdateDatetime)" +
					"values(:plaDate,:plaTodo,:chcId,:plaUpdateDatetime)";
			Query query = this.getSession().createQuery(queryString);
			query.executeUpdate();
			query.setParameter("plaDate", salPlan.getPlaDate());
			query.setParameter("plaTodo", salPlan.getPlaTodo());
			query.setParameter("chcId", salPlan.getChcId());
			query.setParameter("plaUpdateDatetime", new Timestamp(System.currentTimeMillis()));
			return query.executeUpdate()>0;*/
			return false;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#save(com.crm.entity.SalPlan)
	 */
	public boolean updateSalPlan(SalPlan salPlan) {
		log.debug("saving SalPlan instance");
		try {
			String queryString = "update SalPlan model set model.plaResult=:plaResult,model.plaUpdateDatetime=:plaUpdateDatetime where model.plaId=:plaId";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("plaResult", salPlan.getPlaResult());
			query.setParameter("plaUpdateDatetime", new Timestamp(System.currentTimeMillis()));
			query.setParameter("plaId", salPlan.getPlaId());
			query.executeUpdate();
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#delete(com.crm.entity.SalPlan)
	 */
	public void delete(SalPlan persistentInstance) {
		log.debug("deleting SalPlan instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#findById(java.lang.Long)
	 */
	public SalPlan findById(java.lang.Long id) {
		log.debug("getting SalPlan instance with id: " + id);
		try {
			SalPlan instance = (SalPlan) getHibernateTemplate().get(
					"com.crm.entity.SalPlan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#findById(java.lang.Long)
	 */
	public List<SalPlan> getById(Long chcId) {
		try {
			String queryString ="from SalPlan model where model.salChance.chcId=:chcId";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("chcId", chcId);
			return query.list();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#findByExample(com.crm.entity.SalPlan)
	 */
	public List findByExample(SalPlan instance) {
		log.debug("finding SalPlan instance by example");
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
	 * @see com.crm.dao.ISalPlanDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SalPlan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SalPlan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString,value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public void findByProperty(Long userRoleID,	String custName,String chcTitle ,String chcLinkman,	int pageSize, int transmitPage) {
		/*log.debug("finding SalPlan instance with property: " + userRoleID
				+ ", value: " + value);*/
		try {
		
			/*String queryString = "from SalPlan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);*/
			//String query = HibernateSessionFcatory
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#findByPlaTodo(java.lang.Object)
	 */
	public List findByPlaTodo(Object plaTodo) {
		return findByProperty(PLA_TODO, plaTodo);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#findByPlaResult(java.lang.Object)
	 */
	public List findByPlaResult(Object plaResult) {
		return findByProperty(PLA_RESULT, plaResult);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all SalPlan instances");
		try {
			String queryString = "from SalPlan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#merge(com.crm.entity.SalPlan)
	 */
	public SalPlan merge(SalPlan detachedInstance) {
		log.debug("merging SalPlan instance");
		try {
			SalPlan result = (SalPlan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#attachDirty(com.crm.entity.SalPlan)
	 */
	public void attachDirty(SalPlan instance) {
		log.debug("attaching dirty SalPlan instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISalPlanDAO#attachClean(com.crm.entity.SalPlan)
	 */
	public void attachClean(SalPlan instance) {
		log.debug("attaching clean SalPlan instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISalPlanDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ISalPlanDAO) ctx.getBean("SalPlanDAO");
	}
}