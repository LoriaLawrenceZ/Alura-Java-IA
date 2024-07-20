package br.com.alura.screenmatch.viacep;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public NossoCEP consultaCep(String cep) throws Exception {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();

        String apiURL = "https://viacep.com.br/ws/" + cep + "/json/";

        NossoCEP nossoCep;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiURL)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonBody = response.body();

        CEP oCep = gson.fromJson(jsonBody, CEP.class);

        nossoCep = new NossoCEP(oCep);

        return nossoCep;
    }
}
