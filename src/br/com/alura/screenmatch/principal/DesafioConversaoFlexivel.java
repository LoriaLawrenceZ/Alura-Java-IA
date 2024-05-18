package br.com.alura.screenmatch.principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

record PessoaDesafioConversaoFlexivel(String nome, int idade, String cidade) {}

public class DesafioConversaoFlexivel {

    public static void main(String[] args) {
        String jsonPessoa = "{\"nome\":\"Rodrigo\",\"cidade\":\"Brasília\"}";

        Gson gson = new GsonBuilder().setLenient().create();
        PessoaDesafioConversaoFlexivel pessoa = gson.fromJson(jsonPessoa, PessoaDesafioConversaoFlexivel.class);

        System.out.println("Objeto Pessoa: " + pessoa);
    }
}
