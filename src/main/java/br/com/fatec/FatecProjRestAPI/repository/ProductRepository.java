package br.com.fatec.FatecProjRestAPI.repository;
import br.com.fatec.FatecProjRestAPI.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
