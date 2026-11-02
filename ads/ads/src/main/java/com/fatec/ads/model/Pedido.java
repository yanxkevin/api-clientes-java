package com.fatec.ads.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPedido;
    private Double valorTotal;
    private Long clienteId;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDataPedido() { return dataPedido; }
    public void setDataPedido(LocalDate dataPedido) { this.dataPedido = dataPedido; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}