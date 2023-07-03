package br.edu.iftm.jsf.bean.converter;

import br.edu.iftm.jsf.entity.Permissao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "permissaoConverter")
public class PermissaoConverter implements Converter<Permissao>{

    @Override
    public Permissao getAsObject(FacesContext context, UIComponent component, String chave) {
        if(chave != null && !chave.equals("")){
            Permissao permissao = (Permissao) component.getAttributes().get(chave);
            return permissao;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Permissao permissao) {
        if(permissao != null && permissao.getId() != null){
            String chave = "permissao_"+permissao.getId();
            component.getAttributes().put(chave, permissao);
            return chave;
        }
        return null;
    }
    
}
