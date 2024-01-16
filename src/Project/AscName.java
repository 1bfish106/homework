package Project;

import java.util.Comparator;

public class AscName implements Comparator<AnimalDTO> {
    @Override
    public int compare (AnimalDTO o1, AnimalDTO o2){
        return o1.getName().compareTo(o2.getName());
    }
}
