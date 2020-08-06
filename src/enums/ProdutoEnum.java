package enums;

public enum ProdutoEnum {
    CADASTRO_PRODUTO("INSTRUÇÕES PARA O CADASTRAMENTO DE PRODUTO:\n" +
            "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES.\n" +
            "O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES E DEVE EXISTIR NA TABELA DE SEGMENTOS.\n" +
            "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM APENAS NÚMEROS."),

    ALTERACAO_PRODUTO("INSTRUÇÕES PARA O ALTERAÇÃO DE PRODUTO:\n" +
            "O CAMPO NOME DO PRODUTO DEVE CONTER DE 4 A 25 CARACTERES.\n" +
            "O CAMPO SEGMENTO DEVE CONTER 3 CARACTERES E DEVE EXISTIR NA TABELA DE SEGMENTOS.\n" +
            "O CAMPO VIGÊNCIA DEVE CONTER A DATA DE INÍCIO E FIM DE VIGÊNCIA DO PRODUTO NO PADRÃO DD/MM/AAAA COM APENAS NÚMEROS.\n" +
            "O CAMPO STATUS DEVE CONTER 1 CARACTERE, INDICANDO STATUS ATIVO/INATIVO (1/0).");

    ProdutoEnum(String message) {
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
