package Animals;

public class Animal implements Comparable<Animal> {

    private String name;
    private int age;
    private CleansingStatus status;

    public Animal(String name, int age) {
        setName(name);
        setAge(age);
        setCleansingStatus(CleansingStatus.UNCLEANSED);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public CleansingStatus getStatus() {
        return status;
    }

    public void setCleansingStatus(CleansingStatus status) {
        this.status = status;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Animal a) {
        return this.getName().compareTo(a.getName());
    }
}
