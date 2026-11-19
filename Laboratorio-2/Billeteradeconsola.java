import java.util.Scanner;

public class Billeteradeconsola {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del titular: ");
        String titular = scanner.nextLine();

        double saldo = 0;
        int opcion;

        do {
            mostrarMenu();

            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Registramos el ingreso y actualizamos el saldo usando el método
                    saldo = registrarIngreso(scanner, saldo);
                    break;
                case 2:
                    // Registramos el gasto y actualizamos el saldo usando el método
                    saldo = registrarGasto(scanner, saldo);
                    break;
                case 3:
                    // Consultamos el saldo actual
                    mostrarSaldo(saldo);
                    break;
                case 4:
                    // Mostramos el resumen completo
                    mostrarResumen(titular, saldo);
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Método para mostrar el menú visual
    static void mostrarMenu() {
        System.out.println();
        System.out.println("=========================");
        System.out.println("       MI BILLETERA");
        System.out.println("=========================");
        System.out.println("1. Registrar ingreso");
        System.out.println("2. Registrar gasto");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Mostrar resumen");
        System.out.println("0. Salir");
    }

    // Método para registrar ingresos (valida que sea > 0 y devuelve el nuevo saldo)
    static double registrarIngreso(Scanner scanner, double saldoActual) {
        System.out.print("Ingrese el valor a depositar: ");
        double ingreso = scanner.nextDouble();

        if (ingreso > 0) {
            double nuevoSaldo = saldoActual + ingreso;
            System.out.println("¡Ingreso exitoso! Saldo actual: $" + nuevoSaldo);
            return nuevoSaldo;
        } else {
            System.out.println("Error: El valor debe ser mayor a cero. El saldo no cambia.");
            return saldoActual; // Retorna el saldo intacto si no es válido
        }
    }

    // Método para registrar gastos (valida que sea > 0 y que no supere el saldo)
    static double registrarGasto(Scanner scanner, double saldoActual) {
        System.out.print("Ingrese el valor del gasto: ");
        double gasto = scanner.nextDouble();

        if (gasto <= 0) {
            System.out.println("Error: El valor debe ser mayor a cero. El saldo no cambia.");
            return saldoActual;
        }

        if (gasto <= saldoActual) {
            double nuevoSaldo = saldoActual - gasto;
            System.out.println("¡Gasto registrado! Saldo actual: $" + nuevoSaldo);
            return nuevoSaldo;
        } else {
            System.out.println("Error: Saldo insuficiente. No se puede realizar el gasto.");
            return saldoActual; // Retorna el saldo sin modificar
        }
    }

    // Método para consultar el saldo individualmente
    static void mostrarSaldo(double saldo) {
        System.out.println("\n>>> Su saldo actual es: $" + saldo);
    }

    // Método para mostrar el resumen del titular y su saldo
    static void mostrarResumen(String titular, double saldo) {
        System.out.println("\n--- RESUMEN DE LA BILLETERA ---");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("-------------------------------");
    }
}