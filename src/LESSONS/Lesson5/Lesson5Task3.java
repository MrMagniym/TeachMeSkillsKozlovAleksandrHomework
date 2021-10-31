package Lessons.Lesson5;

import java.util.*;

import static javafx.scene.input.KeyCode.K;
import static javafx.scene.input.KeyCode.V;

public class Lesson5Task3 {

    public static void main(String[] args) {

        System.out.println("Enter count of elements");
        Scanner scanner = new Scanner(System.in);
        int countOfElements = scanner.nextInt();

        Map<String, Set<String>> map = new HashMap<>();

        for (int i = 0; i < countOfElements; i++) {
            scanner = new Scanner(System.in);
            System.out.println("Enter Key #" + (i + 1) + " ");
            String key = scanner.nextLine();
            System.out.println("Enter Value #" + (i + 1) + " ");
            Set<String> value = new HashSet<>();
            value.add(scanner.nextLine());
            map.put(key, value);

        }

        System.out.println("Before:");
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        Map<String, Set<String>> mapInverse = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            for (String value : entry.getValue()) {
                Set<String> set = mapInverse.get(value);
                if (set == null) {
                    mapInverse.put(value, set = new HashSet<>());
                }
                set.add(key);
            }
        }

        System.out.println("After:");
        for (Map.Entry entry : mapInverse.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

    }

}
