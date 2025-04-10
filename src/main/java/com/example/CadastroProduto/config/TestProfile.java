package com.example.CadastroProduto.config;

import com.example.CadastroProduto.entities.Produto;
import com.example.CadastroProduto.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestProfile implements CommandLineRunner {
    @Autowired
    private ProdutoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Produto produto = new Produto(null, "boneco", 19.90, "92923jfjf02", 1);
        repository.save(produto);
    }
}
