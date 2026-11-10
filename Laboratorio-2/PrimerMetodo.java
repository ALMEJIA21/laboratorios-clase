public class PrimerMetodo {

    
    public static void mostrarProducto(String nombre, double precio) {
        System.out.println("Producto: " + nombre + " - Precio: $" + precio);
    }

    
    public static void main(String[] args) {
        
        mostrarProducto("Laptop", 2500000.0);
        mostrarProducto("Mouse Gamer", 85000.0);
        mostrarProducto("Teclado Mecánico", 150000.0);
        mostrarProducto("Monitor 24 pulgadas", 650000.0);
    }
}