package com.fatec.lojinha;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
    @Query (value = "select * from produto where destaque > 0 and quantidade > 0 order by desttaque", nativeQuery = true)
    public List<Produto> carregarVitrine();

    @Query (value = "select * from produto where nome like :termo order by destaque", nativeQuery = true)
    public List<Produto> fazerBuscar(String termo);
}
