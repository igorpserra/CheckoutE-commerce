package com.pulse.desafio.ecommerce.checkout.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Entity
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProdutosEmPedido> produtos;
    private Float precoTotal;
    private Float desconto;
    private Float precoFinal;
    @OneToOne
    private Transportadora transportadora;
    private String codRastreio;

    public Pedido(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public List<ProdutosEmPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutosEmPedido> produtos) {
        this.produtos = produtos;
    }

    public Float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public String getCodRastreio() {
        return codRastreio;
    }

    public void setCodRastreio() {
        Random r = new Random();
        int num = r.nextInt((999999999- 111111111) + 1) + 111111111;
        this.codRastreio = ("CO"+ num +"BR");
    }

    public List<ProdutosEmPedido> converte(List<Produto> produtos){
        return produtos.stream().map(ProdutosEmPedido::new).collect(Collectors.toList());
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Float getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Float precoFinal) {
        this.precoFinal = precoFinal;
    }
}
