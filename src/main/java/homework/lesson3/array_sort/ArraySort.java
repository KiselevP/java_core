package homework.lesson3.array_sort;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        String[] array = new String[]{"1","2","3","4","5"};
        System.out.println(Arrays.toString(array));
        arraySort(array, 0, 4);
        System.out.println(Arrays.toString(array));
    }

    private static void arraySort(String[] array, int a, int b) {

        String cache = "";

        for (int i = 0; i < array.length; i++) {
            cache = array[a];
            array[a] = array[b];
            array[b] = cache;
        }
    }
}
