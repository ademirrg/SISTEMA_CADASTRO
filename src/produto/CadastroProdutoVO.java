package produto;

public class CadastroProdutoVO {
	
	private static String NomePRD;
	private static String CodPRD;
	private static String CodSeg;
	private static String InicioVig;
	private static String FimVig;
	private static String PRDSTA;

	
	public String getNomePRD() {
		return NomePRD;
	}
	public void setNomePRD(String nomePRD) {
		CadastroProdutoVO.NomePRD = nomePRD;
	}
	public String getCodPRD() {
		return CodPRD;
	}
	public void setCodPRD(String codPRD) {
		CadastroProdutoVO.CodPRD = codPRD;
	}
	public String getCodSeg() {
		return CodSeg;
	}
	public void setCodSeg(String codSeg) {
		CadastroProdutoVO.CodSeg = codSeg;
	}
	public String getInicioVig() {
		return InicioVig;
	}
	public void setInicioVig(String inicioVig) {
		CadastroProdutoVO.InicioVig = inicioVig;
	}
	public String getFimVig() {
		return FimVig;
	}
	public void setFimVig(String fimVig) {
		CadastroProdutoVO.FimVig = fimVig;
	}
	public String getPRDSTA() {
		return PRDSTA;
	}
	public void setPRDSTA(String prdsta) {
		CadastroProdutoVO.PRDSTA = prdsta;
	}
}
