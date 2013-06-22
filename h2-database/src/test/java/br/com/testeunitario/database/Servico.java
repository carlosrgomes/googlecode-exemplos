package br.com.testeunitario.database;

public class Servico {
	
	private int codServico;
	private String descricao;
	
	
	public int getCodServico() {
		return codServico;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setCodServico(int codServico) {
		this.codServico = codServico;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Servico(int int1, String string) {
		this.codServico = int1;
		this.descricao = string;
	}

}
