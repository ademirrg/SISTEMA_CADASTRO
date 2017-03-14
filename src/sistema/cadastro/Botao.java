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
	JButton bt_cadastro_vend;
	JButton bt_cadastro_prod;
	JButton bt_entrar;
	JButton bt_menu;
	JButton bt_consulta_user;
	JButton bt_nova_senha;
	JButton bt_encontra_user;
	JButton bt_consulta_prod;
	JButton bt_cadastro_seg;
	JButton bt_consulta_seg;
	JButton bt_altera_prod;
	JButton bt_buscar_prod;
	JButton bt_alterar_prod;
	JButton bt_altera_seg;
	JButton bt_busca_seg;
	JButton bt_alterar_seg;

	public void definirBotoesTelaPrincipal(ActionListener tela, JFrame frame) {
		bt_sair = new JButton("Sair");
		bt_sair.setBounds(600, 430, 75, 30);
		bt_sair.addActionListener(tela);
		bt_sair.setActionCommand("command_sair");

		bt_cadastro_user = new JButton("Cadastrar Usuário");
		bt_cadastro_user.setBounds(20, 20, 152, 30);
		bt_cadastro_user.addActionListener(tela);
		bt_cadastro_user.setActionCommand("command_cadastro_usuario");
		
		bt_altera_user = new JButton("Alterar Usuário");
		bt_altera_user.setBounds(20, 60, 152, 30);
		bt_altera_user.addActionListener(tela);
		bt_altera_user.setActionCommand("command_alterar_usuario");
		
		bt_consulta_user = new JButton("Consultar Usuário");
		bt_consulta_user.setBounds(20, 100, 152, 30);
		bt_consulta_user.addActionListener(tela);
		bt_consulta_user.setActionCommand("command_consultar_usuario");
		
//		bt_cadastro_vend = new JButton("Cadastrar Vendedor");
//		bt_cadastro_vend.setBounds(20, 140, 152, 30);
//		bt_cadastro_vend.addActionListener(tela);
//		bt_cadastro_vend.setActionCommand("command_cadastro_vendedor");
		
		bt_cadastro_prod = new JButton("Cadastrar Produto");
		bt_cadastro_prod.setBounds(220, 20, 152, 30);
		bt_cadastro_prod.addActionListener(tela);
		bt_cadastro_prod.setActionCommand("command_cadastro_produto");
		
		bt_altera_prod = new JButton("Alterar Produto");
		bt_altera_prod.setBounds(220, 60, 152, 30);
		bt_altera_prod.addActionListener(tela);
		bt_altera_prod.setActionCommand("command_alterar_produto");
		
		bt_consulta_prod = new JButton("Consultar Produto");
		bt_consulta_prod.setBounds(220, 100, 152, 30);
		bt_consulta_prod.addActionListener(tela);
		bt_consulta_prod.setActionCommand("command_consultar_produto");
		bt_consulta_prod.setEnabled(false);
		
		bt_cadastro_seg= new JButton("Cadastrar Segmento");
		bt_cadastro_seg.setBounds(420, 20, 152, 30);
		bt_cadastro_seg.addActionListener(tela);
		bt_cadastro_seg.setActionCommand("command_cadastro_segmento");
		
		bt_altera_seg = new JButton("Alterar Segmento");
		bt_altera_seg.setBounds(420, 60, 152, 30);
		bt_altera_seg.addActionListener(tela);
		bt_altera_seg.setActionCommand("command_alterar_segmento");
		
		bt_consulta_seg = new JButton("Consultar Segmento");
		bt_consulta_seg.setBounds(420, 100, 152, 30);
		bt_consulta_seg.addActionListener(tela);
		bt_consulta_seg.setActionCommand("command_consultar_segmento");
		bt_consulta_seg.setEnabled(false);
		
		bt_info = new JButton("?");
		bt_info.setBounds(630, 20, 45, 30);
		bt_info.addActionListener(tela);
		bt_info.setActionCommand("command_info");

		frame.add(bt_sair);
		frame.add(bt_cadastro_user);
		frame.add(bt_altera_user);
		frame.add(bt_consulta_user);
		//frame.add(bt_cadastro_vend);
		frame.add(bt_cadastro_prod);
		frame.add(bt_altera_prod);
		frame.add(bt_consulta_prod);
		frame.add(bt_cadastro_seg);
		frame.add(bt_altera_seg);
		frame.add(bt_consulta_seg);
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
	
	public void definirBotoesTelaCadastroVend(ActionListener cadastroVend, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(cadastroVend);
		bt_voltar.setActionCommand("command_voltar");

		bt_salvar = new JButton("Salvar");
		bt_salvar.setBounds(20, 420, 75, 30);
		bt_salvar.addActionListener(cadastroVend);
		bt_salvar.setActionCommand("command_salvar");
		
		frame.add(bt_voltar);
		frame.add(bt_salvar);

	}
	
	public void definirBotoesTelaCadastroProd(ActionListener cadastroProd, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(cadastroProd);
		bt_voltar.setActionCommand("command_voltar");

		bt_salvar = new JButton("Salvar");
		bt_salvar.setBounds(20, 420, 75, 30);
		bt_salvar.addActionListener(cadastroProd);
		bt_salvar.setActionCommand("command_salvar");
		
		bt_info = new JButton("?");
		bt_info.setBounds(630, 20, 45, 30);
		bt_info.addActionListener(cadastroProd);
		bt_info.setActionCommand("command_info");
		
		frame.add(bt_voltar);
		frame.add(bt_salvar);
		frame.add(bt_info);

	}
	
	public void definirBotoesTelaBuscaProd(ActionListener buscaProd, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(buscaProd);
		bt_voltar.setActionCommand("command_voltar");

		bt_buscar_prod = new JButton("Buscar");
		bt_buscar_prod.setBounds(20, 420, 75, 30);
		bt_buscar_prod.addActionListener(buscaProd);
		bt_buscar_prod.setActionCommand("command_buscar_prod");
			
		frame.add(bt_voltar);
		frame.add(bt_buscar_prod);

	}
	
	public void definirBotoesTelaAlteraProd(ActionListener alteraProd, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(alteraProd);
		bt_voltar.setActionCommand("command_voltar_busca");

		bt_alterar_prod = new JButton("Alterar");
		bt_alterar_prod.setBounds(20, 420, 75, 30);
		bt_alterar_prod.addActionListener(alteraProd);
		bt_alterar_prod.setActionCommand("command_alterar_prod");
		
		bt_info = new JButton("?");
		bt_info.setBounds(630, 20, 45, 30);
		bt_info.addActionListener(alteraProd);
		bt_info.setActionCommand("command_info_altera");
		
		frame.add(bt_voltar);
		frame.add(bt_alterar_prod);
		frame.add(bt_info);

	}
	
	public void definirBotoesTelaCadastroSeg(ActionListener cadastroSeg, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(cadastroSeg);
		bt_voltar.setActionCommand("command_voltar");

		bt_salvar = new JButton("Salvar");
		bt_salvar.setBounds(20, 420, 75, 30);
		bt_salvar.addActionListener(cadastroSeg);
		bt_salvar.setActionCommand("command_salvar");
		
		bt_info = new JButton("?");
		bt_info.setBounds(630, 20, 45, 30);
		bt_info.addActionListener(cadastroSeg);
		bt_info.setActionCommand("command_info");
		
		frame.add(bt_voltar);
		frame.add(bt_salvar);
		frame.add(bt_info);

	}
	
	public void definirBotoesTelaBuscaSeg(ActionListener buscaSeg, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(buscaSeg);
		bt_voltar.setActionCommand("command_voltar");

		bt_busca_seg = new JButton("Buscar");
		bt_busca_seg.setBounds(20, 420, 75, 30);
		bt_busca_seg.addActionListener(buscaSeg);
		bt_busca_seg.setActionCommand("command_buscar_seg");
			
		frame.add(bt_voltar);
		frame.add(bt_busca_seg);

	}
	
	public void definirBotoesTelaAlteraSeg(ActionListener alteraSeg, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(alteraSeg);
		bt_voltar.setActionCommand("command_voltar_busca");

		bt_alterar_seg = new JButton("Alterar");
		bt_alterar_seg.setBounds(20, 420, 75, 30);
		bt_alterar_seg.addActionListener(alteraSeg);
		bt_alterar_seg.setActionCommand("command_alterar_seg");
		
		bt_info = new JButton("?");
		bt_info.setBounds(630, 20, 45, 30);
		bt_info.addActionListener(alteraSeg);
		bt_info.setActionCommand("command_info_altera");
		
		frame.add(bt_voltar);
		frame.add(bt_alterar_seg);
		frame.add(bt_info);

	}
	
	public void definirBotoesTelaAlteraUser(ActionListener alteraUser, JFrame frame) {
		bt_alterar_user = new JButton("Alterar");
		bt_alterar_user.setBounds(180, 80, 75, 30);
		bt_alterar_user.addActionListener(alteraUser);
		bt_alterar_user.setActionCommand("command_alterar_usuario");
		
		bt_alterar_pass = new JButton("Alterar");
		bt_alterar_pass.setBounds(180, 220, 75, 30);
		bt_alterar_pass.addActionListener(alteraUser);
		bt_alterar_pass.setActionCommand("command_alterar_senha");
		
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(600, 430, 75, 30);
		bt_voltar.addActionListener(alteraUser);
		bt_voltar.setActionCommand("command_voltar");
		
		frame.add(bt_alterar_user);
		frame.add(bt_alterar_pass);
		frame.add(bt_voltar);
	}
	
	public void definirBotoesTelaConsultaUser(ActionListener consultaUser, JFrame frame) {
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(550, 430, 75, 30);
		bt_voltar.addActionListener(consultaUser);
		bt_voltar.setActionCommand("command_voltar");
		
		frame.add(bt_voltar);
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
