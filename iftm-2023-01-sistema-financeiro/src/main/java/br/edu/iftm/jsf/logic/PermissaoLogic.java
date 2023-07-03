package br.edu.iftm.jsf.logic;

import br.edu.iftm.jsf.dao.PermissaoDAO;
import br.edu.iftm.jsf.entity.Permissao;
import br.edu.iftm.jsf.util.Transacional;
import br.edu.iftm.jsf.util.exception.ErroNegocioException;
import br.edu.iftm.jsf.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class PermissaoLogic implements GenericLogic<Permissao>{

    @Inject
    private PermissaoDAO dao;
    
    
    
    public List<Permissao> listarTodas(){
        return dao.listar();
    }

    @Override
    @Transacional
    public Permissao salvar(Permissao entity) throws ErroNegocioException, ErroSistemaException {
       return dao.salvar(entity);
    }

    @Override
    public void remover(Permissao entity) throws ErroNegocioException, ErroSistemaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Permissao> listar() throws ErroNegocioException, ErroSistemaException {
        return dao.listar();
    }
    
}
