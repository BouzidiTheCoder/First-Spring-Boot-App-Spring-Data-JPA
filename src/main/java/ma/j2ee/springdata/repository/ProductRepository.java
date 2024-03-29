package ma.j2ee.springdata.repository;
import ma.j2ee.springdata.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Méthode de recherche de produits par nom
    List<Product> findByNameContains(String mc);
    // Méthode de recherche de produits par prix
    List<Product> findByPriceGreaterThan(double price);


    // Requête personnalisée pour la recherche de produits par nom (utilise JPQL)
    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x")String mc);

    // Requête personnalisée pour la recherche de produits par prix (utilise JPQL)
    @Query("select p from Product p where p.price > :x")
    List<Product> search_price(@Param("x")double price);
}
