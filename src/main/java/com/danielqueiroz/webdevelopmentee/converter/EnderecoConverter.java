package com.danielqueiroz.webdevelopmentee.converter;

import com.danielqueiroz.webdevelopmentee.model.Endereco;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Endereco.class)
public class EnderecoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null)
            return null;

        String[] tokens = value.split(",");
        Endereco endereco = new Endereco();
        endereco.setRua(tokens[0].trim());
        endereco.setNumero(tokens[1].trim());

        return endereco;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Endereco endereco =  (Endereco) value;
        return endereco.getRua() +", " + endereco.getNumero();
    }
}
