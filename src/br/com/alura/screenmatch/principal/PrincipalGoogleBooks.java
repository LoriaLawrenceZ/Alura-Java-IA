package br.com.alura.screenmatch.principal;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalGoogleBooks {

    public static void main(String[] args) throws IOException, InterruptedException {
        String livro = JOptionPane.showInputDialog("Qual o nome do livro?");

        HttpClient client = HttpClient.newHttpClient();

        StringBuilder endereco = new StringBuilder("https://www.googleapis.com/books/v1/volumes?q=").append(livro)
                .append("&oderBy=newest&key=AIzaSyCXgXC150nuS9bUd7nBL2S4jZSe0dZ5OlM");

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco.toString()))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
