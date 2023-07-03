package br.edu.iftm.jsf.dao;

import br.edu.iftm.jsf.entity.Usuario;
import java.util.List;

public class UsuarioDAO extends GenericDAO<Usuario, Long>{

    @Override
    public Class<Usuario> getClassEntity() {
        return Usuario.class;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = super.listar();
        for (Usuario usuario : usuarios) {
            usuario.getPermissaoList().size();
        }
        return usuarios;
    }
    
    
  
    
}
