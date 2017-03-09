package usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import login.Login;
import sistema.cadastro.Botao;
import sistema.cadastro.Tela;

public class EsqueciUser extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JTextField tCPF = new JTextField();
	private JTextField tData = new JTextField();
	private Botao botoes = new Botao();
	private CadastroUserVO cadastroVO = new CadastroUserVO();
	private CadastroUserDAO dao = new CadastroUserDAO();
	
	
	
	public void criaTelaEsqueciUser(){
		
		tCPF.setBounds(150,50,120,25);
		tData.setBounds(150,80,120,25);
		JLabel l1 = new JLabel("CPF:");
		l1.setBounds(116,50,60,30);
		JLabel l2 = new JLabel("DATA DE NASC.:");
		l2.setBounds(50,80,100,30);
		JLabel l3 = new JLabel("INFORME O SEU CPF E DATA DE NASCIMENTO E PRESSIONE ENCONTRAR.");
		l3.setBounds(31,15,450,30);

		
		//Tela
		setTitle("RECUPERA��O DE USU�RIO");
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
		getContentPane().add(tCPF);
		getContentPane().add(tData);
				
	}
	
	public void pegaValorTelaEsqueciUser(){
		String cpf = tCPF.getText();
		String data = tData.getText();
		String CPFVO = "";
		String NomeUserVO = "";
		String DataVO = "";
		
		if (cpf.length()==0 || cpf.length() <11 || cpf.length()>11){
			JOptionPane.showMessageDialog(null, "CAMPO CPF INV�LIDO!" + System.lineSeparator() +"O CPF DEVE CONTER 11 CARACTERES, SOMENTE N�MEROS","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (data.length()==0 || data.length() <10 || data.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO DATA INV�LIDO!" + System.lineSeparator() +"A DATA DEVE SER PREENCHIDA NO PADR�O DD/MM/AAAA COM BARRAS","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		if (cpf.length()==11 && data.length()==10){
			CadastroUserVO.setCPF(cpf);
			
			try {
				dao.buscarDadosNaBaseCPF(cadastroVO);
				CPFVO = CadastroUserVO.getCPF();
				DataVO = CadastroUserVO.getDataNasc();
				
				if (cpf.equals(CPFVO)==false){
					System.out.println("CPF n�o encontrado na base.");
					JOptionPane.showMessageDialog(null, "N�O EXISTE USU�RIO CADASTRADO PARA O CPF INFORMADO: " + cpf,"ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (data.equals(DataVO)==false){
					JOptionPane.showMessageDialog(null, "A DATA DE NASCIMENTO INFORMADA EST� INCORRETA PARA O CPF INFORMADO: " + cpf, "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					NomeUserVO = cadastroVO.getNomeUser();
					JOptionPane.showMessageDialog(null, "SEU USU�RIO �: " + NomeUserVO, "RECUPERA��O DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
					Login login = new Login(null);
					login.criaTela();
					login.criaBotoesLogin();
					login.setVisible(true);
					dispose();
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "command_cancelar":
			Tela tela = new Tela();
			tela.criaBotoes();
			tela.setVisible(true);
			dispose();
			break;
		case "command_encontrar_usuario":
			pegaValorTelaEsqueciUser();
			break;
		default:
			break;
		}
	}
	
	public void criaBotoesEsqueciUser() {
		
		botoes.definirBotoesTelaEsqueciUser(this, this);
	}
}