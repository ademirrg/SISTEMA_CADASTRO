package enums;

public enum UsuarioEnum {
    CADASTRO_USUARIO("INSTRUÇÕES PARA O CADASTRAMENTO DE USUÁRIO:\n" +
            "O CAMPO USUÁRIO DEVE CONTER DE 4 A 25 CARACTERES.\n" +
            "O CAMPO SENHA DEVE CONTER DE 5 A 12 CARACTERES.\n" +
            "O CAMPO NOME DEVE CONTER DE 5 A 25 CARACTERES.\n" +
            "O CAMPO CPF DEVE SER PREENCHIDO COM APENAS NÚMEROS E DEVE CONTER 11 CARACTERES.\n" +
            "O CAMPO DATA DE NASCIMENTO DEVE SER PREENCHIDO NO PADRÃO DD/MM/AAAA COM APENAS NÚMEROS.\n" +
            "NÃO SERÁ REALIZADA VALIDAÇÃO DE LETRAS MAIÚSCULAS OU MINÚSCULAS PARA O USUARIO CRIADO, APENAS PARA SENHA.");

    UsuarioEnum(String message) {
        this.message = message;
    }

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
