package com.isi.stock.managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.isi.stock.dao.MembreDAO;
import com.isi.stock.entities.Membre;

@ManagedBean
@SessionScoped
public class MembreBean implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String membreId;
	private String nom;
	private String email;
	private String pw;
	
	
	private MembreDAO userDAO;
	
	
	private String destination="login.xhtml";
	
	
	
	
	
	public MembreBean() {
		super();
		userDAO = new MembreDAO();
	}

	public String getMembreId() {
		return membreId;
	}

	public void setMembreId(String membreId) {
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

	
	public String login(){
		
		Membre user=userDAO.selectMembre(getEmail(), getPw());
		if(user!=null){
			destination="success";
			setNom(user.getNom());
		}else{
			destination="";
		}
		return destination;
	}
	
	
	public void validerEmail(FacesContext arg0, UIComponent arg1, Object value)
			throws ValidatorException {
		
		String email = (String) value;
		
		if(email.length()<5){
			FacesMessage message = new FacesMessage();
			message.setDetail("email " + email + " doit contenir au moins 5 caracteres");
			message.setSummary("email Incorrect");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}
	
}