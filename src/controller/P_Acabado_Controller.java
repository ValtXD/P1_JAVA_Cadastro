package controller;

import model.ProdutoAcabado;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class P_Acabado_Controller {
    private Set<ProdutoAcabado> produtos = new HashSet<>();

    public boolean salvar(ProdutoAcabado produto) {
        return produtos.add(produto);
    }

    public List<ProdutoAcabado> getProdutos() {
        return new ArrayList<>(produtos);
    }
}
