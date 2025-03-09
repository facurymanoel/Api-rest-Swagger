package com.produtos.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.api_rest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Produto findById(long id); 
		
	 

}
