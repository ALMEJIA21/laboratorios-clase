import java.util.Scanner;

public class CalculadoraSegura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n=== MINI CALCULADORA SEGURA ===");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            String entradaOpcion = scanner.nextLine();

            try {
                opcion = Integer.parseInt(entradaOpcion);

                if (opcion == 0) {
                    System.out.println("¡Saliendo de la calculadora. Hasta luego!");
                    break;
                }

                if (opcion < 1 || opcion > 4) {
                    System.out.println("Error: La opción del menú no existe.");
                    continue;
                }

                // Si la opción es válida (1 al 4), solicitamos los dos números
                System.out.print("Introduce el primer número: ");
                double num1 = leerNumeroSeguro(scanner);

                System.out.print("Introduce el segundo número: ");
                double num2 = leerNumeroSeguro(scanner);

                double resultado = 0;
                boolean operacionValida = true;

                switch (opcion) {
                    case 1:
                        resultado = num1 + num2;
                        System.out.println("Resultado: " + num1 + " + " + num2 + " = " + resultado);
                        break;
                    case 2:
                        resultado = num1 - num2;
                        System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resultado);
                        break;
                    case 3:
                        resultado = num1 * num2;
                        System.out.println("Resultado: " + num1 + " * " + num2 + " = " + resultado);
                        break;
                    case 4:
                        // Impedir división entre cero
                        if (num2 == 0) {
                            System.out.println("Operación no permitida: No se puede dividir entre cero.");
                            operacionValida = false;
                        } else {
                            resultado = num1 / num2;
                            System.out.println("Resultado: " + num1 + " / " + num2 + " = " + resultado);
                        }
                        break;
                }

            } catch (NumberFormatException e) {
                // Mensaje separado para entrada no numérica (error de conversión)
                System.out.println("Error de entrada: El valor ingresado no es un número válido.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Método auxiliar para leer y validar que el número sea finito y numérico
    private static double leerNumeroSeguro(Scanner scanner) {
        while (true) {
            String entrada = scanner.nextLine();
            try {
                double valor = Double.parseDouble(entrada);
                if (Double.isNaN(valor) || Double.isInfinite(valor)) {
                    System.out.print("Operación no permitida: El valor no puede ser NaN ni Infinity. Inténtalo de nuevo: ");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.print("Error de entrada: Texto no válido. Introduce un número: ");
            }
        }
    }
}