import java.util.Scanner;

public class PeakColumnsArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       //Inputting  Dimension of Matrix Which Means Columns And Rows
        System.out.print("Enter number of rows (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = scanner.nextInt();

        // Initialize the matrix
        int[][] matrix = new int[m][n];

        // Nested Loop To input the elements Of Matrix
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        //  The Arrays to keep track of max in rows and min in columns
        int[] maxInRow = new int[m];
        int[] minInColumn = new int[n];

        // Find maximum Value In Each Row
        for (int i = 0; i < m; i++) {
            int maxRowValue = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] > maxRowValue) {
                    maxRowValue = matrix[i][j];
                }
            }
            maxInRow[i] = maxRowValue;
        }

        // Finding Minimum Value in Each Column
        for (int j = 0; j < n; j++) {
            int minColumnValue = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] < minColumnValue) {
                    minColumnValue = matrix[i][j];
                }
            }
            minInColumn[j] = minColumnValue;
        }

        //This Function is For Checking Peak Columns and Print Them
        boolean foundPeakColumn = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == maxInRow[i] && matrix[i][j] == minInColumn[j]) {
                    System.out.printf("A (%d,%d) = %d\n", i + 1, j + 1, matrix[i][j]);
                    foundPeakColumn = true;
                }
            }
        }

        //Condition To Catch error if there is No Peak Columns Found in Matrix
        if (!foundPeakColumn) {
            System.out.println("No peak-columns found in the matrix.");
        }

        scanner.close();
    }
}

