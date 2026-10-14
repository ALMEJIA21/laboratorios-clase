import java.util.ArrayList;
import java.util.List;

public class Historialsimple2 {

    public static void main(String[] args) {
        List<Movimiento> movimientos = new ArrayList<>();

        movimientos.add(new Movimiento("INGRESO", "Salario", 1500000));
        movimientos.add(new Movimiento("GASTO", "Transporte", 30000));
        movimientos.add(new Movimiento("GASTO", "Alimentación", 45000));

        for (Movimiento movimiento : movimientos) {
            System.out.println(
                movimiento.getTipo() + " | "
                + movimiento.getCategoria() + " | $"
                + movimiento.getValor()
            );
        }

        System.out.println("Movimientos: " + movimientos.size());

        // --- Recorrido para acumular gastos ---
        double totalGastos = 0.0;
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipo().equals("GASTO")) {
                totalGastos += movimiento.getValor();
            }
        }
        System.out.println("Total de gastos: " + totalGastos);

        // --- Agregar otro movimiento y comprobar cambio ---
        movimientos.add(new Movimiento("GASTO", "Entretenimiento", 20000));
        totalGastos = 0.0;
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipo().equals("GASTO")) {
                totalGastos += movimiento.getValor();
            }
        }
        System.out.println("Total de gastos actualizado: " + totalGastos);

        // ==========================================
        // --- NUEVO: COPIA DEL HISTORIAL ---
        // ==========================================
        
        // 1. Creamos una copia superficial de la lista original
        List<Movimiento> copiaMovimientos = new ArrayList<>(movimientos);

        // 2. Eliminamos el primer elemento solo de la copia
        if (!copiaMovimientos.isEmpty()) {
            copiaMovimientos.remove(0);
        }

        // 3. Imprimimos las cantidades para comprobar
        System.out.println("\n=== COMPROBACIÓN DE COPIA ===");
        System.out.println("Cantidad en lista original: " + movimientos.size());
        System.out.println("Cantidad en la copia: " + copiaMovimientos.size());
        System.out.println("¡El historial original conserva sus elementos intactos!");
    }
} {
    
}
