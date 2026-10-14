import java.util.HashMap;
import java.util.Map;

public class PrimerMapa {

    public static void main(String[] args) {
        Map<String, Double> gastos = new HashMap<>();

        gastos.put("Transporte", 30000.0);
        gastos.put("Alimentación", 45000.0);

        System.out.println(gastos.get("Transporte"));
        System.out.println(gastos.containsKey("Salud"));

        gastos.put("Transporte", 50000.0);

        System.out.println(gastos.get("Transporte"));
        System.out.println("Categorías: " + gastos.size());
    }
}