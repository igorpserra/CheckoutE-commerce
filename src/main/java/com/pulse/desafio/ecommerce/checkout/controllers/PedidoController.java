package com.pulse.desafio.ecommerce.checkout.controllers;

import com.pulse.desafio.ecommerce.checkout.models.*;
import com.pulse.desafio.ecommerce.checkout.models.DTOs.Carrinho;
import com.pulse.desafio.ecommerce.checkout.models.DTOs.CheckoutSuccess;
import com.pulse.desafio.ecommerce.checkout.models.DTOs.DadosCheckout;
import com.pulse.desafio.ecommerce.checkout.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    TransportadoraRepository transportadoraRepository;
    @Autowired
    ProdutosEmPedidoRepository produtosEmPedidoRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    CupomRepository cupomRepository;


    Cliente cliente;
    Carrinho carrinho = new Carrinho();

    @PostMapping("/inicio")
    public ResponseEntity criarCarrinho(String user){
        cliente = clienteRepository.findByNomeCliente(user);

        if(cliente == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/carrinho")
    public ResponseEntity<Carrinho> ListarCarrinho(){

        if (cliente == null){
            return ResponseEntity.notFound().build();
        }else{
            carrinho.setNomeClienteCarrinho(cliente.getNomeCliente());
            return ResponseEntity.ok(carrinho);
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<List<Produto>> adicionarItem (Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            Float antigoValor = carrinho.getPrecoTotal();
            carrinho.setPrecoTotal(antigoValor += produto.get().getPreco());
            Carrinho.produtos.add(produto.get());

            return ResponseEntity.ok(Carrinho.produtos);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //checar na lista a presença do id informado e não no banco de pedidos
    @DeleteMapping("/remover")
    public ResponseEntity<List<Produto>> removerItem (Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
            if(produto.isPresent()) {
                for (Produto produtoI : Carrinho.getProdutos()) {
                    if (produtoI.getId().equals(produto.get().getId())) {
                        Carrinho.getProdutos().remove(produtoI);
                        return ResponseEntity.ok(Carrinho.getProdutos());
                    }
                }
                return ResponseEntity.notFound().build();

            }else{
                return ResponseEntity.notFound().build();
            }
    }


    @PostMapping("/checkout")
    public CheckoutSuccess checkout(@RequestBody DadosCheckout dados){
        Transportadora transportadora = transportadoraRepository.findByNome(dados.getNomeTransportadora());
        Pedido pedido = new Pedido();
        Float valorDesconto = 0.00F;
        Float valorFinal = 0.00F;

        pedido.setTipoPagamento(dados.getTipoPagamento());
        pedido.setCliente(cliente.getNomeCliente());
        pedido.setPrecoTotal(carrinho.getPrecoTotal());
        pedido.setTransportadora(transportadora);
        pedido.setCodRastreio();
        pedido.setProdutos(pedido.converte(carrinho.getProdutosObjeto()));
        //referenciando o pedido aos itens
        for (ProdutosEmPedido produtosEmPedido: pedido.getProdutos()) {
            produtosEmPedido.setPedido(pedido);
        }

        //adição de desconto de 5% para compras no boleto ou a vista
        if(pedido.getTipoPagamento().equals(TipoPagamento.BOLETO) ||
                pedido.getTipoPagamento().equals(TipoPagamento.VISTA)){

            valorDesconto = pedido.getPrecoTotal() * 0.05F;
            valorFinal = pedido.getPrecoTotal() - valorDesconto;
            pedido.setPrecoTotal(valorFinal);
        }else{
            valorFinal = pedido.getPrecoTotal();
        }

        Cupom cupom = cupomRepository.findByNomeCupom(dados.getCupom());
        if(cupom != null){
           Float valorCupom = valorFinal * cupom.getValorDesconto();
            valorDesconto += valorCupom;
            valorFinal -= valorCupom;
        }else{
            valorFinal = pedido.getPrecoTotal();
        }

        valorFinal += transportadora.getTaxa();
        pedido.setDesconto(valorDesconto);
        pedido.setPrecoFinal(valorFinal);

        pedidoRepository.save(pedido);

        return new CheckoutSuccess(pedido);

    }

    @GetMapping("/pedidos")
    public List<Pedido> listarPedidos(){

        return pedidoRepository.findAll();
    }

    @GetMapping("/checkout/transportadoras")
    public List<Transportadora> listarTransportadoras(){

        return transportadoraRepository.findAll();
    }

    @GetMapping("/checkout/cupons")
    public List<Cupom> listarCupons(){

        return cupomRepository.findAll();
    }
}
