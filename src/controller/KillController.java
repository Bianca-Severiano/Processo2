package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}	
	
	public void chamaProcesso(String c, int valor, String os) {
		try {
			Process processo = Runtime.getRuntime().exec(c);

			if (valor == 0 || valor == 1) { // Mostra Processos
				InputStream fluxo = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
			}		

		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
		}
	}
	
	public void listaProcessos () {
		String os = os();
		if (os.contains("Windows")) {
			String c = "TASKLIST /FO TABLE";
			chamaProcesso(c, 0, os);
			
		} else if (os.contains("Linux")) {
			String c = "ps -ef";
			chamaProcesso(c, 1, os);
		}
		
	}
	
	public void mataPid (String pid) {
		String os = os();
		
		if (os.contains("Windows")) {
			String c = "TASKKILL /PID " + pid ;
			chamaProcesso(c, 2, os);
			
		} else if (os.contains("Linux")) {
			String c = "kill -9 " + pid;
			chamaProcesso(c, 3, os);
		}
	}
	
	
	public void mataNome (String nome) {
		String os = os();
		if (os.contains("Windows")) {
			String c = "TASKKILL /IM " + nome;
			chamaProcesso(c, 4, os);
			
		} else if (os.contains("Linux")) {
			String c = "pkill -f " + nome;
			chamaProcesso(c, 5, os);
		}
	}

}
