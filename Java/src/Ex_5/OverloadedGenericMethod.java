package Ex_5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OverloadedGenericMethod {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.printf("Array intArray contains:%n");
        printArray(intArray);
        System.out.printf("Array doubleArray contains:%n");
        printArray(doubleArray);
        System.out.printf("Array charArray contains:%n");
        printArray(charArray);

        System.out.println();


        System.out.printf("Array intArray between an interval:%n");
        System.out.print(printArray(intArray, 0, 4));
        System.out.println();
        System.out.printf("Array doubleArray between an interval:%n");
        System.out.print(printArray(doubleArray, 0, 6));
        System.out.println();
        System.out.printf("Array charArray between an interval:%n");
        System.out.print(printArray(charArray, 0, 3));

        //////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println();
        System.out.println("**********TEST**********");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the lowSubscript and highSubscript of intArray ");
        System.out.print("lowSubscript = ");
        int lowSubscript = input.nextInt();
        System.out.print("highSubscript = ");
        int highSubscript = input.nextInt();

        Boolean bool1 = printBoolean(intArray, lowSubscript, highSubscript);
        System.out.println();
        if(bool1 == false){
            System.out.println();
        }
        if(bool1 == true){
            System.out.println("intArray don't contains this index, array contains "+intArray.length+" elements");
            printArray(intArray);
        }

    }
    public static <T> void printArray(T[] inputArray){

        for(T element : inputArray)
            System.out.printf("%s ", element);

        System.out.println();
    }

    public static <T> List<T> printArray(T[] inputArray, int lowSubscript, int highSubscript){

        List<T> list = Arrays.asList(inputArray);
        list = list.subList(lowSubscript, highSubscript);

        return list;
    }

    // Create a method that a checks if method printArray(T[] inputArray, int lowSubscript, int highSubscript)
    // return an error, in this case the variable of type boolean return true
    public static <T> boolean printBoolean(T[] inputArray, int lowSubscript, int highSubscript){
        Boolean bool = false;
        try{
            System.out.print(printArray(inputArray, lowSubscript, highSubscript));
        }catch (IndexOutOfBoundsException ex){
            bool = true;
        }

        return bool;
    }
}