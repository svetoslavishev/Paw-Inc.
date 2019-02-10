package Centers;

import Animals.Animal;
import Animals.CleansingStatus;

import java.util.Set;
import java.util.TreeSet;

public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleansing(CleansingCenter cleansingCenter) {
        Set<Animal> uncleansedAnimals = this.getStoredAnimals();
        Set<Animal> animalsForCleansing = cleansingCenter.getStoredAnimals();

        animalsForCleansing.addAll(uncleansedAnimals);
    }

    public Set<Animal> adopt() {
        Set<Animal> storedAnimals = this.getStoredAnimals();
        Set<Animal> adoptedAnimals = new TreeSet<>();

        for(Animal a : storedAnimals) {
            if(a.getStatus() == CleansingStatus.CLEANSED) {
                adoptedAnimals.add(a);
            }
        }

        storedAnimals.removeAll(adoptedAnimals);

        return adoptedAnimals;
    }
}
