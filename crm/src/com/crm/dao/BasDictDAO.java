package com.crm.dao;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.IBasDictDAO;
import com.crm.entity.BasDict;
import com.crm.entity.SysRole;

import com.crm.entity.SysUser;
import com.crm.util.PageModel;

import com.sun.jmx.snmp.Timestamp;


/**
 * A data access object (DAO) providing persistence and search support for
 * BasDict entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.BasDict
 * @author MyEclipse Persistence Tools
 */

public class BasDictDAO extends HibernateDaoSupport implements IBasDictDAO  {
	private static final Logger log = LoggerFactory.getLogger(BasDictDAO.class);
	// property constants
	public static final String DICT_TYPE = "dictType";
	public static final String DICT_ITEM = "dictItem";
	public static final String DICT_VALUE = "dictValue";
	public static final String DICT_IS_EDITABLE = "dictIsEditable";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#save(com.crm.entity.BasDict)
	 */
	public void save(BasDict transientInstance) {
		log.debug("saving BasDict instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public boolean updateBasDict(BasDict basDict) {
		log.debug("saving BasDict instance");
		try {
			String queryString = "update BasDict model " +
					"set "+
					"model.dictUpdateDatetime=:CurDictUpdateDatetime" +
					" where model.dictId=:dictId and model.dictUpdateDatetime=:dictUpdateDatetime";
			if (basDict.getDictType()!=null&&!basDict.getDictType().equalsIgnoreCase("")) {
				queryString+=",model.dictType=:dictType";
			}
			if (basDict.getDictItem()!=null&&!basDict.getDictItem().equalsIgnoreCase("")) {
				queryString+=",model.dictItem=:dictItem";
			}
			if (basDict.getDictValue()!=null&&!basDict.getDictValue().equalsIgnoreCase("")) {
				queryString+=",model.dictValue=:dictValue";
			}
			if (basDict.getDictIsEditable()!=null) {
				queryString+=",model.dictIsEditable=:dictIsEditable";
			}
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("CurDictUpdateDatetime",new Timestamp(System.currentTimeMillis()));
			query.setParameter("dictUpdateDatetime", basDict.getDictUpdateDatetime());
			query.setParameter("dictId", basDict.getDictId());
			if (basDict.getDictType()!=null&&!basDict.getDictType().equalsIgnoreCase("")) {
				queryString+=",model.dictType=:dictType";
			}
			if (basDict.getDictItem()!=null&&!basDict.getDictItem().equalsIgnoreCase("")) {
				queryString+=",model.dictItem=:dictItem";
			}
			if (basDict.getDictValue()!=null&&!basDict.getDictValue().equalsIgnoreCase("")) {
				queryString+=",model.dictValue=:dictValue";
			}
			if (basDict.getDictIsEditable()!=null) {
				queryString+=",model.dictIsEditable=:dictIsEditable";
			}
			
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#delete(com.crm.entity.BasDict)
	 */
	public void delete(BasDict persistentInstance) {
		log.debug("deleting BasDict instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#findById(java.lang.Long)
	 */
	public BasDict findById(java.lang.Long id) {
		log.debug("getting BasDict instance with id: " + id);
		try {
			BasDict instance = (BasDict) getHibernateTemplate().get(
					"com.crm.entity.BasDict", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#findByExample(com.crm.entity.BasDict)
	 */
	@SuppressWarnings("unchecked")
	public List findByExample(BasDict instance) {
		log.debug("finding BasDict instance by example");
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
	 * @see com.crm.dao.IBasDictDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BasDict instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BasDict as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#findByDictType(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByDictType(Object dictType) {
		return findByProperty(DICT_TYPE, dictType);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#findByDictItem(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByDictItem(Object dictItem) {
		return findByProperty(DICT_ITEM, dictItem);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#findByDictValue(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByDictValue(Object dictValue) {
		return findByProperty(DICT_VALUE, dictValue);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#findByDictIsEditable(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByDictIsEditable(Object dictIsEditable) {
		return findByProperty(DICT_IS_EDITABLE, dictIsEditable);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List findAll() {
		log.debug("finding all BasDict instances");
		try {
			String queryString = "from BasDict";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/*public List Select2(){
		List list= new ArrayList();
		 try {
			 list =(List) getSession().createSQLQuery("select b.dict_item,count(*) from bas_dict b left join dbo.cst_customer c on b.dict_value=c.cust_level where b.dict_type='客户等级' group by b.dict_item").list();
					} catch (Exception e) {
						e.printStackTrace();
					}
					return list;
					}*/
	public List<String[]> Select2(){
		List<String[]> list = new ArrayList<String[]>();
		try {
			String sql="select b.dict_item,count(*) from bas_dict b left join dbo.cst_customer c on b.dict_value=c.cust_level where b.dict_type='客户等级' group by b.dict_item";
			SQLQuery  sqlQuery =this.getSession().createSQLQuery(sql);
			list = sqlQuery.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	 public List custList(){
		 List list= new ArrayList();
		 try {
			 list= getSession().createSQLQuery("").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	 }

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#merge(com.crm.entity.BasDict)
	 */
	public BasDict merge(BasDict detachedInstance) {
		log.debug("merging BasDict instance");
		try {
			BasDict result = (BasDict) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#attachDirty(com.crm.entity.BasDict)
	 */
	public void attachDirty(BasDict instance) {
		log.debug("attaching dirty BasDict instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.IBasDictDAO#attachClean(com.crm.entity.BasDict)
	 */
	public void attachClean(BasDict instance) {
		log.debug("attaching clean BasDict instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IBasDictDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IBasDictDAO) ctx.getBean("BasDictDAO");
	}

	//查询客户的等级
	@SuppressWarnings("unchecked")
	public List<BasDict> selectAll() {
	     Session session=this.getSession();
	     String hql="select b from BasDict b where b.dictType='客户等级'";						 
	     Query q=session.createQuery(hql);
	     List<BasDict> list=q.list();
	     return list;
	}
	//查询客户的地区
	@SuppressWarnings("unchecked")
	public List<BasDict> selectAlldq() {
		     Session session=this.getSession();
		     String hql="select b from BasDict b where b.dictType='地区'";						 
		     Query q=session.createQuery(hql);
		     List<BasDict> list=q.list();
		     return list;
	}
  //查询客户的满意度
	@SuppressWarnings("unchecked")
	public List<BasDict> selectAllmyd() {
	     Session session=this.getSession();
	     String hql="select b from BasDict b where b.dictType='满意度'";						 
	     Query q=session.createQuery(hql);
	     List<BasDict> list=q.list();
	     return list;
}
	//查询客户的信用度
	@SuppressWarnings("unchecked")
	public List<BasDict> selectAllxyd() {
	     Session session=this.getSession();
	     String hql="select b from BasDict b where b.dictType='信用度'";						 
	     Query q=session.createQuery(hql);
	     List<BasDict> list=q.list();   
	     return list;
	}
	public BasDict seldjmc(int id) {
		 Session session=this.getSession();
		 String hql="select b from BasDict b where b.dictType='客户等级' and dictValue="+id;
		 BasDict b=(BasDict) session.createQuery(hql).uniqueResult();
		return b;
	}
	//获取服务类型
	public List<BasDict>  findTypeByServiceType() {
		 Session session=this.getSession();
		 String queryString="select b from BasDict b where b.dictType='服务类型'" ;
		 List<BasDict>  basDictObjectList =session.createQuery(queryString).list();
		return basDictObjectList;
	}

	
	public PageModel<BasDict> getPageModel(BasDict basDict,int page,int pageSize){
		PageModel<BasDict> pageModel = new PageModel<BasDict>();
		try {
			String stringQuery="from BasDict su where 1=1 ";
			int rows = getTotalRowsByChoose(basDict);
			pageModel.setAllRecord(rows);
			Query query  =  setParameter(stringQuery,basDict);
			query.setMaxResults(pageSize);
			query.setFirstResult((page-1)*pageSize);
			List<BasDict> list = query.list();
			pageModel.setResultList(list);
			pageModel.setCurrPage(page);
			pageModel.setMaxRecord(pageSize);
			return pageModel;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
			}
		}
		public int getTotalRowsByChoose(BasDict basDict){
			log.debug("finding all SalChance instances");
			try {
				String queryString="select count(su) from BasDict su where 1=1 ";
				Query query  =  setParameter(queryString,basDict);
				Object object = query.uniqueResult();
				return Integer.parseInt(object.toString());
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}
		private Query setParameter(String queryString,BasDict basDict){
			if(basDict.getDictType()!=null&&!basDict.getDictType().equals("")){
				queryString+=" and su.dictType like :dictType";
			}
			if(basDict.getDictItem()!=null&&!basDict.getDictItem().equals("")){
				queryString+=" and su.dictItem like :dictItem";
			}
			if(basDict.getDictValue()!=null&&!basDict.getDictValue().equals("")){
				queryString+=" and su.dictValue like :dictValue";
			}
			System.out.println(queryString);
			Query query = this.getSession().createQuery(queryString);
			/*this.dictType = dictType;
			this.dictItem = dictItem;
			this.dictValue = dictValue;
			this.dictIsEditable = dictIsEditable;*/
			
			if(basDict.getDictType()!=null&&!basDict.getDictType().equals("")){
				query.setParameter("dictType", "%"+basDict.getDictType()+"%");
			}
			if(basDict.getDictItem()!=null&&!basDict.getDictItem().equals("")){
				query.setParameter("dictItem", "%"+basDict.getDictItem()+"%");
			}
			if(basDict.getDictValue()!=null&&!basDict.getDictValue().equals("")){
				query.setParameter("dictValue", "%"+ basDict.getDictValue()+"%");
			}
		
			return query;
		}
}