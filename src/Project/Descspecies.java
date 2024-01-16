package Project;

import java.util.Comparator;

public class Descspecies implements Comparator<AnimalDTO> {
    @Override
    public int compare(AnimalDTO o1, AnimalDTO o2){
        return o2.getSpecies().compareTo(o1.getSpecies());
    }
}
