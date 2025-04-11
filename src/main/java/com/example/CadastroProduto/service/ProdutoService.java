package com.example.CadastroProduto.service;

import com.example.CadastroProduto.entities.Produto;
import com.example.CadastroProduto.repositories.ProdutoRepository;
import com.example.CadastroProduto.service.exceptions.DatabaseException;
import com.example.CadastroProduto.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Produto insert(Produto obj) {
        return obj = repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Produto update(Long id, Produto obj) {
        try {
            Produto entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Produto entity, Produto obj) {
        entity.setNome(obj.getNome());
        entity.setPreco(obj.getPreco());
        entity.setCodigoBarra(obj.getCodigoBarra());
        entity.setStatus(obj.getStatus());
    }
}
