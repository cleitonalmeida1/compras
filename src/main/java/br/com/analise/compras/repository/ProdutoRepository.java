package br.com.analise.compras.repository;

import br.com.analise.compras.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE UPPER(p.nome) LIKE UPPER(?1)")
    Produto buscarPorNome(String nome);
}
