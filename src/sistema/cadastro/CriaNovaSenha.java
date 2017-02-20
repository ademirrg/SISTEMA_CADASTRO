package sistema.cadastro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CriaNovaSenha  extends JFrame implements ActionListener{
	private JTextField tPass = new JPasswordField();
	private JTextField tPass2 = new JPasswordField();
	private Botao botoes = new Botao();
	private CadastroUserVO cadastroVO = new CadastroUserVO();
	private CadastroUserDAO dao = new CadastroUserDAO();
	
	public void criaTelaNovaSenha(){
		
		tPass.setBounds(180,50,120,25);
		tPass2.setBounds(180,80,120,25);
		JLabel l1 = new JLabel("NOVA SENHA:");
		l1.setBounds(97,50,100,30);
		JLabel l2 = new JLabel("CONFIRME A NOVA SENHA:");
		l2.setBounds(25,80,160,30);
		JLabel l3 = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE ALTERAR.");
		l3.setBounds(25,15,450,30);

		
		//Tela
		setTitle("ALTERAÇÃO DE SENHA");
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
		getContentPane().add(tPass);
		getContentPane().add(tPass2);
				
	}
	
	public void pegaValorTelaNovaSenha(){ 
		String pass = tPass.getText();
		String pass2 = tPass2.getText();
		String SenhaUserVO = "";
		String NomeUserVO = cadastroVO.getOldUser();
		
		if (pass.length()==0 || pass.length() <5 || pass.length()>12){
			JOptionPane.showMessageDialog(null, "CAMPO SENHA INVÁLIDO!" + System.lineSeparator() +"A SENHA DEVE CONTER DE 5 A 12 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}
			
		else if (pass2.equals(pass)==false){
			JOptionPane.showMessageDialog(null, "AS SENHAS DIGITADAS NÃO CONFEREM!" + System.lineSeparator() +"POR FAVOR, DIGITE NOVAMENTE.","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		if (pass.equals(pass2) && pass.length()>=5 && pass.length()<=12 && pass2.length()>=5 && pass2.length()<=12){
			
			try {
				cadastroVO.setPass(pass);
				dao.atualizaSenhaNaBase(cadastroVO);
				System.out.println("Senha alterada para o usuário " + NomeUserVO + ".");
				JOptionPane.showMessageDialog(null, "A SENHA FOI ALTERADA COM SUCESSO!" + System.lineSeparator() + "POR FAVOR, EFETUE O LOGIN NOVAMENTE.", "ALTERAÇÃO DE SENHA", JOptionPane.INFORMATION_MESSAGE);
				LoginUser login = new LoginUser();
				login.criaTelaLoginUser();
				login.criaBotoesLogin();
				login.setVisible(true);
				dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}


	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "command_cancelar":
			LoginUser login = new LoginUser();
			login.criaTelaLoginUser();
			login.criaBotoesLogin();
			login.setVisible(true);
			dispose();
			break;
		case "command_alterar_senha":
			pegaValorTelaNovaSenha();
			break;
		default:
			break;
		}
	}
	
	public void criaBotoesNovaSenha() {
		
		botoes.definirBotoesTelaNovaSenha(this, this);
	}
}
