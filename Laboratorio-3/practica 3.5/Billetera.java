public class Billetera {

    // Atributos privados (Encapsulamiento)
    private String titular;
    private double saldo;
    private int cantidadIngresos;
    private double totalIngresos;
    private int cantidadGastos;
    private double totalGastos;

    // Constructor que recibe el titular e inicializa todo lo demás en cero
    public Billetera(String titular) {
        this.titular = titular;
        this.saldo = 0;
        this.cantidadIngresos = 0;
        this.totalIngresos = 0;
        this.cantidadGastos = 0;
        this.totalGastos = 0;
    }

    // Métodos públicos de consulta (Getters)
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

    // Método para registrar un ingreso con validación
    public boolean registrarIngreso(double valor) {
        if (valor <= 0) {
            return false; // Rechaza montos menores o iguales a cero
        }

        saldo += valor;
        cantidadIngresos++;
        totalIngresos += valor;
        return true;
    }

    // Método para registrar un gasto con validación
    public boolean registrarGasto(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false; // Rechaza si es menor/igual a cero o si supera el saldo disponible
        }

        saldo -= valor;
        cantidadGastos++;
        totalGastos += valor;
        return true;
    }
}