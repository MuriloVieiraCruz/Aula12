package br.com.senai.util;

import br.com.senai.dominio.Paciente;

public class BaseDeDados {
	
	private final int QTDE_MAX = 100;
	
	private Paciente[] pacientes;
	
	private int indice;
	
	public BaseDeDados() {
		this.pacientes = new Paciente[QTDE_MAX];
		
	}
	
	public void registrar (Paciente paciente) {
		if(paciente != null) {
			this.pacientes[indice] = paciente;
			this.indice++;
		}else {
			throw new IllegalArgumentException(
					"O paciente não pode ser nulo");
		}
	}
	
	public Paciente[] listarRegistrados() {
		Paciente[] pacientesRegistrados = new Paciente[indice];
		int i = 0;
		for (Paciente paciente : pacientes) {
			if(paciente != null) {
				pacientesRegistrados[i] = paciente;
				i++;
			}
		}
		return pacientesRegistrados;
	}
	
	public Paciente buscarPor(int id) {
		Paciente[] pacientesRegistrados = listarRegistrados();
		for (Paciente paciente : pacientesRegistrados) {
			if(paciente.getId() == id) {
				return paciente;
			}
		}
		
		throw new IllegalArgumentException("Não existe paciente com id informado!");
	}

}
