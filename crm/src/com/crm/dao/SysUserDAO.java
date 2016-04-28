package com.crm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crm.dao.impl.ISysUserDAO;
import com.crm.entity.SysUser;
import com.crm.util.PageModel;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.entity.SysUser
 * @author MyEclipse Persistence Tools
 */

public class SysUserDAO extends HibernateDaoSupport implements ISysUserDAO {
	private static final Logger log = LoggerFactory.getLogger(SysUserDAO.class);
	// property constants
	public static final String USR_NO = "usrNo";
	public static final String USR_NAME = "usrName";
	public static final String USR_PASSWORD = "usrPassword";
	public static final String USR_ROLE_ID = "usrRoleId";
	public static final String USR_FLAG = "usrFlag";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#save(com.crm.entity.SysUser)
	 */
	public void save(SysUser transientInstance) {
		log.debug("saving SysUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void updUserByRoleID(SysUser sysUserObject) {
		log.debug("saving SysUser instance");
		try {
			String queryString = "update SysUser model set model.usrRoleId=:usrRoleId,model.usrUpdateDatetime=:usrUpdateDatetime where model.usrId=:usrId";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("usrRoleId", sysUserObject.getUsrRoleId());
			query.setParameter("usrUpdateDatetime", sysUserObject.getUsrUpdateDatetime());
			query.setParameter("usrId", sysUserObject.getUsrId());
			query.executeUpdate();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#delete(com.crm.entity.SysUser)
	 */
	public void delete(SysUser persistentInstance) {
		log.debug("deleting SysUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public boolean deleteByUserID(SysUser sysUserObject) {
		log.debug("deleting SysUser instance");
		try {
			String queryString = "delete SysUser model where model.usrId=:usrId ";
			Query query = this.getSession().createQuery(queryString);
			query.setParameter("usrId", sysUserObject.getUsrId());
			return query.executeUpdate()>0;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#findById(java.lang.Long)
	 */
	public SysUser findById(java.lang.Long id) {
		log.debug("getting SysUser instance with id: " + id);
		try {
			SysUser instance = (SysUser) getHibernateTemplate().get(
					"com.crm.entity.SysUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#findByExample(com.crm.entity.SysUser)
	 */
	public List findByExample(SysUser instance) {
		log.debug("finding SysUser instance by example");
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
	 * @see com.crm.dao.ISysUserDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SysUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public SysUser findByUserNoAndPassWord(String userNo, String passWord) {
	log.debug("finding SysUser instance with property: " + USR_NO
			+ ", value: " + userNo +" and with property:"+USR_PASSWORD + ", value: "+passWord);
	
		try {
			String queryString = "from SysUser as model where model."+ USR_NO + "= ?"+" and model."+USR_PASSWORD+"= ?";
			Session session = this.getSession();
			Query query = session.createQuery(queryString);
			query.setParameter(0, userNo);
			query.setParameter(1, passWord);
			SysUser sysUserObject =  (SysUser) query.uniqueResult();
			return sysUserObject;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public static void main(String[] args) {
		SysUserDAO s=new SysUserDAO();
		//s.findByUserNoAndPassWord("admin", "pwd");
		s.findAll();
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#findByUsrNo(java.lang.Object)
	 */
	public List findByUsrNo(Object usrNo) {
		return findByProperty(USR_NO, usrNo);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#findByUsrName(java.lang.Object)
	 */
	public List findByUsrName(Object usrName) {
		return findByProperty(USR_NAME, usrName);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#findByUsrPassword(java.lang.Object)
	 */
	public List findByUsrPassword(Object usrPassword) {
		return findByProperty(USR_PASSWORD, usrPassword);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#findByUsrRoleId(java.lang.Object)
	 */
	public List findByUsrRoleId(Object usrRoleId) {
		return findByProperty(USR_ROLE_ID, usrRoleId);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#findByUsrFlag(java.lang.Object)
	 */
	public List findByUsrFlag(Object usrFlag) {
		return findByProperty(USR_FLAG, usrFlag);
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all SysUser instances");
		try {
			//销售经理usrRoleId=2指派给客服经理usrRoleId=3
			String queryString = "from SysUser model where model.usrRoleId = 3";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAllList() {
		log.debug("finding all SysUser instances");
		try {
			//销售经理usrRoleId=2指派给客服经理usrRoleId=3
			String queryString = "from SysUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#merge(com.crm.entity.SysUser)
	 */
	public SysUser merge(SysUser detachedInstance) {
		log.debug("merging SysUser instance");
		try {
			SysUser result = (SysUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#attachDirty(com.crm.entity.SysUser)
	 */
	public void attachDirty(SysUser instance) {
		log.debug("attaching dirty SysUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.crm.dao.ISysUserDAO#attachClean(com.crm.entity.SysUser)
	 */
	public void attachClean(SysUser instance) {
		log.debug("attaching clean SysUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISysUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ISysUserDAO) ctx.getBean("SysUserDAO");
	}
	//查出所有用户
	public List<SysUser> sel(){
		Session session=this.getSession();
		Query q=session.createQuery("select a from SysUser a inner join fetch a.sysrole b where b.roleName='客户经理'");
		List<SysUser> list=q.list();
		return list;
	}
	public List<SysUser> fillAll(){
		Query query=this.getSession().createQuery("select s from SysUser s");
		List<SysUser> list=query.list();
		return list;
	}

	public PageModel<SysUser> getPageModel(SysUser sysUser,int page,int pageSize){
		PageModel<SysUser> pageModel = new PageModel<SysUser>();
		try {
			String stringQuery="from SysUser su where 1=1 ";
			int rows = getTotalRowsByChoose(sysUser);
			pageModel.setAllRecord(rows);
			Query query  =  setParameter(stringQuery,sysUser);
			query.setMaxResults(pageSize);
			query.setFirstResult((page-1)*pageSize);
			List<SysUser> list = query.list();
			pageModel.setResultList(list);
			pageModel.setCurrPage(page);
			pageModel.setMaxRecord(pageSize);
			return pageModel;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
			}
		}
		public int getTotalRowsByChoose(SysUser sysUser){
			log.debug("finding all SalChance instances");
			try {
				String queryString="select count(su) from SysUser su where 1=1 ";
				Query query  =  setParameter(queryString,sysUser);
				Object object = query.uniqueResult();
				return Integer.parseInt(object.toString());
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}
		private Query setParameter(String queryString,SysUser sysUser){
			if(sysUser.getUsrName()!=null&&!sysUser.getUsrName().equals("")){
				queryString+=" and su.usrName like :userName";
			}
			if(sysUser.getUsrFlag()!=null&&!sysUser.getUsrFlag().equals("")&& sysUser.getUsrFlag()!=0){
				queryString+=" and su.usrFlag=:userFlag";
			}
			Query query = this.getSession().createQuery(queryString);
			if(sysUser.getUsrName()!=null&&!sysUser.getUsrName().equals("")){
				query.setParameter("userName", "%"+sysUser.getUsrName()+"%");
			}
			if(sysUser.getUsrFlag()!=null&&!sysUser.getUsrFlag().equals("")&&sysUser.getUsrFlag()!=0){
				query.setParameter("userFlag", sysUser.getUsrFlag());
			}
			return query;
		}
}