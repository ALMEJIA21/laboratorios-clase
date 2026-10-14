import java.util.Scanner;

public class MontoSeguro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double monto = 0.0;
        boolean montoValido = false;

        System.out.println("=== REGISTRO DE MONTO SEGURO ===");

        // Bucle que se repite hasta recibir un monto positivo y finito válido
        while (!montoValido) {
            System.out.print("Introduce un monto: ");
            String entrada = scanner.nextLine();

            try {
                // 1. Intentamos convertir el texto ingresado a un número decimal (double)
                monto = Double.parseDouble(entrada);

                // 2. Comprobamos si es NaN (Not a Number) o Infinity
                if (Double.isNaN(monto) || Double.isInfinite(monto)) {
                    System.out.println("Error: El valor no puede ser NaN ni Infinity. Inténtalo de nuevo.");
                } 
                // 3. Comprobamos que sea estrictamente mayor que cero (rechaza cero y negativos)
                else if (monto <= 0) {
                    System.out.println("Error: El monto debe ser mayor que cero (rechaza cero y negativos). Inténtalo de nuevo.");
                } 
                // Si pasa todas las validaciones, el monto es correcto
                else {
                    montoValido = true;
                    System.out.println("¡Monto aceptado con éxito: $" + monto + "!");
                }

            } catch (NumberFormatException e) {
                // Se ejecuta si el usuario ingresa texto que no representa un número (ej. "abc")
                System.out.println("Error: Texto no válido. Debes introducir un número numérico. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }
}