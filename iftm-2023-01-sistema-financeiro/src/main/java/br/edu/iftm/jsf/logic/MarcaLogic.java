package br.edu.iftm.jsf.logic;

import br.edu.iftm.jsf.dao.MarcaDAO;
import br.edu.iftm.jsf.entity.Marca;
import br.edu.iftm.jsf.logic.GenericLogic;
import br.edu.iftm.jsf.util.Transacional;
import br.edu.iftm.jsf.util.exception.ErroNegocioException;
import br.edu.iftm.jsf.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class MarcaLogic implements GenericLogic<Marca> {

    @Inject
    private MarcaDAO dao;

    @Override
    @Transacional
    public Marca salvar(Marca entity) throws ErroNegocioException, ErroSistemaException {
        if ("".equals(entity.getNome())) {
            throw new ErroNegocioException("Por favor informe o nome");

        }
        entity = dao.salvar(entity);
        return entity;
    }

    @Override
    @Transacional
    public void remover(Marca entity) throws ErroNegocioException, ErroSistemaException {
        dao.deletar(entity.getId());
    }

    @Override
    public List<Marca> listar() throws ErroNegocioException, ErroSistemaException {
        return dao.listar();
    }

    public List<Marca> completeMarca(String marcaRecebida) {
        List<Marca> marcasFiltradas = new ArrayList<>();

        Iterator<Marca> iterator = dao.listar().iterator();
        while (iterator.hasNext()) {
            Marca marca = (Marca) iterator.next();
            if (marca.getNome().toLowerCase().contains(marcaRecebida.toLowerCase())) {
                marcasFiltradas.add(marca);
            }
        }

        return marcasFiltradas;
    }

}
