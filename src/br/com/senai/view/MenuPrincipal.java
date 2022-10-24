package br.com.senai.view;

import javax.swing.JOptionPane;

import br.com.senai.dominio.Paciente;
import br.com.senai.dominio.Prontuario;
import br.com.senai.util.BaseDeDados;

public class MenuPrincipal {
	
	private BaseDeDados baseDeDados;
	
	public MenuPrincipal() {
		this.baseDeDados = new BaseDeDados();
	}
	
	public void Iniciar() {
		
		int opcaoSelecionada = 0;
		
		String textoDoMenu = "1 - Cadastrar Paciente\n"
				+ "2 - Cadastrar Prontuário\n"
				+ "3 - Listar Paciente\n"
				+ "4 - Sair";
		
		Paciente paciente = new Paciente(1, "Murilo Vieira", "123456789", "12345678912");
		
		this.baseDeDados.registrar(paciente);
		
		 paciente = new Paciente(2, "Loiola Pordemos", "123456789", "12345678912");
		
		this.baseDeDados.registrar(paciente);
		
		do {
			
			try {
				opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(textoDoMenu));
	
				switch (opcaoSelecionada) {
				case 1: {
					this.cadastrarPaciente();
					
					break;
				}
				case 2 : {
					this.cadastrarProntuario();
					break;
				}
				case 3 : {
					this.listarPacientes();
					break;
				}
		}
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"A opção é inválida");
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			
		}while(opcaoSelecionada != 4);
		
	}
	
	private void cadastrarPaciente() {
		int id = 0;
		do {
			try {
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do paciente:"));
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "o id deve conter apenas n�meros!");
				id = 0;
			}
		}while (id == 0);
		try {
			
			String nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo:");
			String rg = JOptionPane.showInputDialog("Digite o rg:");
			String cpf = JOptionPane.showInputDialog("Digite o cpf:");
			Paciente novoPaciente = new Paciente(id, nomeCompleto, rg, cpf);
			this.baseDeDados.registrar(novoPaciente);
			JOptionPane.showMessageDialog(null, "Paciente registrado com sucesso!");
			
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private Paciente selecionarPaciente() {
		Paciente[] pacientes = baseDeDados.listarRegistrados();
		String listagem = "";
		for (Paciente paciente : pacientes) {
			listagem += paciente + "\n";
		}
		Paciente paciente = null;
		try {
			int idInformado = Integer.parseInt(JOptionPane.showInputDialog(listagem));
			 paciente = baseDeDados.buscarPor(idInformado);
		}catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, nfe.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return paciente;
		
	}
	
	private void cadastrarProntuario() {
		Paciente pacienteSelecionado = selecionarPaciente();
		try {
			if(pacienteSelecionado != null) {
			double temperatura = Double.parseDouble(JOptionPane
					.showInputDialog("Informe a temperatura:"));
			
			int pressaoSistolica = Integer.parseInt(JOptionPane
					.showInputDialog("Informe a pressão sistólica:"));
			
			int pressaoDiastolica = Integer.parseInt(JOptionPane
					.showInputDialog("Informe a pressão diastólica:"));
			
			Prontuario prontuario = new Prontuario(temperatura, 
					pressaoSistolica, pressaoDiastolica);
			
				pacienteSelecionado.setProntuario(prontuario);
				JOptionPane.showMessageDialog(null, "Prontuário registrado com sucesso");
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, nfe.getMessage());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void listarPacientes() {
		Paciente[] pacientes = baseDeDados.listarRegistrados();
		String relatorio = "";
		for (Paciente paciente : pacientes) {
			relatorio += paciente + "\n";
		}
		JOptionPane.showMessageDialog(null, relatorio);
	}
	
}
