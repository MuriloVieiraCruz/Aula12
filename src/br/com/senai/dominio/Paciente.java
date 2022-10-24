package br.com.senai.dominio;

public class Paciente {
	
	private int id;
	
	private String nomeCompleto;
	
	private String rg;
	
	private String cpf;
	
	private Prontuario prontuario;
	
	public Paciente(int id, String nomeCompleto, String rg, String cpf) {
		this.setId(id);
		this.setNomeCompleto(nomeCompleto);
		this.setRg(rg);
		this.setCpf(cpf);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		
		if (nomeCompleto != null && nomeCompleto.length() > 0) {
			
			if(nomeCompleto.contains(" ")) {
				this.nomeCompleto = nomeCompleto;
			}else {
				throw new IllegalArgumentException("O formato "
						+ "deve ser em nome e sobrenome");
			}
			
		}else{
			throw new IllegalArgumentException("O nome completo é obrigatório");
		}
		
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		
		if (cpf != null && cpf.length() == 11) {
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("O cpf é obrigatório e deve possuir 11 caracteres");
		}
		
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public String toString() {
		
		if (getProntuario() != null) {
			return getId() + " - " + getNomeCompleto() + " - " + getProntuario();
		}
		
		return getId() + " - " + getNomeCompleto();
	}

}
