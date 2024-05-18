package br.com.alura.screenmatch.principal;

import com.google.gson.Gson;

record EditoraDesafioConversaoAninhado(String nome, String cidade) {}
record LivroDesafioConversaoAninhado(String titulo, String autor, EditoraDesafioConversaoAninhado editora) {}

public class DesafioConversaoAninhado {

    public static void main(String[] args) {
        String jsonLivro = "{\"titulo\":\"Aventuras do Java\",\"autor\":\"Akemi\",\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}}";

        Gson gson = new Gson();
        LivroDesafioConversaoAninhado livro = gson.fromJson(jsonLivro, LivroDesafioConversaoAninhado.class);

        System.out.println("Objeto Livro: " + livro);
    }
}