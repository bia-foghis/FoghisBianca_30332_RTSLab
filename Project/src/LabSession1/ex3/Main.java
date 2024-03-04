package LabSession1.ex3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] array = generateRandom();

        Arrays.sort(array);

        displayArray(array);
    }

    public static int[] generateRandom(){
        int[] rand = new int[10];
        int min = 1;
        int max = 100;

        for(int i = 0; i < 10; i++){
            rand[i]  = (int)(Math.random()*(max - min + 1)) + min;
        }

        return rand;
    }

    public static void displayArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
