package br.edu.iftm.jsf.bean;

import br.edu.iftm.jsf.entity.Cliente;
import br.edu.iftm.jsf.logic.ClienteLogic;
import br.edu.iftm.jsf.logic.GenericLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ClienteBean extends GenericBean<Cliente, ClienteLogic>{

    @Inject
    private ClienteLogic logic;
    
    @Override
    public ClienteLogic getLogic() {
        return logic;
    }

    @Override
    public Class<Cliente> getClassEntity() {
        return Cliente.class;
    }
    
}
