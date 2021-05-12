package com.pulse.desafio.ecommerce.checkout.controllers;

import com.pulse.desafio.ecommerce.checkout.models.Cliente;
import com.pulse.desafio.ecommerce.checkout.models.Endereco;
import com.pulse.desafio.ecommerce.checkout.repository.ClienteRepository;
import com.pulse.desafio.ecommerce.checkout.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
