package usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.MaskFormatter;

import enums.UsuarioEnum;
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
	private JFormattedTextField tCPF = new JFormattedTextField();
	private JTextField tData = new JTextField();
	private Botao botoes = new Botao();
	private CadastroUserVO cadastroVO = new CadastroUserVO();
	private CadastroUserDAO dao = new CadastroUserDAO();
	
	public void criaTelaCadastroUser() {
		
		//Cria campos formatados
		try {
			MaskFormatter cpf;
			cpf = new MaskFormatter("###.###.###-##");
			cpf.setValidCharacters("0123456789");
			tCPF = new JFormattedTextField(cpf);
			
			MaskFormatter data;
			data = new MaskFormatter("##/##/####");
			data.setValidCharacters("0123456789");
			tData = new JFormattedTextField(data);	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Label
		tUser.setBounds(150,50,120,25);
		tPass.setBounds(150,80,120,25);
		tPass2.setBounds(150,110,120,25);
		tNome.setBounds(150,140,120,25);
		tCPF.setBounds(150,170,120,25);
		tData.setBounds(150,200,120,25);
		JLabel info = new JLabel("INFORME OS DADOS SOLICITADOS E PRESSIONE SALVAR.");
		info.setBounds(31,15,330,30);
		JLabel usuario = new JLabel("USUÁRIO:");
		usuario.setBounds(90,50,60,30);
		JLabel senha = new JLabel("SENHA:");
		senha.setBounds(103,80,47,30);
		JLabel confirmeSenha = new JLabel("CONFIRME A SENHA:");
		confirmeSenha.setBounds(31,110,120,30);
		JLabel nome = new JLabel("NOME:");
		nome.setBounds(109,140,50,30);
		JLabel cpf = new JLabel("CPF:");
		cpf.setBounds(120,170,30,30);
		JLabel dtNasc = new JLabel("DATA DE NASC.:");
		dtNasc.setBounds(55,200,120,30);
		
		//Tela
		setTitle("CADASTRAMENTO DE USUÁRIO");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Add
		getContentPane().add(tUser);
		getContentPane().add(tPass);
		getContentPane().add(tPass2);
		getContentPane().add(tNome);
		getContentPane().add(tCPF);
		getContentPane().add(tData);
		getContentPane().add(info);
		getContentPane().add(usuario);
		getContentPane().add(senha);
		getContentPane().add(confirmeSenha);
		getContentPane().add(nome);
		getContentPane().add(cpf);
		getContentPane().add(dtNasc);
	}
	
	public void criaBotoes() {	
		botoes.definirBotoesTelaCadastroUser(this, this);
	}
	
	public void criaFocoCadastroUser(){
		tUser.requestFocusInWindow();
	}
	
	public void criaTelaAlteraUser(){	
		tUser.setBounds(180,50,120,25);
		tPass.setBounds(180,130,120,25);
		tPass2.setBounds(180,160,120,25);
		tPass3.setBounds(180,190,120,25);
		JLabel info = new JLabel("PARA ALTERAÇÃO DE NOME DE USUÁRIO OU SENHA, INFORME OS DADOS ABAIXO E PRESSIONE ALTERAR.");
		info.setBounds(25,15,615,30);
		JLabel novoUsuario = new JLabel("NOVO USUÁRIO:");
		novoUsuario.setBounds(84,50,120,30);
		JLabel senhaAntiga = new JLabel("SENHA ANTIGA:");
		senhaAntiga.setBounds(88,130,100,30);
		JLabel novaSenha = new JLabel("NOVA SENHA:");
		novaSenha.setBounds(97,160,120,30);
		JLabel confirmeSenha = new JLabel("CONFIRME A NOVA SENHA:");
		confirmeSenha.setBounds(25,190,160,30);
		
		//Tela
		setTitle("ALTERAÇÃO DE USUÁRIO - USUÁRIO LOGADO: " + CadastroUserVO.getOldUser().toUpperCase());
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Add
		getContentPane().add(tUser);
		getContentPane().add(tPass);
		getContentPane().add(tPass2);
		getContentPane().add(tPass3);	
		getContentPane().add(info);
		getContentPane().add(novoUsuario);
		getContentPane().add(senhaAntiga);
		getContentPane().add(novaSenha);
		getContentPane().add(confirmeSenha);
	}
	
	public void criaBotoesAltera() {
		botoes.definirBotoesTelaAlteraUser(this, this);
	}
	
	public void criaTelaConsultaUser(){
		
		try {
			List<ConsultaVO> list = dao.consultaUsuario();
			
			//Tela
			setTitle("CONSULTA DE USUÁRIOS");
			setSize(1200, 500);
			setLocationRelativeTo(null);
			setResizable(false);
			getContentPane().setBackground(Color.LIGHT_GRAY);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			JPanel painel = new JPanel();
			setContentPane(painel);
			
			//Label
			JLabel consulta = new JLabel("CONSULTA DE USUÁRIOS CADASTRADOS");
			consulta.setFont(new Font("Dialog",Font.PLAIN, 15));
			consulta.setBounds(430,15,300,30);
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
			getContentPane().add(consulta);
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
			Object[] cabecalho = {"NOME USUÁRIO", "DATA CRIAÇÃO", "DATA ALTERAÇÃO USUÁRIO", "DATA ALTERAÇÃO SENHA", "NOME",  "CPF", "DATA NASCIMENTO"};
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
			
			//Modificador cabeçalho
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
			JOptionPane.showMessageDialog(null, "ERRO AO CONSULTAR USUÁRIOS.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void criaBotoesConsulta(){
		botoes.definirBotoesTelaConsultaUser(this, this);
	}

	//Ação dos botões
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
			JOptionPane.showMessageDialog(null, UsuarioEnum.CADASTRO_USUARIO.getMessage(), "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
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
	
	public void pegaValorTelaCadastroUser() throws NoSuchAlgorithmException, UnsupportedEncodingException{	
		String user = tUser.getText().trim();
		String pass = tPass.getText();
		String pass2 = tPass2.getText();
		String nome = tNome.getText().trim();
		String cpf = tCPF.getText();
		cpf = cpf.replaceAll("[.-]", "");
		cpf = cpf.trim();
		String data = tData.getText();
		String NomeUserVO = "";
		String CPFVO = "";
		String retornoValidador = "";
		
		//Valida n�mero do CPF
		CadastroUserVO.setCPF(cpf);
		retornoValidador = ValidaCPF.validaCPF();
		
		//Para valida��o de data
		String[] separador = data.split("/");
		String dia = separador[0];
		String mes = separador[1];
		String ano = separador[2];
		data = ano + "-" + mes + "-" + dia;
		data = data.trim();
		
		//Para valida��o de maioridade
		int anoVigente = Calendar.getInstance().get(Calendar.YEAR);
		int anoMinimiPermitido = anoVigente - 120;
		int anoMaximoPermitido = anoVigente - 18;
		
		if (user.length()==0 || user.length() <4 || user.length()>25){
			JOptionPane.showMessageDialog(null, "CAMPO USU�RIO INV�LIDO!" + System.lineSeparator() +
					"O USU�RIO DEVE CONTER DE 4 A 25 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}

		else if (pass.length()==0 || pass.length() <5 || pass.length()>12){
			JOptionPane.showMessageDialog(null, "CAMPO SENHA INV�LIDO!" + System.lineSeparator() +
					"A SENHA DEVE CONTER DE 5 A 12 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (pass.equals(pass2)==false){
			JOptionPane.showMessageDialog(null, "AS SENHAS DIGITADAS N�O CONFEREM!" + System.lineSeparator() +
					"POR FAVOR, DIGITE NOVAMENTE.","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (nome.length()==0 || nome.length() <4 || nome.length()>25){
			JOptionPane.showMessageDialog(null, "CAMPO NOME INV�LIDO!" + System.lineSeparator() +
					"A NOME DEVE CONTER DE 4 A 25 CARACTERES","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (cpf.length()==0 || cpf.length() <11 || cpf.length()>11){
			JOptionPane.showMessageDialog(null, "CAMPO CPF INV�LIDO!" + System.lineSeparator() +
					"O CPF DEVE CONTER 11 CARACTERES, SOMENTE NÚMEROS","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (retornoValidador.equals("NOK")){
			JOptionPane.showMessageDialog(null, "O CPF INFORMADO NÃO É VÁLIDO!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (data.length() <10 || data.length()>10){
			JOptionPane.showMessageDialog(null, "CAMPO DATA INVÁLIDO!" + System.lineSeparator() +
					"A DATA DEVE SER PREENCHIDA NO PADR�O DD/MM/AAAA COM APENAS NÚMEROS","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(dia) < 1 || (Integer.parseInt(dia) > 31)){
			JOptionPane.showMessageDialog(null,  "DATA DE NASCIMENTO INV�LIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(mes) < 1 || Integer.parseInt(mes) > 12){
			JOptionPane.showMessageDialog(null, "DATA DE NASCIMENTO INV�LIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(ano) < anoMinimiPermitido || Integer.parseInt(ano) >= anoVigente){
			JOptionPane.showMessageDialog(null, "DATA DE NASCIMENTO INV�LIDA!", "ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (Integer.parseInt(ano) > anoMaximoPermitido){
			JOptionPane.showMessageDialog(null, "CADASTRO PERMITIDO APENAS PARA MAIORES DE 18 ANOS.", "ERRO",JOptionPane.ERROR_MESSAGE);
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
				
			//Realiza uma consulta no banco e verifica a disponibilidade do nome e cadastro por CPF
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
				JOptionPane.showMessageDialog(null,"J� EXISTE UM USU�RIO CADASTRADO PARA O CPF: " + cpf + System.lineSeparator() + 
						"POR FAVOR, CASO SEJA NECESS�RIO ALTERAR O NOME DE USU�RIO, V� AO MENU PRINCIPAL E SELECIONE E OP��O ALTERAR USU�RIO", 
						"CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if (user.equalsIgnoreCase(NomeUserVO)){
				System.out.println("Usu�rio "+ user.toUpperCase() + " j� existe na base." );
				JOptionPane.showMessageDialog(null,"J� EXISTE UM USU�RIO " + user.toUpperCase() +" CADASTRADO." + System.lineSeparator() + 
						"POR FAVOR, ESCOLHA OUTRO NOME DE USU�RIO.", "CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else {
				
				try {
					cadastroVO.setUser(user);
					CadastroUserVO.setCPF(cpf);
					CadastroUserVO.setDataNasc(data);
					dao.insereDadosNaBase(cadastroVO);
					System.out.println("Usu�rio "+ user.toUpperCase() + " cadastrado." );
					JOptionPane.showMessageDialog(null,"USU�RIO " + user.toUpperCase() +" CADASTRADO COM SUCESSO.", 
							"CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					CadastroUser cadastroUser = new CadastroUser();
					cadastroUser.criaTelaCadastroUser();
					cadastroUser.criaBotoes();
					cadastroUser.setVisible(true);
					cadastroUser.criaFocoCadastroUser();
				
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
			JOptionPane.showMessageDialog(null, "CAMPO USU�RIO INV�LIDO!" + System.lineSeparator() +"O USU�RIO DEVE CONTER DE 4 A 25 CARACTERES",
					"ERRO",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null,"J� EXISTE UM USU�RIO " + newUser.toUpperCase() +" CADASTRADO." + System.lineSeparator() + 
						"POR FAVOR, ESCOLHA OUTRO NOME DE USU�RIO.", "CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
			
				try {
					cadastroVO.setUser(newUser);
					dao.atualizaUsuarioNaBase(cadastroVO);
					System.out.println("Usu�rio "+ oldUser.toUpperCase() + " alterado para " + newUser.toUpperCase() + ".");
					JOptionPane.showMessageDialog(null,"O USU�RIO " + oldUser.toUpperCase() +" FOI ALTERADO PARA: " + newUser.toUpperCase() + "." + System.lineSeparator() + 
							"POR FAVOR, EFETUE O LOGIN NOVAMENTE.", "CADASTRAMENTO DE USU�RIO", JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "CAMPO SENHA INV�LIDO!" + System.lineSeparator() +"A SENHA DEVE CONTER DE 5 A 12 CARACTERES",
					"ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (newPass.length()==0 || newPass.length() <5 || newPass.length()>12){
			JOptionPane.showMessageDialog(null, "CAMPO NOVA SENHA INV�LIDO!" + System.lineSeparator() +"A SENHA DEVE CONTER DE 5 A 12 CARACTERES",
					"ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		else if (newPass.equals(newPass2)==false){
			JOptionPane.showMessageDialog(null, "AS SENHAS DIGITADAS N�O CONFEREM!" + System.lineSeparator() +"POR FAVOR, DIGITE NOVAMENTE.",
					"ERRO",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, UsuarioEnum.CADASTRO_USUARIO.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

			if (oldPass.equals(SenhaUserVO)==false){
				System.out.println("Senha antiga informada incorreta." );
				JOptionPane.showMessageDialog(null,"A SENHA ANTIGA INFORMADA ESTÁ INCORRETA!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				try {
					//Gera hash da senha para inserção no banco
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
					JOptionPane.showMessageDialog(null, "A SENHA FOI ALTERADA COM SUCESSO!" + System.lineSeparator() + 
							"POR FAVOR, EFETUE O LOGIN NOVAMENTE.", "ALTERAÇÃO DE SENHA", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					Login login = new Login(Login.COMMAND_ALTERAR_USUARIO);
					login.criaTela();
					login.criaBotoesLogin();
					login.setVisible(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			
			}
		
		}
	}

}

