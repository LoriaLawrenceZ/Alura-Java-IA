package br.com.alura.screenmatch.principal;

import com.google.gson.Gson;

record PessoaDesafioConversao(String nome, int idade, String cidade) {}

public class DesafioConversaoPessoa {
    public static void main(String[] args) {
        String jsonPessoa = "{\"nome\":\"Rodrigo\",\"idade\":20,\"cidade\":\"Brasília\"}";

        Gson gson = new Gson();
        PessoaDesafioConversao pessoa = gson.fromJson(jsonPessoa, PessoaDesafioConversao.class);

        System.out.println("Objeto Pessoa: " + pessoa);
    }
}
