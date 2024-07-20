package br.com.alura.screenmatch.viacep;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileControl {

    public void escrever(List<NossoCEP> ceps) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();

        FileWriter writer = new FileWriter("ceps.json");
        writer.write(gson.toJson(ceps));
        writer.close();
    }
}
