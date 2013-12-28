package com.isi.stock.entities;

public class Membre {
	private int membreId;
	private String nom;
	private String email;
	private String pw;
	
	
	public Membre() {
		super();
	}
	public Membre(int membreId, String nom, String email, String pw) {
		super();
		this.membreId = membreId;
		this.nom = nom;
		this.email = email;
		this.pw = pw;
	}
	public int getMembreId() {
		return membreId;
	}
	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	

}
