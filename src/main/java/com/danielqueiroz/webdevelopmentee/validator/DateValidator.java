package com.danielqueiroz.webdevelopmentee.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;

@FacesValidator("dateValidator")
public class DateValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Date dateNasc = (Date) value;
        Date now = new Date();

        if (dateNasc != null && dateNasc.after(now)){
            FacesMessage msg = new FacesMessage("A data digitada é maior que a data atual");
            throw new ValidatorException(msg);
        }

    }
}
