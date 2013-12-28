package com.isi.stock.entities;

public class Produit {
	private int id;
	private String nom;
	private double prix;
	private int catId;
	
	
	public Produit(int id, String nom, double prix, int catId) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.catId = catId;
	}
	
	public Produit() {}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public int getCatId() {
		return catId;
	}
	
	public void setCatId(int catId) {
		this.catId = catId;
	}
	

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", catId=" + catId ;
	}

	public boolean equals(Object obj) {  
		Produit produit = (Produit) obj;
		if (this.id != produit.id){
			return false;
		}
		if (!this.nom.equals(produit.getNom())){
			return false;
		}
		if (!(this.prix==produit.getPrix())){
			return false;
		}
		if (!(this.catId==(produit.getCatId()))){
			return false;
		}
		return true;
	}

	
}
