package zoopark.animals;

public class Animal {
    private String name;
    private boolean predator;
    private zoopark.cages.Cage cage;

    public Animal(String name, boolean predator) {
        this.name = name;
        this.predator = predator;
    }

// getters / setters

    public String getName() {
        return name;
    }

    public boolean getPredator() {
        return predator;
    }

    public zoopark.cages.Cage getCage() {
        return cage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    public void setCage(zoopark.cages.Cage cage) {
        this.cage = cage;
    }
}
