package usuario;

public class ValidaCPF {

	public static String validaCPF() {
		int digito1 = 0, digito2 = 0, resto = 0;
		String numeroDigitado = CadastroUserVO.getCPF();
		String[] numeroSeparado = numeroDigitado.split("");
		String cpfValido = "";
	
		if(numeroDigitado.equals("00000000000") || numeroDigitado.equals("11111111111") || 
				numeroDigitado.equals("22222222222") || numeroDigitado.equals("33333333333") || 
				numeroDigitado.equals("44444444444") || numeroDigitado.equals("55555555555") || 
				numeroDigitado.equals("66666666666") || numeroDigitado.equals("77777777777") || 
				numeroDigitado.equals("88888888888") || numeroDigitado.equals("99999999999") || 
				numeroDigitado.length()==0){
			cpfValido = "NOK";
			
			return cpfValido;
		}
		
		else {
			
			//Números separados
			int n1 = Integer.parseInt(numeroSeparado[0]);
			int n2 = Integer.parseInt(numeroSeparado[1]);
			int n3 = Integer.parseInt(numeroSeparado[2]);
			int n4 = Integer.parseInt(numeroSeparado[3]);
			int n5 = Integer.parseInt(numeroSeparado[4]);
			int n6 = Integer.parseInt(numeroSeparado[5]);
			int n7 = Integer.parseInt(numeroSeparado[6]);
			int n8 = Integer.parseInt(numeroSeparado[7]);
			int n9 = Integer.parseInt(numeroSeparado[8]);
			int n10 = Integer.parseInt(numeroSeparado[9]);
			int n11 = Integer.parseInt(numeroSeparado[10]);
			
			//Digito 1.
			int soma = n1 * 10 + n2 * 9 + n3 * 8 + n4 * 7 + n5 * 6 + n6 * 5 + n7 * 4 + n8 * 3 + n9 * 2;			
			resto = (soma % 11);
			if (resto < 2) {
				digito1 = 0;
			} 
			else {
				digito1 = 11 - resto;
			}
			
			//Digito 2.
			int soma2 = n1 * 11 + n2 * 10 + n3 * 9 + n4 * 8 + n5 * 7 + n6 * 6 + n7 * 5 + n8 * 4 + n9 * 3 + digito1 * 2;			
			resto = (soma2 % 11);
			if (resto < 2) {
				digito2 = 0;
			} 
			else {
				digito2 = 11 - resto;
			}
		     
			if (n10 != digito1 || n11 != digito2){
				cpfValido = "NOK";
			}
			
			else {
				cpfValido = "OK";
			}
			
			return cpfValido;
		}
	}
}
