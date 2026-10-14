import java.util.Scanner;

public class MenuSeguro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1; // Inicializamos con un valor que no sea ninguna opción válida

        // Usamos un bucle do-while para que el menú se repita hasta que el usuario elija salir (0)
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Consultar");
            System.out.println("2. Registrar");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            // Leemos la entrada como texto para evitar errores de formato inmediatos
            String entrada = scanner.nextLine();

            try {
                // Intentamos convertir el texto ingresado a un número entero
                opcion = Integer.parseInt(entrada);

                // Evaluamos la opción utilizando switch
                switch (opcion) {
                    case 1:
                        System.out.println(">> Has seleccionado: Consultar.");
                        // Aquí iría la lógica para consultar
                        break;
                    case 2:
                        System.out.println(">> Has seleccionado: Registrar.");
                        // Aquí iría la lógica para registrar
                        break;
                    case 0:
                        System.out.println("¡Saliendo del programa. Hasta luego!");
                        break;
                    default:
                        // Si el número no es 0, 1 o 2
                        System.out.println("Error: La opción no existe. Por favor, elige una opción válida.");
                        break;
                }

            } catch (NumberFormatException e) {
                // Se ejecuta si el usuario escribe letras (ej. "hola") o símbolos que no se pueden convertir
                System.out.println("Error: La opción no es numérica. Introduce un número válido.");
                opcion = -1; // Mantiene el bucle activo y evita falsas salidas
            }

        } while (opcion != 0);

        // Cerramos el scanner al terminar
        scanner.close();
    }
}