package usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

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
		
		//Cria campos formatados
		try {
			MaskFormatter cpf;
			cpf = new MaskFormatter( "###.###.###-##" );
			cpf.setValidCharacters("0123456789");
			tCPF = new JFormattedTextField(cpf);
			
			MaskFormatter data;
			data = new MaskFormatter( "##/##/####" );
			data.setValidCharacters("0123456789");
			tData = new JFormattedTextField(data);	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		//setLocation(450, 100);
		setLocationRelativeTo(null);
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
		cpf = cpf.replaceAll("[.-]", "");
		cpf = cpf.trim();
		String data = tData.getText();
		String CPFVO = "";
		String NomeUserVO = "";
		String DataVO = "";
		String retornoValidador = "";
		
		//Valida n�mero do CPF
		CadastroUserVO.setCPF(cpf);
		retornoValidador = ValidaCPF.validaCPF();
		
		//Para valida��o de data
		String[] separador = data.split("/");
		String dia = separador[0];
		String mes = separador[1];
		String ano = separador[2];
		data = ano + "-" + mes + "-" + dia;
		data = data.trim();
		
		//Para valida��o de maioridade
		int anoVigente = Calendar.getInstance().get(Calendar.YEAR);
		int anoMinimiPermitido = anoVigente - 120;
		int anoMaximoPermitido = anoVigente - 18;
		
		if (cpf.length()==0 || cpf.length() <11 || cpf.length()>11){
			JOptionPane.showMessageDialog(null, "CAMPO CPF INV�LIDO!" + System.lineSeparator() +
					"O CPF DEVE CONTER 11 CARACTERES, SOMENTE N�MEROS","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (retornoValidador.equals("NOK")){
			JOptionPane.showMessageDialog(null, "O CPF INFORMADO N�O � V�LIDO!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (data.length()==0 || data.length() <10 || data.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO DATA INV�LIDO!" + System.lineSeparator() +
					"A DATA DEVE SER PREENCHIDA NO PADR�O DD/MM/AAAA COM BARRAS","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(dia) < 1 || (Integer.parseInt(dia) > 31)){
			JOptionPane.showMessageDialog(null,  "DATA DE NASCIMENTO INV�LIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(mes) < 1 || Integer.parseInt(mes) > 12){
			JOptionPane.showMessageDialog(null, "DATA DE NASCIMENTO INV�LIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(ano) < anoMinimiPermitido || Integer.parseInt(ano) >= anoVigente){
			JOptionPane.showMessageDialog(null, "DATA DE NASCIMENTO INV�LIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(ano) > anoMaximoPermitido){
			JOptionPane.showMessageDialog(null, "CADASTRO PERMITIDO APENAS PARA MAIORES DE 18 ANOS.", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		else{
			
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
					Tela tela = new Tela();
					tela.criaTela();
					tela.criaBotoes();
					tela.setVisible(true);
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
			tela.criaTela();
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
