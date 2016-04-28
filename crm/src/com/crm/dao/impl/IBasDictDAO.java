package com.crm.dao.impl;

import java.util.List;

import com.crm.dao.BasDictDAO;
import com.crm.entity.BasDict;
import com.crm.util.PageModel;

public interface IBasDictDAO {

	public abstract void save(BasDict transientInstance);

	public abstract void delete(BasDict persistentInstance);

	public abstract BasDict findById(java.lang.Long id);

	public abstract List findByExample(BasDict instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByDictType(Object dictType);

	public abstract List findByDictItem(Object dictItem);

	public abstract List findByDictValue(Object dictValue);

	public abstract List findByDictIsEditable(Object dictIsEditable);

	public abstract List findAll();
	
	public abstract List<String[]> Select2();

	public abstract BasDict merge(BasDict detachedInstance);

	public abstract void attachDirty(BasDict instance);

	public abstract void attachClean(BasDict instance);
	//查询所有客户等级
	public abstract List<BasDict> selectAll();
	
	public abstract List<BasDict> selectAlldq();

	public abstract List<BasDict> selectAllmyd();

	public abstract List<BasDict> selectAllxyd();
	//根据客户等级查名称
	public abstract BasDict seldjmc(int id);
	public abstract List<BasDict>  findTypeByServiceType() ;
	public abstract List custList();
	public PageModel<BasDict> getPageModel(BasDict basDict, int page,
			int pageSize);

}