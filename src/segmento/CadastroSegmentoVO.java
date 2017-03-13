package segmento;

public class CadastroSegmentoVO {
	
	private static String nomeSeg;
	private static String codSeg;
	private static String tpCtt;
	private static String tpPessoa;
	private static String segSta;

	
	public String getNomeSeg() {
		return nomeSeg;
	}
	public void setNomeSeg(String nomeSeg) {
		CadastroSegmentoVO.nomeSeg = nomeSeg;
	}
	public String getCodSeg() {
		return codSeg;
	}
	public void setCodSeg(String codSeg) {
		CadastroSegmentoVO.codSeg = codSeg;
	}
	public String getTpCtt() {
		return tpCtt;
	}
	public void setTpCtt(String tpCtt) {
		CadastroSegmentoVO.tpCtt = tpCtt;
	}
	public String getTpPessoa() {
		return tpPessoa;
	}
	public void setTpPessoa(String tpPessoa) {
		CadastroSegmentoVO.tpPessoa = tpPessoa;
	}
	public String getSegSta() {
		return segSta;
	}
	public void setSegSta(String segSta) {
		CadastroSegmentoVO.segSta = segSta;
	}
}
