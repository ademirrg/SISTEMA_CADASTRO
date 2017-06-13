package sistema.cadastro;
import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class Conexao {
	private static final String USUARIO = "root";
	private static final String SENHA = "1234";
	private static final String URL = "jdbc:mysql://localhost/";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	public static Connection abrir() throws Exception {
		System.out.println("Tentando conexão com o servidor...");
		// Registrar o driver
		Class.forName(DRIVER);
		
		// Capturar a conexão
		Connection conn = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
		System.out.println("Conexão realizada com sucesso.");
		
		// Retorna a conexao aberta
		return conn;
	}
}