package Project;

import java.util.ArrayList;
import java.util.List;

public class AnimalManager {

    private List<AnimalDTO> AnimalList = new ArrayList<>();

    public void addList(AnimalDTO animal){
        AnimalList.add(animal);
    }

    public List<AnimalDTO> selectAnimal(){
        return AnimalList;
    }

    public List<AnimalDTO> searchAnimal(String name){
        List<AnimalDTO> searshList = new ArrayList<>();
        for(AnimalDTO animal : searshList){
            if(animal.getName().contains(name)){
                searshList.add(animal);
            }
        }
        return searshList;
    }

    public List<AnimalDTO> searchspecies (String species){
        List<AnimalDTO> searchList = new ArrayList<>();
        for(AnimalDTO animal : searchList){
            if(animal.getSpecies().contains(species)){
                searchList.add(animal);
            }
        }

        return searchList;
    }

    public boolean updateAnimal(AnimalDTO updateAnimal){
        AnimalDTO old = null;
        for (int i = 0; i < AnimalList.size(); i++){
            if(AnimalList.get(i).getId() == updateAnimal.getId()){
                old = AnimalList.set(i, updateAnimal);
            }
        }
        return old != null;
    }

    public boolean removeAnimal (int id){
        AnimalDTO old = null;
        for(int i = 0; i < AnimalList.size(); i++){
            if(AnimalList.get(i).getId() == id){
                old = AnimalList.remove(i);
            }
        }
        return old != null;
    }
}

