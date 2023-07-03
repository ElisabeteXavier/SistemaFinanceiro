package br.edu.iftm.jsf.dao;

import br.edu.iftm.jsf.entity.Produto;
import br.edu.iftm.jsf.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danilo
 */
public abstract class GenericDAO<E, ID> implements Serializable {
    
    @Inject
    private EntityManager manager;
    
    public E salvar(E entity) throws ErroSistemaException {
        try {
            entity = manager.merge(entity);
        } catch (Exception ex) {
            throw new ErroSistemaException("Erro ao tentar salvar no banco.", ex);
        }
        return entity;
    }
    
    public void deletar(ID id){
        E entity = manager.find(getClassEntity(), id);
        manager.remove(entity);
    }
    
    public List<E> listar(){
        List<E> entitys;
        entitys = manager.createQuery("from "+getClassEntity().getName()).getResultList();
        return entitys;
    }
    
     public E buscarPorID(ID id) {
        E entity = manager.find(getClassEntity(), id);
        return entity;
    }
    
    public abstract Class<E> getClassEntity();
    
}
