import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Digite un número (0 para terminar): ");
        int numero = scanner.nextInt();


        while (numero != 0) {
            System.out.println("Número ingresado: " + numero);

            
            System.out.print("Digite otro número (0 para terminar): ");
            numero = scanner.nextInt();
        }

        
        System.out.println("¡Escribiste cero! El programa ha terminado.");

        scanner.close();
    }
}