
package br.edu.iftm.jsf.dao;

import br.edu.iftm.jsf.entity.Fornecedor;


public class FornecedorDAO extends GenericDAO<Fornecedor, Long> {
    
     @Override
    public Class<Fornecedor> getClassEntity() {
        return Fornecedor.class;
    }
    
}
