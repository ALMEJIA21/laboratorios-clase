
public class AliasExercise {

    static final class Pet {
        private String name;

        Pet(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        void rename(String newName) {
            name = newName;
        }
    }

    public static void main(String[] args) {
        Pet first = new Pet("Luna");
        Pet alias = first;
        Pet third = first;
        Pet independent = new Pet("Luna");

        System.out.println("Third initially: " + third.getName());

        alias = new Pet("Nova");
        alias.rename("Max");

        System.out.println("First: " + first.getName());
        System.out.println("Third: " + third.getName());
        System.out.println("Independent: " + independent.getName());
        System.out.println("Alias: " + alias.getName());
    }
}
