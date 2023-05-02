package homework.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(
                new Student(
                        "Petr",
                        Arrays.asList(
                                new Course("Math"),
                                new Course("Biology"),
                                new Course("Programming")
                        )
                )
        );
        students.add(
                new Student(
                        "Oleg",
                        Arrays.asList(
                                new Course("Math"),
                                new Course("Geography"),
                                new Course("Chemistry"),
                                new Course("Astronomy")
                        )
                )
        );
        students.add(
                new Student(
                        "Svetlana",
                        Arrays.asList(
                                new Course("Physics"),
                                new Course("Programming"),
                                new Course("Drawing")
                        )
                )
        );

        students.add(
                new Student(
                        "Nikolai",
                        Arrays.asList(
                                new Course("Physics"),
                                new Course("Biology"),
                                new Course("Geography"),
                                new Course("Programming"),
                                new Course("Drawing")
                        )
                )
        );

        students.add(
                new Student(
                        "Gleb",
                        Arrays.asList(
                                new Course("Physics"),
                                new Course("Biology"),
                                new Course("Programming"),
                                new Course("Drawing"),
                                new Course("Astronomy"),
                                new Course("Geography")
                        )
                )
        );

        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .collect(Collectors.toSet())
        );

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList())
        );

        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(new Course("Math")))
                .collect(Collectors.toList())
        );
    }
}
