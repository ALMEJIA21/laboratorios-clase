import java.util.Scanner;

public class DescuentoCompra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Digite su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Digite el valor de la compra: ");
        double valorCompra = scanner.nextDouble();

        
        double porcentaje = 0;

        // 2. Aplicamos las reglas según el valor (de mayor a menor)
        if (valorCompra >= 500000) {
            porcentaje = 0.15; // 15%
        } else if (valorCompra >= 250000) {
            porcentaje = 0.10; // 10%
        } else if (valorCompra >= 100000) {
            porcentaje = 0.05; // 5%
        } else {
            porcentaje = 0.0;  // 0%
        }

        // 3. Hacemos los cálculos matemáticos
        double valorDescuento = valorCompra * porcentaje;
        double totalFinal = valorCompra - valorDescuento;

        // 4. Mostramos los resultados en pantalla
        System.out.println("\n--- RESUMEN DE COMPRA ---");
        System.out.println("Cliente: " + nombre);
        System.out.println("Valor original: $" + valorCompra);
        System.out.println("Porcentaje aplicado: " + (porcentaje * 100) + "%");
        System.out.println("Valor del descuento: $" + valorDescuento);
        System.out.println("Total final a pagar: $" + totalFinal);

        scanner.close();
    }
}