package com.pulse.desafio.ecommerce.checkout.repository;

import com.pulse.desafio.ecommerce.checkout.models.ProdutosEmPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosEmPedidoRepository extends JpaRepository<ProdutosEmPedido,Long> {
}
