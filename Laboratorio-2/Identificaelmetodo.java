public class Identificaelmetodo {

    // ==========================================
    // 1. MÉTODOS TIPO VOID (Solo ejecutan acciones)
    // ==========================================
    
    public static void mostrarTitulo() {
        System.out.println("========================================");
        System.out.println("      SISTEMA DE FACTURACIÓN BÁSICO     ");
        System.out.println("========================================");
    }

    public static void mostrarMenu() {
        System.out.println("1. Procesar compra");
        System.out.println("2. Salir");
    }

    public static void mostrarDespedida() {
        System.out.println("¡Gracias por usar el sistema! Hasta luego.");
    }

    // ==========================================
    // 2. MÉTODOS CON RETORNO (Calculan y devuelven datos)
    // ==========================================
    
    public static double calcularSubtotal(double precioUnitario, int cantidad) {
        double subtotal = precioUnitario * cantidad;
        return subtotal; // Devuelve el resultado hacia afuera
    }

    public static double calcularDescuento(double subtotal, double porcentaje) {
        double descuento = subtotal * porcentaje;
        return descuento; // Devuelve el resultado hacia afuera
    }

    // ==========================================
    // 3. MÉTODO PRINCIPAL (MAIN)
    // ==========================================
    
    public static void main(String[] args) {
        // Llamamos a los métodos void para mostrar el título y menú
        mostrarTitulo();
        mostrarMenu();

        System.out.println("\n--- Procesando datos ---");

        // Usamos los métodos con retorno para hacer operaciones y guardar los resultados
        double precioProducto = 50000.0;
        int cantidadComprada = 3;
        
        double subtotal = calcularSubtotal(precioProducto, cantidadComprada);
        System.out.println("Subtotal calculado: $" + subtotal);

        double descuento = calcularDescuento(subtotal, 0.10); // 10% de descuento
        System.out.println("Descuento aplicado: $" + descuento);

        double totalFinal = subtotal - descuento;
        System.out.println("Total final a pagar: $" + totalFinal);

        System.out.println();
        // Llamamos al método void de despedida para cerrar
        mostrarDespedida();
    }
}