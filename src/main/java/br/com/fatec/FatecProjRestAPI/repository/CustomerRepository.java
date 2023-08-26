package br.com.fatec.FatecProjRestAPI.repository;
import br.com.fatec.FatecProjRestAPI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
