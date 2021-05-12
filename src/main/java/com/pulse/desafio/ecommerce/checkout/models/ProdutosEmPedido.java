package com.pulse.desafio.ecommerce.checkout.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pulse.desafio.ecommerce.checkout.models.DTOs.ProdutosDTOs.ProdutoDTO;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "produtos_em_pedido")
public class ProdutosEmPedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private Float preço;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    @JsonIgnore
    private Pedido pedido;

    public ProdutosEmPedido(){}

    public ProdutosEmPedido(Produto produto){
        this.nomeProduto = produto.getNomeProduto();
        this.preço = produto.getPreco();
        this.descricao = produto.getDescricao();
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

    public Float getPreço() {
        return preço;
    }

    public void setPreço(Float preço) {
        this.preço = preço;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
