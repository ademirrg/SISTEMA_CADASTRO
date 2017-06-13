package sistema.cadastro;
import java.sql.SQLException;

public class Principal {
		
	public static void main(String args[]){
		try {
			//Executar script de criação da base de dados	
			ScriptMaster.executaScriptMaster(null);
			
			// Chama Tela
			Tela tela = new Tela();
			tela.criaTela();
			tela.criaBotoes();
			tela.setVisible(true);
		}
		catch (SQLException sql) {
			if(sql.getErrorCode() != 1007) {
				System.out.println("Erro: "+sql);
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
			// TODO: handle exception
		}
		
	}
	
}
