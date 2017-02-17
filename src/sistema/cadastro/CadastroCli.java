package sistema.cadastro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CadastroCli extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Botao botoes = new Botao();
	private JTextField t1 = new JTextField();
	private JTextField t2 = new JTextField();
	private JTextField t3 = new JTextField();
	private JTextField t4 = new JTextField();
	
	CadastroCli(){
	
	//Tela
	setTitle("CADASTRAMENTO DE CLIENTE");
	setSize(700, 500);
	setLocation(450, 100);
	setResizable(false);
	setLayout(null);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	//Label
	JLabel l1 = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE SALVAR.");
	l1.setBounds(30,15,330,30);
	JLabel l2 = new JLabel("NOME:");
	l2.setBounds(58,50,60,30);
	JLabel l3 = new JLabel("ENDEREÇO:");
	l3.setBounds(30,80,85,30);
	t1.setBounds(100,50,500,25);
	
	//Add
	getContentPane().add(l1);
	getContentPane().add(l2);
	getContentPane().add(l3);
	getContentPane().add(t1);
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
		default:
			break;
		}
	}

	public void pegaValor(){
		String nome = t1.getText();
		String endereco = t2.getText();
		String cpf = t3.getText();
		String dtnasc = t4.getText();
	}
	public void criaBotoes() {
		
		botoes.definirBotoesTelaCadastroCli(this, this);
	}
}
