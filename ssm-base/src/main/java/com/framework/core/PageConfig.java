package com.framework.core;

import com.framework.bean.IndexConfig;

public class PageConfig {
	
	private String indexTitle;
	private int pageSize;
	private String restUrl;
	
	private GridConfig gridConfig;
	private FormConfig addConfig;
	private FormConfig updateConfig;
	
	/*public PageConfig(String gridConfig, String addConfig , String updateConfig){
		
		this.gridConfig = new GridConfig(gridConfig);
		this.addConfig = new FormConfig(addConfig);
		this.updateConfig = new FormConfig(updateConfig);
	}*/
	
	public PageConfig(IndexConfig indexConfig){
		this.indexTitle = indexConfig.getIndexTitle();
		this.pageSize = indexConfig.getPageSize();
		this.restUrl = indexConfig.getRestUrl();
		this.gridConfig = new GridConfig(indexConfig.getGridConfig());
		this.addConfig = new FormConfig(indexConfig.getAddConfig());
		this.updateConfig = new FormConfig(indexConfig.getUpdateConfig());
	}

	
	

	public String getIndexTitle() {
		return indexTitle;
	}
	public void setIndexTitle(String indexTitle) {
		this.indexTitle = indexTitle;
	}


	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	public String getRestUrl() {
		return restUrl;
	}



	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}



	public GridConfig getGridConfig() {
		return gridConfig;
	}

	public void setGridConfig(GridConfig gridConfig) {
		this.gridConfig = gridConfig;
	}

	public FormConfig getAddConfig() {
		return addConfig;
	}

	public void setAddConfig(FormConfig addConfig) {
		this.addConfig = addConfig;
	}

	public FormConfig getUpdateConfig() {
		return updateConfig;
	}

	public void setUpdateConfig(FormConfig updateConfig) {
		this.updateConfig = updateConfig;
	}


}

class GridConfig{
	//姓名:name,年龄:age,邮箱:email
	private String gridConfig;
	
	private String nCols[];
	private String pCols[];
	private String colProcFuns[];
	
	public GridConfig(String gridConfig){
		
		this.gridConfig = gridConfig;
		
		initGridConfig();
	}
	
	private void initGridConfig(){
		String item1[] = this.gridConfig.split(",");
		nCols = new String[item1.length];
		pCols = new String[item1.length];
		colProcFuns = new String[item1.length];
		for(int i=0;i<item1.length;i++){
			String item11 = item1[i];
			String item2[] = item11.split(":");
			
			nCols[i] = item2[0];
			pCols[i] = item2[1];
			
			if(item2.length>2){
				colProcFuns[i] = item2[2];
			}else{
				colProcFuns[i] = "gridColProcFun";
			}
			
		}
		 
	}

	public String getGridConfig() {
		return gridConfig;
	}

	public void setGridConfig(String gridConfig) {
		this.gridConfig = gridConfig;
	}

	public String[] getnCols() {
		return nCols;
	}

	public void setnCols(String[] nCols) {
		this.nCols = nCols;
	}

	public String[] getpCols() {
		return pCols;
	}

	public void setpCols(String[] pCols) {
		this.pCols = pCols;
	}

	public String[] getColProcFuns() {
		return colProcFuns;
	}

	public void setColProcFuns(String[] colProcFuns) {
		this.colProcFuns = colProcFuns;
	}
	
	
}

class FormConfig{
	//用户名:userName:text:[ph=请输入用户名],密码:password:password:[ph=请输入密码],性别:gendar:radio:[kv=男=1@女=2],邮箱:email:text:[ph=请输入邮箱],所属部门:deptId:select:[url=/sysmgr/dept/service/list]
	private String formConfig;
	private String nCols[];
	private String pCols[];
	private String types[];
	private String others[];
	
	public FormConfig(String formConfig){
		this.formConfig = formConfig;
		init();
	}
	
	public void init(){
		String item1[] = this.formConfig.split(",");
		nCols = new String[item1.length];
		pCols = new String[item1.length];
		types = new String[item1.length];
		others = new String[item1.length];
		for(int i=0;i<item1.length;i++){
			String item11 = item1[i];
			String item2[] = item11.split(":");
			
			nCols[i] = item2[0];
			pCols[i] = item2[1];
			types[i] = item2[2];
			others[i] = item2[3];
		}
	}

	public String getFormConfig() {
		return formConfig;
	}

	public void setFormConfig(String formConfig) {
		this.formConfig = formConfig;
	}
	
	

	public String[] getnCols() {
		return nCols;
	}

	public void setnCols(String[] nCols) {
		this.nCols = nCols;
	}

	public String[] getpCols() {
		return pCols;
	}

	public void setpCols(String[] pCols) {
		this.pCols = pCols;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}


	public String[] getOthers() {
		return others;
	}

	public void setOthers(String[] others) {
		this.others = others;
	}
	
	
	
	
}
