package com.pulse.desafio.ecommerce.checkout.models.DTOs;

import com.pulse.desafio.ecommerce.checkout.models.Pedido;

public class CheckoutSuccess {
    private Long numPedido;
    private String codRastreio;
    private Float valorTotal;

    public CheckoutSuccess(Pedido pedido){
        this.numPedido = pedido.getId();
        this.codRastreio = pedido.getCodRastreio();
        this.valorTotal = pedido.getPrecoTotal();
    }

    public Long getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Long numPedido) {
        this.numPedido = numPedido;
    }

    public String getCodRastreio() {
        return codRastreio;
    }

    public void setCodRastreio(String codRastreio) {
        this.codRastreio = codRastreio;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
