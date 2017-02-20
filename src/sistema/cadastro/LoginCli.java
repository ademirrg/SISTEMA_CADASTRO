package sistema.cadastro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginCli extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L; 
	
	private JTextField tUser = new JTextField();
	private JTextField tPass = new JPasswordField();
	private Botao botoes = new Botao();
	private CadastroUserVO cadastroVO = new CadastroUserVO();
	private CadastroUserDAO dao = new CadastroUserDAO();
	private CadastroCli cadastroCli;
	
	
	public void criaTelaLoginCli(){
		
		tUser.setBounds(150,50,120,25);
		tPass.setBounds(150,80,120,25);
		JLabel l1 = new JLabel("USU�RIO:");
		l1.setBounds(90,50,60,30);
		JLabel l2 = new JLabel("SENHA:");
		l2.setBounds(103,80,47,30);
		JLabel l3 = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE ENTRAR.");
		l3.setBounds(31,15,330,30);
		JLabel l4 = new JLabel("ESQUECI MEU USU�RIO.");
		l4.setBounds(540,15,180,30);
		JLabel l5 = new JLabel("ESQUECI MINHA SENHA.");
		l5.setBounds(540,75,180,30);
		
		//Tela
		setTitle("LOGIN DE USU�RIO");
		setSize(700, 500);
		setLocation(450, 100);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Add
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(l3);
		getContentPane().add(l4);
		getContentPane().add(l5);
		getContentPane().add(tUser);
		getContentPane().add(tPass);

					
	}
	
	public void pegaValorTelaLoginCli(){
		String user = (tUser.getText());
		String pass = (tPass.getText());
		String NomeUserVO ="";
		String SenhaUserVO ="";
		
		if (user.length()==0 || user.length() <4 || user.length()>25){
			JOptionPane.showMessageDialog(null, "CAMPO USU�RIO INV�LIDO!" + System.lineSeparator() +"O USU�RIO DEVE CONTER DE 4 A 25 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);

		}

		else if (pass.length()==0 || pass.length() <5 || pass.length()>12){
			JOptionPane.showMessageDialog(null, "CAMPO SENHA INV�LIDO!" + System.lineSeparator() +"A SENHA DEVE CONTER DE 5 A 12 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		if (user.length()>=4 && user.length()<=25 && pass.length()>=5 && pass.length()<=12){
			cadastroVO.setUser(user);
			cadastroVO.setPass(pass);
			
			//Realiza uma conulta no banco e verifica o usu�rio e senha informado.
			try {
				dao.buscarDadosNaBaseUser(cadastroVO);
				NomeUserVO = cadastroVO.getNomeUser();
				SenhaUserVO = cadastroVO.getSenhaUser();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (user.equalsIgnoreCase(NomeUserVO) == false){
				System.out.println("Tentativa de login com o usu�rio " + user.toUpperCase() + ", usu�rio n�o cadastrado.");
				JOptionPane.showMessageDialog(null,"O USU�RIO " + user.toUpperCase() + " N�O EXISTE NA BASE.", "ERRO DE LOGIN", JOptionPane.ERROR_MESSAGE);
			
			}	
			
			else if (pass.equals(SenhaUserVO) == false){
				System.out.println("Tentativa de login com o usu�rio " + user.toUpperCase() + ", senha incorreta.");
				JOptionPane.showMessageDialog(null, "SENHA INCORRETA.", "ERRO DE LOGIN", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				cadastroVO.setOldUser(user);
				System.out.println("Usu�rio " + user.toUpperCase() + " acessou tela de cadastramento de clientes.");
				cadastroCli = new CadastroCli();
				cadastroCli.criaTelaCadastroCli();
				cadastroCli.criaBotoes();
				cadastroCli.setVisible(true);
				dispose();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "command_voltar":
			Tela tela = new Tela();
			tela.criaBotoes();
			tela.setVisible(true);
			dispose();
			break;
		case "command_login_usuario":
			pegaValorTelaLoginCli();
			break;
		case "command_encontrar_usuario":
			EsqueciUser encontrar = new EsqueciUser();
			encontrar.criaTelaEsqueciUser();
			encontrar.criaBotoesEsqueciUser();
			encontrar.setVisible(true);
			dispose();
			break;
		case "command_nova_senha":
			EsqueciSenha nova = new EsqueciSenha();
			nova.criaTelaEsqueciSenha();
			nova.criaBotoesEsqueciSenha();
			nova.setVisible(true);
			dispose();
			break;
		default:
			break;
		}
	}
	
	public void criaBotoesLogin() {
		
		botoes.definirBotoesTelaLoginUser(this, this);
	}
}
