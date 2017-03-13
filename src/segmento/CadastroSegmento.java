package segmento;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import produto.CadastroProduto;
import sistema.cadastro.Botao;
import sistema.cadastro.Tela;

public class CadastroSegmento extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Botao botoes = new Botao();
	private JTextField tNome = new JTextField();
	private JTextField tCod = new JTextField();
	private JTextField tTpCtt = new JTextField();
	private JTextField tTpPessoa = new JTextField();
	CadastroSegmentoDAO dao = new CadastroSegmentoDAO();
	CadastroSegmentoVO cadastroVO = new CadastroSegmentoVO();
	
	//Campos necessários para exibição dos valores na tela de alteração de segmento
	String altCodSeg = cadastroVO.getCodSeg();
	String altNomeSeg = cadastroVO.getNomeSeg();
	String altTpCtt = cadastroVO.getTpCtt();
	String altTpPessoa = cadastroVO.getTpPessoa();
	String altSegSta = cadastroVO.getSegSta();
	JTextField tAltCod = new JTextField(altCodSeg);
	JTextField tAltNome = new JTextField(altNomeSeg);	
	JTextField tAltTpCtt = new JTextField(altTpCtt);
	JTextField tAltTpPessoa = new JTextField(altTpPessoa);
	JTextField tAltSegSta = new JTextField(altSegSta);
	
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

	public void criaTelaBuscaSeg(){
		
	//Tela
	setTitle("ALTERAÇÃO DE SEGMENTO");
	setSize(700, 500);
	setLocation(450, 100);
	setResizable(false);
	setLayout(null);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	//Label
	tNome.setBounds(210,50,165,25);
	JLabel l1 = new JLabel("INFORME OS DADOS DO SEGMENTO QUE DESEJA ALTERAR E PRESSIONE BUSCAR.");
	l1.setBounds(30,15,500,30);
	JLabel l2 = new JLabel("NOME OU COD. DO SEGMENTO:");
	l2.setBounds(30,50,250,30);

	//Add
	getContentPane().add(tNome);
	getContentPane().add(l1);
	getContentPane().add(l2);
	}
	
	public void criaTelaAlteraSeg(){
		
	//Tela
	setTitle("ALTERAÇÃO DO PRODUTO: " + altCodSeg + " - " + altNomeSeg);
	setSize(700, 500);
	setLocation(450, 100);
	setResizable(false);
	setLayout(null);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	//Label
	tAltNome.setBounds(157,50,165,25);
	tAltCod.setBounds(157,80,70,25);
	tAltCod.setEnabled(false);
	tAltTpCtt.setBounds(157,110,70,25);
	tAltTpPessoa.setBounds(157,140,70,25);
	tAltSegSta.setBounds(157,170,70,25);
	JLabel l1 = new JLabel("INFORME OS DADOS DO SEGMENTO QUE DESEJA ALTERAR.");
	l1.setBounds(30,15,330,30);
	JLabel l2 = new JLabel("NOME DO SEGMENTO:");
	l2.setBounds(30,50,200,30);
	JLabel l3 = new JLabel("COD. DO SEGMENTO:");
	l3.setBounds(36,80,200,30);
	JLabel l4 = new JLabel("TIPO CONTRATO:");
	l4.setBounds(57,110,200,30);
	JLabel l5 = new JLabel("TIPO PESSOA:");
	l5.setBounds(73,140,200,30);
	JLabel l6 = new JLabel("STATUS:");
	l6.setBounds(98,170,85,30);
	
	//Add
	getContentPane().add(tAltNome);
	getContentPane().add(tAltCod);
	getContentPane().add(tAltTpCtt);
	getContentPane().add(tAltTpPessoa);
	getContentPane().add(tAltSegSta);
	getContentPane().add(l1);
	getContentPane().add(l2);
	getContentPane().add(l3);
	getContentPane().add(l4);
	getContentPane().add(l5);
	getContentPane().add(l6);
	}
	
	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()) {
		case "command_salvar":
			pegaValor();
			break;
		case "command_alterar_seg":
			pegaValorTelaAlteraSeg();
			break;
		case "command_buscar_seg":
			pegaValorTelaBuscaSeg();
			break;
		case "command_voltar":
			Tela tela = new Tela();
			tela.criaTela();
			tela.criaBotoes();
			tela.setVisible(true);
			dispose();
			break;
		case "command_voltar_busca":
			CadastroSegmento busca = new CadastroSegmento();
			busca.criaTelaBuscaSeg();
			busca.criaBotoesBuscaSeg();
			busca.setVisible(true);
			dispose();
			break;
		case "command_info":
			JOptionPane.showMessageDialog(null, "INSTRUÇÕES PARA O CADASTRAMENTO DE SEGMENTO:" + System.lineSeparator() + "O CAMPO NOME DO SEGMENTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + "O CAMPO COD. DO SEGMENTO DEVE CONTER 3 CARACTERES." + System.lineSeparator() + "O CAMPO TIPO CONTRATO DEVE CONTER 3 CARACTERES (CDC OU LSG)." + System.lineSeparator() + "O CAMPO TIPO PESSOA DEVE CONTER 2 CARACTERES (PF OU PJ).","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		case "command_info_altera":
			JOptionPane.showMessageDialog(null, "INSTRUÇÕES PARA O ALTERAÇÃO DE SEGMENTO:" + System.lineSeparator() + "O CAMPO NOME DO SEGMENTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + "O CAMPO TIPO CONTRATO DEVE CONTER 3 CARACTERES (CDC OU LSG)." + System.lineSeparator() + "O CAMPO TIPO PESSOA DEVE CONTER 2 CARACTERES (PF OU PJ)." + System.lineSeparator() + "O CAMPO STATUS DEVE CONTER 1 CARACTERE, INDICANDO STATUS ATIVO/INATIVO (1/0).","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		}
	}
	
	//Cadastro de segmento
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
		else if(nomeSeg.length()>=4 && nomeSeg.length()<=25 && codSeg.length()==3 && tpCtt.equalsIgnoreCase("CDC")==true || tpCtt.equalsIgnoreCase("LSG") && tpPessoa.equalsIgnoreCase("PF") || tpPessoa.equalsIgnoreCase("PJ")){
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
	
	//Busca de segmento
	public void pegaValorTelaBuscaSeg(){
		String nomeCodSeg = tNome.getText();
		String nomeSegVO = "";
		String codSegVO = "";
		
		if(nomeCodSeg.length()<3 || nomeCodSeg.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO SEGMENTO/COD. INVÁLIDO!" + System.lineSeparator() + "O CAMPO NOME/COD. DO SEGMENTO DEVE CONTER DE 3 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		if(nomeCodSeg.length()>=3 && nomeCodSeg.length()<=25){
			
			//Busca código e nome do produto na base
			try {
				cadastroVO.setCodSeg(nomeCodSeg);
				dao.buscarCodNaBaseSeg(cadastroVO);
				codSegVO = cadastroVO.getCodSeg();
				
				cadastroVO.setNomeSeg(nomeCodSeg);
				dao.buscarNomeNaBaseSeg(cadastroVO);
				nomeSegVO = cadastroVO.getNomeSeg();
				
				if(codSegVO.length()==0 && nomeSegVO.length()==0){
					JOptionPane.showMessageDialog(null, "O SEGMENTO INFORMADO NÃO EXISTE NA BASE.", "CONSULTA DE SEGMENTO", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(nomeCodSeg.equalsIgnoreCase(codSegVO)){
					//Chamada DAO para atualização dos valores VO
					cadastroVO.setCodSeg(nomeCodSeg);
					dao.buscarCodNaBaseSeg(cadastroVO);
					dispose();
					CadastroSegmento altera = new CadastroSegmento();
					altera.criaTelaAlteraSeg();
					altera.criaBotoesAlteraSeg();
					altera.setVisible(true);
				}
				else if(nomeCodSeg.equalsIgnoreCase(nomeSegVO)){
					//Chamada DAO para atualização dos valores VO
					cadastroVO.setNomeSeg(nomeCodSeg);
					dao.buscarNomeNaBaseSeg(cadastroVO);
					dispose();
					CadastroSegmento altera = new CadastroSegmento();
					altera.criaTelaAlteraSeg();
					altera.criaBotoesAlteraSeg();
					altera.setVisible(true);
				}
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
	public void criaBotoesBuscaSeg() {
		
		botoes.definirBotoesTelaBuscaSeg(this, this);
	}
	
	//Alteração de segmento
	public void pegaValorTelaAlteraSeg(){
		String nomeSeg = tAltNome.getText();
		String codSeg = tAltCod.getText();
		String tpCtt = tAltTpCtt.getText();
		String tpPessoa = tAltTpPessoa.getText();
		String segSta = tAltSegSta.getText();
		String nomeSegVO = "";
		String nomeOldSeg = cadastroVO.getNomeSeg();
		
		if(nomeSeg.length()<4 || nomeSeg.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO SEGMENTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO NOME DO SEGMENTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(tpCtt.equalsIgnoreCase("CDC")==false && tpCtt.equalsIgnoreCase("LSG")==false){
			JOptionPane.showMessageDialog(null, "CAMPO TIPO DE CONTRATO INVÁLIDO!" + System.lineSeparator() + "O CAMPO TIPO CONTRATO DEVE CONTER 3 CARACTERES (CDC OU LSG).", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(tpPessoa.equalsIgnoreCase("PF")==false && tpPessoa.equalsIgnoreCase("PJ")==false){
			JOptionPane.showMessageDialog(null, "CAMPO INÍCIO DE VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + "O CAMPO TIPO PESSOA DEVE CONTER 2 CARACTERES (PF OU PJ).", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(segSta.equals("1")==false && segSta.equals("0")==false){
			JOptionPane.showMessageDialog(null, "CAMPO STATUS INVÁLIDO!" + System.lineSeparator() + "O CAMPO STATUS DEVE CONTER 1 CARACTERE, INDICANDO STATUS ATIVO/INATIVO (1/0).", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		if(nomeSeg.length()>=4 && nomeSeg.length()<=25 && codSeg.length()==3 && tpCtt.equalsIgnoreCase("CDC")==true || tpCtt.equalsIgnoreCase("LSG") && tpPessoa.equalsIgnoreCase("PF") || tpPessoa.equalsIgnoreCase("PJ")){
			cadastroVO.setNomeSeg(nomeSeg);
			
			//Busca nome do produto na base
			try {
				dao.buscarNomeNaBaseSeg(cadastroVO);
				nomeSegVO = cadastroVO.getNomeSeg();
				
				if(nomeSeg.equalsIgnoreCase(nomeOldSeg)==false){
					
					if (nomeSeg.equalsIgnoreCase(nomeSegVO)){
						JOptionPane.showMessageDialog(null, "JÁ EXISTE UM SEGMENTO CADASTRADO COM ESTE NOME, POR FAVOR ESCOLHA OUTRO NOME DE SEGMENTO.", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					
					else if(nomeSeg.equalsIgnoreCase(nomeSegVO)==false) {

						cadastroVO.setCodSeg(codSeg);
						cadastroVO.setNomeSeg(nomeSeg);
						cadastroVO.setTpCtt(tpCtt);
						cadastroVO.setTpPessoa(tpPessoa);	
						cadastroVO.setSegSta(segSta);
						//Atualiza dados na base
						dao.atualizaDadosNaBaseSeg(cadastroVO);
						JOptionPane.showMessageDialog(null, "O SEGMENTO: " + codSeg + " - " + nomeSeg.toUpperCase() + " FOI ALTERADO COM SUCESSO.","ALTERAÇÃO DE SEGMENTO", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						CadastroSegmento tela = new CadastroSegmento();
						tela.criaTelaAlteraSeg();
						tela.criaBotoesAlteraSeg();
						tela.setVisible(true);
						
					}
				}
				
				else if(nomeSeg.equalsIgnoreCase(nomeOldSeg)){

					cadastroVO.setCodSeg(codSeg);
					cadastroVO.setNomeSeg(nomeSeg);
					cadastroVO.setTpCtt(tpCtt);
					cadastroVO.setTpPessoa(tpPessoa);	
					cadastroVO.setSegSta(segSta);
					//Atualiza dados na base
					dao.atualizaDadosNaBaseSeg(cadastroVO);
					JOptionPane.showMessageDialog(null, "O SEGMENTO: " + codSeg + " - " + nomeSeg.toUpperCase() + " FOI ALTERADO COM SUCESSO.","ALTERAÇÃO DE SEGMENTO", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					CadastroSegmento tela = new CadastroSegmento();
					tela.criaTelaAlteraSeg();
					tela.criaBotoesAlteraSeg();
					tela.setVisible(true);
				}
				
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
	public void criaBotoesAlteraSeg() {
		
		botoes.definirBotoesTelaAlteraSeg(this, this);
	}
}


