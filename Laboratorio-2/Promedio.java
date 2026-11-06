import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Cantidad de notas: ");
        int cantidadNotas = scanner.nextInt();

    
        double sumaNotas = 0;

       
        for (int i = 1; i <= cantidadNotas; i++) {
            System.out.print("Nota " + i + ": ");
            double nota = scanner.nextDouble();
            
      
            sumaNotas = sumaNotas + nota; 
     
        }

      
        double promedio = sumaNotas / cantidadNotas;

       
        System.out.println("Promedio: " + promedio);

        scanner.close();
    }
}
