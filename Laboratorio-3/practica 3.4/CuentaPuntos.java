public class CuentaPuntos {

    private String titular;
    private int puntos;

    public CuentaPuntos(String titular) {
        this.titular = titular;
        this.puntos = 0;
    }

    public boolean sumarPuntos(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }

        puntos += cantidad;
        return true;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getTitular() {
        return titular;
    }
}