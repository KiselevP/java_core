package lesson1;

public abstract class Human {

    private String name;
    private int energy;

    public Human(String name) {
        this.name = name;
        energy = 100;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        return name;
    }
}
