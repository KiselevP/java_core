public class Test {
    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}
        };

        try {
            checkArray(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        /* Проверка размерности входного массива....Готового решения, к сожалению, я не нашел =( */

        int countOut = 0;
        int countIn = 0;

        for (String[] elemOut : array) {
            countOut++;
            for (String elemIn : elemOut) {
                countIn++;
            }
        }

        /* <-----------------------------------------------------------------------------------> */

        if (countOut != 4 && countIn != 4) {
            throw new MyArraySizeException("Размер массива указан не верно!!");
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                /* array[i][j].matches("-?(0|[1-9]\\d*)") - также можно вставить в условие для проверки */

                boolean isInconvertible = false;
                try {
                    Integer.parseInt(array[i][j]);
                    isInconvertible = true;
                } catch (NumberFormatException ignored) {
                }

                if (isInconvertible) {
                    result = result + Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataException("В ячейке массива " + i + "-" + j + " лежат неверные данные");
                }

            }
        }
        System.out.println(result);
    }
}
    /* Можно конечно сделать так, чтоб расчет всё равно производился, а неконвертируемые элементы складывались в map....но...мне лень =) */
