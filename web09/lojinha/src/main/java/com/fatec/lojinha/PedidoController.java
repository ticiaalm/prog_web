package com.fatec.lojinha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin (origins = "*")
public class PedidoController {
    @Autowired 
    private PedidoRepository bd;
    private ClienteRepository clientes;

    @PostMapping ("/api/pedido")
    public String gravar(@RequestBody Pedido obj) {
        if (obj.getCliente() == null || !clientes.existsById(obj.getCliente().getCodigo())) {
            return "Cliente não existe.";
        }
        bd.save(obj);
        return "Pedido gravado com sucesso: " + obj.getCodigo();
    }
    @PutMapping ("/api/pedido")
    public String alterar(@RequestBody Pedido obj) {
        if (bd.existsById(obj.getCodigo())) {
            if (obj.getCliente() == null || !clientes.existsById(obj.getCliente().getCodigo())) {
                return "Cliente não existe.";
            }
            bd.save(obj);
            return "Pedido alterado com sucesso!";
        } else {
            return "Pedido não existe.";
        }
    }
    @GetMapping ("/api/pedido/{codigo}")
    public Pedido carregar(@PathVariable ("codigo") int codigo) {
        if (bd.existsById(codigo)) {
            return bd.findById(codigo).get();
        } else {
            return new Pedido();
        }
    }
    @DeleteMapping ("/api/pedido/{codigo}")
    public String remover(@PathVariable ("codigo") int codigo) {
        if (bd.existsById(codigo)) {
            bd.deleteById(codigo);
            return "Pedido removido com sucesso!";
        } else {
            return "Pedido não existe.";
        }
    }
}