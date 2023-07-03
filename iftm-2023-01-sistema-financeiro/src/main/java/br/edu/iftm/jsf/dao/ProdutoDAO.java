package br.edu.iftm.jsf.dao;

import br.edu.iftm.jsf.entity.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Long>{

    @Override
    public Class<Produto> getClassEntity() {
        return Produto.class ;
    }
    
}
