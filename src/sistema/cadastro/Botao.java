package sistema.cadastro;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Botao {
	JButton bt_cadastro_user;
	JButton bt_altera_user;
	JButton bt_sair;
	JButton bt_salvar;
	JButton bt_alterar_user;
	JButton bt_alterar_pass;
	JButton bt_voltar;
	JButton bt_info;
	JButton bt_cadastro_cli;
	JButton bt_entrar;
	JButton bt_menu;
	JButton bt_consulta_user;
	JButton bt_nova_senha;

	public void definirBotoesTelaPrincipal(ActionListener tela, JFrame frame) {
		bt_sair = new JButton("Sair");
		bt_sair.setBounds(600, 430, 75, 30);
		bt_sair.addActionListener(tela);
		bt_sair.setActionCommand("command_sair");

		bt_cadastro_user = new JButton("Cadastrar Usuário");
		bt_cadastro_user.setBounds(20, 20, 138, 30);
		bt_cadastro_user.addActionListener(tela);
		bt_cadastro_user.setActionCommand("command_cadastro_usuario");
		
		bt_altera_user = new JButton("Alterar Usuário");
		bt_altera_user.setBounds(20, 60, 138, 30);
		bt_altera_user.addActionListener(tela);
		bt_altera_user.setActionCommand("command_alterar_usuario");
		
		bt_cadastro_cli = new JButton("Cadastrar Cliente");
		bt_cadastro_cli.setBounds(20, 100, 138, 30);
		bt_cadastro_cli.addActionListener(tela);
		bt_cadastro_cli.setActionCommand("command_cadastro_cliente");
		
		bt_info = new JButton("?");
		bt_info.setBounds(630, 20, 45, 30);
		bt_info.addActionListener(tela);
		bt_info.setActionCommand("command_info");

		frame.add(bt_sair);
		frame.add(bt_cadastro_user);
		frame.add(bt_altera_user);
		frame.add(bt_cadastro_cli);
		frame.add(bt_info);
	}

	public void definirBotoesTelaCadastroUser(ActionListener cadastroUser, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(cadastroUser);
		bt_voltar.setActionCommand("command_voltar");

		bt_salvar = new JButton("Salvar");
		bt_salvar.setBounds(150, 230, 75, 30);
		bt_salvar.addActionListener(cadastroUser);
		bt_salvar.setActionCommand("command_salvar");
		
		bt_info = new JButton("?");
		bt_info.setBounds(630, 20, 45, 30);
		bt_info.addActionListener(cadastroUser);
		bt_info.setActionCommand("command_info");
		
		frame.add(bt_voltar);
		frame.add(bt_salvar);
		frame.add(bt_info);

	}
	
	public void definirBotoesTelaCadastroCli(ActionListener cadastroCli, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(cadastroCli);
		bt_voltar.setActionCommand("command_voltar");

		bt_salvar = new JButton("Salvar");
		bt_salvar.setBounds(20, 420, 75, 30);
		bt_salvar.addActionListener(cadastroCli);
		bt_salvar.setActionCommand("command_salvar");
		
		frame.add(bt_voltar);
		frame.add(bt_salvar);

	}
	
	public void definirBotoesTelaAlteraUser(ActionListener alteraUser, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(alteraUser);
		bt_voltar.setActionCommand("command_voltar_login");

		bt_alterar_user = new JButton("Alterar");
		bt_alterar_user.setBounds(180, 80, 75, 30);
		bt_alterar_user.addActionListener(alteraUser);
		bt_alterar_user.setActionCommand("command_alterar_usuario");
		
		bt_alterar_pass = new JButton("Alterar");
		bt_alterar_pass.setBounds(180, 220, 75, 30);
		bt_alterar_pass.addActionListener(alteraUser);
		bt_alterar_pass.setActionCommand("command_alterar_senha");
		
		bt_menu = new JButton("Menu");
		bt_menu.setBounds(520, 430, 75, 30);
		bt_menu.addActionListener(alteraUser);
		bt_menu.setActionCommand("command_voltar_menu");
		
		frame.add(bt_voltar);
		frame.add(bt_alterar_user);
		frame.add(bt_alterar_pass);
		frame.add(bt_menu);
	}
	
	public void definirBotoesTelaLoginUser(ActionListener loginUser, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(loginUser);
		bt_voltar.setActionCommand("command_voltar");

		bt_entrar = new JButton("Entrar");
		bt_entrar.setBounds(150, 110, 75, 30);
		bt_entrar.addActionListener(loginUser);
		bt_entrar.setActionCommand("command_login_usuario");
		
		bt_consulta_user = new JButton("Encontrar");
		bt_consulta_user.setBounds(565, 45, 90, 30);
		bt_consulta_user.addActionListener(loginUser);
		bt_consulta_user.setActionCommand("command_encontrar_usuario");
		
		bt_nova_senha = new JButton("Alterar");
		bt_nova_senha.setBounds(565, 110, 90, 30);
		bt_nova_senha.addActionListener(loginUser);
		bt_nova_senha.setActionCommand("command_nova_senha");
		
		frame.add(bt_voltar);
		frame.add(bt_entrar);
		frame.add(bt_consulta_user);
		frame.add(bt_nova_senha);

	}
	
	public void definirBotoesTelaLoginCli(ActionListener loginCli, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(loginCli);
		bt_voltar.setActionCommand("command_voltar");

		bt_entrar = new JButton("Entrar");
		bt_entrar.setBounds(150, 110, 75, 30);
		bt_entrar.addActionListener(loginCli);
		bt_entrar.setActionCommand("command_login_usuario");
		
		bt_consulta_user = new JButton("Encontrar");
		bt_consulta_user.setBounds(565, 45, 90, 30);
		bt_consulta_user.addActionListener(loginCli);
		bt_consulta_user.setActionCommand("command_encontrar_usuario");
		
		bt_nova_senha = new JButton("Alterar");
		bt_nova_senha.setBounds(565, 110, 90, 30);
		bt_nova_senha.addActionListener(loginCli);
		bt_nova_senha.setActionCommand("command_nova_senha");
		
		frame.add(bt_voltar);
		frame.add(bt_entrar);
		frame.add(bt_consulta_user);
		frame.add(bt_nova_senha);

	}
	
	public void definirBotoesTelaLoginMasterUser(ActionListener loginMasterUser, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(loginMasterUser);
		bt_voltar.setActionCommand("command_voltar");

		bt_entrar = new JButton("Entrar");
		bt_entrar.setBounds(150, 110, 75, 30);
		bt_entrar.addActionListener(loginMasterUser);
		bt_entrar.setActionCommand("command_login_usuario_master");
		
		frame.add(bt_voltar);
		frame.add(bt_entrar);

	}
	
	public void definirBotoesTelaEsqueciUser(ActionListener esqueciUser, JFrame frame) {
		bt_voltar = new JButton("Cancelar");
		bt_voltar.setBounds(600, 430, 85, 30);
		bt_voltar.addActionListener(esqueciUser);
		bt_voltar.setActionCommand("command_cancelar");


		bt_consulta_user = new JButton("Encontrar");
		bt_consulta_user.setBounds(150, 110, 90, 30);
		bt_consulta_user.addActionListener(esqueciUser);
		bt_consulta_user.setActionCommand("command_encontrar_usuario");
		
		
		frame.add(bt_voltar);
		frame.add(bt_consulta_user);

	}
	
	public void definirBotoesTelaEsqueciSenha(ActionListener esqueciSenha, JFrame frame) {
		bt_voltar = new JButton("Cancelar");
		bt_voltar.setBounds(600, 430, 85, 30);
		bt_voltar.addActionListener(esqueciSenha);
		bt_voltar.setActionCommand("command_cancelar");


		bt_alterar_pass = new JButton("Alterar");
		bt_alterar_pass.setBounds(150, 110, 85, 30);
		bt_alterar_pass.addActionListener(esqueciSenha);
		bt_alterar_pass.setActionCommand("command_alterar_senha");
		
		
		frame.add(bt_voltar);
		frame.add(bt_alterar_pass);

	}
	
	public void definirBotoesTelaNovaSenha(ActionListener novaSenha, JFrame frame) {
		bt_voltar = new JButton("Cancelar");
		bt_voltar.setBounds(600, 430, 85, 30);
		bt_voltar.addActionListener(novaSenha);
		bt_voltar.setActionCommand("command_cancelar");


		bt_alterar_pass = new JButton("Alterar");
		bt_alterar_pass.setBounds(180, 110, 85, 30);
		bt_alterar_pass.addActionListener(novaSenha);
		bt_alterar_pass.setActionCommand("command_alterar_senha");
		
		
		frame.add(bt_voltar);
		frame.add(bt_alterar_pass);

	}

}
