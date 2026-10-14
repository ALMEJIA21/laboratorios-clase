import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Billetera {
    private String titular;
    private double saldo;
    private int cantidadIngresos;
    private double totalIngresos;
    private int cantidadGastos;
    private double totalGastos;
    private List<Movimiento> movimientos;

    public Billetera(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
        this.cantidadIngresos = 0;
        this.totalIngresos = 0.0;
        this.cantidadGastos = 0;
        this.totalGastos = 0.0;
        this.movimientos = new ArrayList<>();
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getCantidadIngresos() {
        return cantidadIngresos;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public int getCantidadGastos() {
        return cantidadGastos;
    }

    public double getTotalGastos() {
        return totalGastos;
    }

    // Copia superficial para proteger la lista interna de modificaciones externas
    public List<Movimiento> getMovimientos() {
        return new ArrayList<>(movimientos);
    }

    // Registrar ingreso
    public boolean registrarIngreso(double valor, String categoria) {
        if (!Double.isFinite(valor) || valor <= 0) {
            return false;
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            return false;
        }

        // Creamos el movimiento (validado internamente)
        Movimiento mov = new Movimiento("INGRESO", categoria, valor);

        // Actualizamos estado solo si todo es correcto
        this.saldo += valor;
        this.cantidadIngresos++;
        this.totalIngresos += valor;
        this.movimientos.add(mov);

        return true;
    }

    // Registrar gasto
    public boolean registrarGasto(double valor, String categoria) {
        if (!Double.isFinite(valor) || valor <= 0) {
            return false;
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            return false;
        }
        // Rechazar si el gasto supera el saldo actual
        if (valor > this.saldo) {
            return false;
        }

        // Creamos el movimiento
        Movimiento mov = new Movimiento("GASTO", categoria, valor);

        // Actualizamos estado
        this.saldo -= valor;
        this.cantidadGastos++;
        this.totalGastos += valor;
        this.movimientos.add(mov);

        return true;
    }

    // Buscar movimientos por tipo ("INGRESO" o "GASTO")
    public List<Movimiento> buscarPorTipo(String tipo) {
        List<Movimiento> encontrados = new ArrayList<>();
        if (tipo == null) return encontrados;

        String tipoMayus = tipo.trim().toUpperCase();
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipo().equals(tipoMayus)) {
                encontrados.add(movimiento);
            }
        }
        return encontrados;
    }

    // Obtener categorías únicas utilizadas (tanto en ingresos como en gastos)
    public Set<String> categoriasUtilizadas() {
        Set<String> categorias = new HashSet<>();
        for (Movimiento movimiento : movimientos) {
            categorias.add(movimiento.getCategoria());
        }
        return categorias;
    }

    // Reporte de gastos agrupados por categoría (excluye ingresos)
    public Map<String, Double> gastosPorCategoria() {
        Map<String, Double> totales = new HashMap<>();
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipo().equals("GASTO")) {
                String cat = movimiento.getCategoria();
                double acumulado = totales.getOrDefault(cat, 0.0);
                totales.put(cat, acumulado + movimiento.getValor());
            }
        }
        return totales;
    }
}