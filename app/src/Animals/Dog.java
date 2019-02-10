package Animals;

public class Dog extends Animal {

    private int numberOfCommands;

    public Dog(String name, int age, int numberOfCommands) {
        super(name, age);
        setNumberOfCommands(numberOfCommands);
    }

    private void setNumberOfCommands(int numberOfCommands) {
        this.numberOfCommands = numberOfCommands;
    }
}
