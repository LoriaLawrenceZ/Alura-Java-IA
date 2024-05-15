package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        String filme = JOptionPane.showInputDialog("Qual o nome do filme?");

        try (HttpClient client = HttpClient.newHttpClient()) {

            StringBuilder endereco = new StringBuilder("https://www.omdbapi.com/?t=").append(filme).append("&apikey=5d1ee8ba");

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco.toString()))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonBody = response.body();
            System.out.println(jsonBody);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb meuTituloOmdb = gson.fromJson(jsonBody, TituloOmdb.class);
            System.out.println(meuTituloOmdb);
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);
        }
    }
}
