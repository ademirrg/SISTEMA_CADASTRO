package usuario;

public class ConsultaVO {
	private String NomeUser;
	private String SenhaUser;
	private String DataCadastro;
	private String DataAlteracaoUser;
	private String DataAlteracaoSenha;
	private String Nome;
	private String CPF;
	private String DataNasc;

	
	public String getNomeUser() {
		return NomeUser;
	}
	public void setNomeUser(String nomeUser) {
		this.NomeUser = nomeUser;
	}
	public String getSenhaUser() {
		return SenhaUser;
	}
	public void setSenhaUser(String senhaUser) {
		this.SenhaUser = senhaUser;
	}
	public String getDataCadastro() {
		return DataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.DataCadastro = dataCadastro;
	}
	public String getDataAlteracaoUser() {
		return DataAlteracaoUser;
	}
	public void setDataAlteracaoUser(String dataAlteracaoUser) {
		this.DataAlteracaoUser = dataAlteracaoUser;
	}
	public String getDataAlteracaoSenha() {
		return DataAlteracaoSenha;
	}
	public void setDataAlteracaoSenha(String dataAlteracaoSenha) {
		this.DataAlteracaoSenha = dataAlteracaoSenha;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = cPF;
	}
	public String getDataNasc() {
		return DataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.DataNasc = dataNasc;
	}
}
