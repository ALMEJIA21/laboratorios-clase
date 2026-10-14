import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Titular de la cuenta: ");
        String nombre = scanner.nextLine();

        CuentaPuntos cuenta = new CuentaPuntos(nombre);

        // 1. Mostrar puntos iniciales
        System.out.println("Puntos iniciales: " + cuenta.getPuntos());

        // 2. Primera cantidad
        System.out.print("Ingrese la primera cantidad de puntos: ");
        int cant1 = scanner.nextInt();
        if (cuenta.sumarPuntos(cant1)) {
            System.out.println("¡Primer registro exitoso!");
        } else {
            System.out.println("Registro rechazado (debe ser positivo).");
        }

        // 3. Segunda cantidad
        System.out.print("Ingrese la segunda cantidad de puntos: ");
        int cant2 = scanner.nextInt();
        if (cuenta.sumarPuntos(cant2)) {
            System.out.println("¡Segundo registro exitoso!");
        } else {
            System.out.println("Registro rechazado (debe ser positivo).");
        }

        // 4. Mostrar puntos finales
        System.out.println("--------------------------------");
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Puntos finales en la cuenta: " + cuenta.getPuntos());

        scanner.close();
    }
}