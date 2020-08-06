package segmento;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import sistema.cadastro.Botao;
import sistema.cadastro.Tela;

public class CadastroSegmento extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Botao botoes = new Botao();
	private JTextField tNome = new JTextField();
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
	JFormattedTextField tAltTpCtt = new JFormattedTextField(altTpCtt);
	JFormattedTextField tAltTpPessoa = new JFormattedTextField(altTpPessoa);
	JFormattedTextField tAltSegSta = new JFormattedTextField(altSegSta);
	
	public void criaTelaCadastroSeg(){
		
		//Cria campos formatados
		try {
			MaskFormatter tpCtt;
			tpCtt = new MaskFormatter("***");
			tpCtt.setValidCharacters("cCdDlLsSgG");
			tTpCtt = new JFormattedTextField(tpCtt);
			
			MaskFormatter tpPessoa;
			tpPessoa = new MaskFormatter("**");
			tpPessoa.setValidCharacters("pPfFjJ");
			tTpPessoa = new JFormattedTextField(tpPessoa);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//Tela
		setTitle("CADASTRAMENTO DE SEGMENTO");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Label
		tNome.setBounds(157,50,165,25);
		tTpCtt.setBounds(157,80,70,25);
		tTpPessoa.setBounds(157,110,70,25);
		JLabel info = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE SALVAR.");
		info.setBounds(30,15,330,30);
		JLabel nome = new JLabel("NOME DO SEGMENTO:");
		nome.setBounds(30,50,200,30);
		JLabel tpCtt = new JLabel("TIPO CONTRATO:");
		tpCtt.setBounds(57,80,200,30);
		JLabel tpPessoa = new JLabel("TIPO PESSOA:");
		tpPessoa.setBounds(73,110,200,30);
		JLabel caracteres = new JLabel("CARACTERES: 0");
		caracteres.setBounds(330,50,200,30);
		
		//Contador de caracteres
		KeyListener kl = new KeyListener(){
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String nome = tNome.getText().trim();
				caracteres.setText("CARACTERES: " + nome.length());
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
		};
		
		tNome.addKeyListener(kl);
		
		//Add
		getContentPane().add(tNome);
		getContentPane().add(tTpCtt);
		getContentPane().add(tTpPessoa);
		getContentPane().add(info);
		getContentPane().add(nome);
		getContentPane().add(tpCtt);
		getContentPane().add(tpPessoa);
		getContentPane().add(caracteres);
	}
	
	public void criaBotoes() {	
		botoes.definirBotoesTelaCadastroSeg(this, this);
	}
	
	public void criaFocoCadastroSeg(){
		tNome.requestFocusInWindow();
	}

	public void criaTelaBuscaSeg(){
			
		//Tela
		setTitle("ALTERA��O DE SEGMENTO");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Label
		tNome.setBounds(210,50,165,25);
		JLabel info = new JLabel("INFORME OS DADOS DO SEGMENTO QUE DESEJA ALTERAR E PRESSIONE BUSCAR.");
		info.setBounds(30,15,500,30);
		JLabel nomeCod = new JLabel("NOME OU COD. DO SEGMENTO:");
		nomeCod.setBounds(30,50,250,30);
	
		//Add
		getContentPane().add(tNome);
		getContentPane().add(info);
		getContentPane().add(nomeCod);
	}
	
	public void criaBotoesBuscaSeg() {
		botoes.definirBotoesTelaBuscaSeg(this, this);
	}
	
	public void criaTelaAlteraSeg(){
		
		//Cria campos formatados
		try {
			MaskFormatter tpCtt;
			tpCtt = new MaskFormatter("***");
			tpCtt.setValidCharacters("cCdDlLsSgG");
			tpCtt.install(tAltTpCtt);
			
			MaskFormatter tpPessoa;
			tpPessoa = new MaskFormatter("**");
			tpPessoa.setValidCharacters("pPfFjJ");
			tpPessoa.install(tAltTpPessoa);
			
			MaskFormatter segStatus;
			segStatus = new MaskFormatter("#");
			segStatus.setValidCharacters("01");
			segStatus.install(tAltSegSta);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Tela
		setTitle("ALTERA��O DO SEGMENTO: " + altCodSeg + " - " + altNomeSeg);
		setSize(700, 500);
		setLocationRelativeTo(null);
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
		JLabel info = new JLabel("INFORME OS DADOS DO SEGMENTO QUE DESEJA ALTERAR.");
		info.setBounds(30,15,350,30);
		JLabel nome = new JLabel("NOME DO SEGMENTO:");
		nome.setBounds(30,50,200,30);
		JLabel cod = new JLabel("COD. DO SEGMENTO:");
		cod.setBounds(36,80,200,30);
		JLabel tpCtt = new JLabel("TIPO CONTRATO:");
		tpCtt.setBounds(57,110,200,30);
		JLabel tpPessoa = new JLabel("TIPO PESSOA:");
		tpPessoa.setBounds(73,140,200,30);
		JLabel status = new JLabel("STATUS:");
		status.setBounds(98,170,85,30);
		JLabel caracteres = new JLabel("CARACTERES: " + tAltNome.getText().length());
		caracteres.setBounds(330,50,200,30);
		
		//Contador de caracteres
		KeyListener kl = new KeyListener(){
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String nome = tAltNome.getText().trim();
				caracteres.setText("CARACTERES: " + nome.length());
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
		};
		
		tAltNome.addKeyListener(kl);
		
		//Add
		getContentPane().add(tAltNome);
		getContentPane().add(tAltCod);
		getContentPane().add(tAltTpCtt);
		getContentPane().add(tAltTpPessoa);
		getContentPane().add(tAltSegSta);
		getContentPane().add(info);
		getContentPane().add(nome);
		getContentPane().add(cod);
		getContentPane().add(tpCtt);
		getContentPane().add(tpPessoa);
		getContentPane().add(status);
		getContentPane().add(caracteres);
	}
	
	public void criaBotoesAlteraSeg() {
		botoes.definirBotoesTelaAlteraSeg(this, this);
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
			JOptionPane.showMessageDialog(null, "INSTRU��ES PARA O CADASTRAMENTO DE SEGMENTO:" + System.lineSeparator() + 
					"O CAMPO NOME DO SEGMENTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + 
					"O CAMPO TIPO CONTRATO DEVE CONTER 3 CARACTERES (CDC OU LSG)." + System.lineSeparator() + 
					"O CAMPO TIPO PESSOA DEVE CONTER 2 CARACTERES (PF OU PJ).","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		case "command_info_altera":
			JOptionPane.showMessageDialog(null, "INSTRU��ES PARA O ALTERA��O DE SEGMENTO:" + System.lineSeparator() + 
					"O CAMPO NOME DO SEGMENTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + 
					"O CAMPO TIPO CONTRATO DEVE CONTER 3 CARACTERES (CDC OU LSG)." + System.lineSeparator() + 
					"O CAMPO TIPO PESSOA DEVE CONTER 2 CARACTERES (PF OU PJ)." + System.lineSeparator() + 
					"O CAMPO STATUS DEVE CONTER 1 CARACTERE, INDICANDO STATUS ATIVO/INATIVO (1/0).","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		}
	}
	
	//Cadastro de segmento
	public void pegaValor(){
		String nomeSeg = tNome.getText().trim();
		String tpCtt = tTpCtt.getText();
		String tpPessoa = tTpPessoa.getText();
		String segSta = "1";
		String nomeSegVO = "";
		String codSegVO = "";
		
		if (nomeSeg.length()<4 || nomeSeg.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO SEGMENTO INV�LIDO!" + System.lineSeparator() + 
					"O CAMPO NOME DO SEGMENTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (tpCtt.equalsIgnoreCase("CDC")==false && tpCtt.equalsIgnoreCase("LSG")==false){
			JOptionPane.showMessageDialog(null, "TIPO DE CONTRATO INV�LIDO!" + System.lineSeparator() + 
					"O CAMPO TIPO CONTRATO DEVE CONTER 3 CARACTERES (CDC OU LSG).", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (tpPessoa.equalsIgnoreCase("PF")==false && tpPessoa.equalsIgnoreCase("PJ")==false){
			JOptionPane.showMessageDialog(null, "CAMPO TIPO DE PESSOA INV�LIDO!" + System.lineSeparator() + 
					"O CAMPO TIPO PESSOA DEVE CONTER 2 CARACTERES (PF OU PJ).", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		else if(nomeSeg.length()>=4 && nomeSeg.length()<=25 && tpCtt.equalsIgnoreCase("CDC")==true || tpCtt.equalsIgnoreCase("LSG") && 
				tpPessoa.equalsIgnoreCase("PF") || tpPessoa.equalsIgnoreCase("PJ")){
			
			try {
				cadastroVO.setNomeSeg(nomeSeg);
				cadastroVO.setTpCtt(tpCtt);
				cadastroVO.setTpPessoa(tpPessoa);
				cadastroVO.setSegSta(segSta);
				
				//Busca nome na base
				dao.buscarNomeNaBaseSeg(cadastroVO);
				nomeSegVO = cadastroVO.getNomeSeg();
				
				if(nomeSeg.equalsIgnoreCase(nomeSegVO)){
					JOptionPane.showMessageDialog(null, "J� EXISTE UM SEGMENTO CADASTRADO COM ESTE NOME, POR FAVOR ESCOLHA OUTRO NOME DE SEGMENTO.", 
							"ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
				else{
					//Insere dados na base
					cadastroVO.setNomeSeg(nomeSeg);
					cadastroVO.setTpCtt(tpCtt);
					cadastroVO.setTpPessoa(tpPessoa);
					cadastroVO.setSegSta(segSta);
					dao.insereDadosNaBaseSeg(cadastroVO);
					
					//Pega cod gerado para apresenta��o em tela
					dao.buscarNomeNaBaseSeg(cadastroVO);
					codSegVO = cadastroVO.getCodSeg();
					JOptionPane.showMessageDialog(null, "O SEGMENTO: " + nomeSeg.toUpperCase() + " FOI CADASTRADO COM SUCESSO." + System.lineSeparator() + 
							"O C�DIGO DESTE SEGMENTO �: " + codSegVO + ".","CADASTRAMENTO DE SEGMENTO", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					CadastroSegmento tela = new CadastroSegmento();
					tela.criaTelaCadastroSeg();
					tela.criaBotoes();
					tela.setVisible(true);
					tela.criaFocoCadastroSeg();
				}
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
	//Busca de segmento
	public void pegaValorTelaBuscaSeg(){
		String nomeCodSeg = tNome.getText().trim();
		String nomeSegVO = "";
		String codSegVO = "";
		
		if (nomeCodSeg.length()<3 || nomeCodSeg.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO SEGMENTO/COD. INV�LIDO!" + System.lineSeparator() + 
					"O CAMPO NOME/COD. DO SEGMENTO DEVE CONTER DE 3 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		else {
			
			//Busca c�digo e nome do produto na base
			try {
				cadastroVO.setCodSeg(nomeCodSeg);
				dao.buscarCodNaBaseSeg(cadastroVO);
				codSegVO = cadastroVO.getCodSeg();
				
				cadastroVO.setNomeSeg(nomeCodSeg);
				dao.buscarNomeNaBaseSeg(cadastroVO);
				nomeSegVO = cadastroVO.getNomeSeg();
				
				if (codSegVO.length()==0 && nomeSegVO.length()==0){
					JOptionPane.showMessageDialog(null, "O SEGMENTO INFORMADO N�O EXISTE NA BASE.", "CONSULTA DE SEGMENTO", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (nomeCodSeg.equals(codSegVO)){
					//Chamada DAO para atualiza��o dos valores VO
					cadastroVO.setCodSeg(nomeCodSeg);
					dao.buscarCodNaBaseSeg(cadastroVO);
					dispose();
					CadastroSegmento altera = new CadastroSegmento();
					altera.criaTelaAlteraSeg();
					altera.criaBotoesAlteraSeg();
					altera.setVisible(true);
				}
				else if (nomeCodSeg.equalsIgnoreCase(nomeSegVO)){
					//Chamada DAO para atualiza��o dos valores VO
					cadastroVO.setNomeSeg(nomeCodSeg);
					dao.buscarNomeNaBaseSeg(cadastroVO);
					dispose();
					CadastroSegmento altera = new CadastroSegmento();
					altera.criaTelaAlteraSeg();
					altera.criaBotoesAlteraSeg();
					altera.setVisible(true);
				}
				else if (nomeCodSeg.equalsIgnoreCase(codSegVO) == false && nomeCodSeg.equalsIgnoreCase(nomeSegVO) == false){
					JOptionPane.showMessageDialog(null, "O SEGMENTO INFORMADO N�O EXISTE NA BASE.", "CONSULTA DE SEGMENTO", JOptionPane.INFORMATION_MESSAGE);
				}
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
	//Altera��o de segmento
	public void pegaValorTelaAlteraSeg(){
		String nomeSeg = tAltNome.getText().trim();
		String codSeg = cadastroVO.getCodSeg();
		String tpCtt = tAltTpCtt.getText().trim();
		String tpPessoa = tAltTpPessoa.getText().trim();
		String segSta = tAltSegSta.getText().trim();
		String nomeSegVO = "";
		String nomeOldSeg = cadastroVO.getNomeSeg();
		
		if (nomeSeg.length()<4 || nomeSeg.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO SEGMENTO INV�LIDO!" + System.lineSeparator() + 
					"O CAMPO NOME DO SEGMENTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroSegmento tela = new CadastroSegmento();
			tela.criaTelaAlteraSeg();
			tela.criaBotoesAlteraSeg();
			tela.setVisible(true);
		}
		
		else if (tpCtt.equalsIgnoreCase("CDC")==false && tpCtt.equalsIgnoreCase("LSG")==false){
			JOptionPane.showMessageDialog(null, "CAMPO TIPO DE CONTRATO INV�LIDO!" + System.lineSeparator() + 
					"O CAMPO TIPO CONTRATO DEVE CONTER 3 CARACTERES (CDC OU LSG).", "ERRO", JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroSegmento tela = new CadastroSegmento();
			tela.criaTelaAlteraSeg();
			tela.criaBotoesAlteraSeg();
			tela.setVisible(true);
		}
		
		else if (tpPessoa.equalsIgnoreCase("PF")==false && tpPessoa.equalsIgnoreCase("PJ")==false){
			JOptionPane.showMessageDialog(null, "CAMPO TIPO DE PESSOA INV�LIDO!" + System.lineSeparator() + 
					"O CAMPO TIPO DE PESSOA DEVE CONTER 2 CARACTERES (PF OU PJ).", "ERRO", JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroSegmento tela = new CadastroSegmento();
			tela.criaTelaAlteraSeg();
			tela.criaBotoesAlteraSeg();
			tela.setVisible(true);
		}
		
		else if (segSta.equals("1")==false && segSta.equals("0")==false){
			JOptionPane.showMessageDialog(null, "CAMPO STATUS INV�LIDO!" + System.lineSeparator() + 
					"O CAMPO STATUS DEVE CONTER 1 CARACTERE, INDICANDO STATUS ATIVO/INATIVO (1/0).", "ERRO", JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroSegmento tela = new CadastroSegmento();
			tela.criaTelaAlteraSeg();
			tela.criaBotoesAlteraSeg();
			tela.setVisible(true);
		}
		
		//Se todos os campos estiverem ok
		else {
			cadastroVO.setNomeSeg(nomeSeg);
			
			//Busca nome do segmento na base
			try {
				dao.buscarNomeNaBaseSeg(cadastroVO);
				nomeSegVO = cadastroVO.getNomeSeg();
				
				if(nomeSeg.equalsIgnoreCase(nomeOldSeg)==false){
					
					if(nomeSeg.equalsIgnoreCase(nomeSegVO)){
						JOptionPane.showMessageDialog(null, "J� EXISTE UM SEGMENTO CADASTRADO COM ESTE NOME, POR FAVOR ESCOLHA OUTRO NOME DE SEGMENTO.", 
								"ERRO", JOptionPane.ERROR_MESSAGE);
					}
					
					else if(nomeSeg.equalsIgnoreCase(nomeSegVO)==false) {
						cadastroVO.setCodSeg(codSeg);
						cadastroVO.setNomeSeg(nomeSeg);
						cadastroVO.setTpCtt(tpCtt);
						cadastroVO.setTpPessoa(tpPessoa);	
						cadastroVO.setSegSta(segSta);
						//Atualiza dados na base
						dao.atualizaDadosNaBaseSeg(cadastroVO);
						JOptionPane.showMessageDialog(null, "O SEGMENTO: " + codSeg + " - " + nomeSeg.toUpperCase() + 
								" FOI ALTERADO COM SUCESSO.","ALTERA��O DE SEGMENTO", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						CadastroSegmento tela = new CadastroSegmento();
						tela.criaTelaAlteraSeg();
						tela.criaBotoesAlteraSeg();
						tela.setVisible(true);	
					}
				}
				
				else if (nomeSeg.equalsIgnoreCase(nomeOldSeg)){
					cadastroVO.setCodSeg(codSeg);
					cadastroVO.setNomeSeg(nomeSeg);
					cadastroVO.setTpCtt(tpCtt);
					cadastroVO.setTpPessoa(tpPessoa);	
					cadastroVO.setSegSta(segSta);
					//Atualiza dados na base
					dao.atualizaDadosNaBaseSeg(cadastroVO);
					JOptionPane.showMessageDialog(null, "O SEGMENTO: " + codSeg + " - " + nomeSeg.toUpperCase() + 
							" FOI ALTERADO COM SUCESSO.","ALTERA��O DE SEGMENTO", JOptionPane.INFORMATION_MESSAGE);
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
	
}