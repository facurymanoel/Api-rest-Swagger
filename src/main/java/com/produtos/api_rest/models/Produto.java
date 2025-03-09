package com.produtos.api_rest.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	// @ApiModelProperty - principal função é fornecer uma descrição do campo.
	@ApiModelProperty(value = "Código do produto", dataType = "Long")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ApiModelProperty(value = "Nome do produto", dataType = "String")
	private String nome;

	@ApiModelProperty(value = "Quantidade do produto", dataType = "BigDecimal")
	private BigDecimal quantidade;

	@ApiModelProperty(value = "Valor do produto", dataType = "BigDecimal")
	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
