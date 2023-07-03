package br.edu.iftm.jsf.bean;

import br.edu.iftm.jsf.entity.Permissao;
import br.edu.iftm.jsf.entity.Usuario;
import br.edu.iftm.jsf.logic.PermissaoLogic;
import br.edu.iftm.jsf.logic.UsuarioLogic;
import br.edu.iftm.jsf.util.exception.ErroNegocioException;
import br.edu.iftm.jsf.util.exception.ErroSistemaException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class UsuarioBean extends GenericBean<Usuario, UsuarioLogic> {

    @Inject    
    private UsuarioLogic logic;

    @Inject
    private PermissaoLogic permissaoLogic;

    private List<Permissao> permissaoList;
    
    @Override
    public UsuarioLogic getLogic() {
        return logic;
    }

    public void desativar(Usuario entity){
        try {
            if(entity.getDataDesativacao() == null) {
                entity.setDataDesativacao(new Date());
            } else {
                entity.setDataDesativacao(null);
            }
            getLogic().salvar(entity);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addError(ex);
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Class<Usuario> getClassEntity() {
        return Usuario.class;
    }

    public List<Permissao> getPermissaoList() {
        if(permissaoList == null) {
            permissaoList = permissaoLogic.listarTodas();
        }
        return permissaoList;
    }
    
    
    
}
