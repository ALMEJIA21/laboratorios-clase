
public class PetProfile {

    private String name;
    private int visits;

    public PetProfile(String name) {
        this.name = name;
        this.visits = 0;
    }

    public String getName() {
        return name;
    }

    public int getVisits() {
        return visits;
    }

    public void registerVisit() {
        visits++;
    }
}
