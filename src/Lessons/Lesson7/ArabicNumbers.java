package Lessons.Lesson7;

public class ArabicNumbers implements IBaseMathActions{

    public static boolean arabicWasUsed = false;

    public ArabicNumbers(){

    }

    public String arabicToRoman(int arabicNumber) {
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
        arabicWasUsed = true;
        return finalRomanNumber.toString().replaceAll("VIIII", "IX").replaceAll("IIII", "IV");
    }

}
