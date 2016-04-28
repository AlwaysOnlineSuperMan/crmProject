package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.IStorageDAO;
import com.crm.entity.Product;
import com.crm.entity.Storage;
import com.crm.util.PageModel;

/**
 * A data access object (DAO) providing persistence and search support for
 * Storage entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.Storage
 * @author MyEclipse Persistence Tools
 */

public class StorageDAO extends HibernateDaoSupport implements IStorageDAO {
	private static final Logger log = LoggerFactory.getLogger(StorageDAO.class);
	// property constants
	public static final String STK_PROD_ID = "stkProdId";
	public static final String STK_WAREHOUSE = "stkWarehouse";
	public static final String STK_WARE = "stkWare";
	public static final String STK_COUNT = "stkCount";
	public static final String STK_MEMO = "stkMemo";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#save(com.crm.entity.Storage)
	 */
	public void save(Storage transientInstance) {
		log.debug("saving Storage instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#delete(com.crm.entity.Storage)
	 */
	public void delete(Storage persistentInstance) {
		log.debug("deleting Storage instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#findById(java.lang.Long)
	 */
	public Storage findById(java.lang.Long id) {
		log.debug("getting Storage instance with id: " + id);
		try {
			Storage instance = (Storage) getHibernateTemplate().get(
					"com.crm.entity.Storage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#findByExample(com.crm.entity.Storage)
	 */
	public List findByExample(Storage instance) {
		log.debug("finding Storage instance by example");
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
	 * @see com.crm.dao.IStorageDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Storage instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Storage as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#findByStkProdId(java.lang.Object)
	 */
	public List findByStkProdId(Object stkProdId) {
		return findByProperty(STK_PROD_ID, stkProdId);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#findByStkWarehouse(java.lang.Object)
	 */
	public List findByStkWarehouse(Object stkWarehouse) {
		return findByProperty(STK_WAREHOUSE, stkWarehouse);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#findByStkWare(java.lang.Object)
	 */
	public List findByStkWare(Object stkWare) {
		return findByProperty(STK_WARE, stkWare);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#findByStkCount(java.lang.Object)
	 */
	public List findByStkCount(Object stkCount) {
		return findByProperty(STK_COUNT, stkCount);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#findByStkMemo(java.lang.Object)
	 */
	public List findByStkMemo(Object stkMemo) {
		return findByProperty(STK_MEMO, stkMemo);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Storage instances");
		try {
			String queryString = "from Storage";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#merge(com.crm.entity.Storage)
	 */
	public Storage merge(Storage detachedInstance) {
		log.debug("merging Storage instance");
		try {
			Storage result = (Storage) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#attachDirty(com.crm.entity.Storage)
	 */
	public void attachDirty(Storage instance) {
		log.debug("attaching dirty Storage instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IStorageDAO#attachClean(com.crm.entity.Storage)
	 */
	public void attachClean(Storage instance) {
		log.debug("attaching clean Storage instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IStorageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IStorageDAO) ctx.getBean("StorageDAO");
	}
	public PageModel<Storage> getPageModel(String[] strs,Storage storage,int page,int pageSize){
		PageModel<Storage> pageModel = new PageModel<Storage>();
		try {
			String stringQuery="from Storage model where 1=1 ";
			int rows = getTotalRowsByChoose(strs,storage);
			pageModel.setAllRecord(rows);
			Query query  =  setParameter(strs,stringQuery,storage);
			query.setMaxResults(pageSize);
			query.setFirstResult((page-1)*pageSize);
			List<Storage> list = query.list();
			pageModel.setResultList(list);
			pageModel.setCurrPage(page);
			pageModel.setMaxRecord(pageSize);
			return pageModel;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
			}
		}
		public int getTotalRowsByChoose(String[] strs,Storage storage){
			log.debug("finding all Storage instances");
			try {
				String queryString="select count(model) from Storage model where 1=1 ";
				Query query  =  setParameter(strs,queryString,storage);
				Object object = query.uniqueResult();
				return Integer.parseInt(object.toString());
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}
		private Query setParameter(String[] strs,String queryString,Storage storage){
			
			if(storage.getStkWarehouse()!=null&&!storage.getStkWarehouse().equals("")){
				queryString+=" and model.stkWarehouse like:stkWarehouse ";
			}
			System.out.println(queryString);
			Query query = this.getSession().createQuery(queryString);
			if(storage.getStkWarehouse()!=null&&!storage.getStkWarehouse().equals("")){
				query.setParameter("stkWarehouse", "%"+storage.getStkWarehouse()+"%");
			}
		
			return query;
		}
}