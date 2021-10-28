package LESSONS.Lesson5;
import java.util.*;

public class Lesson5Task2 {

    /**
     * Постройте частотный словарь букв русского (или английского) алфавита.
     * Т.е. Сколько раз каждая бука алфавита повторяется в введенной строке.
     * Alphabet.put(“A”, 0)
     * А → 3
     * Б → 0
     * …
     */

    static HashMap<Character, Integer> map = new HashMap<>(33);
    static char[] abc = new char[] {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};

    public static void main(String[] args){
        for (int i = 0; i < abc.length; i ++){
            map.put(abc[i], 0);
        }

        char[] array = getString().toLowerCase(Locale.ROOT).toCharArray();
        incMapValuesByLetters(array);
        printMapInABCSort();
    }

    private static String getString(){
        System.out.println("Введите вашу стркоу");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void incMapValuesByLetters(char[] array){
        var temp = 0;
        for (int i = 0; i < array.length; i++){
            for (Map.Entry entry: map.entrySet()) {
                if (Objects.equals(entry.getKey(), array[i])){
                    temp = map.get(array[i]);
                    temp++;
                    map.put(array[i], temp);
                }
            }
        }
    }

    private static void printMapInABCSort(){
        for (int i = 0; i < abc.length; i++){
            for (Map.Entry entry: map.entrySet()) {
                if (Objects.equals(entry.getKey(), abc[i])){
                    System.out.println(entry.getKey() + " → " + entry.getValue());
                }
            }
        }
    }

}
