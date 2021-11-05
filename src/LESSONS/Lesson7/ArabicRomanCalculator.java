package Lessons.Lesson7;

import java.util.*;

public class ArabicRomanCalculator {

    static boolean roman = false;
    static boolean arabic = false;

    static int A = 0;
    static int result;
    static int convertResult = 0;
    static String rimResult = "";
    static boolean arab = false;
    static boolean rim = false;
    static String [] masNum;

    public static void main (String[] args) {
        String mathExpressionString = enterMathExpression();

        String[] mathExpression = refactorMathExpression(mathExpressionString);

        int result = 0;

        for (String element : mathExpression){
            System.out.print(element);
        }

        if (checkLengthOfMathExpression(mathExpression)){
            System.out.println(firstMultiplicationAndDivision(mathExpression));
        }

    }

    public static String enterMathExpression() {
        System.out.println("Enter your math expression");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static String[] refactorMathExpression(String correctableMathExpression){
        String[] symbols = correctableMathExpression.split("[^*/+-]");
        String[] numbers = correctableMathExpression.toUpperCase(Locale.ROOT).split("[^0-9a-zA-Z]");

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayDeque<String> symbolsDeque = new ArrayDeque<>();
        ArrayDeque<String> numbersDeque = new ArrayDeque<>();

        for (String symbol : symbols) { if (!symbol.equals("")) { symbolsDeque.add(symbol); }}
        for (String number : numbers) { if (!number.equals("")) { numbersDeque.add(number); }}

        while(!numbersDeque.isEmpty()){
            arrayList.add(numbersDeque.pollFirst());
            if (!symbolsDeque.isEmpty()){ arrayList.add(symbolsDeque.pollFirst()); }
        }

        return convertArrayListStringToArray(arrayList);
    }

    public static String[] convertArrayListStringToArray(ArrayList<String> arrayList){
        String[] array = new String[arrayList.size()];
        RomanNumbers romanNumbers = new RomanNumbers();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i % 2 == 0) { array[i] = String.valueOf(romanNumbers.romanToArabic(arrayList.get(i))); }
            else { array[i] = arrayList.get(i); }
        }
        return  array;
    }

    public static boolean checkLengthOfMathExpression(String[] mathExpression) {
        if (mathExpression.length < 3) { return false; }
        else { return true; }
    }

    public static int parseToInt(String str){
        return Integer.parseInt(str);
    }

    public static int firstMultiplicationAndDivision(String[] mathExpression) {
        IBaseMathActions iBaseMathActions = new ArabicNumbers();
        int tempCrutch = 0;

        for (int i = 0; i < mathExpression.length-2; ) {
            if (mathExpression[i+1].equals("*")) {
                tempCrutch = iBaseMathActions.multiplication(parseToInt(mathExpression[i]), parseToInt(mathExpression[i+2]));
                mathExpression[i] = "0";
                mathExpression[i+1] = "+";
                mathExpression[i+2] = Integer.toString(tempCrutch);
            }
            if (mathExpression[i+1].equals("/")) {
                tempCrutch = iBaseMathActions.division(parseToInt(mathExpression[i]), parseToInt(mathExpression[i+2]));
                mathExpression[i] = "0";
                mathExpression[i+1] = "+";
                mathExpression[i+2] = Integer.toString(tempCrutch);
            }
            i = i+2;
        }
        System.out.println("");
        for (String element : mathExpression){
            System.out.print(element);
        }

        for (int i = 1; i < mathExpression.length; ) {
            switch (mathExpression[i]) {
                case "+" -> {
                    tempCrutch += iBaseMathActions.addiction(tempCrutch, parseToInt(mathExpression[i+1]));
                }
                case "-" -> {
                    tempCrutch -= iBaseMathActions.subtraction(tempCrutch, parseToInt(mathExpression[i+1]));
                }
                default -> System.out.println("Incorrect format of sign!");
            }
            i = i + 2;
        }

        return tempCrutch;

    }

    public static void outPut() {
        if (arab) {
            System.out.println(result + " | ");
        }
        if (rim) {
            System.out.print(rimResult);
        }
    }

}