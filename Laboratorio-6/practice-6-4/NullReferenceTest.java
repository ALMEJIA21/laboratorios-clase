
public class NullReferenceTest {

    static final class Pet {
        String getName() {
            return "Luna";
        }
    }

    public static void main(String[] args) {
        Pet missing = null;

if (missing != null) {
    System.out.println(missing.getName());
} else {
    System.out.println("No hay una mascota asignada.");
}
    }
}
