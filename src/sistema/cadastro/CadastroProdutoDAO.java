package sistema.cadastro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CadastroProdutoDAO {
	
	public void buscarCodNaBasePRD(CadastroProdutoVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.produto WHERE CodPRD = (?)";
		String CodPRD = "";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getCodPRD());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			CodPRD = resultado.getString(1);
		}
		cadastroVO.setCodPRD(CodPRD);
		comando.close();
		System.out.println("Consulta de código de produto realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
		
		}
	
	public void buscarNomeNaBasePRD(CadastroProdutoVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.produto WHERE NomePRD = (?)";
		String NomePRD = "";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getNomePRD());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			NomePRD = resultado.getString(2);
		}
		cadastroVO.setNomePRD(NomePRD);
		comando.close();
		System.out.println("Consulta de nome de produto realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
		
		}
	
	public void buscarDadosNaBaseSeg(CadastroProdutoVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.segmento WHERE CodSegmento = (?)";
		String seg = "";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getCodSeg());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			seg = resultado.getString(1);
		}
		cadastroVO.setCodSeg(seg);
		comando.close();
		System.out.println("Consulta de segmento realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
		
		}
		
	public void insereDadosNaBasePRD (CadastroProdutoVO cadastroVO) throws Exception{
		
		String sql = "INSERT INTO sistema_cadastro.produto values (?, ?, ?, ?, ?, ?, now())";
		
		Connection conn = Conexao.abrir();
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getCodPRD());
		comando.setString(2, cadastroVO.getNomePRD().toUpperCase());
		comando.setString(3, cadastroVO.getInicioVig());
		comando.setString(4, cadastroVO.getFimVig());
		comando.setString(5, cadastroVO.getCodSeg());
		comando.setString(6, cadastroVO.getPRDSTA());
		comando.execute();
		comando.close();
		System.out.println("Inserção realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
	
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
		
		
		System.out.println("Atualização realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
	
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
		
		
		System.out.println("Atualização realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
	
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
		System.out.println("Consulta de usuários realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
		return lista;
	}
	
}
