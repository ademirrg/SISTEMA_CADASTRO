package segmento;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import sistema.cadastro.Conexao;
import usuario.CadastroUserVO;
import usuario.ConsultaVO;

public class CadastroSegmentoDAO {
	

	public void buscarCodNaBaseSeg(CadastroSegmentoVO cadastroVO) throws Exception{
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
		
	public void insereDadosNaBaseSeg (CadastroSegmentoVO cadastroVO) throws Exception{
		
		String sql = "INSERT INTO sistema_cadastro.segmento values (?, ?, ?, ?, ?, now())";
		
		Connection conn = Conexao.abrir();
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(sql);
		comando.setString(1, cadastroVO.getCodSeg());
		comando.setString(2, cadastroVO.getNomeSeg().toUpperCase());
		comando.setString(3, cadastroVO.getTpCtt().toUpperCase());
		comando.setString(4, cadastroVO.getTpPessoa().toUpperCase());
		comando.setString(5, cadastroVO.getSegSta());
		comando.execute();
		comando.close();
		System.out.println("Inserção realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
	
	}
	
	public void atualizaSegNaBase (CadastroUserVO cadastroVO) throws Exception{
		
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
		System.out.println("Consulta de usuários realizada na base.");
		conn.close();
		System.out.println("Conexão encerrada.");
		return lista;
	}
	
}
