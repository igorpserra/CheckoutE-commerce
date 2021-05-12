package com.pulse.desafio.ecommerce.checkout.repository;

import com.pulse.desafio.ecommerce.checkout.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Pedido findByCliente(String cliente);
}
