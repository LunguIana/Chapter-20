package Ex_4;

import java.security.SecureRandom;
import java.util.Arrays;

public class SelectionSort {

    public static <T extends Comparable<T>> void selectionSort(T[] data){
        for(int i = 0; i <data.length-1; i++){
            int smallest = i;

            for(int index = i; index < data.length; index++)
                if((data[index].compareTo(data[smallest])) < 0)
                    smallest = index;

            swap(data, i, smallest);
            printPass(data,i+1, smallest);

        }
    }

    private static <T> void swap(T[] data, int first, int second){
        T temporary = data[first];
        data[first] = data[second];
        data[second] = temporary;
    }

    private static <T> void printPass(T[] data, int pass, int index){
        System.out.printf("after pass %2d: ", pass);

        for(int i = 0; i < index; i++)
            System.out.printf("%d ", data[i]);

        System.out.printf("%d ", data[index]);

        for(int i = index+1; i < data.length; i++)
            System.out.printf("%d ", data[i]);

        System.out.printf("%n               ");

        for(int j = 0; j < pass; j++)
            System.out.print("--  ");

        System.out.println();
    }

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        int i1 = 10;
        Integer[] data = new Integer[i1];

        Double[] data1 = new Double[i1];

        for(int i = 0; i < data.length; i++)
            data[i] = 10 + generator.nextInt(90);

        System.out.printf("Unsorted array:%n%s%n%n", Arrays.toString(data));
        selectionSort(data);
        System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(data));

        System.out.println();

        System.out.printf("Unsorted array:%n%s%n%n", Arrays.toString(data1));
        selectionSort(data1);
        System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(data1));
    }
}