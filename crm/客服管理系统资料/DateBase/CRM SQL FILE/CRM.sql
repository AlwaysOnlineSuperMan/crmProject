select * from sys_role;
--��˼
update dbo.sys_right set right_url='salChanceAction.do?method=salChanceaManageList' where right_text='���ۻ������'
update dbo.sys_right set right_url='salPlanAction.do?method=planList' where right_text='�ͻ������ƻ�'


--Ȩ�޹���
update dbo.sys_right set right_url='sysUserAction.do?method=userAllList' where right_text='�û�����';

update dbo.sys_right set right_url='sysRoleAction.do?method=toRoleAllList' where right_text='��ɫ����';
update dbo.sys_right set right_url='sysUserAction.do?method=toUserListForPage' where right_text='�û�����';
--------����
update dbo.sys_right set right_url='cstServiceAction.do?method=findAll' where right_text='�������'
update dbo.sys_right set right_url='cstServiceAction.do?method=toCstServiceAdd' where right_text='���񴴽�'
update dbo.sys_right set right_url='cstServiceAction.do?method=findAll2' where right_text='������'
update dbo.sys_right set right_url='cstServiceAction.do?method=findAll1' where right_text='����鵵'
update dbo.sys_right set right_url='cstServiceAction.do?method=findAll3' where right_text='������'
--����ͨ
update dbo.sys_right set right_url='ordersAction.do?method=nameOrprice' where right_text='�ͻ����׷���';
update dbo.sys_right set right_url='basDictAction.do?method=Typename' where right_text='�ͻ����ɷ���';    							
update dbo.sys_right set right_url='cstServiceAction.do?method=toSerList' where right_text='�ͻ��������';
update dbo.sys_right set right_url='cstLostAction.do?method=toLostList' where right_text='�ͻ���ʧ����';

update dbo.sys_right set right_url='cstServiceAction.do?method=toSerList' where right_text='�ͻ��������';
update dbo.sys_right set right_url='cstLostAction.do?method=toLostList' where right_text='�ͻ���ʧ����';



--����

update dbo.sys_right set right_url='cstCustomerAction.do?method=listAll' where right_text='�ͻ���Ϣ����';
update dbo.sys_right set right_url='cstLostAction.do?method=list' where right_text='�ͻ���ʧ����';
	
--	L05 = theMenu.addChild(l2ID, "Folder", "��������", "", "��������...");
--	L0501 = theMenu.addChild(L05, "Document", "�����ֵ����", "~basd/dict.jsp", "�����ֵ����...");
--	L0502 = theMenu.addChild(L05, "Document", "��ѯ��Ʒ��Ϣ", "~basd/product.jsp", "��ѯ��Ʒ��Ϣ...");
--	L0503 = theMenu.addChild(L05, "Document", "��ѯ���", "~basd/storage.jsp", "��ѯ���...");
update dbo.sys_right set right_url='basDictAction.do?method=toBasDictList' where right_text='�����ֵ����';
update dbo.sys_right set right_url='productAction.do?method=toProductList' where right_text='��ѯ��Ʒ��Ϣ';
update dbo.sys_right set right_url='productAction.do?method=toProductLsitForPage' where right_text='��ѯ��Ʒ��Ϣ';
update dbo.sys_right set right_url='storageAction.do?method=toStorageList' where right_text='��ѯ���';
update dbo.sys_right set right_url='storageAction.do?method=toStorageListForPage' where right_text='��ѯ���';

select b.dict_item,count(*) from bas_dict b left join dbo.cst_customer c on b.dict_value=c.cust_level where b.dict_type='�ͻ��ȼ�' group by b.dict_item
select  a.odr_customer,sum(b.odd_price*b.odd_count) from dbo.orders a inner join dbo.orders_line b on a.odr_id=b.odd_order_id group by a.odr_customer
