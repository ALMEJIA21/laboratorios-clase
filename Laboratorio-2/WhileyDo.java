import java.util.Scanner;

public class WhileyDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion; 

        do {
            System.out.println("--- MENÚ DO-WHILE ---");
            System.out.println("1. Saludar");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
        } while (opcion != 0);


        scanner.close();
    }
}