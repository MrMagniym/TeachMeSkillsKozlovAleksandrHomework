package Lessons.Lesson7;

public class RomanNumbers implements IBaseMathActions{

    public boolean romanWasUsed = false;

    public RomanNumbers(){

    }

    public Integer romanToArabic(String romanNumber) {

        if (isDigit(romanNumber)){
            ArabicNumbers arabicNumbers = new ArabicNumbers();
            arabicNumbers.arabicWasUsed = true;
            return Integer.parseInt(romanNumber);
        }

        int finalArabicNumber = 0;
        int lastNumber = 0;
        String stringRomanNumber = romanNumber.toUpperCase();

        for (int x = stringRomanNumber.length() - 1; x >= 0; x--) {
            char checkRomanSymbol = stringRomanNumber.charAt(x);

            switch (checkRomanSymbol) {
                case 'M' -> finalArabicNumber = makingArabic(lastNumber, lastNumber = 1000, finalArabicNumber);
                case 'D' -> finalArabicNumber = makingArabic(lastNumber, lastNumber = 500, finalArabicNumber);
                case 'C' -> finalArabicNumber = makingArabic(lastNumber, lastNumber = 100, finalArabicNumber);
                case 'L' -> finalArabicNumber = makingArabic(lastNumber, lastNumber = 50, finalArabicNumber);
                case 'X' -> finalArabicNumber = makingArabic(lastNumber, lastNumber = 10, finalArabicNumber);
                case 'V' -> finalArabicNumber = makingArabic(lastNumber, lastNumber = 5, finalArabicNumber);
                case 'I' -> finalArabicNumber = makingArabic(lastNumber, lastNumber = 1, finalArabicNumber);
                case 'O' -> finalArabicNumber = 0;
            }
        }

        if(finalArabicNumber == 0){
            return 0;
        }

        romanWasUsed = true;
        return finalArabicNumber;
    }

    private int makingArabic(int lastNumber, int valueOfRomanLetter,  int number) {
        if (lastNumber > valueOfRomanLetter){
            return number - valueOfRomanLetter;
        }
        else{
            return number + valueOfRomanLetter;
        }
    }

}
