package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ICstCustomerDAO;
import com.crm.entity.CstCustomer;
import com.crm.entity.SalChance;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstCustomer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.entity.CstCustomer
 * @author MyEclipse Persistence Tools
 */

public class CstCustomerDAO extends HibernateDaoSupport implements ICstCustomerDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CstCustomerDAO.class);
	// property constants
	public static final String CUST_NO = "custNo";
	public static final String CUST_NAME = "custName";
	public static final String CUST_REGION = "custRegion";
	public static final String CUST_MANAGER_ID = "custManagerId";
	public static final String CUST_MANAGER_NAME = "custManagerName";
	public static final String CUST_LEVEL = "custLevel";
	public static final String CUST_LEVEL_LABEL = "custLevelLabel";
	public static final String CUST_SATISFY = "custSatisfy";
	public static final String CUST_CREDIT = "custCredit";
	public static final String CUST_ADDR = "custAddr";
	public static final String CUST_ZIP = "custZip";
	public static final String CUST_TEL = "custTel";
	public static final String CUST_FAX = "custFax";
	public static final String CUST_WEBSITE = "custWebsite";
	public static final String CUST_LICENCE_NO = "custLicenceNo";
	public static final String CUST_CHIEFTAIN = "custChieftain";
	public static final String CUST_BANKROLL = "custBankroll";
	public static final String CUST_TURNOVER = "custTurnover";
	public static final String CUST_BANK = "custBank";
	public static final String CUST_BANK_ACCOUNT = "custBankAccount";
	public static final String CUST_LOCAL_TAX_NO = "custLocalTaxNo";
	public static final String CUST_NATIONAL_TAX_NO = "custNationalTaxNo";
	public static final String CUST_STATUS = "custStatus";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#save(com.crm.entity.CstCustomer)
	 */
	public void save(CstCustomer transientInstance) {
		log.debug("saving CstCustomer instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public List<CstCustomer> getcstcustname(java.lang.String custName) {
		log.debug("saving CstCustomer instance");
		try {
			String querySting = "from CstCustomer model where 1=1 ";
			if (custName!=null&& !custName.equalsIgnoreCase("")) {
				querySting+=" and model.custName like :custName ";
			}
			Query query = this.getSession().createQuery(querySting);
			if (custName!=null&& !custName.equalsIgnoreCase("")) {
				query.setParameter("custName","%"+custName+"%");
			}
			return query.list();
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void saveOrUpdate(CstCustomer transientInstance) {
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
	
	public String getNewCustNo() {
		log.debug("saving CstCustomer instance");
		try {
			String custNo=null;
			String queryString = "select max(model.custNo) from  CstCustomer model";
			Query query = this.getSession().createQuery(queryString);
			custNo = (String) query.uniqueResult();
			return custNo;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#delete(com.crm.entity.CstCustomer)
	 */
	public void delete(CstCustomer persistentInstance) {
		log.debug("deleting CstCustomer instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findById(java.lang.String)
	 */
	public CstCustomer findById(java.lang.String id) {
		log.debug("getting CstCustomer instance with id: " + id);
		try {
			/*CstCustomer instance = (CstCustomer) getHibernateTemplate().get(
					"com.crm.dao.CstCustomer", id);*/
			/*getHibernateTemplate().get(
			"com.crm.dao.CstCustomer", id);*/
			//return instance;
			CstCustomer cstCustomer =  new CstCustomer();
			String queryString = "from CstCustomer model where model.custNo=:ustNo";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("ustNo", id);
			cstCustomer =(CstCustomer) query.uniqueResult();
			return cstCustomer;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public CstCustomer findByNo(String custNo) {
		try {
			String queryString = "from CstCustomer model where model.custNo=:custNo";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("custNo", custNo);
			List list = query.list();
			CstCustomer cstCustomer= null;
			if (list.size()>0) {
				cstCustomer = (CstCustomer) list.get(0);
				}
			return cstCustomer;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByExample(com.crm.entity.CstCustomer)
	 */
	public List findByExample(CstCustomer instance) {
		log.debug("finding CstCustomer instance by example");
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
	 * @see com.crm.dao.ICstCustomerDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CstCustomer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstCustomer as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustName(java.lang.Object)
	 */
	public List findByCustName(Object custName) {
		return findByProperty(CUST_NAME, custName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustRegion(java.lang.Object)
	 */
	public List findByCustRegion(Object custRegion) {
		return findByProperty(CUST_REGION, custRegion);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustManagerId(java.lang.Object)
	 */
	public List findByCustManagerId(Object custManagerId) {
		return findByProperty(CUST_MANAGER_ID, custManagerId);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustManagerName(java.lang.Object)
	 */
	public List findByCustManagerName(Object custManagerName) {
		return findByProperty(CUST_MANAGER_NAME, custManagerName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustLevel(java.lang.Object)
	 */
	public List findByCustLevel(Object custLevel) {
		return findByProperty(CUST_LEVEL, custLevel);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustLevelLabel(java.lang.Object)
	 */
	public List findByCustLevelLabel(Object custLevelLabel) {
		return findByProperty(CUST_LEVEL_LABEL, custLevelLabel);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustSatisfy(java.lang.Object)
	 */
	public List findByCustSatisfy(Object custSatisfy) {
		return findByProperty(CUST_SATISFY, custSatisfy);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustCredit(java.lang.Object)
	 */
	public List findByCustCredit(Object custCredit) {
		return findByProperty(CUST_CREDIT, custCredit);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustAddr(java.lang.Object)
	 */
	public List findByCustAddr(Object custAddr) {
		return findByProperty(CUST_ADDR, custAddr);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustZip(java.lang.Object)
	 */
	public List findByCustZip(Object custZip) {
		return findByProperty(CUST_ZIP, custZip);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustTel(java.lang.Object)
	 */
	public List findByCustTel(Object custTel) {
		return findByProperty(CUST_TEL, custTel);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustFax(java.lang.Object)
	 */
	public List findByCustFax(Object custFax) {
		return findByProperty(CUST_FAX, custFax);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustWebsite(java.lang.Object)
	 */
	public List findByCustWebsite(Object custWebsite) {
		return findByProperty(CUST_WEBSITE, custWebsite);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustLicenceNo(java.lang.Object)
	 */
	public List findByCustLicenceNo(Object custLicenceNo) {
		return findByProperty(CUST_LICENCE_NO, custLicenceNo);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustChieftain(java.lang.Object)
	 */
	public List findByCustChieftain(Object custChieftain) {
		return findByProperty(CUST_CHIEFTAIN, custChieftain);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustBankroll(java.lang.Object)
	 */
	public List findByCustBankroll(Object custBankroll) {
		return findByProperty(CUST_BANKROLL, custBankroll);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustTurnover(java.lang.Object)
	 */
	public List findByCustTurnover(Object custTurnover) {
		return findByProperty(CUST_TURNOVER, custTurnover);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustBank(java.lang.Object)
	 */
	public List findByCustBank(Object custBank) {
		return findByProperty(CUST_BANK, custBank);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustBankAccount(java.lang.Object)
	 */
	public List findByCustBankAccount(Object custBankAccount) {
		return findByProperty(CUST_BANK_ACCOUNT, custBankAccount);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustLocalTaxNo(java.lang.Object)
	 */
	public List findByCustLocalTaxNo(Object custLocalTaxNo) {
		return findByProperty(CUST_LOCAL_TAX_NO, custLocalTaxNo);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustNationalTaxNo(java.lang.Object)
	 */
	public List findByCustNationalTaxNo(Object custNationalTaxNo) {
		return findByProperty(CUST_NATIONAL_TAX_NO, custNationalTaxNo);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findByCustStatus(java.lang.Object)
	 */
	public List findByCustStatus(Object custStatus) {
		return findByProperty(CUST_STATUS, custStatus);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#findAll()
	 */
	public List findAll() {
		///log.debug("finding all CstCustomer instances");
		try {
			String queryString = "from CstCustomer";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			//log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#merge(com.crm.entity.CstCustomer)
	 */
	public CstCustomer merge(CstCustomer detachedInstance) {
		log.debug("merging CstCustomer instance");
		try {
			CstCustomer result = (CstCustomer) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#attachDirty(com.crm.entity.CstCustomer)
	 */
	public void attachDirty(CstCustomer instance) {
		log.debug("attaching dirty CstCustomer instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ICstCustomerDAO#attachClean(com.crm.entity.CstCustomer)
	 */
	public void attachClean(CstCustomer instance) {
		log.debug("attaching clean CstCustomer instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ICstCustomerDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ICstCustomerDAO) ctx.getBean("CstCustomerDAO");
	}

	public void delByNo(String custNo) {
		System.out.println("dao");
			try {
				String queryString = "update CstCustomer  model set model.custStatus=3 where model.custNo=:custNo";
				Query query = this.getSession().createQuery(queryString);
				query.setParameter("custNo", custNo);
			} catch (RuntimeException re) {
				throw re;
			}	
	}

	public void OrUpdate(CstCustomer transientInstance) {
		// TODO Auto-generated method stub
		
	}
}