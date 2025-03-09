package com.produtos.api_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.produtos.api_rest.models.Produto;
import com.produtos.api_rest.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public ResponseEntity findById(Long id) {
		return produtoRepository.findById(id)
				                .map(p -> ResponseEntity.ok().body(p))
				                .orElse(ResponseEntity.notFound().build());

	}

	public Produto create(Produto produto) {
		return produtoRepository.save(produto);
	}

    public ResponseEntity update(Long id, Produto produto) {
		 return produtoRepository.findById(id)
				                 .map(p -> {
				                	 p.setNome(produto.getNome());
				                	 p.setQuantidade(produto.getQuantidade());
				                	 p.setValor(produto.getValor());
				                	 Produto updated = produtoRepository.save(p);
				                	 return ResponseEntity.ok().body(updated);
				                	 }).orElse(ResponseEntity.notFound().build());
				                 
	}
	 
	public ResponseEntity<?> deletar(Long id) {
		return produtoRepository.findById(id)
				                .map(p -> {
				                	produtoRepository.deleteById(id);
				                	return ResponseEntity.ok().build();
				                }).orElse(ResponseEntity.notFound().build());
		
	}
	

}
