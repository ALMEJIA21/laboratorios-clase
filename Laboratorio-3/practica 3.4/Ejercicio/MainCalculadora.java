package Ejercicio;

import java.util.Scanner;

public class MainCalculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        // Creamos el objeto Calculadora
        Calculadora calc = new Calculadora();

        System.out.println("========================");
        System.out.println("RESULTADOS:");
        System.out.println("Suma: " + calc.sumar(num1, num2));
        System.out.println("Resta: " + calc.restar(num1, num2));
        System.out.println("Multiplicación: " + calc.multiplicar(num1, num2));
        System.out.println("========================");

        scanner.close();
    }
}