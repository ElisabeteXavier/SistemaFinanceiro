package br.edu.iftm.jsf.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class HelloBean implements Serializable {
    
    private String hello;
    private String nome;
    
    public void dizerOla(){
        FacesMessage fm = new FacesMessage("Olá " + nome);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHello() {
        return hello;
    }
    
}
