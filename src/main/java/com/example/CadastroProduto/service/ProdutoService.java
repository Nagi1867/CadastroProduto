package com.example.CadastroProduto.service;

import com.example.CadastroProduto.entities.Produto;
import com.example.CadastroProduto.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }

    public Produto insert(Produto obj) {
        return obj = repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
