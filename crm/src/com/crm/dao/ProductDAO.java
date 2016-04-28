package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.IProductDAO;
import com.crm.entity.Product;
import com.crm.entity.SysUser;
import com.crm.util.PageModel;

/**
 * A data access object (DAO) providing persistence and search support for
 * Product entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.Product
 * @author MyEclipse Persistence Tools
 */

public class ProductDAO extends HibernateDaoSupport implements IProductDAO {
	private static final Logger log = LoggerFactory.getLogger(ProductDAO.class);
	// property constants
	public static final String PROD_NAME = "prodName";
	public static final String PROD_TYPE = "prodType";
	public static final String PROD_BATCH = "prodBatch";
	public static final String PROD_UNIT = "prodUnit";
	public static final String PROD_PRICE = "prodPrice";
	public static final String PROD_MEMO = "prodMemo";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#save(com.crm.entity.Product)
	 */
	public void save(Product transientInstance) {
		log.debug("saving Product instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#delete(com.crm.entity.Product)
	 */
	public void delete(Product persistentInstance) {
		log.debug("deleting Product instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#findById(java.lang.Long)
	 */
	public Product findById(java.lang.Long id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = (Product) getHibernateTemplate().get(
					"com.crm.entity.Product", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#findByExample(com.crm.entity.Product)
	 */
	public List findByExample(Product instance) {
		log.debug("finding Product instance by example");
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
	 * @see com.crm.dao.IProductDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Product as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#findByProdName(java.lang.Object)
	 */
	public List findByProdName(Object prodName) {
		return findByProperty(PROD_NAME, prodName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#findByProdType(java.lang.Object)
	 */
	public List findByProdType(Object prodType) {
		return findByProperty(PROD_TYPE, prodType);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#findByProdBatch(java.lang.Object)
	 */
	public List findByProdBatch(Object prodBatch) {
		return findByProperty(PROD_BATCH, prodBatch);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#findByProdUnit(java.lang.Object)
	 */
	public List findByProdUnit(Object prodUnit) {
		return findByProperty(PROD_UNIT, prodUnit);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#findByProdPrice(java.lang.Object)
	 */
	public List findByProdPrice(Object prodPrice) {
		return findByProperty(PROD_PRICE, prodPrice);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#findByProdMemo(java.lang.Object)
	 */
	public List findByProdMemo(Object prodMemo) {
		return findByProperty(PROD_MEMO, prodMemo);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Product instances");
		try {
			String queryString = "from Product";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#merge(com.crm.entity.Product)
	 */
	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = (Product) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#attachDirty(com.crm.entity.Product)
	 */
	public void attachDirty(Product instance) {
		log.debug("attaching dirty Product instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IProductDAO#attachClean(com.crm.entity.Product)
	 */
	public void attachClean(Product instance) {
		log.debug("attaching clean Product instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IProductDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IProductDAO) ctx.getBean("ProductDAO");
	}
	
	
	
	public PageModel<Product> getPageModel(Product product,int page,int pageSize){
		PageModel<Product> pageModel = new PageModel<Product>();
		try {
			String stringQuery="from Product su where 1=1 ";
			int rows = getTotalRowsByChoose(product);
			pageModel.setAllRecord(rows);
			Query query  =  setParameter(stringQuery,product);
			query.setMaxResults(pageSize);
			query.setFirstResult((page-1)*pageSize);
			List<Product> list = query.list();
			pageModel.setResultList(list);
			pageModel.setCurrPage(page);
			pageModel.setMaxRecord(pageSize);
			return pageModel;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
			}
		}
		public int getTotalRowsByChoose(Product product){
			log.debug("finding all SalChance instances");
			try {
				String queryString="select count(su) from Product su where 1=1 ";
				Query query  =  setParameter(queryString,product);
				Object object = query.uniqueResult();
				return Integer.parseInt(object.toString());
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}
		private Query setParameter(String queryString,Product product){
			if(product.getProdName()!=null&&!product.getProdName().equals("")){
				queryString+=" and su.prodName like :prodName";
			}
			if(product.getProdType()!=null&&!product.getProdType().equals("")){
				queryString+=" and su.prodType like :prodType";
			}
			if(product.getProdBatch()!=null&&!product.getProdBatch().equals("")){
				queryString+=" and su.prodBatch like :prodBatch";
			}
		
			Query query = this.getSession().createQuery(queryString);
			if(product.getProdName()!=null&&!product.getProdName().equals("")){
				query.setParameter("prodName", "%"+product.getProdName()+"%");
			}
			if(product.getProdType()!=null&&!product.getProdType().equals("")){
				query.setParameter("prodType", "%"+product.getProdType()+"%");
			}
			if(product.getProdBatch()!=null&&!product.getProdBatch().equals("")){
				query.setParameter("prodBatch", "%"+product.getProdBatch()+"%");
			}
		
			return query;
		}
		public String[] getProductByName(String productName){
			log.debug("attaching clean Product instance");
			/*try {*/
				Query query = this.getSession().createQuery("select model.prodId from Product model where model.prodName like :prodName ");
				query.setParameter("prodName", "%"+productName+"%");
				String[] strs=(String[]) query.uniqueResult();
				return strs;
			/*} catch (RuntimeException re) {
				log.error("attach failed", re);
				throw re;
			}*/
		}
	
}