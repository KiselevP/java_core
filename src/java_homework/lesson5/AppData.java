package lesson5;

public class AppData {
    private String[] modelCar;
    private int[][] dataFuel;

    public AppData(String[] modelCar, int[][] dataFuel) {
        this.modelCar = modelCar;
        this.dataFuel = dataFuel;
    }

    public String[] getModelCar() {
        return modelCar;
    }

    public int[][] getDataFuel() {
        return dataFuel;
    }

    public void setModelCar(String[] modelCar) {
        this.modelCar = modelCar;
    }

    public void setDataFuel(int[][] dataFuel) {
        this.dataFuel = dataFuel;
    }
}
