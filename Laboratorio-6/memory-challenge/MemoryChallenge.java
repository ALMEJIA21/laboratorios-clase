
public class MemoryChallenge {

    private static void update(PetProfile current) {
        current.registerVisit();

        current = new PetProfile("Nova");
        current.registerVisit();

        System.out.println("Inside: " + current.getName()
                + " (" + current.getVisits() + ")");
    }

    private static PetProfile createReplacement(PetProfile previous) {
        return new PetProfile("Max");
    }

    private static void registerTwoVisits(PetProfile pet) {
        pet.registerVisit();
        pet.registerVisit();
    }

    private static PetProfile createNewProfile(String name) {
        return new PetProfile(name);
    }

    public static void main(String[] args) {
        PetProfile pet = new PetProfile("Luna");
        PetProfile alias = pet;

        update(pet);

        System.out.println("Outside: " + pet.getName()
                + " (" + pet.getVisits() + ")");

        PetProfile replacement = createReplacement(pet);

        System.out.println("Same reference: " + (pet == alias));
        System.out.println("Replacement: " + replacement.getName()
                + " (" + replacement.getVisits() + ")");

        PetProfile missing = null;

        if (missing != null) {
            missing.registerVisit();
        }

        PetProfile extra = new PetProfile("Rocky");

        registerTwoVisits(extra);

        System.out.println("Extra: " + extra.getName()
                + " (" + extra.getVisits() + ")");

        PetProfile newProfile = createNewProfile("Toby");

        System.out.println("New profile: " + newProfile.getName()
                + " (" + newProfile.getVisits() + ")");
    }
}
