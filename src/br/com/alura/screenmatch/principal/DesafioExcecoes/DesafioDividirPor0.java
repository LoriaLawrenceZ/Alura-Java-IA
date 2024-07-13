package br.com.alura.screenmatch.principal.DesafioExcecoes;

import javax.swing.*;
import java.io.IOException;

public class DesafioDividirPor0 {
    public static void main(String[] args) {
        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Primeiro número:"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Segundo número:"));

        try {
            Divisao.dividir(num1, num2);
        } catch (DividiuPor0Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
