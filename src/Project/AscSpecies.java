package Project;

import java.util.Comparator;

public class AscSpecies implements Comparator<AnimalDTO> {
    @Override
    public int compare (AnimalDTO o1, AnimalDTO o2){
        return o1.getSpecies().compareTo(o2.getSpecies());
    }
}
