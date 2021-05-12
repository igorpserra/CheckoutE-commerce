package com.pulse.desafio.ecommerce.checkout.repository;

import com.pulse.desafio.ecommerce.checkout.models.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomRepository extends JpaRepository<Cupom,Long> {
    Cupom findByNomeCupom(String nome);
}
