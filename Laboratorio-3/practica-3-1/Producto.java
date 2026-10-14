public class Producto {

    String nombre;
    double precio;
    int cantidad;
    
    double calcularSubtotal() {
        return precio * cantidad;
    }

    void mostrarDetalle() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
    }
}