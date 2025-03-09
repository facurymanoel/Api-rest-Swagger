package com.produtos.api_rest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.api_rest.models.Produto;
import com.produtos.api_rest.repository.ProdutoRepository;
import com.produtos.api_rest.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Usuário"}, description = "Cadastro de Usuário")
@RestController
@RequestMapping(value = "/produtos")
 public class ProdutoResource {
    @Autowired
	private ProdutoService produtoService;
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping()
	public ResponseEntity<List<Produto>> listaTodos() {
		List<Produto> produto = produtoService.findAll();
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
    
	@ApiOperation(value = "Busca Usuário por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorno com sucesso."),
			@ApiResponse(code = 403, message = "Você não têm permissão para acessar."),
			@ApiResponse(code = 500, message = "Erro interno do servidor."),
			@ApiResponse(code = 401, message = "Acesso não autorizado.")
	})
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Produto> listaPorId(@PathVariable Long id) {
		return produtoService.findById(id);

	}

	@PostMapping()
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		produto = produtoService.create(produto);
		return new ResponseEntity<Produto>(HttpStatus.CREATED);

	}

	@PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json" )
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		return new ResponseEntity<>(produtoService.update(id, produto), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();

	}

}
