package Ejercicio;

public class Main {

    public static void main(String[] args) {
        Termometro termometro1 = new Termometro(0);
        Termometro termometro2 = new Termometro(25);

        System.out.print("Termómetro 1: ");
        termometro1.mostrarCelsius();
        System.out.println("-> " + termometro1.convertirAFahrenheit() + " °F");

        System.out.println("----------------------------");

        System.out.print("Termómetro 2: ");
        termometro2.mostrarCelsius();
        System.out.println("-> " + termometro2.convertirAFahrenheit() + " °F");
    }
}