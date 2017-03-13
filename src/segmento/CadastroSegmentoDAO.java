package segmento;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import sistema.cadastro.Conexao;
import usuario.ConsultaVO;

public class CadastroSegmentoDAO {
	

	public void buscarCodNaBaseSeg(CadastroSegmentoVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.segmento WHERE CodSegmento = (?)";
		String codSeg = "";
		String nomeSeg = "";
		String tpCtt = "";
		String tpPessoa = "";
		String segSta = "";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getCodSeg());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			codSeg = resultado.getString(1);
			nomeSeg = resultado.getString(2);
			tpCtt = resultado.getString(3);
			tpPessoa = resultado.getString(4);
			segSta = resultado.getString(5);
		}
		cadastroVO.setCodSeg(codSeg);
		cadastroVO.setNomeSeg(nomeSeg);
		cadastroVO.setTpCtt(tpCtt);
		cadastroVO.setTpPessoa(tpPessoa);
		cadastroVO.setSegSta(segSta);
		
		comando.close();
		System.out.println("Consulta de segmento realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
		
		}
	
	public void buscarNomeNaBaseSeg(CadastroSegmentoVO cadastroVO) throws Exception{
		String sql = "SELECT * FROM sistema_cadastro.segmento WHERE NomeSegmento = (?)";
		String codSeg = "";
		String nomeSeg = "";
		String tpCtt = "";
		String tpPessoa = "";
		String segSta = "";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getNomeSeg());
		ResultSet resultado = comando.executeQuery();
		
		if (resultado.next()){
			codSeg = resultado.getString(1);
			nomeSeg = resultado.getString(2);
			tpCtt = resultado.getString(3);
			tpPessoa = resultado.getString(4);
			segSta = resultado.getString(5);
		}
		cadastroVO.setCodSeg(codSeg);
		cadastroVO.setNomeSeg(nomeSeg);
		cadastroVO.setTpCtt(tpCtt);
		cadastroVO.setTpPessoa(tpPessoa);
		cadastroVO.setSegSta(segSta);
		
		comando.close();
		System.out.println("Consulta de segmento realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
		
		}
		
	public void insereDadosNaBaseSeg (CadastroSegmentoVO cadastroVO) throws Exception{
		
		String sql = "INSERT INTO sistema_cadastro.segmento values (?, ?, ?, ?, ?, now(), now())";
		
		Connection conn = Conexao.abrir();
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getCodSeg());
		comando.setString(2, cadastroVO.getNomeSeg().toUpperCase());
		comando.setString(3, cadastroVO.getTpCtt().toUpperCase());
		comando.setString(4, cadastroVO.getTpPessoa().toUpperCase());
		comando.setString(5, cadastroVO.getSegSta());
		comando.execute();
		comando.close();
		System.out.println("Inser��o realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
	
	}
	
	public void atualizaDadosNaBaseSeg (CadastroSegmentoVO cadastroVO) throws Exception{
		
		String sqlNome = "UPDATE sistema_cadastro.segmento SET NomeSegmento = (?) WHERE CodSegmento = (?)";
		String sqlTpCtt = "UPDATE sistema_cadastro.segmento SET TPContrato = (?) WHERE CodSegmento = (?)";
		String sqlTpPessoa = "UPDATE sistema_cadastro.segmento SET TPPessoa = (?) WHERE CodSegmento = (?)";
		String sqlSegSta = "UPDATE sistema_cadastro.segmento SET SEGSTA = (?) WHERE CodSegmento = (?)";
		String sqlDtAlt = "UPDATE sistema_cadastro.segmento SET DataAlteracao = now() WHERE CodSegmento = (?)";
		
		Connection conn = Conexao.abrir();
		
		PreparedStatement comando1 = (PreparedStatement) conn.prepareStatement(sqlNome);
		comando1.setString(1, cadastroVO.getNomeSeg().toUpperCase());
		comando1.setString(2, cadastroVO.getCodSeg());
		comando1.execute();
		comando1.close();
		
		PreparedStatement comando2 = (PreparedStatement) conn.prepareStatement(sqlTpCtt);
		comando2.setString(1, cadastroVO.getTpCtt().toUpperCase());
		comando2.setString(2, cadastroVO.getCodSeg());
		comando2.execute();
		comando2.close();
		
		PreparedStatement comando3 = (PreparedStatement) conn.prepareStatement(sqlTpPessoa);
		comando3.setString(1, cadastroVO.getTpPessoa().toUpperCase());
		comando3.setString(2, cadastroVO.getCodSeg());
		comando3.execute();
		comando3.close();
		
		PreparedStatement comando4 = (PreparedStatement) conn.prepareStatement(sqlSegSta);
		comando4.setString(1, cadastroVO.getSegSta());
		comando4.setString(2, cadastroVO.getCodSeg());
		comando4.execute();
		comando4.close();
		
		PreparedStatement comando5 = (PreparedStatement) conn.prepareStatement(sqlDtAlt);
		comando5.setString(1, cadastroVO.getCodSeg());
		comando5.execute();
		comando5.close();
		
		
		System.out.println("Atualiza��o realizada na base.");
		conn.close();
		System.out.println("Conex�o encerrada.");
	
	}
	
	
	public List<ConsultaVO> consultaSegmento() throws Exception{
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
