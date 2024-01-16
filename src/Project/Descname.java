package Project;

import java.util.Comparator;

public class Descname implements Comparator<AnimalDTO> {
    @Override
    public int compare(AnimalDTO o1, AnimalDTO o2){
        return o2.getName().compareTo(o1.getName());
    }
}
