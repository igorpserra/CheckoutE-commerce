package com.pulse.desafio.ecommerce.checkout.models.DTOs.ProdutosDTOs;

import com.pulse.desafio.ecommerce.checkout.models.Produto;
import com.pulse.desafio.ecommerce.checkout.repository.ProdutoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {

    Long id;
    String nomeProduto;
    Float preco;
    String descricao;

    public ProdutoDTO(){}

    public ProdutoDTO(Produto produto){
        this.setId(produto.getId());
        this.setNomeProduto(produto.getNomeProduto());
        this.setPreco(produto.getPreco());
        this.setDescricao(produto.getDescricao());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static List<ProdutoDTO> converteParaDTO (List<Produto> produtos){

        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public Produto atualizar(Produto produto, ProdutoRepository produtoRepository) {
        produto.setNomeProduto(this.getNomeProduto());
        produto.setPreco(this.getPreco());
        produto.setDescricao(this.getDescricao());

        return produto;
    }
}
