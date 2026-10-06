package com.ads.loja;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")

public class ClienteController {
    @GetMapping("/api/cliente/{codigo}")
    public Cliente carregarDetalhe(@PathVariable("codigo") int codigo) {
        var obj = new Cliente();
        obj.setCodigo(codigo);
        obj.setNome("João da Silva");
        obj.setEmail("joao@email.com");
        obj.setCpf("12345678900");
        obj.setTelefone("11999999999");
        return obj;
    }

    @PostMapping("/api/cliente/")
    public String gravar(@RequestBody Cliente obj) {  
        return "Cliente gravado com sucesso: " + obj.getNome(); 
    }

    @PutMapping("/api/cliente/{codigo}")
    public String alterar(@PathVariable("codigo") int codigo, @RequestBody Cliente obj) {
        obj.setCodigo(codigo);
        return "Cliente alterado com sucesso: " + obj.getNome();
    }

    @DeleteMapping("/api/cliente/{codigo}")
    public String excluir(@PathVariable("codigo") int codigo) {
        return "Cliente excluído com sucesso: " + codigo;
    }
}