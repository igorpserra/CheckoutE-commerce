package com.pulse.desafio.ecommerce.checkout.models.DTOs;

import com.pulse.desafio.ecommerce.checkout.models.TipoPagamento;

public class DadosCheckout {

    private TipoPagamento tipoPagamento;
    private String nomeTransportadora;
    private String cupom;

    public DadosCheckout() {}

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getNomeTransportadora() {
        return nomeTransportadora;
    }

    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }
}
