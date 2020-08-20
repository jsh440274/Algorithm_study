import java.util.*;

public class Main {
    public static boolean row_col_sqare(int i, int j, int[][] input_arrays) {
        Set rows = new HashSet();
        Set cols = new HashSet();
        Set square = new HashSet();
        Set row_nums = new HashSet();
        Set col_nums = new HashSet();
        Set square_nums = new HashSet();


        row_nums.add(input_arrays[i][0]);
        col_nums.add(input_arrays[0][j]);
        for (int k = 1; k < 9; k++) {
            rows.add(k);
            cols.add(k);
            square.add(k);
            row_nums.add(input_arrays[i][k]);
            col_nums.add(input_arrays[k][j]);
        }
        rows.add(9);
        cols.add(9);
        square.add(9);

        rows.removeAll(row_nums);
        if (rows.size() == 1) {
            input_arrays[i][j] = (int) rows.toArray()[0];
            return true;
        }

        cols.removeAll(col_nums);
        if (cols.size() == 1) {
            input_arrays[i][j] = (int) cols.toArray()[0];
            return true;
        }

        for (int k = 0; k < 3; k++) {
            for (int h = 0; h < 3; h++) {
                square_nums.add(input_arrays[i - i % 3 + k][j - j % 3 + h]);
            }
        }

        square.removeAll(square_nums);
        if (square.size() == 1) {
            input_arrays[i][j] = (int) square.toArray()[0];
            return true;
        }

        return false;
    }

    public static int[][] sudoku_result(int[][] input_arrays) {
        ArrayList zero_list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (input_arrays[i][j] == 0) {
                    int[] temp = {i, j};
                    zero_list.add(temp);
                }
            }
        }
        while (!zero_list.isEmpty()) {
            for (Iterator<int[]> it = zero_list.iterator(); it.hasNext(); ) {
                int[] zero_index = it.next();
                if (row_col_sqare(zero_index[0], zero_index[1], input_arrays)) {
                    it.remove();
                }
            }
        }
        print_sudoku(input_arrays);
        return input_arrays;
    }

    public static void print_sudoku(int[][] input_arrays) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(input_arrays[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] sudoku_table = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku_table[i][j] = s.nextInt();
            }
        }
        sudoku_result(sudoku_table);
    }
}
