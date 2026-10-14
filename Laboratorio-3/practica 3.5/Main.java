import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del titular: ");
        String titular = scanner.nextLine().trim();

        while (titular.isEmpty()) {
            System.out.print("El nombre es obligatorio. Intenta nuevamente: ");
            titular = scanner.nextLine().trim();
        }

        Billetera billetera = new Billetera(titular);
        int opcion;

        do {
            mostrarMenu(billetera);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el valor a ingresar: ");
                    double valorIngreso = scanner.nextDouble();
                    boolean registrado = billetera.registrarIngreso(valorIngreso);
                    
                    if (registrado) {
                        System.out.println("¡Ingreso registrado exitosamente!");
                    } else {
                        System.out.println("El ingreso no fue aceptado (debe ser mayor a cero).");
                    }
                }
                case 2 -> {
                    System.out.print("Ingrese el valor a gastar: ");
                    double valorGasto = scanner.nextDouble();
                    boolean gastado = billetera.registrarGasto(valorGasto);
                    
                    if (gastado) {
                        System.out.println("¡Gasto registrado exitosamente!");
                    } else {
                        System.out.println("Gasto rechazado: Verifique que el monto sea positivo y no supere el saldo disponible.");
                    }
                }
                case 3 -> {
                    System.out.println("\nSaldo disponible actual: $" + billetera.getSaldo());
                }
                case 4 -> {
                    System.out.println();
                    System.out.println("================================");
                    System.out.println("        RESUMEN DE BILLETERA");
                    System.out.println("================================");
                    System.out.println("Titular: " + billetera.getTitular());
                    System.out.println("Saldo actual: $" + billetera.getSaldo());
                    System.out.println("Ingresos realizados: " + billetera.getCantidadIngresos());
                    System.out.println("Total ingresado: $" + billetera.getTotalIngresos());
                    System.out.println("Gastos realizados: " + billetera.getCantidadGastos());
                    System.out.println("Total gastado: $" + billetera.getTotalGastos());
                    System.out.println("================================");
                }
                case 0 -> System.out.println("Programa finalizado. ¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    static void mostrarMenu(Billetera billetera) {
        System.out.println();
        System.out.println("================================");
        System.out.println("        MI BILLETERA JAVA");
        System.out.println("================================");
        System.out.println("Titular: " + billetera.getTitular());
        System.out.println("Saldo disponible: $" + billetera.getSaldo());
        System.out.println();
        System.out.println("1. Registrar ingreso");
        System.out.println("2. Registrar gasto");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Mostrar resumen");
        System.out.println("0. Salir");
    }
}