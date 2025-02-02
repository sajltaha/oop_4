package zoopark;

import zoopark.cages.Cage;

import java.util.ArrayList;
import java.util.List;

public class Zoopark {
    private String name;
    private final List<Cage> cages;

    public Zoopark(String name) {
        this.name = name;
        this.cages = new ArrayList<>();
    }

    public void addCage(Cage cage) {
        cages.add(cage);
    }

    public void removeCage(Cage cage) {
        cages.remove(cage);
    }

    public zoopark.animals.Animal searchForAnimal(String name) {
        for (Cage cage : cages) {
            for (zoopark.animals.Animal animal : cage.getAnimals()) {
                if (animal.getName().equals(name)) {
                    return animal;
                }
            }
        }
        return null;
    }

// getters / setters

    public String getName() {
        return name;
    }

    public List<Cage> getCages() {
        return cages;
    }

    public void setName(String name) {
        this.name = name;
    }
}
