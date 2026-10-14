import java.util.Scanner;

public class NotasArreglo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        double[] notas = new double[5];

        System.out.println("REGISTRO DE 5 CALIFICACIONES DE ESTUDIANTES");

        
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        System.out.println("RESULTADOS");

        
        System.out.println("Notas registradas:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Posicion " + i + ": " + notas[i]);
        }

        
        double suma = 0;
        double notaMayor = notas[0]; 
        double notaMenor = notas[0]; 
        int aprobadas = 0;

        
        for (int i = 0; i < notas.length; i++) {
            double notaActual = notas[i];

           
            suma = suma + notaActual;

            
            if (notaActual > notaMayor) {
                notaMayor = notaActual;
            }

           
            if (notaActual < notaMenor) {
                notaMenor = notaActual;
            }

            
            if (notaActual >= 3.0) {
                aprobadas++;
            }
        }

        
        double promedio = suma / notas.length;

        // 6. Mostrar los resultados finales solicitados
        System.out.println("Promedio: " + promedio);
        System.out.println("Nota mayor: " + notaMayor);
        System.out.println("Nota menor: " + notaMenor);
        System.out.println("Cantidad de notas aprobadas (>= 3.0): " + aprobadas);

        
        scanner.close();
    }
}