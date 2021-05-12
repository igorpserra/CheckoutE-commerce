package com.pulse.desafio.ecommerce.checkout.controllers;

import com.pulse.desafio.ecommerce.checkout.models.DTOs.ProdutosDTOs.ProdutoDTO;
import com.pulse.desafio.ecommerce.checkout.models.Produto;
import com.pulse.desafio.ecommerce.checkout.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

//Controlador dos serviços de produto

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    ProdutoRepository produtoRepository;

    //Método criar através do POST
    @PostMapping("/new")
    @Transactional
    public ProdutoDTO criar (@RequestBody ProdutoDTO produtoDTO){
        Produto produto = new Produto(produtoDTO);

        produtoRepository.save(produto);

        return produtoDTO;
    }

    //Método listar através do GET e retornando através da classe DTO
    @GetMapping
    public List<ProdutoDTO> listar(){

        List<Produto> produtos = produtoRepository.findAll();

        //método que converte a lista de produtos para uma lista de produtos da classe DTO
        return ProdutoDTO.converteParaDTO(produtos);
    }

    //Método excluir através do DELETE
    //id para exclusão passada na URL por exemplo: localhost:8080/produtos/delete/123
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()){
            produtoRepository.delete(produto.get());
            //retorno de acordo com o HTTP 200ok
            return ResponseEntity.ok().build();
        }else {
            //retorno do código HTTP 404 not found
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/editar/{id}")
    @Transactional
    public ResponseEntity<ProdutoDTO> editar(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){

        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isPresent()){
            produtoDTO.atualizar(produto.get(), produtoRepository);
            return ResponseEntity.ok(new ProdutoDTO(produto.get()));

        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
