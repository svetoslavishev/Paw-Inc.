package Centers;

import Animals.Animal;

import java.util.Set;
import java.util.TreeSet;

public class Center {

    private String name;
    private Set<Animal> storedAnimals;

    public Center(String name) {
        storedAnimals = new TreeSet<>();
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Set<Animal> getStoredAnimals() {
        return storedAnimals;
    }
}
