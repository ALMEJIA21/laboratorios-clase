import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostramos el menú
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        // 2. Solicitamos los dos números una sola vez antes de evaluar el switch
        System.out.print("Digite su primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite su segundo número: ");
        double num2 = scanner.nextDouble();

        // 3. Usamos el switch para ejecutar la operación seleccionada
        switch (opcion) {
            case 1:
                double suma = num1 + num2;
                System.out.println("El resultado de la suma es: " + suma);
                break;
                
            case 2:
                double resta = num1 - num2;
                System.out.println("El resultado de la resta es: " + resta);
                break;
                
            case 3:
                double multiplicacion = num1 * num2;
                System.out.println("El resultado de la multiplicación es: " + multiplicacion);
                break;
                
            case 4:
                // 4. Comprobamos con un if que el segundo número no sea cero antes de dividir
                if (num2 != 0) {
                    double division = num1 / num2;
                    System.out.println("El resultado de la división es: " + division);
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                }
                break;
                
            default:
                System.out.println("Opción no válida.");
            
                break;
        }

        scanner.close();
    }
}