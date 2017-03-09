package produto;

public class CadastroProdutoVO {
	
	private String NomePRD;
	private String CodPRD;
	private String CodSeg;
	private String InicioVig;
	private String FimVig;
	private String PRDSTA;

	
	public String getNomePRD() {
		return NomePRD;
	}
	public void setNomePRD(String nomePRD) {
		this.NomePRD = nomePRD;
	}
	public String getCodPRD() {
		return CodPRD;
	}
	public void setCodPRD(String codPRD) {
		this.CodPRD = codPRD;
	}
	public String getCodSeg() {
		return CodSeg;
	}
	public void setCodSeg(String codSeg) {
		this.CodSeg = codSeg;
	}
	public String getInicioVig() {
		return InicioVig;
	}
	public void setInicioVig(String inicioVig) {
		this.InicioVig = inicioVig;
	}
	public String getFimVig() {
		return FimVig;
	}
	public void setFimVig(String fimVig) {
		this.FimVig = fimVig;
	}
	public String getPRDSTA() {
		return PRDSTA;
	}
	public void setPRDSTA(String prdsta) {
		this.PRDSTA = prdsta;
	}
}
