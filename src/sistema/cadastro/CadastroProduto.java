package sistema.cadastro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CadastroProduto extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Botao botoes = new Botao();
	private JTextField tNome = new JTextField();
	private JTextField tSeg = new JTextField();
	private JTextField tInicioVig = new JTextField();
	private JTextField tFimVig = new JTextField();
	
	public void criaTelaCadastroProd(){
	
	//Tela
	setTitle("CADASTRAMENTO DE PRODUTO");
	setSize(700, 500);
	setLocation(450, 100);
	setResizable(false);
	setLayout(null);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	//Label
	tNome.setBounds(150,50,165,25);
	tSeg.setBounds(150,80,70,25);
	tInicioVig.setBounds(150,110,70,25);
	tFimVig.setBounds(245,110,70,25);
	JLabel l1 = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE SALVAR.");
	l1.setBounds(30,15,330,30);
	JLabel l2 = new JLabel("NOME DO PRODUTO:");
	l2.setBounds(30,50,200,30);
	JLabel l3 = new JLabel("SEGMENTO:");
	l3.setBounds(80,80,85,30);
	JLabel l4 = new JLabel("VIGÊNCIA:");
	l4.setBounds(91,110,85,30);
	JLabel l5 = new JLabel("Á");
	l5.setBounds(228,110,85,30);

	
	//Add
	getContentPane().add(tNome);
	getContentPane().add(tSeg);
	getContentPane().add(tInicioVig);
	getContentPane().add(tFimVig);
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
		case "command_info":
			JOptionPane.showMessageDialog(null, "INSTRUÇÕES PARA O CADASTRAMENTO DE PRODUTO:" + System.lineSeparator() + "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + "O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES." + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS.","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		}
	}

	public void pegaValor(){
		String nome = tNome.getText();
		String segmento = tSeg.getText();
		String inicioVig = tInicioVig.getText();
		String fimVig = tFimVig.getText();
		
		if(nome.length()<4 || nome.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO PRODUTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(segmento.length()<3 || segmento.length()>3){
			JOptionPane.showMessageDialog(null, "CAMPO SEGMENTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(inicioVig.length()<10 || inicioVig.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO INÍCIO DE VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(fimVig.length()<10 || fimVig.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO INÍCIO DE VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	public void criaBotoes() {
		
		botoes.definirBotoesTelaCadastroProd(this, this);
	}
}
