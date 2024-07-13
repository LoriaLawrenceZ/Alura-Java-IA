package br.com.alura.screenmatch.principal.DesafioExcecoes;

public class Divisao {
    public static double dividir(double num1, double num2) {
        if (num2 == 0) {
            throw new DividiuPor0Exception("Não é possível dividir por 0");
        }
        return num1 / num2;
    }
}
