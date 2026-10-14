public class PruebaBilleteras {

    public static void main(String[] args) {
        Billetera laura = new Billetera("Laura");
        Billetera diego = new Billetera("Diego");

        laura.registrarIngreso(100000);
        diego.registrarIngreso(200000);
        laura.registrarGasto(25000);

        System.out.println("Laura: $" + laura.getSaldo());
        System.out.println("Diego: $" + diego.getSaldo());
    }
}