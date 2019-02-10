package AnimalCenterManager;

import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Centers.AdoptionCenter;
import Centers.CleansingCenter;

import java.util.*;

public class AnimalCenterManager {

    private Map<String, CleansingCenter> cleansingCenters;
    private Map<String, AdoptionCenter> adoptionCenters;

    private static Set<Animal> adoptedAnimals;
    private static Set<Animal> cleansedAnimals;

    public AnimalCenterManager() {
        cleansingCenters = new HashMap<>();
        adoptionCenters = new HashMap<>();
        adoptedAnimals = new TreeSet<>();
        cleansedAnimals = new TreeSet<>();
    }

    public void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter = new CleansingCenter(name);
        cleansingCenters.put(name, cleansingCenter);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter = new AdoptionCenter(name);
        adoptionCenters.put(name, adoptionCenter);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, learnedCommands);

        AdoptionCenter adoptionCenter = adoptionCenters.get(adoptionCenterName);
        Set<Animal> animals = adoptionCenter.getStoredAnimals();
        animals.add(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, intelligenceCoefficient);

        AdoptionCenter adoptionCenter = adoptionCenters.get(adoptionCenterName);
        Set<Animal> animals = adoptionCenter.getStoredAnimals();
        animals.add(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        AdoptionCenter adoptionCenter = adoptionCenters.get(adoptionCenterName);
        CleansingCenter cleansingCenter = cleansingCenters.get(cleansingCenterName);

        adoptionCenter.sendForCleansing(cleansingCenter);
    }

    public void cleanse(String cleansingCenterName) {
        CleansingCenter cleansingCenter = cleansingCenters.get(cleansingCenterName);
        Set<Animal> cleansed = cleansingCenter.cleanse();
        cleansedAnimals.addAll(cleansed);
    }

    public void adopt(String adoptionCenterName) {
        AdoptionCenter adoptionCenter = adoptionCenters.get(adoptionCenterName);
        adoptedAnimals.addAll(adoptionCenter.adopt());
    }

    public void printStatistics() {

        String numberOfAdoptionCenters = "Adoption Centers: " + adoptionCenters.size() + "\n";
        String numberOfCleansingCenters = "Cleansing Centers: " + cleansingCenters.size() + "\n";

        StringBuilder adoptedAnimalsBuilder = new StringBuilder();
        adoptedAnimalsBuilder.append("Adopted Animals: ");

        addStatisticsForCleansedOrAdoptedAnimals(adoptedAnimalsBuilder, adoptedAnimals);
        adoptedAnimalsBuilder.append("\n");

        String numberOfAdoptedAnimals = adoptedAnimalsBuilder.toString();

        StringBuilder cleansedAnimalsBuilder = new StringBuilder();
        cleansedAnimalsBuilder.append("Cleansed Animals: ");

        addStatisticsForCleansedOrAdoptedAnimals(cleansedAnimalsBuilder, cleansedAnimals);
        cleansedAnimalsBuilder.append("\n");

        String numberOfCleansedAnimals = cleansedAnimalsBuilder.toString();

        String numberOfAnimalsAwaitingAdoption =
                "Animals Awaiting Adoption: " + calculateAmountOfAnimalsWaitingForAdoption() + "\n";

        String numberOfAnimalsAwaitingCleansing =
                "Animals Awaiting Cleansing: " + calculateAmountOfAnimalsWaitingForCleansing() + "\n";

        String output = "Paw Incorporative Regular Statistics\n" +
                numberOfAdoptionCenters +
                numberOfCleansingCenters +
                numberOfAdoptedAnimals +
                numberOfCleansedAnimals +
                numberOfAnimalsAwaitingAdoption +
                numberOfAnimalsAwaitingCleansing;

        System.out.println(output);
    }

    private void addStatisticsForCleansedOrAdoptedAnimals(StringBuilder builder, Set<Animal> animals) {
        if(animals.isEmpty()) {
            builder.append("None");
        } else {
            for(Animal a : cleansedAnimals) {
                builder.append(a.getName()).append(", ");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private int calculateAmountOfAnimalsWaitingForAdoption() {
        int result = 0;
        for (AdoptionCenter adoptionCenter : adoptionCenters.values()) {
            result += adoptionCenter.getStoredAnimals().size();
        }

        return result;
    }

    private int calculateAmountOfAnimalsWaitingForCleansing() {
        int result = 0;
        for (CleansingCenter cleansingCenter : cleansingCenters.values()) {
            result += cleansingCenter.getStoredAnimals().size();
        }

        return result;
    }
}
