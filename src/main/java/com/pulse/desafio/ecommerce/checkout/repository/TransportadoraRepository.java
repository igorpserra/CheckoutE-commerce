package com.pulse.desafio.ecommerce.checkout.repository;

import com.pulse.desafio.ecommerce.checkout.models.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportadoraRepository extends JpaRepository<Transportadora,Long> {

    Transportadora findByNome(String nome);
}
