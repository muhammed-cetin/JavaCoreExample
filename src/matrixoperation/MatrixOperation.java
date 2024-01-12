package matrixoperation;

public class MatrixOperation {

    private int[][] resultMatrix;
    private MatrixCreation matrixOne;
    private MatrixCreation matrixTwo;

    public MatrixOperation(MatrixCreation matrixOne, MatrixCreation matrixTwo) {
        if (matrixOne.getMatrix().length != matrixTwo.getMatrix().length ||
                matrixOne.getMatrix()[0].length != matrixTwo.getMatrix()[0].length) {
            throw new IllegalArgumentException("Matrislerin boyutları uyumsuz.");
        }

        this.matrixOne = matrixOne;
        this.matrixTwo = matrixTwo;
        this.resultMatrix = new int[matrixOne.getMatrix().length][matrixOne.getMatrix()[0].length];
    }

    public void matrixMultiplication() {
        for (int i = 0; i < matrixOne.getMatrix().length; i++) {
            for (int j = 0; j < matrixTwo.getMatrix()[0].length; j++) {
                for (int k = 0; k < matrixOne.getMatrix()[0].length; k++) {
                    resultMatrix[i][j] += matrixOne.getMatrix()[i][k] * matrixTwo.getMatrix()[k][j];
                }
            }
        }
        System.out.println("Matrix Multiplication Result:");
        matrixPrint(resultMatrix);

        // Her bir matrisin determinantını ayrı ayrı hesapla
        int determinantMatrixOne = determinant(matrixOne.getMatrix());
        int determinantMatrixTwo = determinant(matrixTwo.getMatrix());


        System.out.println("-----------------------------------------------------------------------");

        System.out.println("Matrix One Determinant: " + determinantMatrixOne);
        System.out.println("Matrix Two Determinant: " + determinantMatrixTwo);
    }

    public void matrixSubtraction() {
        for (int i = 0; i < matrixOne.getMatrix().length; i++) {
            for (int j = 0; j < matrixOne.getMatrix()[0].length; j++) {
                resultMatrix[i][j] = matrixOne.getMatrix()[i][j] - matrixTwo.getMatrix()[i][j];
            }
        }
        System.out.println("Matrix Subtraction Result:");
        matrixPrint(resultMatrix);
    }

    public static void matrixPrint(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]" + " ");
            }
            System.out.println();
        }
    }

    // Genel matris determinantını hesapla
    public static int determinant(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows != cols) {
            throw new IllegalArgumentException("Kare matris gerekli.");
        }

        return determinantRecursive(matrix);
    }

    private static int determinantRecursive(int[][] matrix) {
        int size = matrix.length;

        if (size == 1) {
            return matrix[0][0];
        }

        int det = 0;

        for (int i = 0; i < size; i++) {
            int[][] submatrix = new int[size - 1][size - 1];
            for (int j = 1; j < size; j++) {
                for (int k = 0, l = 0; k < size; k++) {
                    if (k != i) {
                        submatrix[j - 1][l++] = matrix[j][k];
                    }
                }
            }
            int sign = (i % 2 == 0) ? 1 : -1;
            det += sign * matrix[0][i] * determinantRecursive(submatrix);
        }

        return det;
    }
}
