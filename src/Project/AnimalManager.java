package Project;

import java.util.ArrayList;
import java.util.List;

public class AnimalManager {

    private List<AnimalDTO> animalList = new ArrayList<>();

    public void addList(AnimalDTO animal){
        animalList.add(animal);
    }

    public List<AnimalDTO> selectAnimal(){
        return animalList;
    }

    public List<AnimalDTO> searchAnimal(String name){
        List<AnimalDTO> searchList = new ArrayList<>();
        for(AnimalDTO animal : searchList){
            if(animal.getName().contains(name)){
                searchList.add(animal);
            }
        }
        return searchList;
    }

    public List<AnimalDTO> searchSpecies (String species){
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
        for (int i = 0; i < animalList.size(); i++){
            if(animalList.get(i).getId() == updateAnimal.getId()){
                old = animalList.set(i, updateAnimal);
            }
        }
        return old != null;
    }

    public boolean removeAnimal (int id){
        AnimalDTO old = null;
        for(int i = 0; i < animalList.size(); i++){
            if(animalList.get(i).getId() == id){
                old = animalList.remove(i);
            }
        }
        return old != null;
    }
}

