import java.util.Scanner;

public class CotizadorCompra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=============================");
        System.out.println("    *   COTIZADOR JAVA   *   ");
        System.out.println("=============================");

        System.out.print("Nombre del cliente: ");
        String cliente = scanner.nextLine();

        System.out.print("Producto: ");
        String producto = scanner.nextLine();

        System.out.print("Precio unitario: ");
        double precioUnitario = scanner.nextDouble();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();

        System.out.print("Descuento (%): ");
        double descuentoPorcentaje = scanner.nextDouble();

        System.out.print("Impuesto (%): ");
        double impuestoPorcentaje = scanner.nextDouble();

        // Cálculos usando variables intermedias
        double subtotal = precioUnitario * cantidad;
        double valorDescuento = subtotal * (descuentoPorcentaje / 100.0);
        double base = subtotal - valorDescuento;
        double valorImpuesto = base * (impuestoPorcentaje / 100.0);
        double total = base + valorImpuesto;

        System.out.println("\n-----------------------------");
        System.out.println("     RESUMEN DE COMPRA       ");
        System.out.println("-----------------------------");
        System.out.println("Cliente: " + cliente);
        System.out.println("Producto: " + producto);
        System.out.println("Precio unitario: $" + precioUnitario);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento: $" + valorDescuento);
        System.out.println("Base: $" + base);
        System.out.println("Impuesto: $" + valorImpuesto);
        System.out.println("TOTAL: $" + total);

        scanner.close();
    }
}