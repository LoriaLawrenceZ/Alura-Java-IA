package br.com.alura.screenmatch.principal;

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
            System.out.println(response.body());
        }
    }
}
