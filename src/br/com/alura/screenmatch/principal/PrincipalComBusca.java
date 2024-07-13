package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {

            String filme = JOptionPane.showInputDialog("Qual o nome do filme?");

            String endereco = "https://www.omdbapi.com/?t=" + filme.replace(" ", "+") + "&apikey=5d1ee8ba";

            if (filme.equalsIgnoreCase("sair")) {
                break;
            }

            try{

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String jsonBody = response.body();
                System.out.println(jsonBody);

                TituloOmdb meuTituloOmdb = gson.fromJson(jsonBody, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Título já convertido");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (NumberFormatException nfe) {
                System.out.println("Erro ao buscar o filme. Verifique o endereço.");
                System.out.println(nfe.getMessage());
            } catch (IllegalArgumentException iae) {
                System.out.println("Erro de argumento na busca. Verifique o endereço.");
                System.out.println(iae.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException npe) {
                System.out.println("Filme não encontrado.\n" + npe.getMessage());
            }
        }

        System.out.println("Títulos encontrados: " + titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("O programa finalizou corretamente!");
    }
}
