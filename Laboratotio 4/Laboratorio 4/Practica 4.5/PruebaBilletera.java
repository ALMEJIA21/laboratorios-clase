public class Movimiento {

    private final String tipo;
    private final String categoria;
    private final double valor;

    public Movimiento(String tipo, String categoria, double valor) {
        // Valida que el tipo sea estrictamente INGRESO o GASTO
        if (tipo == null || (!tipo.equals("INGRESO") && !tipo.equals("GASTO"))) {
            throw new IllegalArgumentException("El tipo debe ser INGRESO o GASTO.");
        }
        
        // Valida que la categoría no sea nula, vacía o solo espacios
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }

        // Valida que el valor sea positivo y finito
        if (!Double.isFinite(valor) || valor <= 0) {
            throw new IllegalArgumentException("El valor debe ser positivo y finito.");
        }

        this.tipo = tipo;
        this.categoria = categoria.trim();
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getValor() {
        return valor;
    }
}