package sistema.cadastro;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ScriptMaster {
	//Script Master - Cria Base de dados e popula tabela de usuário master
		
	public static void executaScriptMaster (CadastroUserVO cadastroVO) throws Exception{
		
		
		String sqlSCHEMA = "CREATE SCHEMA `Sistema_Cadastro`";
		String sqlTable1 = "CREATE TABLE `sistema_cadastro`.`master` (`MasterUser` VARCHAR(25) NOT NULL,`SenhaMaster` VARCHAR(12) NULL,`DataCri` DATETIME NULL,PRIMARY KEY (`MasterUser`));";
		String sqlTable2 = "CREATE TABLE `sistema_cadastro`.`usuario` (`NomeUser` VARCHAR(25) NULL,`SenhaUser` VARCHAR(12) NULL,`DataCadastro` DATETIME NULL,`DataAlteracaoUser` DATETIME NULL,`DataAlteracaoSenha` DATETIME NULL,`Nome` VARCHAR(25) NULL,`CPF` VARCHAR(11) NOT NULL,`DataNasc` VARCHAR(10) NULL,PRIMARY KEY (`CPF`));";
		String sqlTable3 = "CREATE TABLE `sistema_cadastro`.`produto` (`CodPRD` VARCHAR(3) NOT NULL, `NomePRD` VARCHAR(25) NULL,`InicioVigencia` VARCHAR(10) NULL,`FimVigencia` VARCHAR(10) NULL,`CodSegmento` VARCHAR(3) NULL,`PRDSTA` VARCHAR(1) NULL,`DataCadastro` DATETIME NULL,PRIMARY KEY (`CodPRD`));";
		String sqlTable4 = "CREATE TABLE `sistema_cadastro`.`segmento` (`CodSegmento` VARCHAR(3) NOT NULL,`NomeSegmento` VARCHAR(25) NULL,`TPContrato` VARCHAR(25) NULL,`TPPessoa` VARCHAR(2) NULL, `SEGSTA` VARCHAR(1) NULL,`DataCadastro` DATETIME NULL, PRIMARY KEY (`CodSegmento`));";
		String sqlInsert = "INSERT INTO sistema_cadastro.master VALUES ('admin','admin',now())";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando1 = (PreparedStatement) conn.prepareStatement(sqlSCHEMA);
		comando1.execute();
		comando1.close();
		
		PreparedStatement comando2 = (PreparedStatement) conn.prepareStatement(sqlTable1);
		comando2.execute();
		comando2.close();
		
		PreparedStatement comando3 = (PreparedStatement) conn.prepareStatement(sqlTable2);
		comando3.execute();
		comando3.close();
		
		PreparedStatement comando4 = (PreparedStatement) conn.prepareStatement(sqlTable3);
		comando4.execute();
		comando4.close();
		
		PreparedStatement comando5 = (PreparedStatement) conn.prepareStatement(sqlTable4);
		comando5.execute();
		comando5.close();
		
		PreparedStatement comando6 = (PreparedStatement) conn.prepareStatement(sqlInsert);
		comando6.execute();
		comando6.close();
		
		System.out.println("Banco de dados criado.");
		conn.close();
		System.out.println("Conexão encerrada.");
	
	}
	
	public void buscarDadosNaBaseMaster(CadastroUserVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.master WHERE MasterUser = (?)";
		String MasterUser = "";
		String SenhaMaster= "";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getUser().toUpperCase());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			MasterUser = resultado.getString(1);
			SenhaMaster = resultado.getString(2);
			CadastroUserVO.setMasterUser(MasterUser);
			CadastroUserVO.setSenhaMaster(SenhaMaster);
		}
		
		comando.close();
		System.out.println("Consulta realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
		
		}
}
