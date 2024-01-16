package Project;

public class AnimalDTO {

    private static int nextId = 1;
    private int id;
    private String species;
    private String name;

    public AnimalDTO(String name, String species) {
        this.id = AnimalDTO.nextId++;
        this.species = species;
        this.name = name;
    }

    public AnimalDTO(int id, String name, String species) {
        this.id = id;
        this.species = species;
        this.name = name;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        AnimalDTO.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnimalDTO{" +
                "id=" + id +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
