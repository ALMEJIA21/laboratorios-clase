public class Main {

    public static void main(String[] args) {
        Billetera billetera = new Billetera("Laura");

        boolean primera = billetera.registrarIngreso(100000);
        boolean segunda = billetera.registrarIngreso(-5000);

        System.out.println("Primer ingreso: " + primera);
        System.out.println("Segundo ingreso: " + segunda);
        System.out.println("Saldo: $" + billetera.getSaldo());
    }
}