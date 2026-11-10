import java.util.Scanner;

public class ContadorFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Digite un número para ver su tabla: ");
        int numero = scanner.nextInt();

        System.out.println("\n--- TABLA DE MULTIPLICAR DEL " + numero + " ---");

       
        for (int i = 1; i <= 10; i++) {
          
            int resultado = numero * i;

            
            System.out.println(numero + " x " + i + " = " + resultado);
        }

        
        scanner.close();
    }
}