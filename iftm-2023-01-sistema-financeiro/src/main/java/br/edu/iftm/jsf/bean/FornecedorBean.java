
package br.edu.iftm.jsf.bean;

import br.edu.iftm.jsf.entity.Fornecedor;
import br.edu.iftm.jsf.logic.FornecedorLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class FornecedorBean extends GenericBean<Fornecedor, FornecedorLogic>{
    
    
    @Inject
    private FornecedorLogic logic;
    
    @Override
    public FornecedorLogic getLogic() {
        return logic;
    }

    @Override
    public Class<Fornecedor> getClassEntity() {
        return Fornecedor.class;
    }
}
