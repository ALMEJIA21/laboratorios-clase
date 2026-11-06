import java.util.Scanner;

public class DiaSemana {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. ");
        

        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
    case 1:
        System.out.println("Lunes.");
        break; // Detiene la ejecución para que no baje al siguiente caso
    case 2:
        System.out.println("Martes.");
        break;
    case 3:
        System.out.println("Miercoles.");
        break;
    case 4:
        System.out.println("Jueves.");
        break;
    case 5:
        System.out.println("Viernes.");
        break;
    case 6:
        System.out.println("Sabado.");
    case 7:
        System.out.println("Domingo.");
        break;
    default:
        System.out.println("Opcion no valida.");
        break;
}
        scanner.close();
    }
}