package usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import login.Login;
import sistema.cadastro.Botao;
import sistema.cadastro.Tela;

public class CadastroUser extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JTextField tUser = new JTextField();
	private JTextField tPass = new JPasswordField();
	private JTextField tPass2 = new JPasswordField();
	private JTextField tPass3 = new JPasswordField();
	private JTextField tNome = new JTextField();
	private JTextField tCPF = new JTextField();
	private JTextField tData = new JTextField();
	private Botao botoes = new Botao();
	private CadastroUserVO cadastroVO = new CadastroUserVO();
	private CadastroUserDAO dao = new CadastroUserDAO();

	
	public void pegaValorTelaCadastroUser() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String user = tUser.getText().trim();
		String pass = tPass.getText();
		String pass2 = tPass2.getText();
		String nome = tNome.getText().trim();
		String cpf = tCPF.getText();
		String data = tData.getText();
		String NomeUserVO = "";
		String CPFVO = "";

		if (user.length()==0 || user.length() <4 || user.length()>25){
			JOptionPane.showMessageDialog(null, "CAMPO USU�RIO INV�LIDO!" + System.lineSeparator() +"O USU�RIO DEVE CONTER DE 4 A 25 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}

		else if (pass.length()==0 || pass.length() <5 || pass.length()>12){
			JOptionPane.showMessageDialog(null, "CAMPO SENHA INV�LIDO!" + System.lineSeparator() +"A SENHA DEVE CONTER DE 5 A 12 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (pass.equals(pass2)==false){
			JOptionPane.showMessageDialog(null, "AS SENHAS DIGITADAS N�O CONFEREM!" + System.lineSeparator() +"POR FAVOR, DIGITE NOVAMENTE.","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (nome.length()==0 || nome.length() <4 || nome.length()>25){
			JOptionPane.showMessageDialog(null, "CAMPO NOME INV�LIDO!" + System.lineSeparator() +"A NOME DEVE CONTER DE 4 A 25 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (cpf.length()==0 || cpf.length() <11 || cpf.length()>11){
			JOptionPane.showMessageDialog(null, "CAMPO CPF INV�LIDO!" + System.lineSeparator() +"O CPF DEVE CONTER 11 CARACTERES, SOMENTE N�MEROS","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (data.length()==0 || data.length() <10 || data.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO DATA INV�LIDO!" + System.lineSeparator() +"A DATA DEVE SER PREENCHIDA NO PADR�O DD/MM/AAAA COM BARRAS","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		else {
			cadastroVO.setUser(user);
			
			//Gera hash da senha para inser��o no banco
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			byte messageDigest[] = algorithm.digest(pass.getBytes("UTF-8"));
			
			StringBuilder hashPass = new StringBuilder();
			for (byte b : messageDigest) {
				hashPass.append(String.format("%02X", 0xFF & b));
			}
			pass = hashPass.toString();
			
			cadastroVO.setPass(pass);
			
			CadastroUserVO.setNome(nome);
			CadastroUserVO.setDataNasc(data);
			CadastroUserVO.setCPF(cpf);
			
			//Realiza uma conulta no banco e verifica a disponibilidade do nome e cadastro por CPF
			try {
				dao.buscarDadosNaBaseUser(cadastroVO);
				NomeUserVO = cadastroVO.getNomeUser();
				dao.buscarDadosNaBaseCPF(cadastroVO);
				CPFVO = CadastroUserVO.getCPF();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cpf.equals(CPFVO)){
				System.out.println("J� existe um usu�rio para o CPF informado: " + cpf);
				JOptionPane.showMessageDialog(null,"J� EXISTE UM USU�RIO CADASTRADO PARA O CPF: " + cpf + System.lineSeparator() + "POR FAVOR, CASO SEJA NECESS�RIO ALTERAR O NOME DE USU�RIO, V� AO MENU PRINCIPAL E SELECIONE E OP��O ALTERAR USU�RIO", "CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if (user.equalsIgnoreCase(NomeUserVO)){
				System.out.println("Usu�rio "+ user.toUpperCase() + " j� existe na base." );
				JOptionPane.showMessageDialog(null,"J� EXISTE UM USU�RIO " + user.toUpperCase() +" CADASTRADO." + System.lineSeparator() + "POR FAVOR, ESCOLHA OUTRO NOME DE USU�RIO.", "CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else {
				
				try {
					cadastroVO.setUser(user);
					CadastroUserVO.setCPF(cpf);
					CadastroUserVO.setDataNasc(data);
					dao.insereDadosNaBase(cadastroVO);
					System.out.println("Usu�rio "+ user.toUpperCase() + " cadastrado." );
					JOptionPane.showMessageDialog(null,"USU�RIO " + user.toUpperCase() +" CADASTRADO COM SUCESSO.", "CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					CadastroUser cadastroUser = new CadastroUser();
					cadastroUser.criaTelaCadastroUser();
					cadastroUser.criaBotoes();
					cadastroUser.setVisible(true);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}	
		}
		
	}
	
	public void pegaValorTelaAlteraNomeUser(){
		String oldUser = CadastroUserVO.getOldUser();
		String newUser = tUser.getText().trim();
		String NomeUserVO = "";
		
		if (newUser.length()==0 || newUser.length() <4 || newUser.length()>25){
			JOptionPane.showMessageDialog(null, "CAMPO USU�RIO INV�LIDO!" + System.lineSeparator() +"O USU�RIO DEVE CONTER DE 4 A 25 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}

		//Se todos os campos estiverem ok
		else {
			cadastroVO.setUser(newUser);
			
			//Realiza uma conulta no banco e verifica a disponibilidade do nome
			try {
				dao.buscarDadosNaBaseUser(cadastroVO);
				NomeUserVO=cadastroVO.getNomeUser();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (newUser.equalsIgnoreCase(NomeUserVO)){
				System.out.println("Usu�rio "+ newUser.toUpperCase() + " j� existe na base." );
				JOptionPane.showMessageDialog(null,"J� EXISTE UM USU�RIO " + newUser.toUpperCase() +" CADASTRADO." + System.lineSeparator() + "POR FAVOR, ESCOLHA OUTRO NOME DE USU�RIO.", "CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
			
				try {
					cadastroVO.setUser(newUser);
					dao.atualizaUsuarioNaBase(cadastroVO);
					System.out.println("Usu�rio "+ oldUser.toUpperCase() + " alterado para " + newUser.toUpperCase() + ".");
					JOptionPane.showMessageDialog(null,"O USU�RIO " + oldUser.toUpperCase() +" FOI ALTERADO PARA: " + newUser.toUpperCase() + "." + System.lineSeparator() + "POR FAVOR, EFETUE O LOGIN NOVAMENTE.", "CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					Login login = new Login(Login.COMMAND_ALTERAR_USUARIO);
					login.criaTela();
					login.criaBotoesLogin();
					login.setVisible(true);
					cadastroVO.setNomeUser(newUser);//Para utiliza��o na classe LoginUser, onde � comparada a vari�vel NomeUser.
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}	
	}

	public void pegaValorTelaAlteraSenhaUser(){
		String oldUser = CadastroUserVO.getOldUser();
		String oldPass = tPass.getText();
		String newPass = tPass2.getText();
		String newPass2 = tPass3.getText();
		String SenhaUserVO = "";
		
		if (oldPass.length()==0 || oldPass.length() <5 || oldPass.length()>12){
			JOptionPane.showMessageDialog(null, "CAMPO SENHA INV�LIDO!" + System.lineSeparator() +"A SENHA DEVE CONTER DE 5 A 12 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (newPass.length()==0 || newPass.length() <5 || newPass.length()>12){
			JOptionPane.showMessageDialog(null, "CAMPO NOVA SENHA INV�LIDO!" + System.lineSeparator() +"A SENHA DEVE CONTER DE 5 A 12 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (newPass.equals(newPass2)==false){
			JOptionPane.showMessageDialog(null, "AS SENHAS DIGITADAS N�O CONFEREM!" + System.lineSeparator() +"POR FAVOR, DIGITE NOVAMENTE.","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		//Se todos os campos estiverem ok
		else {
			
			try {
				//Gera hash da senha antiga para compara��o com banco
				MessageDigest algorithm = MessageDigest.getInstance("MD5");
				byte messageDigest[] = algorithm.digest(oldPass.getBytes("UTF-8"));
				
				StringBuilder hashPass = new StringBuilder();
				for (byte b : messageDigest) {
					hashPass.append(String.format("%02X", 0xFF & b));
				}
				oldPass = hashPass.toString();
				dao.buscarDadosNaBaseUser(cadastroVO);
				SenhaUserVO = cadastroVO.getSenhaUser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (oldPass.equals(SenhaUserVO)==false){
				System.out.println("Senha antiga informada incorreta." );
				JOptionPane.showMessageDialog(null,"A SENHA ANTIGA INFORMADA EST� INCORRETA!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				try {
					//Gera hash da senha para inser��o no banco
					MessageDigest algorithm = MessageDigest.getInstance("MD5");
					byte messageDigest[] = algorithm.digest(newPass.getBytes("UTF-8"));
					
					StringBuilder hashPass = new StringBuilder();
					for (byte b : messageDigest) {
						hashPass.append(String.format("%02X", 0xFF & b));
					}
					newPass = hashPass.toString();
					cadastroVO.setPass(newPass);
					
					dao.atualizaSenhaNaBase(cadastroVO);
					System.out.println("O usu�rio " + oldUser.toUpperCase() + " alterou a senha.");
					JOptionPane.showMessageDialog(null, "A SENHA FOI ALTERADA COM SUCESSO!" + System.lineSeparator() + "POR FAVOR, EFETUE O LOGIN NOVAMENTE.", "ALTERA��O DE SENHA", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					Login login = new Login(Login.COMMAND_ALTERAR_USUARIO);
					login.criaTela();
					login.criaBotoesLogin();
					login.setVisible(true);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "command_salvar":
			try {
				pegaValorTelaCadastroUser();
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "command_info":
			JOptionPane.showMessageDialog(null, "INSTRU��ES PARA O CADASTRAMENTO DE USU�RIO:" + System.lineSeparator() + "O CAMPO USU�RIO DEVE CONTER DE 4 A 25 CARACTERES." + System.lineSeparator() + "O CAMPO SENHA DEVE CONTER DE 5 A 12 CARACTERES." + System.lineSeparator() + "O CAMPO NOME DEVE CONTER DE 5 A 25 CARACTERES." + System.lineSeparator() + "O CAMPO CPF DEVE SER PREENCHIDO COM APENAS N�MEROS E DEVE CONTER 11 CARACTERES." + System.lineSeparator() + "O CAMPO DATA DE NASCIMENTO DEVE SER PREENCHIDO NO PADR�O DD/MM/AAAA COM BARRAS." + System.lineSeparator() + "N�O SER� REALIZADA VALIDA��O DE LETRAS MAI�SCULAS OU MIN�SCULAS PARA O USU�RIO CRIADO, APENAS PARA SENHA.", "ATEN��O", JOptionPane.WARNING_MESSAGE);
			break;
		case "command_alterar_usuario":
			pegaValorTelaAlteraNomeUser();
			break;
		case "command_alterar_senha":
			pegaValorTelaAlteraSenhaUser();
			break;
		case "command_voltar":
			Tela tela = new Tela();
			tela.criaTela();
			tela.criaBotoes();
			tela.setVisible(true);
			dispose();
			break;
		}
	}
	
	public void criaTelaCadastroUser() {	
		tUser.setBounds(150,50,120,25);
		tPass.setBounds(150,80,120,25);
		tPass2.setBounds(150,110,120,25);
		tNome.setBounds(150,140,120,25);
		tCPF.setBounds(150,170,120,25);
		tData.setBounds(150,200,120,25);
		JLabel l1 = new JLabel("USU�RIO:");
		l1.setBounds(90,50,60,30);
		JLabel l2 = new JLabel("SENHA:");
		l2.setBounds(103,80,47,30);
		JLabel l3 = new JLabel("CONFIRME A SENHA:");
		l3.setBounds(31,110,120,30);
		JLabel l5 = new JLabel("NOME:");
		l5.setBounds(109,140,45,30);
		JLabel l6 = new JLabel("CPF:");
		l6.setBounds(120,170,30,30);
		JLabel l7 = new JLabel("DATA DE NASC.:");
		l7.setBounds(55,200,120,30);
		JLabel l4 = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE SALVAR.");
		l4.setBounds(31,15,330,30);
		
		
		//Tela
		setTitle("CADASTRAMENTO DE USU�RIO");
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
		getContentPane().add(l4);
		getContentPane().add(l5);
		getContentPane().add(l6);
		getContentPane().add(l7);
		getContentPane().add(tUser);
		getContentPane().add(tPass);
		getContentPane().add(tPass2);
		getContentPane().add(tNome);
		getContentPane().add(tCPF);
		getContentPane().add(tData);
	}
	
	public void criaBotoes() {
		
		botoes.definirBotoesTelaCadastroUser(this, this);
	}
	
	public void criaTelaAlteraUser(){
		
		tUser.setBounds(180,50,120,25);
		tPass.setBounds(180,130,120,25);
		tPass2.setBounds(180,160,120,25);
		tPass3.setBounds(180,190,120,25);
		JLabel l1 = new JLabel("NOVO USU�RIO:");
		l1.setBounds(84,50,120,30);
		JLabel l2 = new JLabel("SENHA ANTIGA:");
		l2.setBounds(88,130,100,30);
		JLabel l3 = new JLabel("NOVA SENHA:");
		l3.setBounds(97,160,120,30);
		JLabel l4 = new JLabel("CONFIRME A NOVA SENHA:");
		l4.setBounds(25,190,160,30);
		JLabel l5 = new JLabel("PARA ALTERA��O DE NOME DE USU�RIO OU SENHA, INFORME OS DADOS ABAIXO E PRESSIONE ALTERAR.");
		l5.setBounds(25,15,615,30);
		
		//Tela
		setTitle("ALTERA��O DE USU�RIO - USU�RIO LOGADO: " + CadastroUserVO.getOldUser().toUpperCase());
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
		getContentPane().add(l4);
		getContentPane().add(l5);
		getContentPane().add(tUser);
		getContentPane().add(tPass);
		getContentPane().add(tPass2);
		getContentPane().add(tPass3);
					
	}
	
	public void criaBotoesAltera() {
		
		botoes.definirBotoesTelaAlteraUser(this, this);
	}
	
	public void criaTelaConsultaUser(){

		try {
			List<ConsultaVO> list = dao.consultaUsuario();
						
			//Tela
			setTitle("CONSULTA DE USU�RIOS");
			setSize(1200, 500);
			//setLocation(200, 100);
			setLocationRelativeTo(null);
			setResizable(false);
			getContentPane().setBackground(Color.LIGHT_GRAY);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			JPanel painel = new JPanel();
			setContentPane(painel);
			JLabel l1 = new JLabel("CONSULTA DE USU�RIOS CADASTRADOS");
			l1.setFont(new Font("Dialog",Font.PLAIN, 15));
			l1.setBounds(430,15,300,30);
			//setLocationRelativeTo(null);
			//painel.setSize(1200,320);
			painel.setLayout(null);
			
		
			//Tabela
			JTable tabela = new JTable();//list.size(),6
			tabela.setBounds(20, 50,1150,320);
			tabela.setAutoResizeMode (JTable.AUTO_RESIZE_OFF); 
			tabela.setEnabled(false);
//			tabela.setCellSelectionEnabled(true);
//			tabela.setSelectionBackground(Color.black);
//			tabela.setSelectionForeground(Color.black);
//			tabela.setRowSelectionAllowed(false);
//			tabela.setCellSelectionEnabled(false);
//			tabela.setGridColor(Color.blue);   
	        
//	        JScrollPane scroll = new JScrollPane(tabela);
// 			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 			
 			
	        //Add
	        getContentPane().add(tabela);
	        getContentPane().add(l1);
//	        getContentPane().add(scroll);

			//Mouse Scroll
//			 MouseMotionAdapter doScrollRectToVisible = new MouseMotionAdapter() {
//			     public void mouseDragged(MouseEvent e) {
//			        Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
//			        ((JPanel)e.getSource()).scrollRectToVisible(r);
//			    }
//			 };
//			 tabela.addMouseMotionListener(doScrollRectToVisible);
			
			//Definir colunas
			Object[] cabecalho = {"NOME USU�RIO", "DATA CRIA��O", "DATA ALTERA��O USU�RIO", "DATA ALTERA��O SENHA", "NOME",  "CPF", "DATA NASCIMENTO"};
			List<Object[]> linhas = new ArrayList<Object[]>();
			
			Object[][] cabecalhoTopoEEsquerdo= new Object[1][];
			cabecalhoTopoEEsquerdo[0] = cabecalho;
			tabela.setModel(new DefaultTableModel(cabecalhoTopoEEsquerdo, cabecalho));
			
			
			//Popular linhas
	        for(ConsultaVO consultaVO: list){
	            linhas.add(new Object[]{consultaVO.getNomeUser(), consultaVO.getDataCadastro(), consultaVO.getDataAlteracaoUser(), consultaVO.getDataAlteracaoSenha(),
	            		consultaVO.getNome(), consultaVO.getCPF(), consultaVO.getDataNasc()});
	        }        
	        
	        for(Object[] linha : linhas) {
	        	((DefaultTableModel)tabela.getModel()).addRow(linha);
	        	
	        }  
	        
	        //Modificador cabe�alho
	        final TableCellRenderer hr = tabela.getTableHeader().getDefaultRenderer();
	        JTableHeader th = tabela.getTableHeader();
	        TableColumnModel tcm = th.getColumnModel();
	        
	        for(int i=0; i < 7;i++) {
	        	TableColumn tc = tcm.getColumn(i);
	        	
	        	 tc.setCellRenderer(new TableCellRenderer() {
	 				
	 	        	@Override
	 	        	public Component getTableCellRendererComponent(JTable table, Object value,
	 	        			boolean isSelected, boolean hasFocus, int row, int column) {
	 	        		Component c = hr.getTableCellRendererComponent(table,
	 	        				value, isSelected, hasFocus, row, column);

 	        			if(row == 0) {
 		        			c.setBackground(Color.DARK_GRAY);
 		        			c.setForeground(Color.white);
 	        			} else {
 	        				c.setBackground(Color.white);
 		        			c.setForeground(Color.black);
 	        			}
 	        			return c;
	 	        	}
	 			});
	        }    
		}
		catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR USU�RIOS.", "ERRO", JOptionPane.ERROR_MESSAGE);		
		}
	}
	
	public void criaBotoesConsulta(){
		botoes.definirBotoesTelaConsultaUser(this, this);
	}
}

