public class Billetera {

    private int cantidadIngresos;
    private int cantidadGastos;

    public boolean registrarGasto(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false; // Rechaza si es inválido o no hay suficiente saldo
        }

        saldo -= valor;
        return true;
    }

    // Atributos privados: nadie fuera de esta clase puede tocarlos directamente
    private String titular;
    private double saldo;

    public Billetera(String titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    // Métodos públicos de consulta 
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Regla de negocio para ingresos
    public boolean registrarIngreso(double valor) {
        if (valor <= 0) {
            return false; // Rechaza ingresos negativos o en cero
        }

        saldo += valor;
        return true;

        
    }
}