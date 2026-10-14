public class Inventario {

    public static void main(String[] args) {
        String producto = "Monitor";
        int unidades = 8;
        double precio = 720000.0;
        boolean disponible = true;

        System.out.println("--- ESTADO INICIAL ---");
        System.out.println("Producto: " + producto);
        System.out.println("Unidades: " + unidades);
        System.out.println("Precio: $" + precio);
        System.out.println("Disponible: " + disponible);

        // Simulamos una actualización de unidades y precio
        unidades = 5;
        precio = 699000.0;

        System.out.println("\n--- ESTADO ACTUALIZADO ---");
        System.out.println("Producto: " + producto);
        System.out.println("Unidades: " + unidades);
        System.out.println("Precio: $" + precio);
        System.out.println("Disponible: " + disponible);
    }
}