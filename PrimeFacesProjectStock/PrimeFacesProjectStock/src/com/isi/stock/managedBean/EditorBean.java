package com.isi.stock.managedBean;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class EditorBean {
	 private String value;  
	  
	    public String getValue() {  
	        return value;  
	    }  
	  
	    public void setValue(String value) {  
	        this.value = value;  
	    }  
}
