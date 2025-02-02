import zoopark.Zoopark;
import zoopark.animals.Animal;
import zoopark.cages.Cage;

import java.util.Scanner;

public class ZooparkControl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the zoo's name: ");
        String zooName = scanner.nextLine();
        Zoopark zoopark = new Zoopark(zooName);

        while (true) {
            System.out.println("\nZoo Options:");
            System.out.println("1. Add a new cage");
            System.out.println("2. Remove an existing cage");
            System.out.println("3. Place an animal in a cage");
            System.out.println("4. Take an animal out of a cage");
            System.out.println("5. Show the animals in a cage");
            System.out.println("6. Look for an animal by its name");
            System.out.println("7. End program");

            System.out.print("\nSelect an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter the cage's ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the cage's size (Large/Medium/Small): ");
                String size = scanner.nextLine();
                System.out.print("Enter the cage's maximum animal capacity: ");
                int maxNum = scanner.nextInt();
                scanner.nextLine();

                Cage newCage = new Cage(id, size, maxNum);
                zoopark.addCage(newCage);
                System.out.println("Cage added successfully.");
            } else if (choice == 2) {
                System.out.print("Enter the ID of the cage to remove: ");
                int removeId = scanner.nextInt();
                scanner.nextLine();

                Cage removeCage = null;
                for (Cage cage : zoopark.getCages()) {
                    if (cage.getId() == removeId) {
                        removeCage = cage;
                        break;
                    }
                }

                if (removeCage != null) {
                    zoopark.removeCage(removeCage);
                    System.out.println("Cage removed.");
                }
            } else if (choice == 3) {
                System.out.print("Enter the cage number to add the animal to: ");
                int cageId = scanner.nextInt();
                scanner.nextLine();

                Cage targetCage = null;
                for (Cage c : zoopark.getCages()) {
                    if (c.getId() == cageId) {
                        targetCage = c;
                        break;
                    }
                }

                if (targetCage != null) {
                    System.out.print("Enter the animal's name: ");
                    String animalName = scanner.nextLine();
                    System.out.print("Is the animal a predator? (true/false): ");
                    boolean isPredator = scanner.nextBoolean();
                    scanner.nextLine();

                    Animal newAnimal = new Animal(animalName, isPredator);
                    targetCage.addAnimal(newAnimal);
                    System.out.println("Animal placed in cage.");
                }
            } else if (choice == 4) {
                System.out.print("Enter the cage number to remove the animal from: ");
                int remNum = scanner.nextInt();
                scanner.nextLine();

                Cage fromCage = null;
                for (Cage c : zoopark.getCages()) {
                    if (c.getId() == remNum) {
                        fromCage = c;
                        break;
                    }
                }

                if (fromCage != null) {
                    System.out.print("Enter the name of the animal to remove: ");
                    String animAty = scanner.nextLine();

                    Animal animToRemove = null;
                    for (Animal a : fromCage.getAnimals()) {
                        if (a.getName().equals(animAty)) {
                            animToRemove = a;
                            break;
                        }
                    }

                    if (animToRemove != null) {
                        fromCage.removeAnimal(animToRemove);
                        System.out.println("Animal removed from cage.");
                    }
                }
            } else if (choice == 5) {
                System.out.print("Enter the cage number to view its animals: ");
                int showcage = scanner.nextInt();
                scanner.nextLine();

                Cage showNum = null;
                for (Cage c : zoopark.getCages()) {
                    if (c.getId() == showcage) {
                        showNum = c;
                        break;
                    }
                }

                if (showNum != null) {
                    System.out.println("Animals in cage " + showNum.getId() + ":");
                    for (Animal animal : showNum.getAnimals()) {
                        System.out.println(animal.getName());
                    }
                }
            } else if (choice == 6) {
                System.out.print("Enter the name of the animal to search for: ");
                String searchName = scanner.nextLine();

                Animal foundAnimal = zoopark.searchForAnimal(searchName);
                if (foundAnimal != null) {
                    System.out.println("Animal found: " + foundAnimal.getName());
                }
            } else if (choice == 7) {
                System.out.println("Program terminated.");
                scanner.close();
                return;
            }
        }
    }
}