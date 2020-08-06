package sistema.cadastro;

import login.Login;
import login.LoginMasterUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Botao botoes = new Botao();

	public void criaTela() {

		// Tela
		setTitle("SISTEMA DE CADASTRAMENTO");
		setSize(700, 500);
		setLocationRelativeTo(null);
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
		Login login = null;
		
		switch (e.getActionCommand()) {
		
		case "command_sair":
			System.exit(0);
			break;
		case "command_cadastro_usuario":
			login = new LoginMasterUser(e.getActionCommand());
			break;
		case "command_alterar_usuario":
			login = new Login(e.getActionCommand());
			break;
		case "command_consultar_usuario":
			login = new LoginMasterUser(e.getActionCommand());
			break;
//		case "command_cadastro_vendedor":
//			login = new Login(e.getActionCommand());
//			break;
		case "command_cadastro_produto":
			login = new Login(e.getActionCommand());
			break;
		case "command_alterar_produto":
			login = new Login(e.getActionCommand());
			break;
		case "command_consultar_produto":
			login = new Login(e.getActionCommand());
			break;
		case "command_cadastro_segmento":
			login = new Login(e.getActionCommand());
			break;
		case "command_alterar_segmento":
			login = new Login(e.getActionCommand());
			break;
		case "command_consultar_segmento":
			login = new Login(e.getActionCommand());
			break;
		case "command_info":
			JOptionPane.showMessageDialog(null, "Versão: 1.1" + System.lineSeparator() +
					"Data de criação: 09/02/2017" + System.lineSeparator() +
					"Criado por: Ademir Rocha" + System.lineSeparator() + 
					"STAFF: Kaiservog, RCToscano, Soldado, Kyoshi, MajorGalopante", "SOBRE",JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		
		if (login != null) {
			login.criaTela();
			login.criaBotoesLogin();
			login.setVisible(true);
			dispose();
		}
	}
}
