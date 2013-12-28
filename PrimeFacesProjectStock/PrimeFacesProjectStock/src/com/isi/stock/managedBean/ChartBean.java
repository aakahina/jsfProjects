package com.isi.stock.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import com.isi.stock.dao.ProduitDAO;
import com.isi.stock.entities.Produit;

@ManagedBean
public class ChartBean implements Serializable {  
  
    private PieChartModel pieModel;  
    private List<Produit> lstProd;
    private ProduitDAO produitDAO;
    
    public ChartBean() {  
    	produitDAO = new ProduitDAO();
		lstProd= new ArrayList<Produit>();	
		
        createPieModel();  
    }  
  
    public PieChartModel getPieModel() {  
        return pieModel;  
    }  
  
    private void createPieModel() {  
    	
    	this.lstProd = getAllProduits();
        pieModel = new PieChartModel();  
  
        for (Produit p : lstProd) {
        	pieModel.set(p.getNom(), p.getPrix());
		}
//        pieModel.set("Brand 1", 540);  
//        pieModel.set("Brand 2", 325);  
//        pieModel.set("Brand 3", 702);  
//        pieModel.set("Brand 4", 421);  
    }  
    
    
public List<Produit> getAllProduits(){
		
		List<Produit> lst = produitDAO.selectAll();
		return lst;
	}
}  
              
