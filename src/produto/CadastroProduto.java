package produto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import sistema.cadastro.Botao;
import sistema.cadastro.Tela;

public class CadastroProduto extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Botao botoes = new Botao();
	private JTextField tNome = new JTextField();
	private JTextField tCod = new JTextField();
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
	JTextField tAltIniVig = new JTextField(altInicioVig);
	JTextField tAltFimVig = new JTextField(altFimVig);
	JTextField tAltCodSeg = new JTextField(altCodSeg);
	JTextField tAltPrdSta = new JTextField(altPrdSta);
	
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
	tCod.setBounds(150,80,70,25);
	tSeg.setBounds(150,110,70,25);
	tInicioVig.setBounds(150,140,70,25);
	tFimVig.setBounds(245,140,70,25);
	JLabel l1 = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE SALVAR.");
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
	
	//Add
	getContentPane().add(tNome);
	getContentPane().add(tCod);
	getContentPane().add(tSeg);
	getContentPane().add(tInicioVig);
	getContentPane().add(tFimVig);
	getContentPane().add(l1);
	getContentPane().add(l2);
	getContentPane().add(l3);
	getContentPane().add(l4);
	getContentPane().add(l5);
	getContentPane().add(l6);
	}
	
	public void criaTelaAlteraProd(){

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
			JOptionPane.showMessageDialog(null, "INSTRUÇÕES PARA O CADASTRAMENTO DE PRODUTO:" + System.lineSeparator() + "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + "O CAMPO COD. DO PRODUTO DEVE CONTER 3 CARACTERES." + System.lineSeparator() + "O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES E DEVE EXISTIR NA TABELA DE SEGMENTOS." + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS.","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		case "command_info_altera":
			JOptionPane.showMessageDialog(null, "INSTRUÇÕES PARA O ALTERAÇÃO DE PRODUTO:" + System.lineSeparator() + "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + "O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES E DEVE EXISTIR NA TABELA DE SEGMENTOS." + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS." + System.lineSeparator() + "O CAMPO STATUS DEVE CONTER 1 CARACTERE, INDICANDO STATUS ATIVO/INATIVO (1/0).","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		}
	}

	//Cadastro de produto
	public void pegaValor(){
		String nomePRD = tNome.getText();
		String codPRD = tCod.getText();
		String segmento = tSeg.getText();
		String inicioVig = tInicioVig.getText();
		String fimVig = tFimVig.getText();
		String codPRDVO = "";
		String nomePRDVO = "";
		String prdsta = "1";
		
		if (nomePRD.length()<4 || nomePRD.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO PRODUTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (codPRD.length()<3 || segmento.length()>3){
			JOptionPane.showMessageDialog(null, "CAMPO COD. DO PRODUTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO COD. DO PRODUTO DEVE CONTER 3 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (segmento.length()<3 || segmento.length()>3){
			JOptionPane.showMessageDialog(null, "CAMPO SEGMENTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (inicioVig.length()<10 || inicioVig.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO INÍCIO DE VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (fimVig.length()<10 || fimVig.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO INÍCIO DE VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		else {
			
			//Busca código e nome do produto na base
			try {
				cadastroVO.setCodPRD(codPRD);
				dao.buscarCodNaBasePRD(cadastroVO);
				codPRDVO = cadastroVO.getCodPRD();
				
				cadastroVO.setNomePRD(nomePRD);
				dao.buscarNomeNaBasePRD(cadastroVO);
				nomePRDVO = cadastroVO.getNomePRD();
				
				if (codPRD.equals(codPRDVO)){
					JOptionPane.showMessageDialog(null, "JÁ EXISTE UM PRODUTO CADASTRADO PARA ESTE CÓDIGO, POR FAVOR, ESCOLHA OUTRO CÓDIGO PARA O PRODUTO.", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if (nomePRD.equalsIgnoreCase(nomePRDVO)){
					JOptionPane.showMessageDialog(null, "JÁ EXISTE UM PRODUTO CADASTRADO COM ESTE NOME, POR FAVOR ESCOLHA OUTRO NOME DE PRODUTO.", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if (codPRD.equals(codPRDVO)==false && nomePRD.equalsIgnoreCase(nomePRDVO)==false) {
					cadastroVO.setCodSeg(segmento);
					//Verifica se existe o segmento informado
					dao.buscarDadosNaBaseSeg(cadastroVO);
					segmento = cadastroVO.getCodSeg();
					
					if (segmento.length()==0){
						JOptionPane.showMessageDialog(null, "O SEGMENTO INFORMADO NÃO EXISTE NA BASE.", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					else{
						cadastroVO.setCodPRD(codPRD);
						cadastroVO.setNomePRD(nomePRD);
						cadastroVO.setInicioVig(inicioVig);
						cadastroVO.setFimVig(fimVig);
						cadastroVO.setCodSeg(segmento);
						cadastroVO.setPRDSTA(prdsta);
						//Insere dados na base
						dao.insereDadosNaBasePRD(cadastroVO);
						JOptionPane.showMessageDialog(null, "O PRODUTO: " + codPRD + " - " + nomePRD.toUpperCase() + " FOI CADASTRADO COM SUCESSO.","CADASTRAMENTO DE PRODUTO", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						CadastroProduto tela = new CadastroProduto();
						tela.criaTelaCadastroProd();
						tela.criaBotoes();
						tela.setVisible(true);
					}
				}
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
	public void criaBotoes() {
		
		botoes.definirBotoesTelaCadastroProd(this, this);
	}
	
	//Busca de produto
	public void pegaValorTelaBuscaProd(){
		String nomeCodPRD = tNome.getText();
		String nomePRDVO = "";
		String codPRDVO = "";
		
		if (nomeCodPRD.length()<3 || nomeCodPRD.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO PRODUTO/COD. INVÁLIDO!" + System.lineSeparator() + "O CAMPO NOME/COD. DO PRODUTO DEVE CONTER DE 3 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
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
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	
	public void criaBotoesBuscaProd() {
		
		botoes.definirBotoesTelaBuscaProd(this, this);
	}
	
	//Alteração de produto
	public void pegaValorTelaAlteraProd(){
		String nomePRD = tAltNome.getText();
		String codPRD = tAltCod.getText();
		String segmento = tAltCodSeg.getText();
		String inicioVig = tAltIniVig.getText();
		String fimVig = tAltFimVig.getText();
		String prdsta = tAltPrdSta.getText();
		String nomePRDVO = "";
		String nomeOldPrd = cadastroVO.getNomePRD();
		
		if (nomePRD.length()<4 || nomePRD.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO PRODUTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
			
		else if (segmento.length()<3 || segmento.length()>3){
			JOptionPane.showMessageDialog(null, "CAMPO SEGMENTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (inicioVig.length()<10 || inicioVig.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO INÍCIO DE VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (fimVig.length()<10 || fimVig.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO INÍCIO DE VIGÊNCIA INVÁLIDO!" + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (prdsta.equals("1")==false && prdsta.equals("0")==false){
			JOptionPane.showMessageDialog(null, "CAMPO STATUS INVÁLIDO!" + System.lineSeparator() + "O CAMPO STATUS DEVE CONTER 1 CARACTERE, INDICANDO STATUS ATIVO/INATIVO (1/0).", "ERRO", JOptionPane.ERROR_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "JÁ EXISTE UM PRODUTO CADASTRADO COM ESTE NOME, POR FAVOR ESCOLHA OUTRO NOME DE PRODUTO.", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					
					else if (nomePRD.equalsIgnoreCase(nomePRDVO)==false) {
						cadastroVO.setCodSeg(segmento);
						//Verifica se existe o segmento informado
						dao.buscarDadosNaBaseSeg(cadastroVO);
						segmento = cadastroVO.getCodSeg();
						
						if(segmento.length()==0){
							JOptionPane.showMessageDialog(null, "O SEGMENTO INFORMADO NÃO EXISTE NA BASE.", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
						else {
							cadastroVO.setCodPRD(codPRD);
							cadastroVO.setNomePRD(nomePRD);
							cadastroVO.setInicioVig(inicioVig);
							cadastroVO.setFimVig(fimVig);
							cadastroVO.setCodSeg(segmento);
							cadastroVO.setPRDSTA(prdsta);
							//Atualiza dados na base
							dao.atualizaDadosNaBasePRD(cadastroVO);
							JOptionPane.showMessageDialog(null, "O PRODUTO: " + codPRD + " - " + nomePRD.toUpperCase() + " FOI ALTERADO COM SUCESSO.","ALTERAÇÃO DE PRODUTO", JOptionPane.INFORMATION_MESSAGE);
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
					segmento = cadastroVO.getCodSeg();
					
					if(segmento.length()==0){
						JOptionPane.showMessageDialog(null, "O SEGMENTO INFORMADO NÃO EXISTE NA BASE.", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					else {
						cadastroVO.setCodPRD(codPRD);
						cadastroVO.setNomePRD(nomePRD);
						cadastroVO.setInicioVig(inicioVig);
						cadastroVO.setFimVig(fimVig);
						cadastroVO.setCodSeg(segmento);
						cadastroVO.setPRDSTA(prdsta);
						//Atualiza dados na base
						dao.atualizaDadosNaBasePRD(cadastroVO);
						JOptionPane.showMessageDialog(null, "O PRODUTO: " + codPRD + " - " + nomePRD.toUpperCase() + " FOI ALTERADO COM SUCESSO.","ALTERAÇÃO DE PRODUTO", JOptionPane.INFORMATION_MESSAGE);
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
	
	public void criaBotoesAlteraProd() {
		
		botoes.definirBotoesTelaAlteraProd(this, this);
	}
}
