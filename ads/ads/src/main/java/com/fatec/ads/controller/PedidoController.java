package com.fatec.ads.controller;

import com.fatec.ads.model.Pedido;
import com.fatec.ads.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Rota GET para listar pedidos de um cliente específico
    @GetMapping("/cliente/{clienteId}")
    public List<Pedido> listarPorCliente(@PathVariable Long clienteId) {
        return pedidoRepository.buscarPedidosPorCliente(clienteId);
    }
}