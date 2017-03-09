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
			JOptionPane.showMessageDialog(null, "INSTRUÇÕES PARA O CADASTRAMENTO DE PRODUTO:" + System.lineSeparator() + "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + "O CAMPO COD. DO PRODUTO DEVE CONTER 3 CARACTERES." + System.lineSeparator() + "O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES E DEVE EXISTIR NA TABELA DE SEGMENTOS." + System.lineSeparator() + "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM BARRAS.","INFO", JOptionPane.WARNING_MESSAGE);
			break;
		}
	}

	public void pegaValor(){
		String nomePRD = tNome.getText();
		String codPRD = tCod.getText();
		String segmento = tSeg.getText();
		String inicioVig = tInicioVig.getText();
		String fimVig = tFimVig.getText();
		String codPRDVO = "";
		String nomePRDVO = "";
		String prdsta = "1";
		
		if(nomePRD.length()<4 || nomePRD.length()>25){
			JOptionPane.showMessageDialog(null, "NOME DO PRODUTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(codPRD.length()<3 || segmento.length()>3){
			JOptionPane.showMessageDialog(null, "CAMPO COD. DO PRODUTO INVÁLIDO!" + System.lineSeparator() + "O CAMPO COD. DO PRODUTO DEVE CONTER 3 CARACTERES.", "ERRO", JOptionPane.ERROR_MESSAGE);
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
		
		//Se todos os campos estiverem ok
		if(nomePRD.length()>=4 && nomePRD.length()<=25 && codPRD.length()==3 && segmento.length()==3 && inicioVig.length()==10 && fimVig.length()==10){
			cadastroVO.setCodPRD(codPRD);
			cadastroVO.setNomePRD(nomePRD);
			
			//Busca código e nome do produto na base
			try {
				dao.buscarCodNaBasePRD(cadastroVO);
				codPRDVO = cadastroVO.getCodPRD();
				dao.buscarNomeNaBasePRD(cadastroVO);
				nomePRDVO = cadastroVO.getNomePRD();
				
				if(codPRD.equals(codPRDVO)){
					JOptionPane.showMessageDialog(null, "JÁ EXISTE UM PRODUTO CADASTRADO PARA ESTE CÓDIGO, POR FAVOR, ESCOLHA OUTRO CÓDIGO PARA O PRODUTO.", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if (nomePRD.equalsIgnoreCase(nomePRDVO)){
					JOptionPane.showMessageDialog(null, "JÁ EXISTE UM PRODUTO CADASTRADO COM ESTE NOME, POR FAVOR ESCOLHA OUTRO NOME DE PRODUTO.", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if(codPRD.equals(codPRDVO)==false && nomePRD.equalsIgnoreCase(nomePRDVO)==false) {
					cadastroVO.setCodSeg(segmento);
					//Verifica se existe o segmento informado
					dao.buscarDadosNaBaseSeg(cadastroVO);
					segmento = cadastroVO.getCodSeg();
					
					if(segmento.length()==0){
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
}
