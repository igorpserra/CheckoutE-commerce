package com.pulse.desafio.ecommerce.checkout.controllers;

import com.pulse.desafio.ecommerce.checkout.models.Cliente;
import com.pulse.desafio.ecommerce.checkout.models.Endereco;
import com.pulse.desafio.ecommerce.checkout.models.Pagamento;
import com.pulse.desafio.ecommerce.checkout.repository.ClienteRepository;
import com.pulse.desafio.ecommerce.checkout.repository.EnderecoRepository;
import com.pulse.desafio.ecommerce.checkout.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    PagamentoRepository pagamentoRepository;

    @PostMapping("/criar")
    public void criarCliente(@RequestBody Cliente cliente){

        cliente.getEnderecoCliente().setNomeCliente(cliente.getNomeCliente());
        enderecoRepository.save(cliente.getEnderecoCliente());
        clienteRepository.save(cliente);

    }

    @GetMapping("/procurar/{id}")
    public Cliente procurar(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.get();
    }

    @GetMapping("/procurar/all")
    public List<Cliente> listarTodos(){

        return clienteRepository.findAll();
    }



//    @EventListener
//    public void seedCliente(ContextRefreshedEvent event){
//        Cliente cliente1 = new Cliente();
//        Cliente cliente2 = new Cliente();
//
//        cliente1.setNomeCliente("PulseCompras");
//        cliente1.setCpf("123.123.123-00");
//            Endereco endereco1 = new Endereco();
//            endereco1.setNomeCliente(cliente1.getNomeCliente());
//            endereco1.setCep("65123-110");
//            endereco1.setNumero(21);
//            endereco1.setRua("Rua Diamante");
//            enderecoRepository.save(endereco1);
//        cliente1.setEnderecoCliente(endereco1);
//            Pagamento pagamento1 = new Pagamento();
//            pagamento1.setNomeCartao("PulseCompras Virtual");
//            pagamento1.setValidade("02/22");
//            pagamento1.setNumeroCartao("4452332678429465");
//            pagamentoRepository.save(pagamento1);
//        cliente1.setDadosCartao(pagamento1);
//
//        cliente2.setNomeCliente("EstoquePulse");
//        cliente2.setCpf("321.321.321-12");
//            Endereco endereco2 = new Endereco();
//            endereco2.setNomeCliente(cliente2.getNomeCliente());
//            endereco2.setCep("65321-123");
//            endereco2.setNumero(111);
//            endereco2.setRua("Rua Pax");
//            enderecoRepository.save(endereco2);
//        cliente2.setEnderecoCliente(endereco2);
//            Pagamento pagamento2 = new Pagamento();
//            pagamento2.setNomeCartao("EstoquePulse Master");
//            pagamento2.setValidade("07/24");
//            pagamento2.setNumeroCartao("6487549863638457");
//            pagamentoRepository.save(pagamento2);
//        cliente2.setDadosCartao(pagamento2);
//
//        if(!(clienteRepository.existsByNomeCliente(cliente1.getNomeCliente()))){
//            clienteRepository.save(cliente1);
//        }
//        if(!(clienteRepository.existsByNomeCliente(cliente2.getNomeCliente()))){
//            clienteRepository.save(cliente2);
//        }
//    }
}
