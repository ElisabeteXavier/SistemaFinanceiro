package br.edu.iftm.jsf.bean.converter;

import br.edu.iftm.jsf.entity.Fornecedor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "fornecedorConverter")
public class FornecedorConverter implements Converter<Fornecedor> {

    @Override
    public Fornecedor getAsObject(FacesContext context, UIComponent component, String chave) {
        if (chave != null && !chave.equals("")) {
            Fornecedor fornecedor = (Fornecedor) component.getAttributes().get(chave);
            return fornecedor;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Fornecedor fornecedor) {
        if (fornecedor != null && fornecedor.getId() != null) {
            String chave = "fornecedor_" + fornecedor.getId();
            component.getAttributes().put(chave, fornecedor);
            return chave;
        }
        return null;
    }
}
