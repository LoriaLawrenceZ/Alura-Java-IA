package br.com.alura.screenmatch.viacep;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainViaCEP {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileControl fileControl = new FileControl();
        List<NossoCEP> ceps = new ArrayList<>();
        ConsultaCep consultaCep = new ConsultaCep();


        while (true) {
            String cep = JOptionPane.showInputDialog("Qual o CEP?");

            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

            while (cep.length() != 8) {
                JOptionPane.showMessageDialog(null, "O CEP deve ter 8 dígitos");
                cep = JOptionPane.showInputDialog("Qual o CEP?");
            }

            try {
                ceps.add(consultaCep.consultaCep(cep));
            } catch (Exception e) {
                System.out.println("Houve um erro!" + e.getMessage());
            }
        }

        fileControl.escrever(ceps);

        System.out.println("O programa finalizou corretamente!");
    }
}
