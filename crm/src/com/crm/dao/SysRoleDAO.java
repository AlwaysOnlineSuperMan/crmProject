package com.crm.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ISysRoleDAO;
import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import com.crm.util.PageModel;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysRole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.SysRole
 * @author MyEclipse Persistence Tools
 */

public class SysRoleDAO extends HibernateDaoSupport implements ISysRoleDAO {
	private static final Logger log = LoggerFactory.getLogger(SysRoleDAO.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String ROLE_DESC = "roleDesc";
	public static final String ROLE_FLAG = "roleFlag";
	public static final String ROLE_UPDATE_DATETIME = "roleUpdateDatetime";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#save(com.crm.entity.SysRole)
	 */
	public void save(SysRole transientInstance) {
		log.debug("saving SysRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void addSysRole(SysRole transientInstance) {
		log.debug("saving SysRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#delete(com.crm.entity.SysRole)
	 */
	public void delete(SysRole persistentInstance) {
		log.debug("deleting SysRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public boolean delete(Long roleId) {
		log.debug("deleting SysRole instance");
		try {
			Query query = this.getSession().createQuery("delete SysRole model where model.roleId=:roleId");
			query.setParameter("roleId", roleId);
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#findById(java.lang.Long)
	 */
	public SysRole findById(java.lang.Long id) {
		log.debug("getting SysRole instance with id: " + id);
		try {
			SysRole instance = (SysRole) getHibernateTemplate().get(
					"com.crm.entity.SysRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#findByExample(com.crm.entity.SysRole)
	 */
	public List findByExample(SysRole instance) {
		log.debug("finding SysRole instance by example");
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
	 * @see com.crm.dao.ISysRoleDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SysRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#findByRoleName(java.lang.Object)
	 */
	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#findByRoleDesc(java.lang.Object)
	 */
	public List findByRoleDesc(Object roleDesc) {
		return findByProperty(ROLE_DESC, roleDesc);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#findByRoleFlag(java.lang.Object)
	 */
	public List findByRoleFlag(Object roleFlag) {
		return findByProperty(ROLE_FLAG, roleFlag);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#findByRoleUpdateDatetime(java.lang.Object)
	 */
	public List findByRoleUpdateDatetime(Object roleUpdateDatetime) {
		return findByProperty(ROLE_UPDATE_DATETIME, roleUpdateDatetime);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all SysRole instances");
		try {
			String queryString = "from SysRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#merge(com.crm.entity.SysRole)
	 */
	public SysRole merge(SysRole detachedInstance) {
		log.debug("merging SysRole instance");
		try {
			SysRole result = (SysRole) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#attachDirty(com.crm.entity.SysRole)
	 */
	public void attachDirty(SysRole instance) {
		log.debug("attaching dirty SysRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysRoleDAO#attachClean(com.crm.entity.SysRole)
	 */
	public void attachClean(SysRole instance) {
		log.debug("attaching clean SysRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISysRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ISysRoleDAO) ctx.getBean("SysRoleDAO");
	}
	
	
	public PageModel<SysRole> getPageModel(SysRole sysRole,int page,int pageSize){
		PageModel<SysRole> pageModel = new PageModel<SysRole>();
		try {
			String stringQuery="from SysRole su where 1=1 ";
			int rows = getTotalRowsByChoose(sysRole);
			pageModel.setAllRecord(rows);
			Query query  =  setParameter(stringQuery,sysRole);
			query.setMaxResults(pageSize);
			query.setFirstResult((page-1)*pageSize);
			List<SysRole> list = query.list();
			pageModel.setResultList(list);
			pageModel.setCurrPage(page);
			pageModel.setMaxRecord(pageSize);
			return pageModel;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
			}
		}
		public int getTotalRowsByChoose(SysRole sysRole){
			log.debug("finding all SalChance instances");
			try {
				String queryString="select count(su) from SysRole su where 1=1 ";
				Query query  =  setParameter(queryString,sysRole);
				Object object = query.uniqueResult();
				return Integer.parseInt(object.toString());
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}
		private Query setParameter(String queryString,SysRole sysRole){
			if(sysRole.getRoleName()!=null&&!sysRole.getRoleName().equals("")){
				queryString+=" and su.roleName like :roleName";
			}
			if(sysRole.getRoleDesc()!=null&&!sysRole.getRoleDesc().equals("")){
				queryString+=" and su.roleDesc like :roleDesc";
			}
			if (sysRole.getRoleFlag()!=0) {
				queryString+=" and su.roleFlag=:roleFlag";
			}
	
			Query query = this.getSession().createQuery(queryString);
			
			
			if(sysRole.getRoleName()!=null&&!sysRole.getRoleName().equals("")){
				query.setParameter("roleName", "%"+sysRole.getRoleName()+"%");
			}
			if(sysRole.getRoleDesc()!=null&&!sysRole.getRoleDesc().equals("")){
				query.setParameter("roleDesc", "%"+sysRole.getRoleDesc()+"%");
			}
			if (sysRole.getRoleFlag()!=0) {
				query.setParameter("roleFlag", sysRole.getRoleFlag());
			}
			
			return query;
		}
}