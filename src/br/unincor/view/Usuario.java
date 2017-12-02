package br.unincor.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Usuario {
	
	public void exibeMsg(String texto) {
		JOptionPane.showMessageDialog(null, texto, "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
	}

	public void exibeMsgErro(String texto) {
		JOptionPane.showMessageDialog(null, texto, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	public void exibeMsgDebug(String texto) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(sdf.format(new Date()) + " - [DEBUG] " + texto);
	}
	
	public Integer exibeMenu() {
		String[] opcoes = {"Boletim", "Aproveitamento por disciplina", "Média por disciplina", "Cálculo de Mensalidades"};
		
		return JOptionPane.showOptionDialog(null, 
				"Menu principal", "Menu principal",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				opcoes,
				0);
	}
	
	public Integer importBoletim() {
		String[] opcoes = {"Sim", "Não"};
		
		return JOptionPane.showOptionDialog(null, 
				"Salvar Boletim em txt:", "Exportar",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				opcoes,
				0);
	}

	public Integer recebeInteiro(String texto) {
		return Integer.parseInt(JOptionPane.showInputDialog(texto));
	}

	public Long recebeLong(String texto) {
		try {
			Long resposta = Long.parseLong(JOptionPane.showInputDialog(texto));
			return resposta;
		} catch (Exception e) {
			exibeMsgErro("Erro na entrada do usuário");
		}
		return null;
	}

	public Double recebeDouble(String texto) {
		return Double.parseDouble(JOptionPane.showInputDialog(texto));
	}

	public Float recebeFloat(String texto) {
		return Float.parseFloat(JOptionPane.showInputDialog(texto));
	}

	public Boolean recebeBoolean(String texto) {
		return Boolean.parseBoolean(JOptionPane.showInputDialog(texto));
	}

	public String recebeTexto(String texto) {
		return JOptionPane.showInputDialog(texto);
	}

}
