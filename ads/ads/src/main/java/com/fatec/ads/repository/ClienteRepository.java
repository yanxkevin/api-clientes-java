package com.fatec.ads.repository;

import com.fatec.ads.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Native Query para Login
    @Query(value = "SELECT * FROM cliente WHERE email = :email AND senha = :senha", nativeQuery = true)
    Cliente fazerLogin(@Param("email") String email, @Param("senha") String senha);

    // Native Query para Reenvio de Senha (Buscar por email)
    @Query(value = "SELECT * FROM cliente WHERE email = :email", nativeQuery = true)
    Cliente buscarPorEmail(@Param("email") String email);
}