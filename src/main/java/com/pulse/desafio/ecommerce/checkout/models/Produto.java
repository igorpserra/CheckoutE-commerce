package com.pulse.desafio.ecommerce.checkout.models;

import com.pulse.desafio.ecommerce.checkout.models.DTOs.ProdutosDTOs.ProdutoDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private Float preco;
    private String descricao;

    public Produto(){}

    public Produto(ProdutoDTO produtoDTO){
        this.setNomeProduto(produtoDTO.getNomeProduto());
        this.setPreco(produtoDTO.getPreco());
        this.setDescricao(produtoDTO.getDescricao());
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
}
