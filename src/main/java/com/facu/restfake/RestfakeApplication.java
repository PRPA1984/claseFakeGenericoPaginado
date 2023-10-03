package com.facu.restfake;

import com.facu.restfake.entities.Product;
import com.facu.restfake.entities.Rating;
import com.facu.restfake.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootApplication
public class RestfakeApplication {

	@Autowired
	protected ProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestfakeApplication.class, args);
		System.out.println("Corriendo mi Fake Api");
	}

	@Bean
	CommandLineRunner init() {
		return args -> {

			Random random = new Random();

			for (int i = 0; i < 40; i++) {

				Product product = new Product();
				product.setTitle("Titulo " + i);
				product.setPrice(BigDecimal.valueOf(i));
				product.setDescription("Descripcion "+ i);
				product.setCategory("Categoria " + random.nextInt(10));
				product.setImage("URL Imagen "+ i);

				Rating rating = new Rating();
				rating.setCount(i);
				rating.setRate(BigDecimal.valueOf(i));

				product.setRating(rating);

				productoRepository.save(product);
			}
		};

	}

}
