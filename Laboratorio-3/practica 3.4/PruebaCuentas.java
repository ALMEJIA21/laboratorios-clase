public class PruebaCuentas {

    public static void main(String[] args) {
        CuentaPuntos primera = new CuentaPuntos("Ana");
        CuentaPuntos segunda = new CuentaPuntos("Luis");

        primera.sumarPuntos(50);
        segunda.sumarPuntos(120);
        primera.sumarPuntos(20);

        System.out.println(primera.getTitular() + ": " + primera.getPuntos());
        System.out.println(segunda.getTitular() + ": " + segunda.getPuntos());
    }
}