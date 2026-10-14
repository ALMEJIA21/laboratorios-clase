public class MainE {

    public static void main(String[] args) {
        Estudiante est1 = new Estudiante("Carlos Pérez", "3613994", 3, 2.8);
        Estudiante est2 = new Estudiante("Ana Gómez", "3613994", 3, 4.1);

        est1.mostrarPerfil();
        System.out.println("¿Aprobó?: " + est1.aprobo());
        
        System.out.println("----------------------------");
        
        est2.mostrarPerfil();
        System.out.println("¿Aprobó?: " + est2.aprobo());
    }
}