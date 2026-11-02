package com.fatec.ads.controller;

import com.fatec.ads.model.Cliente;
import com.fatec.ads.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Rota POST para Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciais) {
        String email = credenciais.get("email");
        String senha = credenciais.get("senha");

        Cliente cliente = clienteRepository.fazerLogin(email, senha);

        if (cliente != null) {
            return ResponseEntity.ok(cliente); // Retorna 200 OK com os dados do cliente
        } else {
            return ResponseEntity.status(401).body("Email ou senha incorretos."); // Retorna 401
        }
    }

    // Rota POST para Reenvio de Senha
    @PostMapping("/reenviar-senha")
    public ResponseEntity<String> reenviarSenha(@RequestBody Map<String, String> dados) {
        String email = dados.get("email");
        Cliente cliente = clienteRepository.buscarPorEmail(email);

        if (cliente != null) {
            // Aqui você simularia o envio do e-mail
            return ResponseEntity.ok("E-mail de redefinição enviado com sucesso para: " + email);
        } else {
            return ResponseEntity.status(404).body("E-mail não encontrado no sistema.");
        }
    }
}