package com.pulse.desafio.ecommerce.checkout.repository;

import com.pulse.desafio.ecommerce.checkout.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Cliente findByNomeCliente(String usuario);
}
