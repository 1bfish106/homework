package Project;

import java.util.ArrayList;
import java.util.List;

public class AnimalManager {

    private List<AnimalDTO> animalList = new ArrayList<>();

    public void addList(AnimalDTO animal) {
        animalList.add(animal);
    }

    public List<AnimalDTO> selectAnimal() {
        return animalList;
    }

    public List<AnimalDTO> searchname(String name) {
        List<AnimalDTO> searchList = new ArrayList<>();

        for (AnimalDTO animal : animalList) {
            if (animal.getName().contains(name)) {
                searchList.add(animal);
            }
        }
        return searchList;
    }

    public List<AnimalDTO> searchSpecies(String species) {
        List<AnimalDTO> searchList = new ArrayList<>();
        for (AnimalDTO animal : animalList) {
            if (animal.getSpecies().equals(species)) {
                searchList.add(animal);
            }
        }
        return searchList;
    }

    public boolean updateAnimal(AnimalDTO updateAnimal) {
        AnimalDTO old = null;
        for (int i = 0; i < animalList.size(); i++) {
            if (animalList.get(i).getId() == updateAnimal.getId()) {
                old = animalList.set(i, updateAnimal);
            }
        }
        return old != null;
    }

    public boolean removeAnimal(int id) {
        int indexToRemove = -1;
        for (int i = 0; i < animalList.size(); i++) {
            if (animalList.get(i).getId() == id) {
                indexToRemove = i;
                break;

            }
        }
        if (indexToRemove != -1) {
            animalList.remove(indexToRemove);
            adjustIdsAfterRemoval(indexToRemove);
            return true;
        } else {
            return false;
        }

    }

    private void adjustIdsAfterRemoval(int startIndex) {
        for (int i = startIndex; i < animalList.size(); i++) {
            AnimalDTO animal = animalList.get(i);
            animal.setId(animal.getId() - 1);
        }

    }
    public String getAnimalNameById(int id){
        for (AnimalDTO animal : animalList) {
            if (animal.getId() == id) {
                return animal.getName();
            }
        }
        return null; // 해당 ID에 해당하는 동물이 없을 경우
    }

    public String getAnimalSpeciesById(int id){
        for (AnimalDTO animal : animalList) {
            if (animal.getId() == id) {
                return animal.getSpecies();
            }
        }
        return null; // 해당 ID에 해당하는 동물이 없을 경우
    }
}

