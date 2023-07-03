
package br.edu.iftm.jsf.dao;

import br.edu.iftm.jsf.entity.Marca;


public class MarcaDAO extends GenericDAO<Marca, Long> {

     @Override
    public Class<Marca> getClassEntity() {
        return Marca.class;
    }
    
}
