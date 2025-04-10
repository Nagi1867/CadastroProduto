package com.example.CadastroProduto.repositories;

import com.example.CadastroProduto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
