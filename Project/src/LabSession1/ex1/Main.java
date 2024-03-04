package LabSession1.ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Option 1: Addition");
        System.out.println("Option 2: Subtraction");
        System.out.println("Option 3: Multiplication");
        System.out.println("Enter desired option: ");

        int choice = scanner.nextInt();

        System.out.println("Enter the real part of the first complex number:");
        double real1 = scanner.nextDouble();

        System.out.println("Enter the imaginary part of the first complex number:");
        double imag1 = scanner.nextDouble();

        System.out.println("Enter the real part of the second complex number:");
        double real2 = scanner.nextDouble();

        System.out.println("Enter the imaginary part of the second complex number:");
        double imag2 = scanner.nextDouble();

        switch (choice){
            case 1:
                System.out.println("Addition: " + addition(real1, imag1, real2, imag2));
                break;
            case 2:
                System.out.println("Subtraction: " + subtraction(real1, imag1, real2, imag2));
                break;
            case 3:
                System.out.println("Multiplication: " + multiplication(real1, imag1, real2, imag2));
                break;
            default:
                System.out.println("Please choose a value between 1 and 3!");
        }
    }

    public static String addition(double real1, double imag1, double real2, double imag2){
        double real = real1 + real2;
        double imag = imag1 + imag2;

        if (imag < 0) {
            return real + "" + imag + "i";
        }
        return real + "+" + imag + "i";
    }

    public static String subtraction(double real1, double imag1, double real2, double imag2) {
        double real = real1 - real2;
        double imag = imag1 - imag2;

        if (imag < 0) {
            return real + imag + "i";
        }
        return real + "+" + imag + "i";
    }

    public static String multiplication(double real1, double imag1, double real2, double imag2) {
        double real = real1*real2 - imag1*imag2;
        double imag = real1*imag2 + real2*imag1;

        if (imag < 0) {
            return real + "" + imag + "i";
        }
        return real + "+" + imag + "i";
    }
}
