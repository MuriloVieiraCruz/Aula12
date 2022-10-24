package br.com.senai.dominio;

public class PressaoSanguinea {

	private int diastolica;
	
	private int sistolica;

	public PressaoSanguinea(int diastolica, int sistolica) {
		this.setDiastolica(diastolica);
		this.setSistolica(sistolica);
	}

	public int getDiastolica() {
		return diastolica;
	}

	public void setDiastolica(int diastolica) {
		
		if (diastolica >= 1) {
			this.diastolica = diastolica;
		}else {
			throw new IllegalArgumentException("A pressão "
					+ "diastólica não pode ser menor que 1");
		}
		
		
	}

	public int getSistolica() {
		return sistolica;
	}

	public void setSistolica(int sistolica) {
		
		if (sistolica >= 1) {
			this.sistolica = sistolica;
		}else {
			throw new IllegalArgumentException("A pressão "
					+ "sistótica não pode ser menor que 1");
		}
		
		
	}
	
	public String toString () {
		return "Sistólica: " + getSistolica() 
		+ " - Diastólica: " + getDiastolica();
	}
	
	
}
