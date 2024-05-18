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

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.omdbapi.com/?t=" + filme + "&apikey=5d1ee8ba"))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonBody = response.body();
            System.out.println(jsonBody);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb meuTituloOmdb = gson.fromJson(jsonBody, TituloOmdb.class);
            System.out.println(meuTituloOmdb);
            try {

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                JOptionPane.showMessageDialog(null, meuTitulo);

            } catch (NullPointerException npe) {

                JOptionPane.showMessageDialog(null, "Filme não encontrado");
                System.out.println("Erro:\n" + npe.getMessage());

            } catch (NumberFormatException nfe) {

                JOptionPane.showMessageDialog(null, "Erro ao converter o ano de lançamento ou a duração do filme");
                System.out.println("Erro:\n" + nfe.getMessage());

            }

            System.out.println("Fim do programa");
        }
    }
}
