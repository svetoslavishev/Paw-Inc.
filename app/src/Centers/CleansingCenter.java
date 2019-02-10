package Centers;

import Animals.Animal;
import Animals.CleansingStatus;

import java.util.Set;
import java.util.TreeSet;

public class CleansingCenter extends Center {

    public CleansingCenter(String name) {
        super(name);
    }

    public Set<Animal> cleanse() {

        Set<Animal> storedAnimals = getStoredAnimals();
        Set<Animal> cleansedAnimals = new TreeSet<>();

        for (Animal a : storedAnimals) {
            a.setCleansingStatus(CleansingStatus.CLEANSED);
            cleansedAnimals.add(a);
        }

        storedAnimals.removeAll(cleansedAnimals);

        return cleansedAnimals;
    }
}
