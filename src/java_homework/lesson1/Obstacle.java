public class Obstacle {

    private String name;
    private int energyCost;

    public Obstacle(String name, int energyCost) {
        this.name = name;
        this.energyCost = energyCost;
    }

    public String getName() {
        return name;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void getInformObstacle() {
        System.out.println("    " +
                name +
                " требует " + energyCost + " энергии"
        );
    }
}
