package model;

import AbstractModels.Produto;

public class ProdutoAcabado extends Produto {
    private int garantia;
    private int quantidadePalete;

    public ProdutoAcabado(String nome, float preco, String codigoLegado, int garantia, int quantidadePalete) {
        super(nome, preco, codigoLegado);
        this.garantia = garantia;
        this.quantidadePalete = quantidadePalete;
    }

    public ProdutoAcabado() {
        super();
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public int getQuantidadePalete() {
        return quantidadePalete;
    }

    public void setQuantidadePalete(int quantidadePalete) {
        this.quantidadePalete = quantidadePalete;
    }
}
