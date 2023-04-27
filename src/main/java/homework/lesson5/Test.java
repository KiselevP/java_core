package homework.lesson5;

import java.io.*;

public class Test {
    public static void main(String[] args) {

        String[][] carInfo = new String[3][3];
        try (BufferedReader reader = new BufferedReader(new FileReader("car_info.csv"))) {
            String buffer;
            int i = 0;
            while ((buffer = reader.readLine()) != null) {
                String[] lineCech = buffer.split(";");
                carInfo[i] = lineCech;
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String[] dataName = carInfo[0];


        int[][] dataFuel = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                dataFuel[i][j] = Integer.parseInt(carInfo[i + 1][j]);
            }
        }

        AppData appData = new AppData(dataName, dataFuel);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("car_info_copy.csv"))) {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(carInfo[i][j] + ";");
                }
                writer.write(
                        System.lineSeparator() +
                        "Строка " + (i + 1) +  " перезаписана" +
                        System.lineSeparator()
                );
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*что смог....я не до конца понял крайнюю строку в задании*/
}
