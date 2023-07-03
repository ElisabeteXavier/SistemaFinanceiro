package br.edu.iftm.jsf.util;

import br.edu.iftm.jsf.util.exception.ErroNegocioException;
import br.edu.iftm.jsf.util.exception.ErroSistemaException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class BeanUtil implements Serializable {
    
    public void addMessage(Severity tipo, String resumo, String detalhe){
        FacesMessage message = new FacesMessage(tipo, resumo, detalhe);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void addInfo(String resumo, String detalhe) {
        addMessage(FacesMessage.SEVERITY_INFO, resumo, detalhe);
    }
    public void addInfo(String message) {
        addInfo("Info", message);
    }
    
    public void addAviso(String resumo, String detalhe) {
        addMessage(FacesMessage.SEVERITY_WARN, resumo, detalhe);
    }
    public void addAviso(String message) {
        addAviso("Aviso", message);
    }
    public void addAviso(ErroNegocioException ex){
        addAviso(ex.getMessage());
    }
    public void addError(String resumo, String detalhe) {
        addMessage(FacesMessage.SEVERITY_ERROR, resumo, detalhe);
    }
    public void addError(String message){
        addError("Erro", message);
    }
    public void addError(ErroSistemaException ex){
        addError(ex.getMessage());
    }
}
