package com.isi.stock.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class ListItemHolder {

	private List<SelectItem> dataItems; 
	
	public ListItemHolder(){
		dataItems = new ArrayList<SelectItem>();		
	}

	public List<SelectItem> getDataItems() {
		return dataItems;
	}

	public void setDataItems(List<SelectItem> dataItems) {
		this.dataItems = dataItems;
	}
	
	
	
}
