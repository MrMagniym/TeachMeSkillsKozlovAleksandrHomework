package Lessons.Lesson5;
import java.util.Scanner;

public class Lesson5Task1 {

    /**
     * Создать программу, которая позволяет ввести с клавиа-туры массив размером n и отсортировать его по убыванию. Т.е.:
     * 1. Нужно считать с клавиатуры значение числа "n"(раз-мер массива), используя метод makeMassiveUsingKeyboard();
     * 2.1 Ввести значения, которые будут добавлены в массив (при размере массива, равном «n», необходимо ввести эле-менты массива «n» раз).Example: Выводит на экран строку типа:Enter element [номер элемента]: {Введенное с клавиа-туры целое число}
     * 2.2 Далее вывести массив, который мы создали, каждый элемент через запятую и пробел, используя метод printMassive()}.Example: 7, 23, 12, 0, 322
     * 3. Отсортировать базовый массив по убыванию сорти-ровкой Пузырька, используя метод sortMassiveByBubbleWay()}.
     * 4. Вывести отсортированный массив, используя метод printSortedDescMassive()}.Example: [322, 23, 12, 7, 0]
     */

    public static void main(String[] args){
        int[] array = makeMassiveUsingKeyboard();
        printMassive(array);
        sortMassiveByBubbleWay(array);
        printSortedDescMassiv(array);
    }

    static Scanner scan = new Scanner(System.in);

    public static int[] makeMassiveUsingKeyboard(){
        System.out.print("Enter array size →");
        int countOfNumbersInArray = scan.nextInt();
        boolean checkCountOfElementsInArray = false;

        while (!checkCountOfElementsInArray)
            if (countOfNumbersInArray > 0){
                checkCountOfElementsInArray = true;
            }
            else{
                System.out.println("Net");
                System.out.print("Enter array size → ");
                countOfNumbersInArray = scan.nextInt();
            }


        int[] array = new int[countOfNumbersInArray];
        for (int i = 0; i < countOfNumbersInArray; i++) {
            System.out.print("Enter element #" + (i + 1) + ": ");
            array[i] = scan.nextInt();
        }
        return array;
    }

    private static void printMassive(int[] array){
        System.out.println("Your base array is:");
        for (int i = 0; i < array.length; i++){
            if (i != array.length - 1){
                System.out.print(array[i] + ", ");
            }
            else {
                System.out.println(array[i]);
            }
        }
    }

    private static void sortMassiveByBubbleWay(int[] array){
        int temp;
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - 1; j++)
            if (array[j] < array[j +1]){
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }

    private static void printSortedDescMassiv(int[] array){
        System.out.println("Sorted array DESC:");
        for (int i = 0; i < array.length; i++){
            if (i != array.length - 1){
                System.out.print(array[i] + ", ");
            }
            else {
                System.out.println(array[i]);
            }
        }
    }

}
