public class Main {

    public static void main(String[] args) {
        // 1. Crear tres objetos Producto diferentes
        Producto producto1 = new Producto();
        producto1.nombre = "Teclado Mecánico";
        producto1.precio = 120000;
        producto1.cantidad = 2;

        Producto producto2 = new Producto();
        producto2.nombre = "Mouse Inalámbrico";
        producto2.precio = 45000;
        producto2.cantidad = 4;

        Producto producto3 = new Producto();
        producto3.nombre = "Audífonos Gamer";
        producto3.precio = 95000;
        producto3.cantidad = 3;

        // 2. Mostrar una ficha por objeto
        System.out.println("=== FICHA DE PRODUCTOS ===");
        producto1.mostrarDetalle();
        System.out.println("Subtotal: $" + producto1.calcularSubtotal());
        System.out.println("----------------------------");

        producto2.mostrarDetalle();
        System.out.println("Subtotal: $" + producto2.calcularSubtotal());
        System.out.println("----------------------------");

        producto3.mostrarDetalle();
        System.out.println("Subtotal: $" + producto3.calcularSubtotal());
        System.out.println("----------------------------");

        // 3. Calcular el valor total de los tres subtotales
        double totalInventario = producto1.calcularSubtotal() + producto2.calcularSubtotal() + producto3.calcularSubtotal();
        
        System.out.println("============================");
        System.out.println("VALOR TOTAL DEL INVENTARIO: $" + totalInventario);
        System.out.println("============================");
    }
}