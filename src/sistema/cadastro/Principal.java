package sistema.cadastro;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Principal {
		
	public static void main(String args[]){
		try {
			//Executar script de criação da base de dados
			ScriptMaster.executaScriptMaster();
			
			// Chama Tela
			Tela tela = new Tela();
			tela.criaTela();
			tela.criaBotoes();
			tela.setVisible(true);
		}
		catch (SQLException sql) {
			if(sql.getErrorCode() != 1007) {
				System.out.println("Erro: "+sql);
				JOptionPane.showMessageDialog(null, "Erro de conexão:\n" + sql, "ERRO DE CONEXÃO", JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("Banco de dados já existente.");
				// Chama Tela
				Tela tela = new Tela();
				tela.criaTela();
				tela.criaBotoes();
				tela.setVisible(true);
			}
		}
		catch (Exception e) {
			throw new RuntimeException("Erro", e);
		}
		
	}
	
}
