package br.com.alura.screenmatch.viacep;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

record CEP (String cep, String logradouro, String complemento, String unidade, String bairro, String localidade, String uf, String ibge, String gia, int ddd, String siafi) {}

public class viacep {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<CEP> ceps = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();

        while (true) {
            String cep = JOptionPane.showInputDialog("Qual o CEP?");

            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

            while (cep.length() != 8) {
                JOptionPane.showMessageDialog(null, "O CEP deve ter 8 dígitos");
                cep = JOptionPane.showInputDialog("Qual o CEP?");
            }

            String apiURL = "https://viacep.com.br/ws/" + cep + "/json/";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiURL)).build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String jsonBody = response.body();
                System.out.println(jsonBody);

                CEP oCep = gson.fromJson(jsonBody, CEP.class);
                System.out.println(oCep);

                ceps.add(oCep);
            } catch (Exception e) {
                System.out.println("Houve um erro!\n" + e.getMessage());
            }
        }

        FileWriter writer = new FileWriter("ceps.json");
        writer.write(gson.toJson(ceps));
        writer.close();

        System.out.println("O programa finalizou corretamente!");

    }
}
