package zoopark.cages;

import zoopark.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private int id;
    private String size;
    private int maxNum;
    private final List<Animal> animals;

    public Cage(int id, String size, int maxNum) {
        this.id = id;
        this.size = size;
        this.maxNum = maxNum;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        if (animals.size() < maxNum) {
            animals.add(animal);
            animal.setCage(this);
        } else {
            System.out.println("Not enough place to add animal!");
        }
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

// getters / setters

    public int getCurrentAnimalNum() {
        return animals.size();
    }

    public int getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }
}
