
package br.edu.iftm.jsf.bean.converter;

import br.edu.iftm.jsf.entity.Marca;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisabete
 */
@FacesConverter(value = "marcaConverter")
public class MarcaConverter implements Converter<Marca> {

    @Override
    public Marca getAsObject(FacesContext context, UIComponent component, String chave) {
        if (chave != null && !chave.equals("")) {
            Marca marca = (Marca) component.getAttributes().get(chave);
            return marca;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Marca marca) {
        if (marca != null && marca.getId() != null) {
            String chave = "fornecedor_" + marca.getId();
            component.getAttributes().put(chave, marca);
            return chave;
        }
        return null;
    }
}