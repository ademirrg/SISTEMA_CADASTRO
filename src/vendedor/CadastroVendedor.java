package vendedor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import sistema.cadastro.Botao;
import sistema.cadastro.Tela;

public class CadastroVendedor extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Botao botoes = new Botao();
	private JTextField tNome = new JTextField();
	private JTextField tEnd = new JTextField();
	private JTextField tData = new JTextField();
	private JTextField tCPF = new JTextField();
	
	public void criaTelaCadastroVend(){
	
	//Tela
	setTitle("CADASTRAMENTO DE VENDEDOR");
	setSize(700, 500);
	setLocation(450, 100);
	setResizable(false);
	setLayout(null);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	//Label
	tNome.setBounds(100,50,500,25);
	tEnd.setBounds(100,80,500,25);
	tData.setBounds(100,110,500,25);
	tCPF.setBounds(100,140,500,25);
	JLabel l1 = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE SALVAR.");
	l1.setBounds(30,15,330,30);
	JLabel l2 = new JLabel("NOME:");
	l2.setBounds(58,50,60,30);
	JLabel l3 = new JLabel("ENDEREÇO:");
	l3.setBounds(20,80,85,30);
	JLabel l4 = new JLabel("DATA NASC.:");
	l4.setBounds(20,110,85,30);
	JLabel l5 = new JLabel("CPF:");
	l5.setBounds(60,140,85,30);
	
	//Add
	getContentPane().add(tNome);
	getContentPane().add(tEnd);
	getContentPane().add(tData);
	getContentPane().add(tCPF);
	getContentPane().add(l1);
	getContentPane().add(l2);
	getContentPane().add(l3);
	getContentPane().add(l4);
	getContentPane().add(l5);
	}

	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()) {
		case "command_salvar":
			pegaValor();
			break;
		case "command_voltar":
			Tela tela = new Tela();
			tela.criaBotoes();
			tela.setVisible(true);
			dispose();
			break;
		}
	}

	public void pegaValor(){
		String nome = tNome.getText();
		String endereco = tEnd.getText();
		String dtnasc = tData.getText();
		String cpf = tCPF.getText();
	}
	public void criaBotoes() {
		
		botoes.definirBotoesTelaCadastroVend(this, this);
	}
}
