package ELibro;


    public class Main {

    public static void main(String[] args) {
    
        Libro libro1 = new Libro();
        libro1.titulo = "Cien años de soledad";
        libro1.autor = "Gabriel García Márquez";
        libro1.paginas = 417;

        // Segundo libro
        Libro libro2 = new Libro();
        libro2.titulo = "El Principito";
        libro2.autor = "Antoine de Saint-Exupéry";
        libro2.paginas = 96;

        // Mostrar las fichas
        System.out.println("=== FICHA DEL LIBRO 1 ===");
        libro1.mostrarFicha();
        
        System.out.println("\n=== FICHA DEL LIBRO 2 ===");
        libro2.mostrarFicha();
    }

}
