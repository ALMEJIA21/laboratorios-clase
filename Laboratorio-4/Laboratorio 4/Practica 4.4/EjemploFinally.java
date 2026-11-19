public class EjemploFinally {

    public static void main(String[] args) {
        try {
            int numero = Integer.parseInt("abc");
            System.out.println(numero);
        } catch (NumberFormatException e) {
            System.out.println("No se pudo convertir.");
        } finally {
            System.out.println("Terminó el intento de conversión.");
        }
    }
}
