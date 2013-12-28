package com.isi.stock.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "valider")
public class Validations implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value)
			throws ValidatorException {

		String login = (String) value;
		if (login.length()<5) {
			FacesMessage message = new FacesMessage();
			message.setDetail("login " + login + " doit contenir au moins 7 caracteres");
			message.setSummary("login Incorrect");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	
		
	}

}
