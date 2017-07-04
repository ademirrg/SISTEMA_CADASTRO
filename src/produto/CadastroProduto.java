package produto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import sistema.cadastro.Botao;
import sistema.cadastro.Tela;

public class CadastroProduto extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Botao botoes = new Botao();
	private JTextField tNome = new JTextField();
	private JTextField tSeg = new JTextField();
	private JTextField tInicioVig = new JTextField();
	private JTextField tFimVig = new JTextField();
	CadastroProdutoDAO dao = new CadastroProdutoDAO();
	CadastroProdutoVO cadastroVO = new CadastroProdutoVO();
	
	//Campos necessários para exibição dos valores na tela de alteração de produto
	String altCodPrd = cadastroVO.getCodPRD();
	String altNomePrd = cadastroVO.getNomePRD();
	String altInicioVig = cadastroVO.getInicioVig();
	String altFimVig = cadastroVO.getFimVig();
	String altCodSeg = cadastroVO.getCodSeg();
	String altPrdSta = cadastroVO.getPRDSTA();
	JTextField tAltCod = new JTextField(altCodPrd);
	JTextField tAltNome = new JTextField(altNomePrd);	
	JFormattedTextField tAltIniVig;
	JFormattedTextField tAltFimVig;
	JFormattedTextField tAltCodSeg = new JFormattedTextField(altCodSeg);
	JFormattedTextField tAltPrdSta = new JFormattedTextField(altPrdSta);
	
	public void criaTelaCadastroProd(){
	
		//Cria campos formatados
		try {	
			MaskFormatter data;
			data = new MaskFormatter("##/##/####");
			data.setValidCharacters("0123456789");
			tInicioVig = new JFormattedTextField(data);	
			tFimVig = new JFormattedTextField(data);
			
			MaskFormatter segmento;
			segmento = new MaskFormatter("###");
			segmento.setValidCharacters("0123456789");
			tSeg = new JFormattedTextField(segmento);	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//Tela
		setTitle("CADASTRAMENTO DE PRODUTO");
		setSize(700, 500);
		//setLocation(450, 100);
		setLocationRelativeTo(null);
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
	
	public void criaBotoes() {
		botoes.definirBotoesTelaCadastroProd(this, this);
	}
	
	public void criaFocoCadastroProd(){
		tNome.requestFocusInWindow();
	}
	
	public void criaTelaBuscaProd(){
		
		//Tela
		setTitle("ALTERAÇÃO DE PRODUTO");
		setSize(700, 500);
		//setLocation(450, 100);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Label
		tNome.setBounds(200,50,165,25);
		JLabel l1 = new JLabel("INFORME OS DADOS DO PRODUTO QUE DESEJA ALTERAR E PRESSIONE BUSCAR.");
		l1.setBounds(30,15,500,30);
		JLabel l2 = new JLabel("NOME OU COD. DO PRODUTO:");
		l2.setBounds(30,50,250,30);
		
		//Add
		getContentPane().add(tNome);
		getContentPane().add(l1);
		getContentPane().add(l2);
	}
	
	public void criaBotoesBuscaProd() {
		botoes.definirBotoesTelaBuscaProd(this, this);
	}
	
	public void criaTelaAlteraProd(){
		
		String[] dataSeparadaInicio = altInicioVig.split("-");
		String anoInicio = dataSeparadaInicio[0];
		String mesInicio = dataSeparadaInicio[1];
		String diaInicio = dataSeparadaInicio[2];
		String dataInicio = diaInicio + "/" + mesInicio + "/" + anoInicio;
		tAltIniVig = new JFormattedTextField(dataInicio);
		
		String[] dataSeparadaFim = altFimVig.split("-");
		String anoFim = dataSeparadaFim[0];
		String mesFim = dataSeparadaFim[1];
		String diaFim = dataSeparadaFim[2];
		String dataFim = diaFim + "/" + mesFim + "/" + anoFim;
		tAltFimVig = new JFormattedTextField(dataFim);
		
		try {
			MaskFormatter maskSegmento;
			maskSegmento = new MaskFormatter("###");
			maskSegmento.setValidCharacters("0123456789");
			maskSegmento.install(tAltCodSeg);
			
			MaskFormatter maskDataIni;
			maskDataIni = new MaskFormatter("##/##/####");
			maskDataIni.setValidCharacters("0123456789");
			maskDataIni.install(tAltIniVig);
			
			MaskFormatter maskDataFim;
			maskDataFim = new MaskFormatter("##/##/####");
			maskDataIni.setValidCharacters("0123456789");
			maskDataFim.install(tAltFimVig);
			
			MaskFormatter maskStatus;
			maskStatus = new MaskFormatter("#");
			maskStatus.setValidCharacters("01");
			maskStatus.install(tAltPrdSta);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Tela
		setTitle("ALTERAÇÃO DO PRODUTO: " + altCodPrd + " - " + altNomePrd);
		setSize(700, 500);
		//setLocation(450, 100);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Label
		tAltNome.setBounds(150,50,165,25);
		tAltCod.setBounds(150,80,70,25);
		tAltCod.setEnabled(false);
		tAltCodSeg.setBounds(150,110,70,25);
		tAltIniVig.setBounds(150,140,70,25);
		tAltFimVig.setBounds(245,140,70,25);
		tAltPrdSta.setBounds(150,170,70,25);
		JLabel l1 = new JLabel("INFORME OS DADOS DO PRODUTO QUE DESEJA ALTERAR.");
		l1.setBounds(30,15,330,30);
		JLabel l2 = new JLabel("NOME DO PRODUTO:");
		l2.setBounds(30,50,200,30);
		JLabel l3 = new JLabel("COD. DO PRODUTO:");
		l3.setBounds(36,80,200,30);
		JLabel l4 = new JLabel("SEGMENTO:");
		l4.setBounds(80,110,85,30);
		JLabel l5 = new JLabel("VIGÊNCIA:");
		l5.setBounds(91,140,85,30);
		JLabel l6 = new JLabel("Á");
		l6.setBounds(228,140,85,30);
		JLabel l7 = new JLabel("STATUS:");
		l7.setBounds(98,170,85,30);
		
		//Add
		getContentPane().add(tAltNome);
		getContentPane().add(tAltCod);
		getContentPane().add(tAltCodSeg);
		getContentPane().add(tAltIniVig);
		getContentPane().add(tAltFimVig);
		getContentPane().add(tAltPrdSta);
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(l3);
		getContentPane().add(l4);
		getContentPane().add(l5);
		getContentPane().add(l6);
		getContentPane().add(l7);
	}
	
	public void criaBotoesAlteraProd() {
		botoes.definirBotoesTelaAlteraProd(this, this);
	}
	
	//Ação dos botões
	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()) {
		case "command_salvar":
			pegaValor();
			break;
		case "command_alterar_prod":
			pegaValorTelaAlteraProd();
			break;
		case "command_buscar_prod":
			pegaValorTelaBuscaProd();
			break;
		case "command_voltar":
			Tela tela = new Tela();
			tela.criaTela();
			tela.criaBotoes();
			tela.setVisible(true);
			dispose();
			break;
		case "command_voltar_busca":
			CadastroProduto busca = new CadastroProduto();
			busca.criaTelaBuscaProd();
			busca.criaBotoesBuscaProd();
			busca.setVisible(true);
			dispose();
			break;
		case "command_info":
			JOptionPane.showMessageDialog(null, "INSTRUÇÕES PARA O CADASTRAMENTO DE PRODUTO:" + System.lineSeparator() + 
					"O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + 
					"O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES E DEVE EXISTIR NA TABELA DE SEGMENTOS." + System.lineSeparator() + 
					"O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM APENAS NÚMEROS.","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		case "command_info_altera":
			JOptionPane.showMessageDialog(null, "INSTRUÇÕES PARA O ALTERAÇÃO DE PRODUTO:" + System.lineSeparator() + 
					"O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + 
					"O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES E DEVE EXISTIR NA TABELA DE SEGMENTOS." + System.lineSeparator() + 
					"O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM APENAS NÚMEROS." + System.lineSeparator() + 
					"O CAMPO STATUS DEVE CONTER 1 CARACTERE, INDICANDO STATUS ATIVO/INATIVO (1/0).","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		}
	}

	//Cadastro de produto
	public void pegaValor(){
		String nomePRD = tNome.getText().trim();
		String segmento = tSeg.getText();
		String inicioVig = tInicioVig.getText();
		String fimVig = tFimVig.getText();
		String codPRDVO = "";
		String nomePRDVO = "";
		String prdsta = "1";
		
		//Para validação de data
		int anoVigente = Calendar.getInstance().get(Calendar.YEAR);
		int mesVigente = Calendar.getInstance().get(Calendar.MONTH);
		mesVigente = mesVigente + 1;
		int diaAtual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		String[] separador = inicioVig.split("/");
		String diaInicio = separador[0];
		String mesInicio = separador[1];
		String anoInicio = separador[2];
		inicioVig = anoInicio + "-" + mesInicio + "-" + diaInicio;
		inicioVig = inicioVig.trim();
		
		String[] separador2 = fimVig.split("/");
		String diaFim = separador2[0];
		String mesFim = separador2[1];
		String anoFim = separador2[2];
		fimVig = anoFim + "-" + mesFim + "-" + diaFim;
		fimVig = fimVig.trim();
		
		
		if (nomePRD.length()<4 || nomePRD.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO PRODUTO INVÁLIDO!" + System.lineSeparator() + 
					"O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (segmento.length()<3 || segmento.length()>3){
			JOptionPane.showMessageDialog(null, "CAMPO SEGMENTO INVÁLIDO!" + System.lineSeparator() + 
					"O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (inicioVig.length()<10 || inicioVig.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + 
					"O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM APENAS NÚMEROS.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(diaInicio) < 1 || (Integer.parseInt(diaInicio) > 31)){
			JOptionPane.showMessageDialog(null,  "DATA INÍCIO DA VIGÊNCIA INVÁLIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(mesInicio) < 1 || Integer.parseInt(mesInicio) > 12){
			JOptionPane.showMessageDialog(null, "DATA INÍCIO DA VIGÊNCIA INVÁLIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(anoInicio) < anoVigente){
			JOptionPane.showMessageDialog(null, "O INÍCIO DA VIGÊNCIA DEVE SER À PARTIR DE HOJE: " + 
		diaAtual + "/" + mesVigente + "/" + anoVigente + ".", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(anoInicio) == anoVigente && Integer.parseInt(mesInicio) < mesVigente){
			JOptionPane.showMessageDialog(null, "O INÍCIO DA VIGÊNCIA DEVE SER À PARTIR DE HOJE: " + 
		diaAtual + "/" + mesVigente + "/" + anoVigente + ".", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(anoInicio) == anoVigente && Integer.parseInt(mesInicio) == mesVigente && Integer.parseInt(diaInicio) < diaAtual){
			JOptionPane.showMessageDialog(null, "O INÍCIO DA VIGÊNCIA DEVE SER À PARTIR DE HOJE: " + 
		diaAtual + "/" + mesVigente + "/" + anoVigente + ".", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (fimVig.length()<10 || fimVig.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + 
					"O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM APENAS NÚMEROS.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(diaFim) < 1 || (Integer.parseInt(diaFim) > 31)){
			JOptionPane.showMessageDialog(null,  "DATA FIM DA VIGÊNCIA INVÁLIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(mesFim) < 1 || Integer.parseInt(mesFim) > 12){
			JOptionPane.showMessageDialog(null, "DATA FIM DA VIGÊNCIA INVÁLIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(anoFim) < Integer.parseInt(anoInicio)){
			JOptionPane.showMessageDialog(null, "DATA FINAL DA VIGÊNCIA ANTERIOR A DATA INICIAL DA VIGÊNCIA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(anoFim) == Integer.parseInt(anoInicio) && Integer.parseInt(mesFim) < Integer.parseInt(mesInicio)){
			JOptionPane.showMessageDialog(null, "DATA FINAL DA VIGÊNCIA ANTERIOR A DATA INICIAL DA VIGÊNCIA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(anoFim) == Integer.parseInt(anoInicio) && 
				Integer.parseInt(mesFim) == Integer.parseInt(mesInicio) &&
				Integer.parseInt(diaFim) < Integer.parseInt(diaInicio)){
			JOptionPane.showMessageDialog(null, "DATA FINAL DA VIGÊNCIA ANTERIOR A DATA INICIAL DA VIGÊNCIA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(diaFim) == Integer.parseInt(diaInicio) && 
				Integer.parseInt(mesFim) == Integer.parseInt(mesInicio) && 
				Integer.parseInt(anoFim) == Integer.parseInt(anoInicio)){
			JOptionPane.showMessageDialog(null, "A VIGÊNCIA DO PRODUTO DEVE DURAR POR PELO MENOS 1 DIA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		else {
			
			//Busca código e nome do produto na base
			try {	
				cadastroVO.setNomePRD(nomePRD);
				dao.buscarNomeNaBasePRD(cadastroVO);
				nomePRDVO = cadastroVO.getNomePRD();
				
				if (nomePRD.equalsIgnoreCase(nomePRDVO)){
					JOptionPane.showMessageDialog(null, "JÁ EXISTE UM PRODUTO CADASTRADO COM ESTE NOME, POR FAVOR ESCOLHA OUTRO NOME DE PRODUTO.", 
							"ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if (nomePRD.equalsIgnoreCase(nomePRDVO)==false) {
					cadastroVO.setCodSeg(segmento);
					//Verifica se existe o segmento informado
					dao.buscarDadosNaBaseSeg(cadastroVO);
					segmento = cadastroVO.getCodSeg();
					
					if (segmento.length()==0){
						JOptionPane.showMessageDialog(null, "O SEGMENTO INFORMADO NÃO EXISTE NA BASE.", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					else{
						cadastroVO.setNomePRD(nomePRD);
						cadastroVO.setInicioVig(inicioVig);
						cadastroVO.setFimVig(fimVig);
						cadastroVO.setCodSeg(segmento);
						cadastroVO.setPRDSTA(prdsta);
						
						//Insere dados na base
						dao.insereDadosNaBasePRD(cadastroVO);
						
						//Busca cod de produto para apresentação em tela
						dao.buscarNomeNaBasePRD(cadastroVO);	
						codPRDVO = cadastroVO.getCodPRD();
						
						JOptionPane.showMessageDialog(null, "O PRODUTO: " + codPRDVO + " - " + nomePRD.toUpperCase() + " FOI CADASTRADO COM SUCESSO.",
								"CADASTRAMENTO DE PRODUTO", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						CadastroProduto tela = new CadastroProduto();
						tela.criaTelaCadastroProd();
						tela.criaBotoes();
						tela.setVisible(true);
						tela.criaFocoCadastroProd();
					}
				}
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
	//Busca de produto
	public void pegaValorTelaBuscaProd(){
		String nomeCodPRD = tNome.getText();
		String nomePRDVO = "";
		String codPRDVO = "";
		
		if (nomeCodPRD.length()<2 || nomeCodPRD.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO PRODUTO/COD. INVÁLIDO!" + System.lineSeparator() + 
					"O CAMPO NOME/COD. DO PRODUTO DEVE CONTER DE 2 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		else {
			
			//Busca código e nome do produto na base
			try {
				cadastroVO.setCodPRD(nomeCodPRD);
				dao.buscarCodNaBasePRD(cadastroVO);
				codPRDVO = cadastroVO.getCodPRD();
				
				cadastroVO.setNomePRD(nomeCodPRD);
				dao.buscarNomeNaBasePRD(cadastroVO);
				nomePRDVO = cadastroVO.getNomePRD();
				
				if (codPRDVO.length()==0 && nomePRDVO.length()==0){
					JOptionPane.showMessageDialog(null, "O PRODUTO INFORMADO NÃO EXISTE NA BASE.", "CONSULTA DE PRODUTO", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (nomeCodPRD.equalsIgnoreCase(codPRDVO)){
					//Chamada DAO para atualização dos valores VO
					cadastroVO.setCodPRD(nomeCodPRD);
					dao.buscarCodNaBasePRD(cadastroVO);
					dispose();
					CadastroProduto altera = new CadastroProduto();
					altera.criaTelaAlteraProd();
					altera.criaBotoesAlteraProd();
					altera.setVisible(true);
				}
				else if (nomeCodPRD.equalsIgnoreCase(nomePRDVO)){
					//Chamada DAO para atualização dos valores VO
					cadastroVO.setNomePRD(nomeCodPRD);
					dao.buscarNomeNaBasePRD(cadastroVO);
					dispose();
					CadastroProduto altera = new CadastroProduto();
					altera.criaTelaAlteraProd();
					altera.criaBotoesAlteraProd();
					altera.setVisible(true);
				}
				else if (nomeCodPRD.equalsIgnoreCase(codPRDVO) == false && nomeCodPRD.equalsIgnoreCase(nomePRDVO) == false){
					JOptionPane.showMessageDialog(null, "O PRODUTO INFORMADO NÃO EXISTE NA BASE.", "CONSULTA DE PRODUTO", JOptionPane.INFORMATION_MESSAGE);
				}
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
	//Alteração de produto
	public void pegaValorTelaAlteraProd(){
		String nomePRD = tAltNome.getText();
		String codPRD = tAltCod.getText();
		String segmentoOld = cadastroVO.getCodSeg();//Mantem o ultimo segmento valido na VO
		String segmento = tAltCodSeg.getText();
		segmento = segmento.trim();
		String segmentoVO = "";
		String inicioVig = tAltIniVig.getText();
		String inicioVigOld = cadastroVO.getInicioVig();
		String fimVig = tAltFimVig.getText();
		String prdsta = tAltPrdSta.getText();
		prdsta = prdsta.trim();
		String nomePRDVO = "";
		String nomeOldPrd = cadastroVO.getNomePRD();
		
		//Para validação de data
		int anoVigente = Calendar.getInstance().get(Calendar.YEAR);
		int mesVigente = Calendar.getInstance().get(Calendar.MONTH);
		mesVigente = mesVigente + 1;
		int diaAtual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		String[] separador = inicioVig.split("/");
		String diaInicio = separador[0];
		String mesInicio = separador[1];
		String anoInicio = separador[2];
		inicioVig = inicioVig.trim();
		
		String[] separador2 = fimVig.split("/");
		String diaFim = separador2[0];
		String mesFim = separador2[1];
		String anoFim = separador2[2];
		fimVig = fimVig.trim();
		
		String[] dataSeparadaInicio = inicioVigOld.split("-");
		String anoInicioOld = dataSeparadaInicio[0];
		String mesInicioOld = dataSeparadaInicio[1];
		String diaInicioOld = dataSeparadaInicio[2];
		inicioVigOld = diaInicioOld + "/" + mesInicioOld + "/" + anoInicioOld;
		
		if (nomePRD.length()<4 || nomePRD.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO PRODUTO INVÁLIDO!" + System.lineSeparator() + 
					"O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
			
		else if (segmento.length()<3 || segmento.length()>3){
			JOptionPane.showMessageDialog(null, "CAMPO SEGMENTO INVÁLIDO!" + System.lineSeparator() + 
					"O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
		else if(inicioVig.equals(inicioVigOld)==false){
			
			if (inicioVig.length()<10 || inicioVig.length()>10){
				JOptionPane.showMessageDialog(null, "CAMPO VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + 
						"O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM APENAS NÚMEROS.", "ERRO", JOptionPane.ERROR_MESSAGE);
				dispose();
				CadastroProduto tela = new CadastroProduto();
				tela.criaTelaAlteraProd();
				tela.criaBotoesAlteraProd();
				tela.setVisible(true);
			}
			
			else if (Integer.parseInt(diaInicio) < 1 || (Integer.parseInt(diaInicio) > 31)){
				JOptionPane.showMessageDialog(null,  "DATA INÍCIO DA VIGÊNCIA INVÁLIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
				dispose();
				CadastroProduto tela = new CadastroProduto();
				tela.criaTelaAlteraProd();
				tela.criaBotoesAlteraProd();
				tela.setVisible(true);
			}
			
			else if (Integer.parseInt(mesInicio) < 1 || Integer.parseInt(mesInicio) > 12){
				JOptionPane.showMessageDialog(null, "DATA INÍCIO DA VIGÊNCIA INVÁLIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
				dispose();
				CadastroProduto tela = new CadastroProduto();
				tela.criaTelaAlteraProd();
				tela.criaBotoesAlteraProd();
				tela.setVisible(true);
			}
			
			else if (Integer.parseInt(anoInicio) < anoVigente){
				JOptionPane.showMessageDialog(null, "SE A DATA DE INÍCIO DA VIGÊNCIA FOR ALTERADA, DEVERÁ SER À PARTIR DE HOJE: " + 
			diaAtual + "/" + mesVigente + "/" + anoVigente + ".", "ERRO",JOptionPane.ERROR_MESSAGE);
				dispose();
				CadastroProduto tela = new CadastroProduto();
				tela.criaTelaAlteraProd();
				tela.criaBotoesAlteraProd();
				tela.setVisible(true);
			}
			
			else if (Integer.parseInt(anoInicio) == anoVigente && Integer.parseInt(mesInicio) < mesVigente){
				JOptionPane.showMessageDialog(null, "SE A DATA DE INÍCIO DA VIGÊNCIA FOR ALTERADA, DEVERÁ SER À PARTIR DE HOJE: " + 
			diaAtual + "/" + mesVigente + "/" + anoVigente + ".", "ERRO",JOptionPane.ERROR_MESSAGE);
				dispose();
				CadastroProduto tela = new CadastroProduto();
				tela.criaTelaAlteraProd();
				tela.criaBotoesAlteraProd();
				tela.setVisible(true);
			}
			
			else if (Integer.parseInt(anoInicio) == anoVigente && Integer.parseInt(mesInicio) == mesVigente && Integer.parseInt(diaInicio) < diaAtual){
				JOptionPane.showMessageDialog(null, "SE A DATA DE INÍCIO DA VIGÊNCIA FOR ALTERADA, DEVERÁ SER À PARTIR DE HOJE: " + 
			diaAtual + "/" + mesVigente + "/" + anoVigente + ".", "ERRO",JOptionPane.ERROR_MESSAGE);
				dispose();
				CadastroProduto tela = new CadastroProduto();
				tela.criaTelaAlteraProd();
				tela.criaBotoesAlteraProd();
				tela.setVisible(true);
			}
		}
		
		else if (fimVig.length()<10 || fimVig.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + 
					"O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM APENAS NÚMEROS.", "ERRO", JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
		
		else if (Integer.parseInt(diaFim) < 1 || (Integer.parseInt(diaFim) > 31)){
			JOptionPane.showMessageDialog(null,  "DATA FIM DA VIGÊNCIA INVÁLIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
		
		else if (Integer.parseInt(mesFim) < 1 || Integer.parseInt(mesFim) > 12){
			JOptionPane.showMessageDialog(null, "DATA FIM DA VIGÊNCIA INVÁLIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
		
		else if (Integer.parseInt(anoFim) < Integer.parseInt(anoInicio)){
			JOptionPane.showMessageDialog(null, "DATA FINAL DA VIGÊNCIA ANTERIOR A DATA INICIAL DA VIGÊNCIA!", "ERRO",JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
		
		else if (Integer.parseInt(anoFim) == Integer.parseInt(anoInicio) && Integer.parseInt(mesFim) < Integer.parseInt(mesInicio)){
			JOptionPane.showMessageDialog(null, "DATA FINAL DA VIGÊNCIA ANTERIOR A DATA INICIAL DA VIGÊNCIA!", "ERRO",JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
		
		else if (Integer.parseInt(anoFim) == Integer.parseInt(anoInicio) && 
				Integer.parseInt(mesFim) == Integer.parseInt(mesInicio) && 
				Integer.parseInt(diaFim) < Integer.parseInt(diaInicio)){
			JOptionPane.showMessageDialog(null, "DATA FINAL DA VIGÊNCIA ANTERIOR A DATA INICIAL DA VIGÊNCIA!", "ERRO",JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
		
		else if (Integer.parseInt(diaFim) == Integer.parseInt(diaInicio) && 
				Integer.parseInt(mesFim) == Integer.parseInt(mesInicio) && 
				Integer.parseInt(anoFim) == Integer.parseInt(anoInicio)){
			JOptionPane.showMessageDialog(null, "A VIGÊNCIA DO PRODUTO DEVE DURAR POR PELO MENOS 1 DIA!", "ERRO",JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
		
		else if (prdsta.equals("1")==false && prdsta.equals("0")==false){
			JOptionPane.showMessageDialog(null, "CAMPO STATUS INVÁLIDO!" + System.lineSeparator() + 
					"O CAMPO STATUS DEVE CONTER 1 CARACTERE, INDICANDO STATUS ATIVO/INATIVO (1/0).", "ERRO", JOptionPane.ERROR_MESSAGE);
			dispose();
			CadastroProduto tela = new CadastroProduto();
			tela.criaTelaAlteraProd();
			tela.criaBotoesAlteraProd();
			tela.setVisible(true);
		}
		
		//Se todos os campos estiverem ok
		else {
			cadastroVO.setNomePRD(nomePRD);
			
			//Busca nome do produto na base
			try {
				dao.buscarNomeNaBasePRD(cadastroVO);
				nomePRDVO = cadastroVO.getNomePRD();
				
				if (nomePRD.equalsIgnoreCase(nomeOldPrd)==false){
					
					if (nomePRD.equalsIgnoreCase(nomePRDVO)){
						JOptionPane.showMessageDialog(null, "JÁ EXISTE UM PRODUTO CADASTRADO COM ESTE NOME, POR FAVOR ESCOLHA OUTRO NOME DE PRODUTO.", 
								"ERRO", JOptionPane.ERROR_MESSAGE);
					}
					
					else if (nomePRD.equalsIgnoreCase(nomePRDVO)==false) {
						cadastroVO.setCodSeg(segmento);
						//Verifica se existe o segmento informado
						dao.buscarDadosNaBaseSeg(cadastroVO);
						segmentoVO = cadastroVO.getCodSeg();
						
						if(segmentoVO.length()==0){
							JOptionPane.showMessageDialog(null, "O SEGMENTO INFORMADO NÃO EXISTE NA BASE.", "ERRO", JOptionPane.ERROR_MESSAGE);
							cadastroVO.setCodSeg(segmentoOld);
							dispose();
							CadastroProduto tela = new CadastroProduto();
							tela.criaTelaAlteraProd();
							tela.criaBotoesAlteraProd();
							tela.setVisible(true);
						}
						else {
							cadastroVO.setCodPRD(codPRD);
							cadastroVO.setNomePRD(nomePRD);
							inicioVig = anoInicio + "-" + mesInicio + "-" + diaInicio;
							cadastroVO.setInicioVig(inicioVig);
							fimVig = anoFim + "-" + mesFim + "-" + diaFim;
							cadastroVO.setFimVig(fimVig);
							cadastroVO.setCodSeg(segmento);
							cadastroVO.setPRDSTA(prdsta);
							//Atualiza dados na base
							dao.atualizaDadosNaBasePRD(cadastroVO);
							JOptionPane.showMessageDialog(null, "O PRODUTO: " + codPRD + " - " + nomePRD.toUpperCase() + 
									" FOI ALTERADO COM SUCESSO.","ALTERAÇÃO DE PRODUTO", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							CadastroProduto tela = new CadastroProduto();
							tela.criaTelaAlteraProd();
							tela.criaBotoesAlteraProd();
							tela.setVisible(true);
						}
					}
				}
				
				else if (nomePRD.equalsIgnoreCase(nomeOldPrd)){
					cadastroVO.setCodSeg(segmento);
					//Verifica se existe o segmento informado
					dao.buscarDadosNaBaseSeg(cadastroVO);
					segmentoVO = cadastroVO.getCodSeg();
					
					if(segmentoVO.length()==0){
						JOptionPane.showMessageDialog(null, "O SEGMENTO INFORMADO NÃO EXISTE NA BASE.", "ERRO", JOptionPane.ERROR_MESSAGE);
						cadastroVO.setCodSeg(segmentoOld);
						dispose();
						CadastroProduto tela = new CadastroProduto();
						tela.criaTelaAlteraProd();
						tela.criaBotoesAlteraProd();
						tela.setVisible(true);
					}
					else {
						cadastroVO.setCodPRD(codPRD);
						cadastroVO.setNomePRD(nomePRD);
						inicioVig = anoInicio + "-" + mesInicio + "-" + diaInicio;
						cadastroVO.setInicioVig(inicioVig);
						fimVig = anoFim + "-" + mesFim + "-" + diaFim;
						cadastroVO.setFimVig(fimVig);
						cadastroVO.setCodSeg(segmento);
						cadastroVO.setPRDSTA(prdsta);
						//Atualiza dados na base
						dao.atualizaDadosNaBasePRD(cadastroVO);
						JOptionPane.showMessageDialog(null, "O PRODUTO: " + codPRD + " - " + nomePRD.toUpperCase() + 
								" FOI ALTERADO COM SUCESSO.","ALTERAÇÃO DE PRODUTO", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						CadastroProduto tela = new CadastroProduto();
						tela.criaTelaAlteraProd();
						tela.criaBotoesAlteraProd();
						tela.setVisible(true);
					}
				}
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
}
