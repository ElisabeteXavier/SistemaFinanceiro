package br.edu.iftm.jsf.bean;

import br.edu.iftm.jsf.logic.GenericLogic;
import br.edu.iftm.jsf.util.BeanUtil;
import br.edu.iftm.jsf.util.exception.ErroNegocioException;
import br.edu.iftm.jsf.util.exception.ErroSistemaException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;

public abstract class GenericBean<E, L extends GenericLogic<E>> extends BeanUtil{
    
    @Getter
    private E entity;
    @Getter
    private List<E> entitys;
    
    @Getter
    private Estado estado = Estado.PESQUISANDO;
       
    enum Estado {
        CRIANDO,
        EDITANDO,
        PESQUISANDO
    }
    
    public void newInstanceOfEntity(){
        try {
            entity = (E) getClassEntity().getConstructors()[0].newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void novo(){
        long inicio = new Date().getTime()+30;
        while(inicio > new Date().getTime()) {
            
        }
        newInstanceOfEntity();
        estado = Estado.CRIANDO;
    }
  
    public void salvar(){
        try {
            getLogic().salvar(entity);
            addInfo("Salvo com sucesso.");
            newInstanceOfEntity();
            estado = Estado.PESQUISANDO;
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addError(ex);
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            addError("Erro no sistema: "+ex.getMessage());
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void listar(){
        try {
            estado = Estado.PESQUISANDO;
            entitys = getLogic().listar();
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addError(ex);
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remover(E entity){
        try {
            getLogic().remover(entity);
            addInfo("Removido com sucesso.");
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addError(ex);
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editar(E entity) {
        this.entity = entity;
        estado = Estado.EDITANDO;
    }
    public abstract L getLogic();
    public abstract Class<E> getClassEntity();
}
