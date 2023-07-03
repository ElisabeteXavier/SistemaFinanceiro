package br.edu.iftm.jsf.dao;

import br.edu.iftm.jsf.entity.Permissao;

public class PermissaoDAO extends GenericDAO<Permissao, Long>{

    @Override
    public Class<Permissao> getClassEntity() {
        return Permissao.class;
    }
  
    
}
