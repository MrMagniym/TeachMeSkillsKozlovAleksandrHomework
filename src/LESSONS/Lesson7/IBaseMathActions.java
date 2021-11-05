package Lessons.Lesson7;

public interface IBaseMathActions {

    default boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    default int addiction (int summand1, int summand2){
        return  summand1 + summand2;
    }

    default int subtraction (int deductible, int subtractor){
        return  deductible - subtractor;
    }

    default int multiplication (int multiplier1, int multiplier2){
        return multiplier1 * multiplier2;
    }

    default int division (int divisible, int divisor){
        try{
            return divisible / divisor;
        }
        catch (ArithmeticException arithmeticException){
            System.out.println("Error: " + arithmeticException);
        }
        return 1;
    }
}
