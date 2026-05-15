package br.unit.crud_hotel.repository;

import br.unit.crud_hotel.domain.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente , String > {


    Optional<Cliente> findById(UUID id);

    @Transactional
    void deleteByEmail(String email);
}
