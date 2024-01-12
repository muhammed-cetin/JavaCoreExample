package matrixoperation;

import java.util.Random;

public class MatrixCreation {
    private int[][] matrix;

    public MatrixCreation(int rows, int cols) {
        this.matrix = new int[rows][cols];
    }

    public void fillTheMatrix() {
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.matrix[i][j] = 1 + (int) (Math.random() * 9);
                System.out.print("[" + matrix[i][j] + "]" + " ");
            }
            System.out.println();
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
