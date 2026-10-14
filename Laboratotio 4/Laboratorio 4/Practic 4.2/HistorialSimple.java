import java.util.ArrayList;
import java.util.List;

public class HistorialSimple {

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

        // --- 1. RECORRIDO PARA ACUMULAR EL VALOR DE LOS GASTOS ---
        double totalGastos = 0.0;

        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipo().equals("GASTO")) {
                totalGastos += movimiento.getValor();
            }
        }

        System.out.println("Total de gastos: " + totalGastos);

        // --- 2. AGREGAR OTRO MOVIMIENTO DE GASTO Y COMPROBAR EL CAMBIO ---
        // Agregamos un nuevo gasto, por ejemplo, "Entretenimiento" por 20000
        movimientos.add(new Movimiento("GASTO", "Entretenimiento", 20000));

        // Recorremos nuevamente para recalcular el total actualizado
        totalGastos = 0.0; // Reiniciamos el acumulador
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipo().equals("GASTO")) {
                totalGastos += movimiento.getValor();
            }
        }

        System.out.println("Total de gastos actualizado: " + totalGastos);
    }
}