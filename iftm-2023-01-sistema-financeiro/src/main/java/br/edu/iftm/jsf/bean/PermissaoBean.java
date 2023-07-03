package br.edu.iftm.jsf.bean;

import br.edu.iftm.jsf.entity.Permissao;
import br.edu.iftm.jsf.logic.GenericLogic;
import br.edu.iftm.jsf.logic.PermissaoLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PermissaoBean extends GenericBean<Permissao, PermissaoLogic>{

    @Inject
    private PermissaoLogic logic;
    
    @Override
    public PermissaoLogic getLogic() {
        return  logic;
    }

    @Override
    public Class<Permissao> getClassEntity() {
        return Permissao.class;
    }
    
}
