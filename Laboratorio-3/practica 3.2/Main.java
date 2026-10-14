public  class Main {

    public static void main(String[] args) {
        // Creamos los objetos pasando los datos directamente en el constructor
        Producto primero = new Producto("Teclado", 85000, 3);
        Producto segundo = new Producto("Mouse", 45000, 7);

        primero.mostrarDetalle();
        System.out.println("Subtotal: $" + primero.calcularSubtotal());
        
        System.out.println("----------------------------");

        segundo.mostrarDetalle();
        System.out.println("Subtotal: $" + segundo.calcularSubtotal());

        Contador visitas = new Contador();
        visitas.aumentar();
        visitas.aumentar();
        visitas.mostrar(); // Debe mostrar "Valor: 2"
    }
} 
    

