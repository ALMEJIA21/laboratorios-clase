import java.util.Scanner;
public class Menu {
    


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println();
            System.out.println("1. Saludar");
            System.out.println("2. Mostrar mensaje");
            System.out.println("0. Salir");

            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:  System.out.println("Hola.");
                case 2:  System.out.println("Java continúa ejecutándose.");
                case 0:  System.out.println("Programa finalizado.");
                default:  System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}