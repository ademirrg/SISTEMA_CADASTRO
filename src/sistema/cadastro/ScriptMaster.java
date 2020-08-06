package sistema.cadastro;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import usuario.CadastroUserVO;

public class ScriptMaster {
	//Script Master - Cria Base de dados e popula tabela de usuário master
		
	public static void executaScriptMaster () throws Exception{
		
		String sqlSCHEMA = "CREATE SCHEMA `sistema_cadastro`";
		
		String sqlTabelaMaster = "CREATE TABLE `sistema_cadastro`.`master` ("
				+ "`MasterUser` VARCHAR(25) NOT NULL,"
				+ "`SenhaMaster` VARCHAR(12) NULL,"
				+ "`DataCri` DATETIME NULL,"
				+ "PRIMARY KEY (`MasterUser`));";
		
		String sqlTabelaUsuario = "CREATE TABLE `sistema_cadastro`.`usuario` ("
				+ "`NomeUser` VARCHAR(25) NULL,"
				+ "`SenhaUser` VARCHAR(32) NULL,"
				+ "`DataCadastro` DATETIME NULL,"
				+ "`DataAlteracaoUser` DATETIME NULL,"
				+ "`DataAlteracaoSenha` DATETIME NULL,"
				+ "`Nome` VARCHAR(25) NULL,"
				+ "`CPF` VARCHAR(11) NOT NULL,"
				+ "`DataNasc` VARCHAR(10) NULL,"
				+ "PRIMARY KEY (`CPF`));";
		
		String sqlTabelaProduto = "CREATE TABLE `sistema_cadastro`.`produto` ("
				+ "`CodPRD` INT NOT NULL AUTO_INCREMENT, "
				+ "`NomePRD` VARCHAR(25) NULL,"
				+ "`InicioVigencia` VARCHAR(10) NULL,"
				+ "`FimVigencia` VARCHAR(10) NULL,"
				+ "`CodSegmento` VARCHAR(3) NULL,"
				+ "`PRDSTA` VARCHAR(1) NULL,"
				+ "`DataCadastro` DATETIME NULL,"
				+ "`DataAlteracao` DATETIME NULL,"
				+ "PRIMARY KEY (`CodPRD`)) AUTO_INCREMENT = 10;";
		
		String sqlTabelaSegmento = "CREATE TABLE `sistema_cadastro`.`segmento` ("
				+ "`CodSegmento` INT NOT NULL AUTO_INCREMENT,"
				+ "`NomeSegmento` VARCHAR(25) NULL,"
				+ "`TPContrato` VARCHAR(25) NULL,"
				+ "`TPPessoa` VARCHAR(2) NULL, "
				+ "`SEGSTA` VARCHAR(1) NULL,"
				+ "`DataCadastro` DATETIME NULL,"
				+ "`DataAlteracao` DATETIME NULL,"
				+ "PRIMARY KEY (`CodSegmento`)) AUTO_INCREMENT = 100;";
		
//		String sqlTabelaMensageria = "CREATE TABLE `sistema_cadastro`.`mensageria` ("
//				+ "`CodMSG` VARCHAR(6) NOT NULL,"
//				+ "`TextoMSG` VARCHAR(900) NULL,"
//				+ "`TipoMSG` VARCHAR(25) NULL,"
//				+ "PRIMARY KEY (`CodMSG`));";
		
		String sqlInsertMaster = "INSERT INTO sistema_cadastro.master VALUES ('admin','admin',now());";
		
//		String sqlInsertMensageria = "INSERT INTO sistema_cadastro.mensageria VALUES "
//				+ "('MSG001','','INFORMATIVA'),"
//				+ "(),"
//				+ "();";
		
		System.out.println("Criando banco de dados...");
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando1 = (PreparedStatement) conn.prepareStatement(sqlSCHEMA);
		comando1.execute();
		comando1.close();
		
		PreparedStatement comando2 = (PreparedStatement) conn.prepareStatement(sqlTabelaMaster);
		comando2.execute();
		comando2.close();
		
		PreparedStatement comando3 = (PreparedStatement) conn.prepareStatement(sqlTabelaUsuario);
		comando3.execute();
		comando3.close();
		
		PreparedStatement comando4 = (PreparedStatement) conn.prepareStatement(sqlTabelaProduto);
		comando4.execute();
		comando4.close();
		
		PreparedStatement comando5 = (PreparedStatement) conn.prepareStatement(sqlTabelaSegmento);
		comando5.execute();
		comando5.close();
		
		PreparedStatement comando6 = (PreparedStatement) conn.prepareStatement(sqlInsertMaster);
		comando6.execute();
		comando6.close();
		
		System.out.println("Banco de dados criado com sucesso.");
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
