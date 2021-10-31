package Lessons.Lesson6;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

import java.util.*;

public class RomanArabianCalculator {

    static boolean roman = false;
    static boolean arabic = false;

    public static void main (String[] args) {

        System.out.println("Enter your math expression, like 3 + x - 2 / O");

        Scanner scanner = new Scanner(System.in);
        String mathExpression = scanner.nextLine();
        String[] elements = mathExpression.split("\\s");
        StringBuilder mathExpressionArabic = new StringBuilder();

        for (String element : elements) {
            if (!(element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/"))) {
                mathExpressionArabic.append(romanToArabic(element));
            } else {
                mathExpressionArabic.append(element);
            }
        }

        System.out.println(mathExpressionArabic);

        try{
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            double result = Double.parseDouble(String.valueOf(engine.eval(mathExpressionArabic.toString())));

            if (roman && arabic){
                System.out.println("Result: " + result + "/" + arabicToRoman(result));
            }
            else if (arabic){
                System.out.println("Result: " + result);
            }
            else{
                System.out.println("Result: " + arabicToRoman(result));
            }
        }
        catch (NumberFormatException numberFormatException){
            System.out.println("Data format input error!");
        }
        catch (ArithmeticException arithmeticException){
            System.out.println("Arithmetic error!");
        }
        catch (Exception exception){
            System.out.println("Да " + exception);
        }

    }

    static Integer romanToArabic(String romanNumber) {
        int finalArabicNumber = 0;
        int lastNumber = 0;
        String stringRomanNumber = romanNumber.toUpperCase();

        if (isDigit(romanNumber)){
            arabic = true;
            return Integer.parseInt(romanNumber);
        }

        for (int x = stringRomanNumber.length() - 1; x >= 0; x--) {
            char checkRomanSymbol = stringRomanNumber.charAt(x);

            switch (checkRomanSymbol) {
                case 'M':
                    finalArabicNumber = makingArabic(lastNumber, lastNumber = 1000, finalArabicNumber);
                    break;

                case 'D':
                    finalArabicNumber = makingArabic(lastNumber, lastNumber = 500, finalArabicNumber);
                    break;

                case 'C':
                    finalArabicNumber = makingArabic(lastNumber, lastNumber = 100, finalArabicNumber);
                    break;

                case 'L':
                    finalArabicNumber = makingArabic(lastNumber, lastNumber = 50, finalArabicNumber);
                    break;

                case 'X':
                    finalArabicNumber = makingArabic(lastNumber, lastNumber = 10, finalArabicNumber);
                    break;

                case 'V':
                    finalArabicNumber = makingArabic(lastNumber, lastNumber = 5, finalArabicNumber);
                    break;

                case 'I':
                    finalArabicNumber = makingArabic(lastNumber, lastNumber = 1, finalArabicNumber);
                    break;

                case 'O':
                    finalArabicNumber = 0;
                    break;
            }
        }

        if(finalArabicNumber == 0){
            return 0;
        }

        roman = true;
        return finalArabicNumber;
    }

    static int makingArabic(int lastNumber, int valueOfRomanLetter,  int number) {
        if (lastNumber > valueOfRomanLetter){
            return number - valueOfRomanLetter;
        }
        else{
            return number + valueOfRomanLetter;
        }
    }

    static String arabicToRoman(double arabicNumber) {
        StringBuilder finalRomanNumber = new StringBuilder();

        if(arabicNumber == 0) return "O";

        while(arabicNumber > 0){
            if(arabicNumber >= 1000){
                finalRomanNumber.append('M');
                arabicNumber -= 1000;
            }
            else if(arabicNumber >= 500){
                finalRomanNumber.append('D');
                arabicNumber -= 500;
            }
            else if(arabicNumber >= 100){
                finalRomanNumber.append('C');
                arabicNumber -= 100;
            }
            else if(arabicNumber >= 50){
                finalRomanNumber.append('L');
                arabicNumber -= 50;
            }
            else if(arabicNumber >= 10){
                finalRomanNumber.append('X');
                arabicNumber -= 10;
            }
            else if(arabicNumber >= 5){
                finalRomanNumber.append('V');
                arabicNumber -= 5;
            }
            else{
                finalRomanNumber.append('I');
                arabicNumber -= 1;
            }
        }

        return finalRomanNumber.toString().replaceAll("VIIII", "IX").replaceAll("IIII", "IV");
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}