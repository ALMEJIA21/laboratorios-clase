import java.util.Scanner;

public class ClasificarNota { // (Puedes mantener este nombre o cambiarlo a AccesoSistema)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuarioCorrecto = "admin";
        String claveCorrecta = "java21";

        System.out.print("Digite su Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Digite su clave: ");
        String clave = scanner.nextLine();

        // Comparamos las variables (sin comillas) usando .equals()
        boolean usuarioValido = usuarioCorrecto.equals(usuario);
        boolean claveValida = claveCorrecta.equals(clave);

        // Verificamos si ambas coinciden
        boolean accesoConcedido = usuarioValido && claveValida;

        System.out.println("¿El usuario es correcto? " + usuarioValido);
        System.out.println("¿La clave es correcta? " + claveValida);
        System.out.println("¿Acceso concedido al sistema? " + accesoConcedido);

        scanner.close();
    }
}