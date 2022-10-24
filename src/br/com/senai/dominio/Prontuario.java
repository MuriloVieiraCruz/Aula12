package br.com.senai.dominio;

public class Prontuario {

	private double temperatura;
	
	private PressaoSanguinea pressaoSanguinea;
	
	public Prontuario(double temperatura ,int pressaoSistolica, int pressaoDiastolica) {
		this.setTemperatura(temperatura);
		this.pressaoSanguinea = new PressaoSanguinea(
				pressaoDiastolica, pressaoSistolica);
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		
		if (temperatura > 28 && temperatura < 45) {
			this.temperatura = temperatura;
		}else {
			throw new IllegalArgumentException("A temperatura deve estar entre 29 e 44 graus");
		}
		
	}

	public PressaoSanguinea getPressaoSanguinea() {
		return pressaoSanguinea;
	}
	
	public String toString () {
		return "Temperatura: " + getTemperatura() + " - Pressão: " + getPressaoSanguinea();
	}
	
}
