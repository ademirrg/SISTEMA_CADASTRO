package sistema.cadastro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CadastroUser cadastroUser;
	private CadastroCli cadastroCli;
	private CadastroUser alteraUser;
	private LoginUser loginUser;
	private LoginMasterUser loginMasterUser;
	
	Botao botoes = new Botao();

	public Tela() {

		// Tela
		setTitle("SISTEMA DE CADASTRAMENTO - USUÁRIO / CLIENTE");
		setSize(700, 500);
		setLocation(450, 100);
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void criaBotoes() {
		botoes.definirBotoesTelaPrincipal(this, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "command_sair":
			System.exit(0);
			break;
		case "command_cadastro_usuario":
			criaLoginMasterUser();
			loginMasterUser.criaBotoesLogin();
			loginMasterUser.setVisible(true);
			dispose();
			break;
		case "command_cadastro_cliente":
			criaCadastroCli();
			cadastroCli.criaBotoes();
			cadastroCli.setVisible(true);
			dispose();
			break;
		case "command_info":
			JOptionPane.showMessageDialog(null, "Versão: 0.1" + System.lineSeparator() + "Data de criação: 09/02/2017" + System.lineSeparator() + "Criado por: Ademir Rocha", "SOBRE",JOptionPane.INFORMATION_MESSAGE);
			break;
		case "command_alterar_usuario":
			criaLoginUser();
			loginUser.criaBotoesLogin();
			loginUser.setVisible(true);
			dispose();
			break;
		}
	}

	private void criaCadastroUser() {
		if (cadastroUser == null) {
			cadastroUser = new CadastroUser();
			cadastroUser.criaTelaCadastroUser();
		}	
	}
	
	private void criaCadastroCli() {
		if (cadastroCli == null) {
			cadastroCli = new CadastroCli();
		}
	}

	private void criaAlteraUser() {
		if (alteraUser == null) {
			alteraUser = new CadastroUser();
			alteraUser.criaTelaAlteraUser();
		}
	}
	private void criaLoginUser() {
		if (loginUser == null) {
			loginUser = new LoginUser();
			loginUser.criaTelaLoginUser();
		}
	}
	private void criaLoginMasterUser() {
		if (loginMasterUser == null) {
			loginMasterUser = new LoginMasterUser();
			loginMasterUser.criaTelaLoginMasterUser();
		}
	}
}
