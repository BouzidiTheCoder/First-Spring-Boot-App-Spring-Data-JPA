package ma.j2ee.springdata;

import ma.j2ee.springdata.entities.Product;
import ma.j2ee.springdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    // Injection de dépendance de ProductRepository
    @Autowired
    private ProductRepository productRepository;

    // Méthode principale qui démarre l'application Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    // Méthode exécutée au démarrage de l'application
    @Override
    public void run(String... args) throws Exception {

        // Ajout de quelques produits à la base de données
        productRepository.save(new Product(null, "Computer", 4300, 3));
        productRepository.save(new Product(null, "Printer", 1200, 4));
        productRepository.save(new Product(null, "SmartPhone", 3200, 120));

        // Récupération de tous les produits depuis la base de données
        List<Product> products = productRepository.findAll();

        // Affichage des produits
        products.forEach(p->{
            System.out.println(p.toString());
        });

        // Récupération d'un produit spécifique par son ID
        Product product = productRepository.findById(Long.valueOf(1)).get();

        // Affichage des détails du produit récupéré
        System.out.println("*****************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("*****************");


        System.out.println("----------------------------");
        // Recherche de produits dont le nom contient "C"
        List<Product> C_products1 = productRepository.findByNameContains("C");
        C_products1.forEach(p -> {
            System.out.println(p);
        });

        System.out.println("----------------------------");
        // Recherche de produits dont le nom contient "P"
        List<Product> C_products2 = productRepository.search("%P%");
        C_products2.forEach(p -> {
            System.out.println(p);
        });



        System.out.println("----------------------------");
        // Recherche de produits dont le prix > 3000
        List<Product> C_products4 = productRepository.findByPriceGreaterThan(3000);
        C_products4.forEach(p -> {
            System.out.println(p);
        });

        System.out.println("----------------------------");
        // Recherche de produits dont le prix > 4000
        List<Product> C_products3 = productRepository.search_price(4000);
        C_products3.forEach(p -> {
            System.out.println(p);
        });


    }
}
