
public class MemoryDemo {

    static final class Pet {
        String name;

        Pet(String name) {
            this.name = name;
        }
    }

    static void changePet(Pet pet) {
        pet.name = "Otra";
        System.out.println("Dentro: " + pet.name);
    }

    public static void main(String[] args) {
        Pet myPet = new Pet("Sol");

        changePet(myPet);

        System.out.println("Fuera: " + myPet.name);
    }
}

