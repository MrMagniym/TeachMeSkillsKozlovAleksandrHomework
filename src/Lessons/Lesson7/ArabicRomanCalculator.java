package Lessons.Lesson7;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.util.*;

public class ArabicRomanCalculator {

    public static void main (String[] args) {

        String mathExpressionString = enterMathExpression();
        String[] mathExpression = refactorMathExpression(mathExpressionString);

        if (checkLengthOfMathExpression(mathExpression)){

            int result = crutchCalculation(mathExpression);

            RomanNumbers romanNumbers = new RomanNumbers();
            romanNumbers.printResult(result);
        }
    }

    public static String enterMathExpression() {
        System.out.println("Enter your math expression");
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(new DataInputStream(System.in));
        //return bufferedInputStream.;
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
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
        if (mathExpression.length < 3) { System.exit(0); }
        return true;
    }

    public static int parseToInt(String str){
        return Integer.parseInt(str);
    }
    //3*2+0-4*3/1+6-8*7/2/2/2+3-4*xi
    public static int crutchCalculation(String[] mathExpression) {
        IBaseMathActions iBaseMathActions = new ArabicNumbers();
        int tempCrutch = 1;

        for (int i = 0; i < mathExpression.length-2; ) {
            if (mathExpression[i+1].equals("*")) {
                tempCrutch = iBaseMathActions.multiplication(parseToInt(mathExpression[i]), parseToInt(mathExpression[i+2]));
                mathExpression[i] = "0";
                if (i > 0 && mathExpression[i-1].equals("-")){
                    mathExpression[i+1] = "-";
                }
                else{
                    mathExpression[i+1] = "+";
                }
                mathExpression[i+2] = Integer.toString(tempCrutch);

            }
            if (mathExpression[i+1].equals("/")) {
                tempCrutch = iBaseMathActions.division(parseToInt(mathExpression[i]), parseToInt(mathExpression[i+2]));
                mathExpression[i] = "0";
                if (i > 0 && mathExpression[i-1].equals("-")){
                    mathExpression[i+1] = "-";
                }
                else{
                    mathExpression[i+1] = "+";
                }
                mathExpression[i+2] = Integer.toString(tempCrutch);
            }
            i += 2;
        }


        for (int i = 1; i < mathExpression.length; ) {
            if (i == 1){
                tempCrutch = parseToInt(mathExpression[i-1]);
            }
            switch (mathExpression[i]) {
                case "+" -> tempCrutch = iBaseMathActions.addiction(tempCrutch, parseToInt(mathExpression[i+1]));
                case "-" -> tempCrutch = iBaseMathActions.subtraction(tempCrutch, parseToInt(mathExpression[i+1]));
                default -> {
                    System.out.println("Incorrect format of sign!");
                    System.exit(0);
                }
            }
            i += 2;
        }

        return tempCrutch;

    }

}