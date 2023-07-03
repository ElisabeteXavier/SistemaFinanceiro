package br.edu.iftm.jsf.logic;

import br.edu.iftm.jsf.util.exception.ErroNegocioException;
import br.edu.iftm.jsf.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.List;

public interface GenericLogic<E> extends Serializable{
    
    public E salvar(E entity) throws ErroNegocioException, ErroSistemaException;
    public void remover(E entity) throws ErroNegocioException, ErroSistemaException;
    public List<E> listar() throws ErroNegocioException, ErroSistemaException;
    
}
