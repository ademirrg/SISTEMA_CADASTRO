package sistema.cadastro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LoginMasterUser extends Login {

	private static final long serialVersionUID = 1L; 
	
	private JTextField tUser = new JTextField("admin");
	private JTextField tPass = new JPasswordField("admin");
	private Botao botoes = new Botao();
	private ScriptMaster dao = new ScriptMaster();
	private CadastroUserVO cadastroVO = new CadastroUserVO();
	
	public LoginMasterUser(String e) {
	  super(e);
	}

	@Override
	public void criaTela(){
		
		tUser.setBounds(150,50,120,25);
		tPass.setBounds(150,80,120,25);
		JLabel l1 = new JLabel("USU�RIO:");
		l1.setBounds(90,50,60,30);
		l1.setForeground(Color.WHITE);
		JLabel l2 = new JLabel("SENHA:");
		l2.setBounds(103,80,47,30);
		l2.setForeground(Color.WHITE);
		JLabel l3 = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE ENTRAR.");
		l3.setBounds(31,15,330,30);
		l3.setForeground(Color.WHITE);
		
		//Tela
		setTitle("LOGIN DE USU�RIO MASTER");
		setSize(700, 500);
		setLocation(450, 100);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Add
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(l3);
		getContentPane().add(tUser);
		getContentPane().add(tPass);

					
	}
	public void pegaValorTela(){
		String user = (tUser.getText());
		String pass = (tPass.getText());
		String MasterUserVO ="";
		String SenhaMasterVO ="";
		
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
				dao.buscarDadosNaBaseMaster(cadastroVO);
				MasterUserVO = CadastroUserVO.getMasterUser();
				SenhaMasterVO = CadastroUserVO.getSenhaMaster();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (user.equalsIgnoreCase(MasterUserVO) == false){
				System.out.println("Tentativa de login com o usu�rio mestre: " + user.toUpperCase() + ", usu�rio mestre inv�lido.");
				JOptionPane.showMessageDialog(null,"O USU�RIO " + user.toUpperCase() + " N�O EST� CADASTRADO COMO USU�RIO MESTRE.", "ERRO DE LOGIN", JOptionPane.ERROR_MESSAGE);
			
			}	
			
			else if (pass.equals(SenhaMasterVO) == false){
				System.out.println("Tentativa de login com o usu�rio mestre, senha incorreta.");
				JOptionPane.showMessageDialog(null, "SENHA INCORRETA.", "ERRO DE LOGIN", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				criarTelaNova();
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
		case "command_login_usuario_master":
			pegaValorTela();
			break;
		default:
			break;
		}
	}
	
	public void criaBotoesLogin() {
		
		botoes.definirBotoesTelaLoginMasterUser(this, this);
	}
}
