package homework.lesson8;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "1 - погода на сегодня; " +
                    "5 - погода на 5 дней; " +
                    "2 - погода из БД; " +
                    "Для выхода введите 0:");

            String command = scanner.nextLine();

            if (command.equals("0")) break;

            if (command.equals("1") || command.equals("5")) {
                try {
                    System.out.println("Введите имя города: ");
                    String city = scanner.nextLine();
                    controller.getWeather(command, city);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (command.equals("2")) {
                System.out.println(new DataBaseRepository().getSavedToDBWeather());
            } else{
                    System.out.println("ВВедена некорректная команда, повторите ввод");
                    System.out.println();
                }
            }
        }
    }
