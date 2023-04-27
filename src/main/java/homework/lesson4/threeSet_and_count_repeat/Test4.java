package homework.lesson4.threeSet_and_count_repeat;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        String[] arrayOrigin = new String[11];
        arrayOrigin[0] = "1";
        arrayOrigin[1] = "2";
        arrayOrigin[2] = "3";
        arrayOrigin[3] = "4";
        arrayOrigin[4] = "2";
        arrayOrigin[5] = "4";
        arrayOrigin[6] = "4";
        arrayOrigin[7] = "3";
        arrayOrigin[8] = "5";
        arrayOrigin[9] = "5";
        arrayOrigin[10] = "5";

        System.out.println(Arrays.toString(arrayOrigin));

        Set<String> treeSet = new TreeSet<>(Arrays.asList(arrayOrigin));

        System.out.println(treeSet);

        String[] arrayNoDub = treeSet.toArray(new String[0]);

        for (String arrayNoDubElem: arrayNoDub) {
            int countRepeat = 0;
            for (String arrayOriginElem: arrayOrigin) {
                if (arrayNoDubElem.equals(arrayOriginElem)) {
                    countRepeat++;
                }
            }
            System.out.println("Элемент {" + arrayNoDubElem + "} повторяется " + countRepeat + " раз.");
        }
    }
}
