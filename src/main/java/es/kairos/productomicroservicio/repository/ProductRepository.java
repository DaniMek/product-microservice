package es.kairos.productomicroservicio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.kairos.productomicroservicio.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
