public class Producto {

    String nombre;
    double precio;
    int cantidad;

    // Este es el CONSTRUCTOR: Recibe los datos y los asigna usando 'this'
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    void mostrarDetalle() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
    }

    double calcularSubtotal() {
        return precio * cantidad;
    }
}