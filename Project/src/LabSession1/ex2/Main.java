package LabSession1.ex2;

public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = {{2, 3, 1},{7, 1, 6},{9, 2, 4}};
        int[][] matrix2 = {{8, 5, 3},{3, 9, 2},{2, 7, 3}};

        int[][] sum = sum(matrix1, matrix2);
        int[][] product = product(matrix1, matrix2);

        System.out.println("The sum of the two matrices is: ");
        printMatrix(sum);
        System.out.println("The product of the two matrices is: ");
        printMatrix(product);
    }

    public static int[][] sum(int[][] matrix1, int[][] matrix2){
        int[][] resultMatrix = new int[matrix1.length][matrix1[0].length];

        for(int i = 0; i < matrix1.length; i++) {
            for(int j = 0; j < matrix1[0].length; j++){
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return resultMatrix;
    }

    public static int[][] product(int[][] matrix1, int[][] matrix2){
        int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];

        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix2[0].length; j++){
                for(int k = 0; k < matrix1[0].length; k++){
                    resultMatrix[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }

        return resultMatrix;
    }

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
