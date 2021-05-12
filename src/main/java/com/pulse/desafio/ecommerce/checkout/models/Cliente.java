package com.pulse.desafio.ecommerce.checkout.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeCliente;
    private String cpf;
    @OneToOne
    private Endereco enderecoCliente;
    @OneToOne
    private Pagamento dadosCartao;

    public Cliente(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(Endereco enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public Pagamento getDadosCartao() {
        return dadosCartao;
    }

    public void setDadosCartao(Pagamento dadosCartao) {
        this.dadosCartao = dadosCartao;
    }
}
