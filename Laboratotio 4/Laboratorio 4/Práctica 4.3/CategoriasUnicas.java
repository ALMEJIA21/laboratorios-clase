import java.util.HashSet;
import java.util.Set;

public class CategoriasUnicas {

    public static void main(String[] args) {
        Set<String> categorias = new HashSet<>();

        categorias.add("Transporte");
        categorias.add("Alimentación");
        categorias.add("Transporte");
        categorias.add("Salud");

        System.out.println("Cantidad: " + categorias.size());
        System.out.println("¿Hay transporte? " + categorias.contains("Transporte"));

        for (String categoria : categorias) {
            System.out.println(categoria);
        }
    }
}