package es.kairos.productomicroservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductoMicroservicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoMicroservicioApplication.class, args);
	}

}