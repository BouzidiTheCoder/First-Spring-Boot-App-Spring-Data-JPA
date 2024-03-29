package ma.j2ee.springdata.web;

import ma.j2ee.springdata.entities.Product;
import ma.j2ee.springdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepository productRepository;

    // Endpoint REST pour récupérer tous les produits, format JSON
    @GetMapping("/products")
    public List<Product> products(){
        // Récupérer tous les produits, format JSON
        return productRepository.findAll();
    }

    // Endpoint REST pour récupérer un produit par son ID, format JSON
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id){

        Product product = productRepository.findById(id).orElse(null);
        return product;
    }
}
