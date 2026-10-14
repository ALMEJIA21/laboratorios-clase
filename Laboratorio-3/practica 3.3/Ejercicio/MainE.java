package Ejercicio;
public class MainE {

    public static void main(String[] args) {
        // Creamos la cuenta de puntos con un titular
        CuentaPuntos cuenta = new CuentaPuntos("Carlos");

        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Puntos iniciales: " + cuenta.getPuntos());
        System.out.println("----------------------------");

        // Sumar 80 puntos -> Aceptado
        boolean op1 = cuenta.sumarPuntos(80);
        System.out.println("Sumar 80 puntos: " + op1);
        System.out.println("Puntos actuales: " + cuenta.getPuntos());
        System.out.println("----------------------------");

        // Canjear 30 puntos -> Aceptado
        boolean op2 = cuenta.canjearPuntos(30);
        System.out.println("Canjear 30 puntos: " + op2);
        System.out.println("Puntos actuales: " + cuenta.getPuntos());
        System.out.println("----------------------------");

        // Canjear 100 puntos -> Rechazado (porque supera los puntos disponibles)
        boolean op3 = cuenta.canjearPuntos(100);
        System.out.println("Canjear 100 puntos: " + op3);
        System.out.println("----------------------------");

        // Puntos finales esperados: 50
        System.out.println("Puntos finales en la cuenta: " + cuenta.getPuntos());
    }
}