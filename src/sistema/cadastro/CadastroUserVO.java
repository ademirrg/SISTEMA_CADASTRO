package sistema.cadastro;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CadastroUserVO {
	
	private static String user;
	private static String pass;
	private static String NomeUser; //Para uso DAO
	private	static String SenhaUser; //Para uso DAO
	private static String oldUser; //Para uso DAO
	private static String MasterUser; //Para acesso ao cadastramento de usuários
	private static String SenhaMaster; //Para acesso ao cadastramento de usuários
	private static String Nome;
	private static String CPF; //Para uso DAO
	private static String DataNasc;

	
	public String getUser() {
		return user;
	}
	
	public  void setUser(String user){
		CadastroUserVO.user = user;
		
	}
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass){
		CadastroUserVO.pass = pass;
	}
	
	public String getNomeUser() {
		return NomeUser;
	}
	
	public void setNomeUser(String NomeUser){
		CadastroUserVO.NomeUser = NomeUser;
	}
	
	public String getSenhaUser(){
		return SenhaUser;
	}
	
	public void setSenhaUser(String SenhaUser){
		CadastroUserVO.SenhaUser = SenhaUser;
	}
	public static String getOldUser(){
		return oldUser;
	}
	
	public static void setOldUser(String oldUser){
		CadastroUserVO.oldUser = oldUser;
	}
	public static String getMasterUser(){
		return MasterUser;
	}
	
	public static void setMasterUser(String MasterUser){
		CadastroUserVO.MasterUser = MasterUser;
	}
	public static String getSenhaMaster(){
		return SenhaMaster;
	}
	
	public static void setSenhaMaster(String SenhaMaster){
		CadastroUserVO.SenhaMaster = SenhaMaster;
	}
	public static String getNome(){
		return Nome;
	}
	
	public static void setNome(String Nome){
		CadastroUserVO.Nome = Nome;
	}
	public static String getCPF(){
		return CPF;
	}
	
	public static void setCPF(String CPF){
		CadastroUserVO.CPF = CPF;
	}
	public static String getDataNasc(){
		return DataNasc;
	}
	
	public static void setDataNasc(String DataNasc){
		CadastroUserVO.DataNasc = DataNasc;
	}

}
