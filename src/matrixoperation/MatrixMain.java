package matrixoperation;

public class MatrixMain {
    public static void main(String[] args) {

        System.out.println("-----------------------------------------------------------------------");

        System.out.println("Matrix One:");
        MatrixCreation matrixOne = new MatrixCreation(2, 2);
        matrixOne.fillTheMatrix();

        System.out.println("-----------------------------------------------------------------------");

        System.out.println("Matrix Two:");
        MatrixCreation matrixTwo = new MatrixCreation(2, 2);
        matrixTwo.fillTheMatrix();

        System.out.println("-----------------------------------------------------------------------");

        // MatrixOperation sınıfını kullanarak çarpma işlemi yap
        MatrixOperation matrixOperation = new MatrixOperation(matrixOne, matrixTwo);
        matrixOperation.matrixMultiplication();

        System.out.println("-----------------------------------------------------------------------");

        // MatrixOperation sınıfını kullanarak çıkarma işlemi yap
        matrixOperation.matrixSubtraction();

        System.out.println("-----------------------------------------------------------------------");




    }
}
