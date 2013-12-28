package com.isi.stock.entities;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="categorie")
public class Categorie {
	private int catID;
	private String catNom;
	private String description;
	//private List<Produit> produits;
	
	public Categorie(int catID, String catNom, String description) {
		super();
		this.catID = catID;
		this.catNom = catNom;
		this.description = description;
		
		}
	
	public Categorie() {}

	public int getCatID() {
		return catID;
	}
	
	public void setCatID(int catID) {
		this.catID = catID;
	}
	
	public String getCatNom() {
		return catNom;
	}
	
	public void setCatNom(String catNom) {
		this.catNom = catNom;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
//	public List<Produit> getProduits() {
//		return produits;
//	}
//
//	public void setProduits(List<Produit> produits) {
//		this.produits = produits;
//	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Id = ").append(catID).append(" - ");
		sb.append("Nom Categorie = ").append(catNom).append(" - ");
		sb.append("Description = ").append(description).append(" - \n");
			
		return sb.toString();
	}
	
}
