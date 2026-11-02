package com.fatec.ads.repository;

import com.fatec.ads.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Native Query para listar pedidos de um cliente específico
    @Query(value = "SELECT * FROM pedido WHERE cliente_id = :clienteId", nativeQuery = true)
    List<Pedido> buscarPedidosPorCliente(@Param("clienteId") Long clienteId);
}