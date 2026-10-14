import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GastosPorCategoria {
    public static void main(String[] args) {
        // 1. Representamos las operaciones como objetos Movimiento y las guardamos en una lista
        List<Movimiento> movimientos = new ArrayList<>();

        movimientos.add(new Movimiento("GASTO", "Transporte", 30000));
        movimientos.add(new Movimiento("GASTO", "Alimentación", 45000));
        movimientos.add(new Movimiento("GASTO", "Transporte", 20000));
        movimientos.add(new Movimiento("INGRESO", "Salario", 1500000));
        movimientos.add(new Movimiento("GASTO", "Salud", 40000));

        // 2. Creamos un Map para asociar la categoría (String) con el total acumulado (Double)
        Map<String, Double> gastosPorCat = new HashMap<>();

        // 3. Recorremos los movimientos filtrando únicamente los de tipo GASTO y acumulando por categoría
        for (Movimiento movimiento : movimientos) {
            // Verificamos que sea un gasto (el ingreso por salario queda excluido automáticamente)
            if (movimiento.getTipo().equals("GASTO")) {
                String categoria = movimiento.getCategoria();
                double valor = movimiento.getValor();

                // Si la categoría ya existe en el mapa, sumamos el nuevo valor al acumulado actual.
                // Si no existe, getOrDefault devuelve 0.0 y le sumamos el valor inicial.
                double totalActual = gastosPorCat.getOrDefault(categoria, 0.0);
                gastosPorCat.put(categoria, totalActual + valor);
            }
        }

        // 4. Mostramos los pares del mapa (categoría y su total acumulado)
        System.out.println("=== GASTOS AGRUPADOS POR CATEGORÍA ===");
        for (Map.Entry<String, Double> entrada : gastosPorCat.entrySet()) {
            System.out.println(entrada.getKey() + ": $" + entrada.getValue());
        }
    }
}
/Ejercicio