package sistema.cadastro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CadastroSegmento extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Botao botoes = new Botao();
	private JTextField tNome = new JTextField();
	private JTextField tCod = new JTextField();
	private JTextField tTpCtt = new JTextField();
	private JTextField tTpPessoa = new JTextField();
	CadastroSegmentoDAO dao = new CadastroSegmentoDAO();
	CadastroSegmentoVO cadastroVO = new CadastroSegmentoVO();
	
	public void criaTelaCadastroSeg(){
	
	//Tela
	setTitle("CADASTRAMENTO DE SEGMENTO");
	setSize(700, 500);
	setLocation(450, 100);
	setResizable(false);
	setLayout(null);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	//Label
	tNome.setBounds(157,50,165,25);
	tCod.setBounds(157,80,70,25);
	tTpCtt.setBounds(157,110,70,25);
	tTpPessoa.setBounds(157,140,70,25);
	JLabel l1 = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE SALVAR.");
	l1.setBounds(30,15,330,30);
	JLabel l2 = new JLabel("NOME DO SEGMENTO:");
	l2.setBounds(30,50,200,30);
	JLabel l3 = new JLabel("COD. DO SEGMENTO:");
	l3.setBounds(36,80,200,30);
	JLabel l4 = new JLabel("TIPO CONTRATO:");
	l4.setBounds(57,110,200,30);
	JLabel l5 = new JLabel("TIPO PESSOA:");
	l5.setBounds(73,140,200,30);
	
	//Add
	getContentPane().add(tNome);
	getContentPane().add(tCod);
	getContentPane().add(tTpCtt);
	getContentPane().add(tTpPessoa);
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
			JOptionPane.showMessageDialog(null, "INSTRUÇÕES PARA O CADASTRAMENTO DE SEGMENTO:" + System.lineSeparator() + "O CAMPO NOME DO SEGMENTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + "O CAMPO COD. DO SEGMENTO DEVE CONTER 3 CARACTERES." + System.lineSeparator() + "O CAMPO TIPO CONTRATO DEVE CONTER 3 CARACTERES (CDC OU LSG)." + System.lineSeparator() + "O CAMPO TIPO PESSOA DEVE CONTER 2 CARACTERES (PF OU PJ).","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		}
	}

	public void pegaValor(){
		String nomeSeg = tNome.getText();
		String codSeg = tCod.getText();
		String tpCtt = tTpCtt.getText();
		String tpPessoa = tTpPessoa.getText();
		String codSegVO = "";
		String segSta = "1";
		
		if(nomeSeg.length()<4 || nomeSeg.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO PRODUTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO NOME DO SEGMENTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(codSeg.length()<3 || codSeg.length()>3){
			JOptionPane.showMessageDialog(null, "CAMPO COD. DO SEGMENTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO COD. DO SEGMENTO DEVE CONTER 3 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(tpCtt.equalsIgnoreCase("CDC")==false && tpCtt.equalsIgnoreCase("LSG")==false){
			JOptionPane.showMessageDialog(null, "TIPO DE CONTRATO INVÁLIDO!" + System.lineSeparator() + "O CAMPO TIPO CONTRATO DEVE CONTER 3 CARACTERES (CDC OU LSG).", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(tpPessoa.equalsIgnoreCase("PF")==false && tpPessoa.equalsIgnoreCase("PJ")==false){
			JOptionPane.showMessageDialog(null, "CAMPO TIPO DE PESSOA INVÁLIDO!" + System.lineSeparator() + "O CAMPO TIPO PESSOA DEVE CONTER 2 CARACTERES (PF OU PJ).", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		else if(nomeSeg.length()>=4 && nomeSeg.length()<=25 && codSeg.length()==3 && tpCtt.length()==3 && tpPessoa.length()==2){
			cadastroVO.setCodSeg(codSeg);
			
			//Busca código e nome do produto na base
			try {
				dao.buscarCodNaBaseSeg(cadastroVO);
				codSegVO = cadastroVO.getCodSeg();
				
				if(codSeg.equals(codSegVO)){
					JOptionPane.showMessageDialog(null, "JÁ EXISTE UM SEGMENTO CADASTRADO PARA ESTE CÓDIGO, POR FAVOR, ESCOLHA OUTRO CÓDIGO PARA O SEGMENTO.", "ERRO", JOptionPane.ERROR_MESSAGE);
				}

				else{
					cadastroVO.setCodSeg(codSeg);
					cadastroVO.setNomeSeg(nomeSeg);
					cadastroVO.setTpCtt(tpCtt);
					cadastroVO.setTpPessoa(tpPessoa);
					cadastroVO.setSegSta(segSta);
					//Insere dados na base
					dao.insereDadosNaBaseSeg(cadastroVO);
					JOptionPane.showMessageDialog(null, "O SEGMENTO: " + codSeg + " - " + nomeSeg.toUpperCase() + " FOI CADASTRADO COM SUCESSO.","CADASTRAMENTO DE SEGMENTO", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					CadastroSegmento tela = new CadastroSegmento();
					tela.criaTelaCadastroSeg();
					tela.criaBotoes();
					tela.setVisible(true);
				}
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
	public void criaBotoes() {
		
		botoes.definirBotoesTelaCadastroSeg(this, this);
	}
}
