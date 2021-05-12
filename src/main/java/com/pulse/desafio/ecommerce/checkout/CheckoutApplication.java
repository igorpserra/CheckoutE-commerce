package com.pulse.desafio.ecommerce.checkout;

import com.pulse.desafio.ecommerce.checkout.models.Pagamento;
import com.pulse.desafio.ecommerce.checkout.models.Produto;
import com.pulse.desafio.ecommerce.checkout.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutApplication.class, args);}
}
