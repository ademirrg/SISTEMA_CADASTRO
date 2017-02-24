package sistema.cadastro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CadastroUserDAO {
	
	public void buscarDadosNaBaseUser(CadastroUserVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.usuario WHERE NomeUser = (?)";
		String NomeUser = "";
		String SenhaUser = "";
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getUser());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			NomeUser = resultado.getString(1);
			SenhaUser = resultado.getString(2);
		}
		cadastroVO.setNomeUser(NomeUser);
		cadastroVO.setSenhaUser(SenhaUser);
		
		comando.close();
		System.out.println("Consulta de nome de usu�rio realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
		
		}
	
	public void buscarDadosNaBaseCPF(CadastroUserVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.usuario WHERE cpf = (?)";
		String cpf = "";
		String data = "";
		String NomeUser = ""; //Para recupera��o de usu�rio no login - Esqueci meu usu�rio
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, CadastroUserVO.getCPF());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			cpf = resultado.getString(7);
			data = resultado.getString(8);
			NomeUser = resultado.getString(1);
		}
		CadastroUserVO.setCPF(cpf);
		CadastroUserVO.setDataNasc(data);
		cadastroVO.setNomeUser(NomeUser);
		
		comando.close();
		System.out.println("Consulta de CPF realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
		
		}
		
	public void insereDadosNaBase (CadastroUserVO cadastroVO) throws Exception{
		
		String sql = "INSERT INTO sistema_cadastro.usuario values (?, ?, now(), now(), now(), ?, ?, ?)";
		
		Connection conn = Conexao.abrir();
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getUser().toUpperCase());
		comando.setString(2, cadastroVO.getPass());
		comando.setString(3, CadastroUserVO.getNome().toUpperCase());
		comando.setString(4, CadastroUserVO.getCPF());
		comando.setString(5, CadastroUserVO.getDataNasc());
		comando.execute();
		comando.close();
		System.out.println("Inser��o realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
	
	}
	
	public void atualizaUsuarioNaBase (CadastroUserVO cadastroVO) throws Exception{
		
		String sql = "UPDATE sistema_cadastro.usuario SET NomeUser = (?) WHERE NomeUser = (?)";
		String sql2 = "UPDATE sistema_cadastro.usuario SET DataAlteracaoUser = now() WHERE NomeUser = (?)";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando1 = (PreparedStatement) conn.prepareStatement(sql);
		comando1.setString(1, cadastroVO.getUser().toUpperCase());
		comando1.setString(2, CadastroUserVO.getOldUser().toUpperCase());
		comando1.execute();
		comando1.close();
		
		PreparedStatement comando2 = (PreparedStatement) conn.prepareStatement(sql2);	
		comando2.setString(1, cadastroVO.getUser().toUpperCase());
		comando2.execute();
		comando2.close();
		
		
		System.out.println("Atualiza��o realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
	
	}
	
	public void atualizaSenhaNaBase (CadastroUserVO cadastroVO) throws Exception{
		
		String sql = "UPDATE sistema_cadastro.usuario SET SenhaUser = (?) WHERE NomeUser = (?)";
		String sql2 = "UPDATE sistema_cadastro.usuario SET DataAlteracaoSenha = now() WHERE NomeUser = (?)";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getPass());
		comando.setString(2, CadastroUserVO.getOldUser().toUpperCase());
		comando.execute();
		comando.close();
		
		PreparedStatement comando2 = (PreparedStatement) conn.prepareStatement(sql2);	
		comando2.setString(1, CadastroUserVO.getOldUser().toUpperCase());
		comando2.execute();
		comando2.close();
		
		
		System.out.println("Atualiza��o realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
	
	}
	
	public List<ConsultaVO> consultaUsuario() throws Exception{
		List<ConsultaVO> lista = new ArrayList<ConsultaVO>();

		String sql = "SELECT * FROM sistema_cadastro.usuario order by DataCadastro desc";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery();

		while (resultado.next()) {
			ConsultaVO consultaVO = new ConsultaVO();
			consultaVO.setNomeUser(resultado.getString(1));
			consultaVO.setDataCadastro(resultado.getString(3));
			consultaVO.setDataAlteracaoUser(resultado.getString(4));
			consultaVO.setDataAlteracaoSenha(resultado.getString(5));
			consultaVO.setNome(resultado.getString(6));
			consultaVO.setCPF(resultado.getString(7));
			consultaVO.setDataNasc(resultado.getString(8));
			
			lista.add(consultaVO);
		}
		comando.close();
		System.out.println("Consulta de usu�rios realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
		return lista;
	}
	
}
