package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {

		int resp = 0;

		do {
			resp = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Escolh o metodo para executar: \n 1- Mostra Processos \n2- Mata por PID \n 3- Mata por nome \n 9- Sair"));

			KillController kc = new KillController();

			switch (resp) {
			case 1:
				kc.listaProcessos();
				break;
			case 2:
				String pid = JOptionPane.showInputDialog(null, "Digite valor do PID do processo: ");
				kc.mataPid(pid);
				break;
			case 3:
				String nome = JOptionPane.showInputDialog(null, "Digite nome do processo: ");
				kc.mataNome(nome);
				break;
			}
			
		} while (resp != 9);

	}

}
