package com.isi.stock.managedBean;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.isi.stock.entities.Produit;

public class ProduitDataModel extends ListDataModel<Produit> implements SelectableDataModel<Produit>{
	 public ProduitDataModel() {  
	    }  
	  
	    public ProduitDataModel(List<Produit> data) {  
	        super(data);  
	    }  
	      
	    @Override  
	    public Produit getRowData(String rowKey) {  
	        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
	          
	        List<Produit> Produits = (List<Produit>) getWrappedData();  
	          
	        for(Produit p : Produits) {  
	            if(p.getNom().equals(rowKey))  
	                return p;  
	        }  
	          
	        return null;  
	    }  
	  
	    @Override  
	    public Object getRowKey(Produit produit) {  
	        return produit.getNom();  
	    }  
}
