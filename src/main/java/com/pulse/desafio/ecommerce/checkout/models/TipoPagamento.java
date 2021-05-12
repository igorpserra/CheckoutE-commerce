package com.pulse.desafio.ecommerce.checkout.models;

public enum TipoPagamento {

    VISTA("A vista no cartão, desconto 5pct"),
    BOLETO("Pagamento no boleto, denconto 5pct"),
    PARCELADO("Pagamento dividido em parcelas"),
    CREDIARIO("Pagamento utilizando crediario");

    private String descrição;

    TipoPagamento(String s) {
        this.descrição = s;
    }

    public String getDescrição() {
        return descrição;
    }
}
