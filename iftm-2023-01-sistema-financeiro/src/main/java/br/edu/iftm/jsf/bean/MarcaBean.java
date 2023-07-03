
package br.edu.iftm.jsf.bean;

import br.edu.iftm.jsf.logic.MarcaLogic;
import br.edu.iftm.jsf.entity.Marca;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class MarcaBean extends GenericBean<Marca, MarcaLogic>{
    
    
    @Inject
    private MarcaLogic logic;
    
    @Override
    public MarcaLogic getLogic() {
        return logic;
    }

    @Override
    public Class<Marca> getClassEntity() {
        return Marca.class;
    }
}
