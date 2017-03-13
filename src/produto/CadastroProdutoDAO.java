package produto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import sistema.cadastro.Conexao;
import usuario.ConsultaVO;

public class CadastroProdutoDAO {
	
	public void buscarCodNaBasePRD(CadastroProdutoVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.produto WHERE CodPRD = (?)";
		String codPRD = "";
		String nomePRD = "";
		String inicioVig = "";
		String fimVig = "";
		String codSeg = "";
		String prdSta = "";

		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getCodPRD());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			codPRD = resultado.getString(1);
			nomePRD = resultado.getString(2);
			inicioVig = resultado.getString(3);
			fimVig = resultado.getString(4);
			codSeg = resultado.getString(5);
			prdSta = resultado.getString(6);
		}
		cadastroVO.setCodPRD(codPRD);
		cadastroVO.setNomePRD(nomePRD);
		cadastroVO.setInicioVig(inicioVig);
		cadastroVO.setFimVig(fimVig);
		cadastroVO.setCodSeg(codSeg);
		cadastroVO.setPRDSTA(prdSta);
		
		comando.close();
		System.out.println("Consulta de código de produto realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
		
	}
	
	public void buscarNomeNaBasePRD(CadastroProdutoVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.produto WHERE NomePRD = (?)";
		String codPRD = "";
		String nomePRD = "";
		String inicioVig = "";
		String fimVig = "";
		String codSeg = "";
		String prdSta = "";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getNomePRD());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			codPRD = resultado.getString(1);
			nomePRD = resultado.getString(2);
			inicioVig = resultado.getString(3);
			fimVig = resultado.getString(4);
			codSeg = resultado.getString(5);
			prdSta = resultado.getString(6);
		}
		cadastroVO.setCodPRD(codPRD);
		cadastroVO.setNomePRD(nomePRD);
		cadastroVO.setInicioVig(inicioVig);
		cadastroVO.setFimVig(fimVig);
		cadastroVO.setCodSeg(codSeg);
		cadastroVO.setPRDSTA(prdSta);
		
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
		
		String sql = "INSERT INTO sistema_cadastro.produto values (?, ?, ?, ?, ?, ?, now(), now())";
		
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
	
	public void atualizaDadosNaBasePRD (CadastroProdutoVO cadastroVO) throws Exception{
		
		String sqlNome = "UPDATE sistema_cadastro.produto SET NomePRD = (?) WHERE CodPRD = (?)";
		String sqlIniVig = "UPDATE sistema_cadastro.produto SET InicioVigencia = (?) WHERE CodPRD = (?)";
		String sqlFimVig = "UPDATE sistema_cadastro.produto SET FimVigencia = (?) WHERE CodPRD = (?)";
		String sqlCodSeg = "UPDATE sistema_cadastro.produto SET CodSegmento = (?) WHERE CodPRD = (?)";
		String sqlPrdSta = "UPDATE sistema_cadastro.produto SET PRDSTA = (?) WHERE CodPRD = (?)";
		String sqlDtAlt = "UPDATE sistema_cadastro.produto SET DataAlteracao = now() WHERE CodPRD = (?)";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando1 = (PreparedStatement) conn.prepareStatement(sqlNome);
		comando1.setString(1, cadastroVO.getNomePRD());
		comando1.setString(2, cadastroVO.getCodPRD());
		comando1.execute();
		comando1.close();
		
		PreparedStatement comando2 = (PreparedStatement) conn.prepareStatement(sqlIniVig);	
		comando2.setString(1, cadastroVO.getInicioVig());
		comando2.setString(2, cadastroVO.getCodPRD());
		comando2.execute();
		comando2.close();
		
		PreparedStatement comando3 = (PreparedStatement) conn.prepareStatement(sqlFimVig);	
		comando3.setString(1, cadastroVO.getFimVig());
		comando3.setString(2, cadastroVO.getCodPRD());
		comando3.execute();
		comando3.close();
		
		PreparedStatement comando4 = (PreparedStatement) conn.prepareStatement(sqlCodSeg);	
		comando4.setString(1, cadastroVO.getCodSeg());
		comando4.setString(2, cadastroVO.getCodPRD());
		comando4.execute();
		comando4.close();
		
		PreparedStatement comando5 = (PreparedStatement) conn.prepareStatement(sqlPrdSta);	
		comando5.setString(1, cadastroVO.getPRDSTA());
		comando5.setString(2, cadastroVO.getCodPRD());
		comando5.execute();
		comando5.close();
		
		PreparedStatement comando6 = (PreparedStatement) conn.prepareStatement(sqlDtAlt);	
		comando6.setString(1, cadastroVO.getCodPRD());
		comando6.execute();
		comando6.close();
		
		System.out.println("Atualização realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
	
	}
	
	
	public List<ConsultaVO> consultaProduto() throws Exception{
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
