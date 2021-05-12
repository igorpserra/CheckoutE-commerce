package com.pulse.desafio.ecommerce.checkout.models.DTOs;

import com.pulse.desafio.ecommerce.checkout.models.Produto;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    public static List<Produto> produtos = new ArrayList<>();

    private String nomeClienteCarrinho;
    private List<Produto> produtosObjeto;
    private Float precoTotal = 0.0F;

    public Carrinho(){
        this.setProdutosObjeto(getProdutos());
    }

    public String getNomeClienteCarrinho() {
        return nomeClienteCarrinho;
    }

    public void setNomeClienteCarrinho(String nomeClienteCarrinho) {
        this.nomeClienteCarrinho = nomeClienteCarrinho;
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

    public static void setProdutos(List<Produto> produtos) {
        Carrinho.produtos = produtos;
    }

    public Float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<Produto> getProdutosObjeto() {
        return produtosObjeto;
    }

    public void setProdutosObjeto(List<Produto> produtosObjeto) {
        this.produtosObjeto = produtosObjeto;
    }
}
