package com.isi.stock.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.isi.stock.dao.CategorieDAO;
import com.isi.stock.dao.ProduitDAO;
import com.isi.stock.entities.Produit;

@ManagedBean(name="stockMB")
@SessionScoped
public class StockManagedBean implements Serializable{

	private static final long serialVersionUID = 1878626070410178404L;
	private Integer categorie;
	private Map<String, Integer> categories = new HashMap<String, Integer>();
	private List<Produit> lstProd;
	private Produit selectedProduit;
	private ProduitDataModel mediumProduitModel;  
	
	CategorieDAO categorieDAO;
	ProduitDAO produitDAO;
	
	
	
	public StockManagedBean() {
		categorieDAO = new CategorieDAO();
		produitDAO = new ProduitDAO();
		lstProd= new ArrayList<Produit>();	
		
		mediumProduitModel = new ProduitDataModel(lstProd);
	} 
	
	    
	 public ProduitDataModel getMediumProduitModel() {
		return mediumProduitModel;
	}


	public void setMediumProduitModel(ProduitDataModel mediumProduitModel) {
		this.mediumProduitModel = mediumProduitModel;
	}


	public Produit getSelectedProduit() {
		return selectedProduit;
	}


	public void setSelectedProduit(Produit selectedProduit) {
		this.selectedProduit = selectedProduit;
	}


	public Integer getCategorie() {
		return categorie;
	}




	public void setCategorie(Integer categorie) {
		this.categorie = categorie;
	}


	public Map<String, Integer> getCategories() {
		this.categories=categorieDAO.selectAllCat();
		return categories;
	}

	public List<Produit> getLstProd() {
		
		return lstProd;
	}

	public void setLstProd(ArrayList<Produit> lstProd) {
		this.lstProd = lstProd;
	}


	public void setCategories(Map<String, Integer> categories) {
		this.categories = categories;
	}

	public List<Produit> allProduit(){
		this.lstProd = produitDAO.selectAll();
		return lstProd;
	}
	
	public List<Produit> produitByCat(int cat){
		
		List<Produit> lst = new ProduitDAO().selectAllProductCatDetail(cat);
		return lst;
	}

	public void handleCategorieChange() { 
		
		System.out.println("categorie : "+categorie);
	
	        	
	        	this.lstProd = produitByCat(categorie);	
	        	

	        displayLocation();
	    } 
	 
	public void displayLocation() {  
		 if(categorie !=0)   { 
        FacesMessage msg = new FacesMessage("Selected", "categorie:" +categorieDAO.getCategorie(categorie));  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
		 }else  {
	           
	        	System.out.println("null");
	        }
    }  
	
	public int getSomelistLength() { return this.lstProd.size(); }
	    public void onEdit(RowEditEvent event) {  
	    	
	    	System.out.println("id produit : "+((Produit) event.getObject()).getId());
	    	System.out.println("nom produit : "+((Produit) event.getObject()).getNom());
	    	
	    	Produit p = new Produit(((Produit) event.getObject()).getId(), ((Produit) event.getObject()).getNom(), ((Produit) event.getObject()).getPrix(), ((Produit) event.getObject()).getCatId());
	    	//produitDAO.updateName(((Produit) event.getObject()).getNom(), ((Produit) event.getObject()).getId());
	    	produitDAO.update(p);
	        FacesMessage msg = new FacesMessage("Produit Edited", ((Produit) event.getObject()).getNom());  
	  
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
	    }  
	      
	    public void onCancel(RowEditEvent event) {  
	        FacesMessage msg = new FacesMessage("Produit Cancelled", ((Produit) event.getObject()).getNom());  
	  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  
}
