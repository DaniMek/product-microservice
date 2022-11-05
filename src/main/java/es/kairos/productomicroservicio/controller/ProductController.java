package es.kairos.productomicroservicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.kairos.productomicroservicio.entity.Product;
import es.kairos.productomicroservicio.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable String id) {
		return ResponseEntity.ok(productRepository.findById(id).get());
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productRepository.findAll());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product p) {
		return productRepository.save(p);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@PathVariable String id) {
		productRepository.findById(id).get();
		productRepository.deleteById(id);

	}

	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product p) {
		Product productUpdate = productRepository.findById(id).get();
		productUpdate.setProductDescription(p.getProductDescription());
		productUpdate.setProductName(p.getProductName());
		productUpdate.setUnitPrice(p.getUnitPrice());
		return ResponseEntity.ok(productRepository.save(productUpdate));
	}

}
