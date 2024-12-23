import java.util.Random;

public class MatrixOperations {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(50) + 1; // [1, 50]
            }
        }

        System.out.println("Матриця 4x4:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }

        int evenRowSum = 0, oddRowSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    evenRowSum += matrix[i][j];
                } else {
                    oddRowSum += matrix[i][j];
                }
            }
        }

        long evenColProduct = 1, oddColProduct = 1;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i % 2 == 0) {
                    evenColProduct *= matrix[j][i];
                } else {
                    oddColProduct *= matrix[j][i];
                }
            }
        }

        boolean isMagicSquare = checkMagicSquare(matrix);

        System.out.println("\nСума елементів у парних рядках (рядок 0, 2): " + evenRowSum);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + oddRowSum);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + evenColProduct);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + oddColProduct);
        System.out.println("Матриця " + (isMagicSquare ? "є" : "не є") + " магічним квадратом.");
    }

    public static boolean checkMagicSquare(int[][] matrix) {
        int n = matrix.length;
        int magicSum = 0;

        for (int j = 0; j < n; j++) {
            magicSum += matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        int diag1Sum = 0, diag2Sum = 0;
        for (int i = 0; i < n; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][n - i - 1];
        }
        if (diag1Sum != magicSum || diag2Sum != magicSum) {
            return false;
        }

        return true;
    }
}
