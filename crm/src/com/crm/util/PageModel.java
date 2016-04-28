package com.crm.util;

import java.util.ArrayList;
import java.util.List;

public class PageModel<T> {
	//��allRecord����¼
	private int allRecord;
	// ÿҳmaxRecord����¼
	private int maxRecord;
	//��allPageҳ
	private int allPage;
	//��currPageҳ
	private int currPage;
	//��ҳ�Ľ����
	private  List<T> resultList = new ArrayList<T>();;

	
	
	//ȡ�õ�һҳ
	public int getFristPageNo(){
		return 1;
	}
	
	//ȡ����һҳ
	public int getPreviosPageNo(){
		if(currPage<=1){
			return 1;
		}
		return currPage -1;
	}
	
	//ȡ����һҳ
	public int getNextPageNo(){
		if(currPage>=getAllPage()){
			return getAllPage();
		}
		return currPage+1;
	}
	
	//ȡ�����һҳ
	public int getBottomPageNo(){
		return getAllPage();
	}
	public int getAllRecord() {
		return allRecord;
	}

	public void setAllRecord(int allRecord) {
		this.allRecord = allRecord;
	}

	public int getMaxRecord() {
		return maxRecord;
	}

	public void setMaxRecord(int maxRecord) {
		this.maxRecord = maxRecord;
	}
	//�����ҳ��
	public int getAllPage() {
		return (allRecord+maxRecord-1)/maxRecord;
	}
	public int getAllPage(int allRecord,int maxRecord) {
		return (allRecord+maxRecord-1)/maxRecord;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	@Override
	public String toString() {
		return "PageModel [allPage=" + allPage + ", allRecord=" + allRecord
				+ ", currPage=" + currPage + ", maxRecord=" + maxRecord
				+ ", resultList=" + resultList + "]";
	}
	
/*	<div class="pager">
	��${sessionScope.xxxForm.pageModel.allRecord}����¼
	 ÿҳ
	<html:text property="pageModel.maxRecord" size="2"></html:text>��
	��${sessionScope.xxxForm.pageModel.currPage}ҳ/
	��${sessionScope.xxxForm.pageModel.allPage}ҳ
	<a href="right.do?o=toUserList&param=firstPage">��һҳ</a>
	<a href="right.do?o=toUserList&param=previosPage">��һҳ</a>
	<a href="right.do?o=toUserList&param=nextPage">��һҳ</a>
	<a href="right.do?o=toUserList&param=lastPage">���һҳ</a>
	ת��
	<html:text property="pageModel.currPage" size="2"></html:text>ҳ
	<button width="20" onclick="add();">GO</button>
</div>*/
	
}
