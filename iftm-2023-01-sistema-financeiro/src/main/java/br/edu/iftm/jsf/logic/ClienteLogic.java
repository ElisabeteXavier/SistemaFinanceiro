package br.edu.iftm.jsf.logic;

import br.edu.iftm.jsf.entity.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClienteLogic implements GenericLogic<Cliente> {

    private List<Cliente> clientes = new ArrayList<>();
    private Long id = 1L;
    
    @Override
    public Cliente salvar(Cliente entity) {
        entity.setId(id++);
        clientes.add(entity);
        return entity;
    }

    @Override
    public void remover(Cliente entity) {
        clientes.remove(entity);
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }
    
}
