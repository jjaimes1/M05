package com.jj;
public class Main {
    public static double factorial(double numero) {

        if (numero == 0)
            return 1;
        else
            {
            double resultat = numero * factorial(numero - 1);
            return resultat;
        }
    }

    public static void main(String[] args) {

        System.out.println(factorial(5));
    }

    public static double factorial2 (double numero)
    {
        double resultat = numero;
        for (int i = (int) numero-1; i > 0 ; i--)
        {
            resultat=resultat*i;
        }
        return resultat;
    }

}
