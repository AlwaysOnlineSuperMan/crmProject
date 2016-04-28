select * from sys_role;
--宁思
update dbo.sys_right set right_url='salChanceAction.do?method=salChanceaManageList' where right_text='销售机会管理'
update dbo.sys_right set right_url='salPlanAction.do?method=planList' where right_text='客户开发计划'


--权限管理
update dbo.sys_right set right_url='sysUserAction.do?method=userAllList' where right_text='用户管理';

update dbo.sys_right set right_url='sysRoleAction.do?method=toRoleAllList' where right_text='角色管理';
update dbo.sys_right set right_url='sysUserAction.do?method=toUserListForPage' where right_text='用户管理';
--------服务
update dbo.sys_right set right_url='cstServiceAction.do?method=findAll' where right_text='服务分配'
update dbo.sys_right set right_url='cstServiceAction.do?method=toCstServiceAdd' where right_text='服务创建'
update dbo.sys_right set right_url='cstServiceAction.do?method=findAll2' where right_text='服务处理'
update dbo.sys_right set right_url='cstServiceAction.do?method=findAll1' where right_text='服务归档'
update dbo.sys_right set right_url='cstServiceAction.do?method=findAll3' where right_text='服务反馈'
--杨泽通
update dbo.sys_right set right_url='ordersAction.do?method=nameOrprice' where right_text='客户贡献分析';
update dbo.sys_right set right_url='basDictAction.do?method=Typename' where right_text='客户构成分析';    							
update dbo.sys_right set right_url='cstServiceAction.do?method=toSerList' where right_text='客户服务分析';
update dbo.sys_right set right_url='cstLostAction.do?method=toLostList' where right_text='客户流失分析';

update dbo.sys_right set right_url='cstServiceAction.do?method=toSerList' where right_text='客户服务分析';
update dbo.sys_right set right_url='cstLostAction.do?method=toLostList' where right_text='客户流失分析';



--刘绍

update dbo.sys_right set right_url='cstCustomerAction.do?method=listAll' where right_text='客户信息管理';
update dbo.sys_right set right_url='cstLostAction.do?method=list' where right_text='客户流失管理';
	
--	L05 = theMenu.addChild(l2ID, "Folder", "基础数据", "", "基础数据...");
--	L0501 = theMenu.addChild(L05, "Document", "数据字典管理", "~basd/dict.jsp", "数据字典管理...");
--	L0502 = theMenu.addChild(L05, "Document", "查询产品信息", "~basd/product.jsp", "查询产品信息...");
--	L0503 = theMenu.addChild(L05, "Document", "查询库存", "~basd/storage.jsp", "查询库存...");
update dbo.sys_right set right_url='basDictAction.do?method=toBasDictList' where right_text='数据字典管理';
update dbo.sys_right set right_url='productAction.do?method=toProductList' where right_text='查询产品信息';
update dbo.sys_right set right_url='productAction.do?method=toProductLsitForPage' where right_text='查询产品信息';
update dbo.sys_right set right_url='storageAction.do?method=toStorageList' where right_text='查询库存';
update dbo.sys_right set right_url='storageAction.do?method=toStorageListForPage' where right_text='查询库存';

select b.dict_item,count(*) from bas_dict b left join dbo.cst_customer c on b.dict_value=c.cust_level where b.dict_type='客户等级' group by b.dict_item
select  a.odr_customer,sum(b.odd_price*b.odd_count) from dbo.orders a inner join dbo.orders_line b on a.odr_id=b.odd_order_id group by a.odr_customer
