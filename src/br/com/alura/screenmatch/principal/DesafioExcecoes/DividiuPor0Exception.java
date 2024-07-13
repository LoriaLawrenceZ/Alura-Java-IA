package br.com.alura.screenmatch.principal.DesafioExcecoes;

public class DividiuPor0Exception extends RuntimeException {

    public DividiuPor0Exception(String mensagem) {}

    @Override
    public String getMessage() {
        return "Não é possível dividir por 0";
    }
}
