package br.com.exemplo.validator.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.exemplo.validator.bean.annotations.CaseMode;
import br.com.exemplo.validator.bean.annotations.CheckCase;

public class Pessoa {
	
	@NotNull
	@CheckCase(value=CaseMode.LOWER, message="nome deve ser minusculo")
	private String nome;
	
	@NotNull
	@Min(1000)
	private Integer ano;
	
	@NotNull
	@Min(1)
	@Max(12)
	private Integer mes;
	
	public Integer getMes() {
		return mes;
	}
	
	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
	

}
