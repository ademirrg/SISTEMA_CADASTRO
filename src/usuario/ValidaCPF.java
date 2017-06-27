package usuario;

public class ValidaCPF {

	public static String validaCPF() {
		int digito1 = 0, digito2 = 0, resto = 0;
		String numeroDigitado = CadastroUserVO.getCPF();
		String[] numeroSeparado = numeroDigitado.split("");
		String cpfValido = "";
	
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
		
		int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;
		int valor = (soma / 11) * 11;
		digito1 = soma - valor;
		
		// Primeiro resto da divisão por 11.
		resto = (digito1 % 11);
		if (digito1 < 2) {
			digito1 = 0;
		} 
		else {
			digito1 = 11 - resto;
		}
		
		int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;
		int valor2 = (soma2 / 11) * 11;
		digito2 = soma2 - valor2;
		
		// Primeiro resto da divisão por 11.
		resto = (digito2 % 11);
		if (digito2 < 2) {
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
